package acme.features.administrator.taskstatics;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import acme.entities.tasks.Task;
import acme.forms.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorTaskShowService implements AbstractShowService<Administrator, Dashboard>{

	//Internal state -------------------------------------------------
		@Autowired
		protected AdministratorTaskRepository repository;
		
		@Autowired
		MessageSource messageSource;
		
		
		@Override
		public boolean authorise(final Request<Dashboard> request) {
			assert request !=null;
			return true;
		}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		request.unbind(entity, model, "numberOfPublicTasks", "numberOfPrivateTasks", 
			"numberOfFinishedTasks", "numberOfNonFinishedTasks", 
			"avarageWorkloads", "minimumWorkloads", "maximumWorkloads", "deviationWorkload",
			"avarageExecPeriod", "minimumExecPeriod", "maximumExecPeriod", "deviationExecPeriod");
		
	}

	//----------------------------------------------------------------------------------------------------------------------------
		public Float datesTransformationForward(final Float date) {
			final double dat = Double.parseDouble(date.toString());
			final int horas = (int) dat;
			final double minutos = (dat - horas) * 100 * 100 / 60;

			return Float.parseFloat(horas + "." + (int) minutos);
		}

		public Float datesTransformationBackward(final Float date) {
			final double dat = Double.parseDouble(date.toString());
			final int horas = (int) dat;
			final double minutos = (dat - horas) * 100 * 60 / 100;

			return Float.parseFloat(horas + "." + (int) minutos);
		}
		
		public static Float round(final float d, final int decimalPlace) {
		    BigDecimal bd = new BigDecimal(Float.toString(d));
		    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);       
		    return bd.floatValue();
		}
		
		//----------------------------------------------------------------------------------------------------------------------------
		public Integer getNumberOfPublicTasks(final Request<Dashboard> request) {
			assert request!=null;
			
			return this.repository.getNumberOfPublicTasks();
		}

		public Integer getNumberOfPrivateTasks(final Request<Dashboard> request) {
			assert request!=null;
			
			return this.repository.getNumberOfPrivateTasks();
		}

		
		//----------------------------------------------------------------------------------------------------------------------------
		public Integer getNumberOfFinishedTasks(final Request<Dashboard> request) {
			assert request!=null;

			final ZoneId defaultZoneId = ZoneId.systemDefault();
			
			final LocalDate fechauno = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
			final Date date = Date.from(fechauno.atStartOfDay(defaultZoneId).toInstant());
			
			return this.repository.getNumberOfFinishedTasks(date);
		}

		public Integer getNumberOfNonFinishedTasks(final Request<Dashboard> request) {
			assert request!=null;

			final ZoneId defaultZoneId = ZoneId.systemDefault();
			
			final LocalDate fechauno = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
			final Date date = Date.from(fechauno.atStartOfDay(defaultZoneId).toInstant());
			
			return this.repository.getNumberOfNonFinishedTasks(date);
		}

		
		//----------------------------------------------------------------------------------------------------------------------------
		public Float getAvarageWorkloads(final Request<Dashboard> request) {
			assert request!=null;
			
			Float total = 0f;
			
			final List<Task> lsT = this.repository.findAllTasks().stream().collect(Collectors.toList());
			for (int i = 0; i < lsT.size(); i++) {			
				final Float horasMin = this.datesTransformationForward(lsT.get(i).getWorkload());
				
				total += horasMin;
			}
			
			final Float avg = total / lsT.size();
			return AdministratorTaskShowService.round(this.datesTransformationBackward(avg),2);
		}

		public Float getMinimumWorkloads(final Request<Dashboard> request) {
			assert request!=null;
			
			return this.repository.getMinimumWorkloads();
		}

		public Float getMaximumWorkloads(final Request<Dashboard> request) {
			assert request!=null;
			
			return this.repository.getMaximumWorkloads();
		}

		public Float getDeviationWorkloads(final Request<Dashboard> request) {
			assert request!=null;
			final Float average = this.getAvarageWorkloads(request);
			
			Float res =  0f;
			
			final List<Task> lsT = this.repository.findAllTasks().stream().collect(Collectors.toList());
			for (int i = 0; i < lsT.size(); i++) {			
				final Float diff = this.datesTransformationForward(lsT.get(i).getWorkload());
				
				final Float individualDeviation = Math.abs(diff-average)*Math.abs(diff-average);
				res+=individualDeviation;
			}
			res = res/lsT.size();
			final double sqrt = Math.sqrt(Double.parseDouble(res.toString()));
			final Float final1 = Float.parseFloat(sqrt + "");
			final Float fin = this.datesTransformationBackward(final1);
			return AdministratorTaskShowService.round(fin,2);
		}
		
			
		
		

		
		//----------------------------------------------------------------------------------------------------------------------------
		public Float getAvarageExecPeriod(final Request<Dashboard> request) {
			assert request!=null;
			
			Float total =  0f;
			
			final List<Task> lsT = this.repository.findAllTasks().stream().collect(Collectors.toList());
			for (int i = 0; i < lsT.size(); i++) {
				final Float horasMin = this.datesTransformationForward(lsT.get(i).getPeriod());
				
				total += horasMin;
			}
			

			final Float avg = total/lsT.size();
			return AdministratorTaskShowService.round(this.datesTransformationBackward(avg),2);
		}

		public Float getMinimumExecPeriod(final Request<Dashboard> request) {
			assert request!=null;
			
			Float min =  1000000000000f;
			
			final List<Task> lsT = this.repository.findAllTasks().stream().collect(Collectors.toList());
			for (int i = 0; i < lsT.size(); i++) {
				final Float diff = lsT.get(i).getPeriod();
				if (diff <= min) {
					min = diff;
				}
			}
			
			return AdministratorTaskShowService.round(min,2);
		}

		public Float getMaximumExecPeriod(final Request<Dashboard> request) {
			assert request!=null;
			
			Float max =  0f;
			
			final List<Task> lsT = this.repository.findAllTasks().stream().collect(Collectors.toList());
			for (int i = 0; i < lsT.size(); i++) {
				final Float diff = lsT.get(i).getPeriod();
				if (diff >= max) {
					max = diff;
				}
			}
			
			return AdministratorTaskShowService.round(max,2);
		}

		public Float getDeviationExecPeriod(final Request<Dashboard> request) {
			
			final Float average = this.getAvarageExecPeriod(request);
			
			Float res =  0f;

			final List<Task> lsT = this.repository.findAllTasks().stream().collect(Collectors.toList());
			for (int i = 0; i < lsT.size(); i++) {
				final Float diff = this.datesTransformationForward(lsT.get(i).getPeriod());
				
				final Float individualDeviation = Math.abs(diff-average)*Math.abs(diff-average);
				res+=individualDeviation;
			}
			res = res/lsT.size();
			final double sqrt = Math.sqrt(Double.parseDouble(res.toString()));
			final Float final1 = Float.parseFloat(sqrt + "");
			final Float fin = this.datesTransformationBackward(final1);
			return AdministratorTaskShowService.round(fin,2);
		}

		

		@Override
		public Dashboard findOne(final Request<Dashboard> request) {
			assert request!=null;
			
			final Dashboard result = new Dashboard();
			
			result.setNumberOfPublicTasks(this.getNumberOfPublicTasks(request) + " " + this.messageSource.getMessage("default.dashboard.task", null, LocaleContextHolder.getLocale()));
			result.setNumberOfPrivateTasks(this.getNumberOfPrivateTasks(request) + " " + this.messageSource.getMessage("default.dashboard.task", null, LocaleContextHolder.getLocale()));
			
			result.setNumberOfNonFinishedTasks(this.getNumberOfNonFinishedTasks(request) + " " + this.messageSource.getMessage("default.dashboard.task", null, LocaleContextHolder.getLocale()));
			result.setNumberOfFinishedTasks(this.getNumberOfFinishedTasks(request) + " " + this.messageSource.getMessage("default.dashboard.task", null, LocaleContextHolder.getLocale()));
			
			result.setMinimumWorkloads(this.getMinimumWorkloads(request) + " " + this.messageSource.getMessage("default.dashboard.workloadPeriod", null, LocaleContextHolder.getLocale()));
			result.setMaximumWorkloads(this.getMaximumWorkloads(request) + " " + this.messageSource.getMessage("default.dashboard.workloadPeriod", null, LocaleContextHolder.getLocale()));
			result.setAvarageWorkloads(this.getAvarageWorkloads(request) + " " + this.messageSource.getMessage("default.dashboard.workloadPeriod", null, LocaleContextHolder.getLocale()));
			result.setDeviationWorkload(this.getDeviationWorkloads(request) + " " + this.messageSource.getMessage("default.dashboard.workloadPeriod", null, LocaleContextHolder.getLocale()));
			
			result.setMinimumExecPeriod(this.getMinimumExecPeriod(request) + " " + this.messageSource.getMessage("default.dashboard.workloadPeriod", null, LocaleContextHolder.getLocale()));
			result.setMaximumExecPeriod(this.getMaximumExecPeriod(request) + " " + this.messageSource.getMessage("default.dashboard.workloadPeriod", null, LocaleContextHolder.getLocale()));
			result.setAvarageExecPeriod(this.getAvarageExecPeriod(request) + " " + this.messageSource.getMessage("default.dashboard.workloadPeriod", null, LocaleContextHolder.getLocale()));
			result.setDeviationExecPeriod(this.getDeviationExecPeriod(request) + " " + this.messageSource.getMessage("default.dashboard.workloadPeriod", null, LocaleContextHolder.getLocale()));
			
			return result;
		}

}
