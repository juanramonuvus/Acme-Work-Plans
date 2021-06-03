package acme.entities.spamConfig;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = { @Index(columnList= "id")})
public class SpamConfig extends DomainEntity{

	// Serialisation identifier ----------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	//Attributes -------------------------------------------------------
	
	@Range(min = 0, max = 100)
	@NotNull
	protected Float threshold;
	
}
