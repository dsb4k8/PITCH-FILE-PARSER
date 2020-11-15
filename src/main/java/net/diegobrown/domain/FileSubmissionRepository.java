package net.diegobrown.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileSubmissionRepository extends CrudRepository<FileSubmissionEntity, Long> {
	
}
