package space.thefasttracker.tacoapp.repository;

import org.springframework.data.repository.CrudRepository;
import space.thefasttracker.tacoapp.domains.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}