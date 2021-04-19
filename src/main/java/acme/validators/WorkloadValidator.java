package acme.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import acme.entities.tasks.Task;

public class WorkloadValidator implements ConstraintValidator<ValidWorkload,Task>{
	
	@Override
    public void initialize(final ValidWorkload constraint) {
    }
 
    @Override
    public boolean isValid(final Task task, final ConstraintValidatorContext context) {
    	
		final float workLoadDecimals = task.getWorkload() - task.getWorkload().intValue();
		
		return task.getPeriod() >= task.getWorkload() && task.getWorkload() >= 0 && workLoadDecimals <= 0.59;
    }
	


}
