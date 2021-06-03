package acme.entities.spamConfig;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import acme.framework.entities.DomainEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(indexes = { @Index(columnList= "id")})
public class BlackList extends DomainEntity{

	// Serialisation identifier ----------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	//Attributes -------------------------------------------------------
	

	@NotBlank
	protected String word;
	
}
