package space.thefasttracker.tacoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import space.thefasttracker.tacoapp.domains.Ingredient;

@CrossOrigin(origins="*")
public interface IngredientRepository extends JpaRepository<Ingredient, String> {
}