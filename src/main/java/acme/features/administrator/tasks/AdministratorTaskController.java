package acme.features.administrator.tasks;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/tasks")
public class AdministratorTaskController extends AbstractController<Administrator, TaskStatistics> {
	
	//Internal state ----------------------------------------------------
	@Autowired
	private AdministratorTaskShowService showService;
	
	//Contructors -------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}
	
	
}
