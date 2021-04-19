package acme.features.anonymous.shout;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.shouts.Shout;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousShoutsRepository extends AbstractRepository {
	
	@Query("Select s from Shout s")
	Collection<Shout> findAllShouts();
	
}
