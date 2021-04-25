package acme.features.administrador.threshold;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.spamConfig.SpamConfig;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdmimistratorThresholdRepository extends AbstractRepository{


	@Query("SELECT t FROM SpamConfig t")
	Collection<SpamConfig> findSpamConfig();

	@Query("SELECT t FROM SpamConfig t where t.id = ?1")
	SpamConfig findOneSpamConfigById(int id);
	
}
