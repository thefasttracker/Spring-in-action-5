package space.thefasttracker.tacoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.thefasttracker.tacoapp.domains.Taco;

public interface TacoRepository extends JpaRepository<Taco, Long> {
}