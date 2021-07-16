package space.thefasttracker.tacoapp.messaging.receiver.rabbit;

/*import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import space.thefasttracker.tacoapp.domains.Order;

@Slf4j
@Profile("rabbitmq-listener")
@Component
public class OrderListener {

    *//*private KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }*//*

    @RabbitListener(queues = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
        // ui.displayOrder(order);
        log.info("--- Push message Rabbit receiver OrderListener got order: {}", order);
    }

}*/
