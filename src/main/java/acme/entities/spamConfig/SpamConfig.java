package acme.entities.spamConfig;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class SpamConfig extends DomainEntity{

	// Serialisation identifier ----------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	//Attributes -------------------------------------------------------
	
	@NotNull
	protected Float threshold;
	
}
