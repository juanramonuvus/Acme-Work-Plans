package acme.features.administrator.tasks;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorTaskRepository extends AbstractRepository{

	@Query("select COUNT(t) from Task t WHERE t.isPublic = true")
	Integer getNumberOfPublicTasks();
	
	@Query("select COUNT(t) from Task t WHERE t.isPublic = false")
	Integer getNumberOfPrivateTasks();
	
	@Query("select COUNT(t) from Task t WHERE t.executionEnd <= ?1")
	Integer getNumberOfFinishedTasks(Date fechaActual);
	
	@Query("select COUNT(t) from Task t WHERE t.executionEnd > ?1")
	Integer getNumberOfNonFinishedTasks(Date fechaActual);
	
	@Query("select AVG(t.workload) from Task t")
	Float getAvarageWorkloads();
	
	@Query("select MIN(t.workload) from Task t")
	Float getMinimumWorkloads();
	
	@Query("select MAX(t.workload) from Task t")
	Float getMaximumWorkloads();
	
}
