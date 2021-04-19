package acme.features.administrator.tasks;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Authenticated;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorTaskListService implements AbstractListService<Authenticated, Task> {

	//Internal state -------------------------------------------------
	@Autowired
	AdministratorTaskRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Task> request) {
		assert request !=null;
		return true;
	}

	@Override
	public void unbind(final Request<Task> request, final Task entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "title", "executionStart", "executionEnd", "workload", "description", "isPublic", "link");
		
	}

	@Override
	public Collection<Task> findMany(Request<Task> request) {
		return null;
	}

	public Integer getNumberOfPublicTasks(Request<Task> request) {
		assert request!=null;
		
		return repository.getNumberOfPublicTasks();
	}

	public Integer getNumberOfPrivateTasks(Request<Task> request) {
		assert request!=null;
		
		return repository.getNumberOfPrivateTasks();
	}

	public Integer getNumberOfFinishedTasks(Request<Task> request) {
		assert request!=null;
		
		return repository.getNumberOfFinishedTasks();
	}

	public Integer getNumberOfNonFinishedTasks(Request<Task> request) {
		assert request!=null;
		
		return repository.getNumberOfNonFinishedTasks();
	}

	
}
