package space.thefasttracker.tacoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
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

//Page 57, listing 3.1:
//        The ninth line in listing 3.1 is currently:
//
//        "select id, name, type from Ingredient");
//        It should be:
//
//        "select id, name, type from Ingredient where id=?");
//        Page 88/89:
//        The code in Listing 4.2 will require a password encoder. Look at the example in section 4.2.2 for how you
//        might set a password encoder. Or, optionally declare a bean method that returns an implementation of PasswordEncoder.
//
//        Page 143, listing 6.2
//        Add this note to listing 6.2:
//
//        The findAll() method called on TacoRepository in Listing 6.2 accepts a PageRequest object to perform paging.
//        This particular findAll() method is made available by changing TacoRepository so it extends PagingAndSortingRepository
//        instead of CrudRepository. The downloadable sample code has this change in place, but it is never explicitly called out in the book's text.
//
//        Page 201
//        The first paragraph in the "Handling Rabbit MQ messages with listeners" should read:
//
//        For message-driven RabbitMQ beans, Spring offers RabbitListener, the RabbitMQ counterpart to JmsListener.
//        To specify that a method should be invoked when a message arrives in a RabbitMQ queue, annotate a beanâ€™s method with @RabbitListener.