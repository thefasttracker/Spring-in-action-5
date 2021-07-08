package space.thefasttracker.tacoapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import space.thefasttracker.tacoapp.domains.Taco;
import space.thefasttracker.tacoapp.repository.TacoRepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Slf4j
@RepositoryRestController
public class RecentTacosController {

    private final TacoRepository tacoRepo;
    private final TacoEntityModelAssembler tacoEntityModelAssembler;

    public RecentTacosController(TacoRepository tacoRepo, TacoEntityModelAssembler tacoEntityModelAssembler) {
        this.tacoRepo = tacoRepo;
        this.tacoEntityModelAssembler = tacoEntityModelAssembler;
    }

    @GetMapping(path="/tacos/recent", produces="application/hal+json")
    public ResponseEntity<CollectionModel<TacoEntityModel>> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();

        CollectionModel<TacoEntityModel> tacoResources = tacoEntityModelAssembler.toCollectionModel(tacos);
        CollectionModel<TacoEntityModel> recentResources = CollectionModel.of(tacoResources);

        recentResources.add(
                linkTo(methodOn(RecentTacosController.class)
                        .recentTacos())
                        .withRel("recents"));
        return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }

}
