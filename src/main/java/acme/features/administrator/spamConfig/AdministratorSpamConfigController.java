package acme.features.administrator.spamConfig;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.spamConfig.BlackList;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;
@Controller
@RequestMapping("/administrator/spamconfig/")
public class AdministratorSpamConfigController extends AbstractController<Administrator, BlackList>{

	@Autowired
	protected AdministratorBlackListService blackListService;
	
	@Autowired
	protected AdministratorBlackListDeleteService deleteService;
	
	@Autowired
	protected AdministratorBlackListShowService showService;
	
	@Autowired
	protected AdministratorBlackListCreateService createService;
	
	
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.blackListService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
	}
}
