package space.thefasttracker.tacoapp.restclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import space.thefasttracker.tacoapp.domains.Ingredient;

import java.net.URI;
import java.util.List;

@Component
@Slf4j
public class RestExamples implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner fetchIngredients(TacoClient tacoClient) {
        return args -> {
            log.info("----------------------- GET -------------------------");
            log.info("GETTING INGREDIENT BY IDE");
            log.info("Ingredient:  " + tacoClient.getIngredientById("CHED"));
            log.info("GETTING ALL INGREDIENTS");
            List<Ingredient> ingredients = tacoClient.getAllIngredients();
            log.info("All ingredients:");
            for (Ingredient ingredient : ingredients) {
                log.info("   - " + ingredient);
            }
        };
    }

    @Bean
    public CommandLineRunner putAnIngredient(TacoClient tacoClient) {
        return args -> {
            log.info("----------------------- PUT -------------------------");
            Ingredient before = tacoClient.getIngredientById("LETC");
            log.info("BEFORE:  " + before);
            tacoClient.updateIngredient(new Ingredient("LETC", "Shredded Lettuce", Ingredient.Type.VEGGIES));
            Ingredient after = tacoClient.getIngredientById("LETC");
            log.info("AFTER:  " + after);
        };
    }

  /*  @Bean
    public CommandLineRunner addAnIngredient(TacoClient tacoClient) {
        return args -> {
            log.info("----------------------- POST -------------------------");
            Ingredient chix = new Ingredient("CHIX", "Shredded Chicken", Ingredient.Type.PROTEIN);
            Ingredient chixAfter = tacoClient.createIngredient(chix);
            log.info("AFTER=1:  " + chixAfter);
//      Ingredient beefFajita = new Ingredient("BFFJ", "Beef Fajita", Ingredient.Type.PROTEIN);
//      URI uri = tacoCloudClient.createIngredient(beefFajita);
//      log.info("AFTER-2:  " + uri);      
//      Ingredient shrimp = new Ingredient("SHMP", "Shrimp", Ingredient.Type.PROTEIN);
//      Ingredient shrimpAfter = tacoCloudClient.createIngredient(shrimp);
//      log.info("AFTER-3:  " + shrimpAfter);      
        };
    }*/


    /*@Bean
    public CommandLineRunner deleteAnIngredient(TacoClient tacoClient) {
        return args -> {
            log.info("----------------------- DELETE -------------------------");
            // start by adding a few ingredients so that we can delete them later...
            Ingredient beefFajita = new Ingredient("BFFJ", "Beef Fajita", Ingredient.Type.PROTEIN);
            tacoClient.createIngredient(beefFajita);
            Ingredient shrimp = new Ingredient("SHMP", "Shrimp", Ingredient.Type.PROTEIN);
            tacoClient.createIngredient(shrimp);


            Ingredient before = tacoClient.getIngredientById("CHIX");
            log.info("BEFORE:  " + before);
            tacoClient.deleteIngredient(before);
            Ingredient after = tacoClient.getIngredientById("CHIX");
            log.info("AFTER:  " + after);
            before = tacoClient.getIngredientById("BFFJ");
            log.info("BEFORE:  " + before);
            tacoClient.deleteIngredient(before);
            after = tacoClient.getIngredientById("BFFJ");
            log.info("AFTER:  " + after);
            before = tacoClient.getIngredientById("SHMP");
            log.info("BEFORE:  " + before);
            tacoClient.deleteIngredient(before);
            after = tacoClient.getIngredientById("SHMP");
            log.info("AFTER:  " + after);
        };
    }*/

    //
    // Traverson examples
    //

    @Bean
    public Traverson traverson() {
        Traverson traverson = new Traverson(
                URI.create("http://localhost:8080/api"), MediaTypes.HAL_JSON);
        return traverson;
    }

    @Bean
    public CommandLineRunner traversonGetIngredients(TacoClient tacoClient) {
        return args -> {
            Iterable<Ingredient> ingredients = tacoClient.getAllIngredientsWithTraverson();
            log.info("----------------------- GET INGREDIENTS WITH TRAVERSON -------------------------");
            for (Ingredient ingredient : ingredients) {
                log.info("   -  " + ingredient);
            }
        };
    }

/*    @Bean
    public CommandLineRunner traversonSaveIngredient(TacoClient tacoClient) {
        return args -> {
            Ingredient pico = tacoClient.addIngredient(
                    new Ingredient("PICO", "Pico de Gallo", Ingredient.Type.SAUCE));
            List<Ingredient> allIngredients = tacoClient.getAllIngredients();
            log.info("----------------------- ALL INGREDIENTS AFTER SAVING PICO -------------------------");
            for (Ingredient ingredient : allIngredients) {
                log.info("   -  " + ingredient);
            }
            tacoClient.deleteIngredient(pico);
        };
    }*/

    /*@Bean
    public CommandLineRunner traversonRecentTacos(TacoClient tacoClient) {
        return args -> {
            Iterable<Taco> recentTacos = tacoClient.getRecentTacosWithTraverson();
            log.info("----------------------- GET RECENT TACOS WITH TRAVERSON -------------------------");
            for (Taco taco : recentTacos) {
                log.info("   -  " + taco);
            }
        };
    }*/
}