package space.thefasttracker.tacoapp.repository;

import org.springframework.data.repository.CrudRepository;
import space.thefasttracker.tacoapp.domains.Taco;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}