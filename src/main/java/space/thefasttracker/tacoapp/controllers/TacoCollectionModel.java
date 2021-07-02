package space.thefasttracker.tacoapp.controllers;

import org.springframework.hateoas.CollectionModel;

import java.util.List;

public class TacoCollectionModel extends CollectionModel<TacoEntityModel> {
    public TacoCollectionModel(List<TacoEntityModel> tacoResources) {
        super(tacoResources);
    }
}