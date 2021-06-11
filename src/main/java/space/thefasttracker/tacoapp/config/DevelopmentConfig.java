package space.thefasttracker.tacoapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import space.thefasttracker.tacoapp.domains.Ingredient;
import space.thefasttracker.tacoapp.domains.User;
import space.thefasttracker.tacoapp.repository.IngredientRepository;
import space.thefasttracker.tacoapp.repository.UserRepository;

@Slf4j
@Profile("!prod")
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo, UserRepository userRepo,
                                        PasswordEncoder encoder) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                User user = userRepo.findByUsername("ft2");

                if(user == null) {
                    userRepo.save(new User("ft2", encoder.encode("ft2pass"),
                        "Fast Tracker", "123 North Street", "Cross Roads", "TX",
                        "76227", "123-123-1234"));
                }

                fillIngredientsTable();
            }

            private void fillIngredientsTable() {
                repo.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
                repo.save(new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP));
                repo.save(new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN));
                repo.save(new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN));
                repo.save(new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES));
                repo.save(new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES));
                repo.save(new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE));
                repo.save(new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE));
                repo.save(new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE));
                repo.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));

            }
        };
    }

}