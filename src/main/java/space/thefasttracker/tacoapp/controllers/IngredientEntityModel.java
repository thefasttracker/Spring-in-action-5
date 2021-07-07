package space.thefasttracker.tacoapp.controllers;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;
import space.thefasttracker.tacoapp.domains.Ingredient;

@Data
public class IngredientEntityModel extends RepresentationModel<IngredientEntityModel> {

    private String name;

    private Ingredient.Type type;

    public IngredientEntityModel(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }

}