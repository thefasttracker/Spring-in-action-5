package space.thefasttracker.tacoapp.controllers;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;
import space.thefasttracker.tacoapp.domains.Taco;

@Component
public class TacoEntityModelAssembler extends RepresentationModelAssemblerSupport<Taco, TacoEntityModel> {

    public TacoEntityModelAssembler() {
        super(RecentTacosController.class, TacoEntityModel.class);
    }

    @Override
    protected TacoEntityModel instantiateModel(Taco taco) {
        return new TacoEntityModel(taco);
    }

    @Override
    public TacoEntityModel toModel(Taco taco) {
        return createModelWithId(taco.getId(), taco);
    }

}