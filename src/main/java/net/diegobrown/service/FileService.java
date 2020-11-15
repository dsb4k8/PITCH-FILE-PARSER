package net.diegobrown.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.diegobrown.domain.FileSubmissionEntity;
import net.diegobrown.domain.FileSubmissionRepository;

@Service
public class FileService {
	@Autowired
	FileSubmissionRepository repository;
	
	public FileSubmissionEntity createOrUpdateFileSubmission(FileSubmissionEntity entity) {
		System.out.println("createOrUpdateFile");
		if(entity.getId()== null) {
			entity = repository.save(entity);
			return entity;
		}
		else {
			Optional<FileSubmissionEntity> fileSubmission = repository.findById(entity.getId());		
			
			if(fileSubmission.isPresent()) {
				FileSubmissionEntity newEntity = fileSubmission.get();
				newEntity.setTitle(entity.getTitle());
				newEntity.setSymbolClearCount(entity.getSymbolClearCount());
				
				newEntity = repository.save(newEntity);
				return newEntity;
			}else {
				entity = repository.save(entity);
				return entity;
			}
		}
	}
}
