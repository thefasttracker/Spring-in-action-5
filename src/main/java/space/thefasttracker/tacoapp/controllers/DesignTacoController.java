package space.thefasttracker.tacoapp.controllers;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import space.thefasttracker.tacoapp.domains.Taco;
import space.thefasttracker.tacoapp.repository.TacoRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path="/design",
        produces="application/hal+json")
@CrossOrigin(origins="*")
public class DesignTacoController {

    private final TacoRepository tacoRepo;

    public DesignTacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }
/*@GetMapping("/recent")
    public Iterable<Taco> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }*/

    //with HATEOAS
    @GetMapping("/recent")
    public CollectionModel<EntityModel<Taco>> recentTacos() {
        PageRequest page = PageRequest.of(0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        CollectionModel<EntityModel<Taco>> recentResources = CollectionModel.wrap(tacos);
        recentResources.add(
            linkTo( methodOn( DesignTacoController.class ).recentTacos() )
            .withRel("recents"));
        return recentResources;
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }

    @GetMapping("/{id}}")
    public Taco tacoById(@PathVariable("id") Long id) {
        Optional<Taco> optTaco = tacoRepo.findById(id);
        return optTaco.orElse(null);
    }
}