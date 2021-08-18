package acme.features.anonymous.shout;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.shouts.Shout;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousShoutsRepository extends AbstractRepository {
	
	@Query("SELECT s FROM Shout s WHERE s.moment BETWEEN ?1 and current_timestamp ORDER BY s.moment DESC")
	Collection<Shout> findAllShouts(Date fechaInicio);

}
