package acme.features.administrator.taskstatics;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.forms.Taskstatistics;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractListService;

@Service
public class AdministratorTaskListService implements AbstractListService<Administrator, Taskstatistics> {

	//Internal state -------------------------------------------------
	@Autowired
	protected AdministratorTaskRepository repository;
	
	
	@Override
	public boolean authorise(final Request<Taskstatistics> request) {
		assert request !=null;
		return true;
	}

	@Override
	public void unbind(final Request<Taskstatistics> request, final Taskstatistics entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "numberOfPublicTasks", "numberOfPrivateTasks", 
			"numberOfFinishedTasks", "numberOfNonFinishedTasks", 
			"avarageWorkloads", "minimumWorkloads", "maximumWorkloads", "deviationWorkload",
			"avarageExecPeriod", "minimumExecPeriod", "maximumExecPeriod", "deviationExecPeriod");
		
	}

	
	//----------------------------------------------------------------------------------------------------------------------------
	public Integer getNumberOfPublicTasks(final Request<Taskstatistics> request) {
		assert request!=null;
		
		return this.repository.getNumberOfPublicTasks();
	}

	public Integer getNumberOfPrivateTasks(final Request<Taskstatistics> request) {
		assert request!=null;
		
		return this.repository.getNumberOfPrivateTasks();
	}

	
	//----------------------------------------------------------------------------------------------------------------------------
	public Integer getNumberOfFinishedTasks(final Request<Taskstatistics> request) {
		assert request!=null;

		final ZoneId defaultZoneId = ZoneId.systemDefault();
		
		final LocalDate fechauno = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
		final Date date = Date.from(fechauno.atStartOfDay(defaultZoneId).toInstant());
		
		return this.repository.getNumberOfFinishedTasks(date);
	}

	public Integer getNumberOfNonFinishedTasks(final Request<Taskstatistics> request) {
		assert request!=null;

		final ZoneId defaultZoneId = ZoneId.systemDefault();
		
		final LocalDate fechauno = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
		final Date date = Date.from(fechauno.atStartOfDay(defaultZoneId).toInstant());
		
		return this.repository.getNumberOfNonFinishedTasks(date);
	}

	
	//----------------------------------------------------------------------------------------------------------------------------
	public Float getAvarageWorkloads(final Request<Taskstatistics> request) {
		assert request!=null;
		
		return this.repository.getAvarageWorkloads();
	}

	public Float getMinimumWorkloads(final Request<Taskstatistics> request) {
		assert request!=null;
		
		return this.repository.getMinimumWorkloads();
	}

	public Float getMaximumWorkloads(final Request<Taskstatistics> request) {
		assert request!=null;
		
		return this.repository.getMaximumWorkloads();
	}

	public Float getDeviationWorkloads(final Request<Taskstatistics> request) {
		assert request!=null;
		
		return this.repository.getDeviationWorkloads();
	}

	
	//----------------------------------------------------------------------------------------------------------------------------
	public Float getAvarageExecPeriod(final Request<Taskstatistics> request) {
		assert request!=null;
		
		long total =  0L;
		
		final List<Task> lsT = this.repository.findAllTasks().stream().collect(Collectors.toList());
		for (int i = 0; i < lsT.size(); i++) {
			final long diff = lsT.get(i).getExecutionEnd().getTime() - lsT.get(i).getExecutionStart().getTime();
			total += diff;
		}
		

		final Float media = (float) total/lsT.size();
		return Float.parseFloat(media.toString().substring(0, 4));
	}

	public Float getMinimumExecPeriod(final Request<Taskstatistics> request) {
		assert request!=null;
		
		//return this.repository.getMinimumExecPeriod();
		return 0.f;
	}

	public Float getMaximumExecPeriod(final Request<Taskstatistics> request) {
		assert request!=null;
		
		//return this.repository.getMaximumExecPeriod();
		return 0.f;
	}

	public Float getDeviationExecPeriod(final Request<Taskstatistics> request) {
		assert request!=null;
		
		//return this.repository.getDeviationExecPeriod();
		return 0.f;
	}

	

	@Override
	public Collection<Taskstatistics> findMany(final Request<Taskstatistics> request) {
		assert request!=null;
		final ArrayList<Taskstatistics> lsResult = new ArrayList<>();
		
		final Taskstatistics result = new Taskstatistics();
		
		result.setNumberOfPublicTasks(this.getNumberOfPublicTasks(request));
		result.setNumberOfPrivateTasks(this.getNumberOfPrivateTasks(request));
		
		result.setNumberOfNonFinishedTasks(this.getNumberOfNonFinishedTasks(request));
		result.setNumberOfFinishedTasks(this.getNumberOfFinishedTasks(request));
		
		result.setMinimumWorkloads(this.getMinimumWorkloads(request));
		result.setMaximumWorkloads(this.getMaximumWorkloads(request));
		result.setAvarageWorkloads(this.getAvarageWorkloads(request));
		result.setDeviationWorkload(this.getDeviationWorkloads(request));
		
		result.setMinimumExecPeriod(this.getMinimumExecPeriod(request));
		result.setMaximumExecPeriod(this.getMaximumExecPeriod(request));
		result.setAvarageExecPeriod(this.getAvarageExecPeriod(request));
		result.setDeviationExecPeriod(this.getDeviationExecPeriod(request));
		
		lsResult.add(result);
		return lsResult;
	}

	
}
