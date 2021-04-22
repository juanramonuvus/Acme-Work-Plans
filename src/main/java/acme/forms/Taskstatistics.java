package acme.forms;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Taskstatistics implements Serializable {

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
	
	@NotNull
	Float deviationWorkload;
	
	
	
	@NotNull
	Float avarageExecPeriod;
	
	@NotNull
	Float minimumExecPeriod;
	
	@NotNull
	Float maximumExecPeriod;
	
	@NotNull
	Float deviationExecPeriod;
	

}
	
	

