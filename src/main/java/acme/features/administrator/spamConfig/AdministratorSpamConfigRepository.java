package acme.features.administrator.spamConfig;


import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spamConfig.BlackList;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorSpamConfigRepository extends AbstractRepository {
	
	@Query("SELECT w FROM BlackList w")
	Collection<BlackList> findBlackList();

}
