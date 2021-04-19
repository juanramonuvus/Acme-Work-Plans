package acme.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import acme.entities.plans.Plan;
import acme.entities.tasks.Task;

public class ValidDatesPlanValidator implements ConstraintValidator<ValidDatesPlan,Plan>{
	
	@Override
    public void initialize(final ValidDatesPlan constraint) {
    }
 
    @Override
    public boolean isValid(final Plan plan, final ConstraintValidatorContext context) {
        boolean result = true;
        for(final Task task : plan.getTasks()) {
        	if(task.getExecutionStart().before(plan.getExecutionStart())) {
        		result = false;
        	}
        }
        for(final Task task : plan.getTasks()) {
        	if(task.getExecutionEnd().after(plan.getExecutionStart())) {
        		result = false;
        	}
        }
        return result;
    }
	


}
