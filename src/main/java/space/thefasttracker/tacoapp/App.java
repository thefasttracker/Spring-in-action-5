package space.thefasttracker.tacoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

/*
I add git-ignored profile application-secret.yml
with spring.datasource: url, username, password
and spring.security.user: name, password
*/
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.setAdditionalProfiles("secret");
        app.run(args);
    }

    // To avoid 404s when using Angular HTML 5 routing
    @Bean
    ErrorViewResolver supportPathBasedLocationStrategyWithoutHashes() {
        return (request, status, model) -> status == HttpStatus.NOT_FOUND
                ? new ModelAndView("index.html", Collections.<String, Object>emptyMap(), HttpStatus.OK)
                : null;
    }
}

//@ComponentScan(basePackages ="space.thefasttracker.tacoapp")
//public class App {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(App.class);
//
//        PersonService service = context.getBean(PersonService.class);
//
//        Person ivan = service.getByName("Ivan");
//        System.out.println("name: " + ivan.getName() + " age: " + ivan.getAge());
//    }
//}
