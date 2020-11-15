package net.diegobrown.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @RequestMapping("/aboutproject")
    public String about() {
        return "aboutproject";
    }

}