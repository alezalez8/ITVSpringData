package itvdn.todolist.repositories;

import itvdn.todolist.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
