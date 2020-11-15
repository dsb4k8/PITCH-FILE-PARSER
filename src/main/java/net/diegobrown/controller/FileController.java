package net.diegobrown.controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import net.diegobrown.domain.FileSubmissionEntity;
import net.diegobrown.service.FileService;


@Controller
@RequestMapping("/")
public class FileController {

    @Autowired
    FileService service;

    //upload submitted file to root of application dir -> sub dir "uploads"
    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";

    public static final String keyCategoryMappings(String mappingCode) {

        HashMap < String, String > resultHashMap = new HashMap < String, String > ();
        resultHashMap.put("S", "Symbol Clear");
        resultHashMap.put("A", "Add Order (short)");
        resultHashMap.put("D", "Add Order (long)");
        resultHashMap.put("E", "Order Executed");
        resultHashMap.put("X", "Order Cancel");
        resultHashMap.put("P", "Trade (short)");
        resultHashMap.put("R", "Trade (long)");
        resultHashMap.put("B", "Trade Break");
        resultHashMap.put("H", "Trade Status");
        resultHashMap.put("I", "Auction Upgrade");
        resultHashMap.put("J", "Auction Summary");

        return resultHashMap.get(mappingCode);

    }

    public static void ParseFile(MultipartFile mpFile) {

        HashMap < String, List < String >> mapbuild = new HashMap < String, List < String >> ();
        File file = new File(uploadDirectory + "/" + mpFile.getOriginalFilename());
        BufferedReader br;
        String st;
        try {
            br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null) {

               String messageTypeKey = keyCategoryMappings(Character.toString(st.charAt(9)));
			    mapbuild.computeIfAbsent(messageTypeKey, k -> new ArrayList<>()).add(st); 
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public static HashMap < String, List < String >> makeBaseMap(String filename) {
        //TODO: Make this function return the value of mapbuild

        //HashMap<String, String> mapAssociations = buildMap();

        HashMap < String, List < String >> mapbuild = new HashMap < String, List < String >> ();

        //		does the file have .txt extension?
        File file = new File(uploadDirectory + "/" + filename);
        BufferedReader br;
        String st;
        try {
            br = new BufferedReader(new FileReader(file));

            while ((st = br.readLine()) != null) {
                String messageTypeKey = Character.toString(st.charAt(9));
                if (!mapbuild.containsKey(messageTypeKey)) {
                    mapbuild.put(messageTypeKey, new ArrayList < String > ());

                } else {
                    mapbuild.get(messageTypeKey).add(st);
                }

            }


        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return mapbuild;
        
    }


    public static HashMap < String, Integer > buildFrequencyMap(HashMap < String, List < String >> baseMapBuild) {
        HashMap < String, Integer > frequencyMapResult = new HashMap < String, Integer > ();

        for (String key: baseMapBuild.keySet()) {
            String keyMapping = keyCategoryMappings(key);
            frequencyMapResult.put(keyMapping, (baseMapBuild.get(key).size() + 1));
        }
        return frequencyMapResult;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    //Home vs. Index == loading landing page without javascript vs. load with javascript
    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    public String createOrUpdateFile(FileSubmissionEntity file) {
//        System.out.println("createOrUpdateEmployee");
        service.createOrUpdateFileSubmission(file);
        return "uploadstatusandview";
    }

    @GetMapping("/uploadFile")
    @RequestMapping(path = "/uploadFile", method = RequestMethod.POST)
    public String upload(FileSubmissionEntity fileEntity, Model model, @RequestParam("file") MultipartFile[] files) {

        StringBuilder fileNames = new StringBuilder();

        for (MultipartFile file: files) {
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());

            fileEntity.setTitle(file.getOriginalFilename());

            try {

                //validate each file uploaded -> each must end with '.txt'
                if (!file.getOriginalFilename().matches("^.*(txt)$")) {
                    model.addAttribute("textFileError", Boolean.TRUE);
                    return "home";
                } else {
                    model.addAttribute("textFileError", Boolean.FALSE);

                    Files.write(fileNameAndPath, file.getBytes());
                    //ParseFile(file);

                    HashMap < String, Integer > frequencies = buildFrequencyMap(makeBaseMap(file.getOriginalFilename()));
                    model.addAttribute("frequencyResultMap", frequencies);

                    for (String key: frequencies.keySet()) {

                        switch (key) {

                            case ("Trade (short)"):
                                fileEntity.setTradeShortCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Symbol Clear"):
                                fileEntity.setSymbolClearCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Add Order (short)"):
                                fileEntity.setAddOrderShortCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Add Order (long)"):
                                fileEntity.setAddOrderLongCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Order Executed"):
                                fileEntity.setOrderExecutedCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Order Cancel"):
                                fileEntity.setOrderCancelCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Trade (long)"):
                                fileEntity.setTradeLongCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Trade Status"):
                                fileEntity.setTradeStatusCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Auction Upgrade"):
                                fileEntity.setAuctionUpdateCount(Integer.toString(frequencies.get(key)));
                                break;
                            case ("Auction Summary"):
                                fileEntity.setAuctionSummaryCount(Integer.toString(frequencies.get(key)));
                                break;

                        }

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        service.createOrUpdateFileSubmission(fileEntity);

        return "uploadstatusview";
        
    }


}