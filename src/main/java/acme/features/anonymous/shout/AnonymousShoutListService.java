package acme.features.anonymous.shout;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.shouts.Shout;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousShoutListService implements AbstractListService<Anonymous, Shout>{

	@Autowired
	AnonymousShoutsRepository shoutsRepository;
	
	@Override
	public boolean authorise(final Request<Shout> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<Shout> request, final Shout entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "author", "text", "moment", "info");
		
	}

	@Override
	public Collection<Shout> findMany(final Request<Shout> request) {
		assert request != null;

		final ZoneId defaultZoneId = ZoneId.systemDefault();
		
		final LocalDate fechauno = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue() - 1, LocalDate.now().getDayOfMonth());
		final LocalDate fechados = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
		
		final Date date = Date.from(fechauno.atStartOfDay(defaultZoneId).toInstant());
		final Date date2 = Date.from(fechados.atStartOfDay(defaultZoneId).toInstant());
		
		Collection<Shout> result;
		result = this.shoutsRepository.findAllShouts(date, date2);

		return result;
	}

}
