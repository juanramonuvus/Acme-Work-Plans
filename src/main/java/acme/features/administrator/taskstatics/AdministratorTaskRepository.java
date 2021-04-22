package acme.features.administrator.taskstatics;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
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
	
	@Query("SELECT STDDEV(t.workload) FROM Task t")
	Float getDeviationWorkloads();
	
	//----------------------------------------------------------------------------------------------------------------------------
	/*
	@Query("select avg((day(t.executionEnd)*24*60 + hour(t.executionEnd)*60 + minute(t.executionEnd))-(day(t.executionStart)*24*60 + hour(t.executionStart)*60 + minute(t.executionEnd))) from Task t")
	Float getAvarageExecPeriod();
	
	@Query("SELECT STTDEV(t.workload) FROM Task t")
	Float getDeviationWorkloads();
	
	@Query("SELECT MIN((day(t.executionEnd)*24*60 + hour(t.executionEnd)*60 + minutes(t.executionEnd)) - (day(t.executionStart)*24*60 + hour(t.executionStart)*60 + minutes(t.executionStart))) FROM Task t")
	Float getMinimumExecPeriod();
	
	//@Query("SELECT MAX(resultado) FROM SELECT DATE_PART('day', t.executionEnd - t.executionStart)  AS resultado FROM Task t")
	@Query("SELECT MAX((day(t.executionEnd)*24*60 + hour(t.executionEnd)*60 + minutes(t.executionEnd)) - (day(t.executionStart)*24*60 + hour(t.executionStart)*60 + minutes(t.executionStart))) FROM Task t")
	Float getMaximumExecPeriod();
	
	@Query("SELECT STDDEV((day(t.executionEnd)*24*60 + hour(t.executionEnd)*60 + minutes(t.executionEnd)) - (day(t.executionStart)*24*60 + hour(t.executionStart)*60 + minutes(t.executionStart))) FROM Task t")
	Float getDeviationExecPeriod();
	*/	
	//----------------------------------------------------------------------------------------------------------------------------
	@Query("SELECT t FROM Task t")
	Collection<Task> findAllTasks();
	
}
