package acme.features.administrator.tasks;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.tasks.Task;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("/administrator/task")
public class AdministratorTaskController extends AbstractController<Authenticated, Task> {
	
	//Internal state ----------------------------------------------------
	@Autowired
	private AdministratorTaskListService listService;
	
	//Contructors -------------------------------------------------------
	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.LIST, this.listService);
	}
	

}
