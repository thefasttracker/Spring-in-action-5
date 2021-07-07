package space.thefasttracker.tacoapp.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.thefasttracker.tacoapp.domains.Ingredient;
import space.thefasttracker.tacoapp.repository.IngredientRepository;

@RestController
@RequestMapping(path="/ingredientsx", produces="application/json")
@CrossOrigin(origins="*")
public class IngredientController {

    private final IngredientRepository repo;

    public IngredientController(IngredientRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Ingredient> allIngredients() {
        return repo.findAll();
    }
}