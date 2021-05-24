package acme.features.administrator.spamConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamConfig.BlackList;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorBlackListShowService implements AbstractShowService<Administrator, BlackList>{

	// Internal state --------------------------------------------------------------
	@Autowired
	AdministratorSpamConfigRepository repository;
	
	@Override
	public boolean authorise(final Request<BlackList> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<BlackList> request, final BlackList entity, final Model model) {
		assert request !=null;
		assert entity !=null;
		assert model !=null;
		
		request.unbind(entity, model, "word");
		
	}

	@Override
	public BlackList findOne(final Request<BlackList> request) {
		assert request != null;
		final int id = request.getModel().getInteger("id");
		return this.repository.findOneById(id);
	}
	
	

}
