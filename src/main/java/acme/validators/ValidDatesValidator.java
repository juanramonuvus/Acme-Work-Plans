package acme.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.constraintvalidation.ValidationTarget;

import acme.entities.tasks.Task;

@SupportedValidationTarget(ValidationTarget.PARAMETERS)
public class ValidDatesValidator implements ConstraintValidator<ValidDates,Task>{
	
	@Override
    public void initialize(final ValidDates constraint) {
    }
 
    @Override
    public boolean isValid(final Task task, final ConstraintValidatorContext context) {
        return task.getExecutionStart().before(task.getExecutionEnd());
    }
	


}
