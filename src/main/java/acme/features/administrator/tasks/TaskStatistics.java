package acme.features.administrator.tasks;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import acme.framework.entities.Administrator;
import acme.framework.entities.DomainEntity;
import acme.validators.ValidDatesTask;
import acme.validators.ValidWorkload;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@ValidDatesTask
@ValidWorkload
public class TaskStatistics extends DomainEntity{
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	@NotNull
	Integer numberOfPublicTasks;
	
	@NotNull
	Integer numberOfPrivateTasks;
	
	@NotNull
	Integer numberOfFinishedTasks;
	
	@NotNull
	Integer numberOfNonFinishedTasks;
	
	@NotNull
	Float avarageWorkloads;
	
	@NotNull
	Float minimumWorkloads;
	
	@NotNull
	Float maximumWorkloads;
	
	// Derived attributes -----------------------------------------------------

	// Relationships ----------------------------------------------------------


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Administrator administrator;

}
	
	

