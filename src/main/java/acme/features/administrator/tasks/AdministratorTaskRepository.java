package acme.features.administrator.tasks;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorTaskRepository extends AbstractRepository{

	@Query("SELECT COUNT(t) FROM Task t WHERE t.isPublic = true")
	Integer getNumberOfPublicTasks();
	
	@Query("SELECT COUNT(t) FROM Task t WHERE t.isPublic = false")
	Integer getNumberOfPrivateTasks();
	
	//----------------------------------------------------------------------------------------------------------------------------
	@Query("SELECT COUNT(t) FROM Task t WHERE t.executionEnd <= ?1")
	Integer getNumberOfFinishedTasks(Date fechaActual);
	
	@Query("SELECT COUNT(t) FROM Task t WHERE t.executionEnd > ?1")
	Integer getNumberOfNonFinishedTasks(Date fechaActual);
	
	//----------------------------------------------------------------------------------------------------------------------------
	@Query("SELECT AVG(t.workload) FROM Task t")
	Float getAvarageWorkloads();
	
	@Query("SELECT MIN(t.workload) FROM Task t")
	Float getMinimumWorkloads();
	
	@Query("SELECT MAX(t.workload) FROM Task t")
	Float getMaximumWorkloads();
	
	//----------------------------------------------------------------------------------------------------------------------------
	@Query("SELECT AVG(t.executionEnd - t.executionStart) FROM Task t")
	Float getAvarageExecPeriod();

	@Query("SELECT MIN(t.executionEnd - t.executionStart) FROM Task t")
	Float getMinimumExecPeriod();
	
	//@Query("SELECT MAX(resultado) FROM SELECT DATE_PART('day', t.executionEnd - t.executionStart)  AS resultado FROM Task t")
	@Query("SELECT MAX(t.executionEnd - t.executionStart) FROM Task t")
	Float getMaximumExecPeriod();
	
}
