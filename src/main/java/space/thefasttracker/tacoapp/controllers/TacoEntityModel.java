package space.thefasttracker.tacoapp.controllers;

import lombok.Data;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;
import space.thefasttracker.tacoapp.domains.Taco;

import java.util.Date;

@Data
@Relation(value="taco", collectionRelation="tacos")
public class TacoEntityModel extends RepresentationModel<TacoEntityModel> {

    private static final IngredientEntityModelAssembler ingredientAssembler = new IngredientEntityModelAssembler();

    private final String name;

    private final Date createdAt;

    private final CollectionModel<IngredientEntityModel> ingredients;


    public TacoEntityModel(Taco taco) {
        this.name = taco.getName();
        this.createdAt = taco.getCreatedAt();
        this.ingredients = ingredientAssembler.toCollectionModel(taco.getIngredients());
    }

}
