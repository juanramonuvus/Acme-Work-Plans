package acme.features.administrador.threshold;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.spamConfig.SpamConfig;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorThresholdListService implements AbstractListService<Administrator, SpamConfig>{

	//Internal state -------------------------------------------------------------
	@Autowired
	AdmimistratorThresholdRepository repository;
	
	@Override
	public boolean authorise(final Request<SpamConfig> request) {
assert request != null;
		
		return true;
	}

	@Override
	public void unbind(final Request<SpamConfig> request, final SpamConfig entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "threshold");
		
	}

	@Override
	public Collection<SpamConfig> findMany(final Request<SpamConfig> request) {
		assert request != null;

		return this.repository.findSpamConfig();
	}

}
