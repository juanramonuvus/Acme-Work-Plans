package acme.features.administrator.spamConfig;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamConfig.BlackList;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractUpdateService;

@Service
public class AdministratorBlackListUpdateService implements AbstractUpdateService<Administrator, BlackList> {

	//Internal state ----------------------------------------------------
	@Autowired
	AdministratorSpamConfigRepository repository;
	
	@Override
	public boolean authorise(final Request<BlackList> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<BlackList> request, final BlackList entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<BlackList> request, final BlackList entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "word");
		
	}

	@Override
	public BlackList findOne(final Request<BlackList> request) {
		assert request !=null;
		
		BlackList result;
		int id;
		id=request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		
		return result;
	}

	@Override
	public void validate(final Request<BlackList> request, final BlackList entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		final Collection<String> lista = this.repository.findBlackList().stream().map(x->x.getWord()).collect(Collectors.toList());
		
		
		if(!errors.hasErrors("word")) {
			final boolean res = lista.contains(entity.getWord());
			errors.state(request, !res, "word", "administrator.spamconfig.blacklist.form.error.duplicate");
		}
		
		
	}

	@Override
	public void update(final Request<BlackList> request, final BlackList entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
		
	}

}
