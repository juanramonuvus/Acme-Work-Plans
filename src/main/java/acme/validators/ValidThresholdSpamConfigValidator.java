package acme.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import acme.entities.spamConfig.SpamConfig;

public class ValidThresholdSpamConfigValidator implements ConstraintValidator<ValidThresholdSpamConfig, SpamConfig>{
	
	@Override
    public void initialize(final ValidThresholdSpamConfig constraint) {
    }
 
    @Override
    public boolean isValid(final SpamConfig spamConfig, final ConstraintValidatorContext context) {
    	if (spamConfig.getThreshold() >= 0.f && spamConfig.getThreshold() <= 100.f) {
    		return true;
    	} 
    	
    	return false;
    	
    }
	


}
