package space.thefasttracker.tacoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
