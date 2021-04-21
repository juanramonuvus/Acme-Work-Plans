package acme.features.administrator.tasks;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorTaskShowService implements AbstractShowService<Administrator, TaskStatistics> {

	//Internal state -------------------------------------------------
	@Autowired
	AdministratorTaskRepository repository;
	
	
	@Override
	public boolean authorise(final Request<TaskStatistics> request) {
		assert request !=null;
		return true;
	}

	@Override
	public void unbind(final Request<TaskStatistics> request, final TaskStatistics entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "numberOfPublicTasks", "numberOfPrivateTasks", "numberOfFinishedTasks", "numberOfNonFinishedTasks", "avarageWorkloads", "minimumWorkloads", "maximumWorkloads");
		
	}


	
	
	
	public Integer getNumberOfPublicTasks(final Request<TaskStatistics> request) {
		assert request!=null;
		
		return this.repository.getNumberOfPublicTasks();
	}

	public Integer getNumberOfPrivateTasks(final Request<TaskStatistics> request) {
		assert request!=null;
		
		return this.repository.getNumberOfPrivateTasks();
	}

	public Integer getNumberOfFinishedTasks(final Request<TaskStatistics> request) {
		assert request!=null;

		final ZoneId defaultZoneId = ZoneId.systemDefault();
		
		final LocalDate fechauno = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
		final Date date = Date.from(fechauno.atStartOfDay(defaultZoneId).toInstant());
		
		return this.repository.getNumberOfFinishedTasks(date);
	}

	public Integer getNumberOfNonFinishedTasks(final Request<TaskStatistics> request) {
		assert request!=null;

		final ZoneId defaultZoneId = ZoneId.systemDefault();
		
		final LocalDate fechauno = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
		final Date date = Date.from(fechauno.atStartOfDay(defaultZoneId).toInstant());
		
		return this.repository.getNumberOfNonFinishedTasks(date);
	}

	public Float getAvarageWorkloads(final Request<TaskStatistics> request) {
		assert request!=null;
		
		return this.repository.getAvarageWorkloads();
	}

	public Float getMinimumWorkloads(final Request<TaskStatistics> request) {
		assert request!=null;
		
		return this.repository.getMinimumWorkloads();
	}

	public Float getMaximumWorkloads(final Request<TaskStatistics> request) {
		assert request!=null;
		
		return this.repository.getMaximumWorkloads();
	}

	
	
	
	@Override
	public TaskStatistics findOne(final Request<TaskStatistics> request) {
		assert request!=null;
		
		final TaskStatistics result = new TaskStatistics();
		result.setNumberOfPublicTasks(this.getNumberOfPublicTasks(request));
		result.setNumberOfPrivateTasks(this.getNumberOfPrivateTasks(request));
		result.setNumberOfNonFinishedTasks(this.getNumberOfNonFinishedTasks(request));
		result.setNumberOfFinishedTasks(this.getNumberOfFinishedTasks(request));
		result.setMinimumWorkloads(this.getMinimumWorkloads(request));
		result.setMaximumWorkloads(this.getMaximumWorkloads(request));
		result.setAvarageWorkloads(this.getAvarageWorkloads(request));
		
		return result;
	}

	
}
