package acme.features.manager.tasks;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.tasks.Task;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface ManagerTaskRepository extends AbstractRepository{

	@Query("select t from Task t where t.id = ?1")
	Task findOneTaskById(int id);
	
	@Query("select t from Task t where t.manager.id = :managerId")
	Collection<Task> findManyByManagerId(int managerId);
	
//	@Query("select pts.id from Plan pts where pts.tasks like :taskId")
//	Collection<Plan> findPlanTaskByTaskId(int taskId);
	
}
