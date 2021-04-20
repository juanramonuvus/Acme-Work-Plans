package acme.entities.tasks;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.DomainEntity;
import acme.framework.entities.Manager;
import acme.validators.ValidDatesTask;
import acme.validators.ValidWorkload;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidDatesTask
@ValidWorkload
public class Task extends DomainEntity{
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	@NotBlank
	@Length(min=1, max=80)
	protected String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date executionStart;
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	protected Date executionEnd;
	
	@NotNull
	protected Float workload;
	
	@NotBlank
	@Length(min = 1, max = 500)
	protected String description;
	
	@NotNull
	protected Boolean isPublic;
	
	@URL
	protected String link;
	
	// Derived attributes -----------------------------------------------------

	public Float getPeriod() {
		final float diff = (float)this.getExecutionEnd().getTime() - (float)this.getExecutionStart().getTime();
		final float hours = ((int)diff/ (1000 * 60 * 60));
		final float minsDec = ((diff / (1000 * 60)) % 60)/100;
		return hours+minsDec;
	}
	

	// Relationships ----------------------------------------------------------


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Manager manager;

}
	
	

