package space.thefasttracker.tacoapp.controllers;

import lombok.Getter;
import org.springframework.hateoas.EntityModel;
import space.thefasttracker.tacoapp.domains.Ingredient;

public class IngredientEntityModel extends EntityModel<IngredientEntityModel> {

    @Getter
    private String name;

    @Getter
    private Ingredient.Type type;

    public IngredientEntityModel(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

}