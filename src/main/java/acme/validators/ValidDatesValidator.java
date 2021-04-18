package acme.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import acme.entities.tasks.Task;

public class ValidDatesValidator implements ConstraintValidator<ValidDates,Task>{
	
	@Override
    public void initialize(final ValidDates constraint) {
    }
 
    @Override
    public boolean isValid(final Task task, final ConstraintValidatorContext context) {
        return task.getExecutionStart().before(task.getExecutionEnd());
    }
	


}
