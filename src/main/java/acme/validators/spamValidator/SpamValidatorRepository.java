package acme.validators.spamValidator;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import acme.entities.spamConfig.BlackList;

public interface SpamValidatorRepository extends Repository<BlackList, Integer> {
	
	@Query("SELECT p FROM BlackList p")
	List<BlackList> findWordList();
	
	@Query("SELECT s.threshold FROM SpamConfig s")
	Float findThreshold();
}
