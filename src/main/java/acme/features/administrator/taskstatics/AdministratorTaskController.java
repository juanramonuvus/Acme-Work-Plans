package acme.features.administrator.taskstatics;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.forms.Taskstatistics;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Administrator;

@Controller
@RequestMapping("/administrator/taskstatistics/")
public class AdministratorTaskController extends AbstractController<Administrator, Taskstatistics> {
	
	//Internal state ----------------------------------------------------
	@Autowired
	protected AdministratorTaskListService listService;
	
	//Contructors -------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}
	
}
