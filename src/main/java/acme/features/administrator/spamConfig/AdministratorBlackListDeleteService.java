package acme.features.administrator.spamConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamConfig.BlackList;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractDeleteService;

@Service
public class AdministratorBlackListDeleteService implements AbstractDeleteService<Administrator, BlackList> {

	@Autowired
	AdministratorSpamConfigRepository repository;
	
	@Override
	public boolean authorise(final Request<BlackList> request) {
		assert request != null;

		return true;
	}

	@Override
	public void bind(final Request<BlackList> request, final BlackList entity, final Errors errors) {
		//NotUsed		
	}

	@Override
	public void unbind(final Request<BlackList> request, final BlackList entity, final Model model) {
		//NotUsed
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
	}

	@Override
	public void delete(final Request<BlackList> request, final BlackList entity) {
		assert request != null;
		assert entity != null;

		this.repository.delete(entity);
		
	}

}
