package acme.forms;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dashboard implements Serializable {

	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;

	// Attributes -------------------------------------------------------------
	
	@NotNull
	String numberOfPublicTasks;
	
	@NotNull
	String numberOfPrivateTasks;
	
	
	
	@NotNull
	String numberOfFinishedTasks;
	
	@NotNull
	String numberOfNonFinishedTasks;
	
	
	
	@NotNull
	String avarageWorkloads;
	
	@NotNull
	String minimumWorkloads;
	
	@NotNull
	String maximumWorkloads;
	
	@NotNull
	String deviationWorkload;
	
	
	
	@NotNull
	String avarageExecPeriod;
	
	@NotNull
	String minimumExecPeriod;
	
	@NotNull
	String maximumExecPeriod;
	
	@NotNull
	String deviationExecPeriod;
	

}
	
	

