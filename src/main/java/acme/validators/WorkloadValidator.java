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
    	final float diff = (float)task.getExecutionEnd().getTime() - (float)task.getExecutionStart().getTime();
		final float hours = ((int)diff/ (1000 * 60 * 60))% 24;
		final float minsDec = ((diff / (1000 * 60)) % 60)/100;
		
		final float workLoadDecimals = task.getWorkload() - task.getWorkload().intValue();
		
		return (hours+minsDec) >= task.getWorkload() && task.getWorkload() >= 0 && workLoadDecimals <= 0.59;
    }
	


}
