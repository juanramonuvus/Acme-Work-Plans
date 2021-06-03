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
	@Query("SELECT MIN(t.workload) FROM Task t")
	Float getMinimumWorkloads();
	
	@Query("SELECT MAX(t.workload) FROM Task t")
	Float getMaximumWorkloads();

	@Query("SELECT t FROM Task t")
	Collection<Task> findAllTasks();
	
}
