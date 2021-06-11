package space.thefasttracker.tacoapp.repository;

import org.springframework.data.repository.CrudRepository;
import space.thefasttracker.tacoapp.domains.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}
