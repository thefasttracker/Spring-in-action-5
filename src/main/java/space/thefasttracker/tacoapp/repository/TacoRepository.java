package space.thefasttracker.tacoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import space.thefasttracker.tacoapp.domains.Taco;

@RepositoryRestResource(collectionResourceRel = "tacos", path = "tacos")
public interface TacoRepository extends JpaRepository<Taco, Long> {
}