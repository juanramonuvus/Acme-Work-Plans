package acme.features.administrator.spamConfig;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamConfig.BlackList;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorBlackListService implements AbstractListService<Administrator, BlackList>{

	@Autowired
	AdministratorSpamConfigRepository repository;
	
	@Override
	public boolean authorise(final Request<BlackList> request) {
		assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<BlackList> request, final BlackList entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "word");
		
	}

	@Override
	public Collection<BlackList> findMany(final Request<BlackList> request) {
		assert request != null;

		return this.repository.findBlackList();

	}

}
