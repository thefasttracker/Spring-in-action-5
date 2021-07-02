package space.thefasttracker.tacoapp.controllers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import space.thefasttracker.tacoapp.domains.Ingredient;

class IngredientEntityModelAssembler extends RepresentationModelAssemblerSupport<Ingredient, IngredientEntityModel> {

    public IngredientEntityModelAssembler() {
        super(IngredientController.class, IngredientEntityModel.class);
    }

    @Override
    public IngredientEntityModel toModel(Ingredient ingredient) {
        return createModelWithId(ingredient.getId(), ingredient);
    }

    @Override
    protected IngredientEntityModel instantiateModel(Ingredient ingredient) {
        return new IngredientEntityModel(ingredient);
    }

}
