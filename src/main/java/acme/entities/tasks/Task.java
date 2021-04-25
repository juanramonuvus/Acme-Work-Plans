package acme.entities.tasks;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.plans.Plan;
import acme.framework.entities.DomainEntity;
import acme.framework.entities.Manager;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
		final Double diff = (double)(this.getExecutionEnd().getTime() - this.getExecutionStart().getTime());
		
		final Float hours = (float) (diff/ (1000 * 60 * 60));
		final Float minsDec = (float) (((diff / (1000 * 60)) % 60)/100);
		return hours.intValue()+minsDec;
	}
	

	// Relationships ----------------------------------------------------------


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	protected Manager manager;
	
	@Valid
	@ManyToMany(mappedBy="tasks", cascade = CascadeType.REMOVE)
	@OnDelete(action = OnDeleteAction.CASCADE)
	protected List<Plan> plans;
	

}
	
	

