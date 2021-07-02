package space.thefasttracker.tacoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.thefasttracker.tacoapp.domains.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
