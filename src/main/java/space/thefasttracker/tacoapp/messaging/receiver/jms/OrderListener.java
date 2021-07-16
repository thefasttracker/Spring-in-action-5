package space.thefasttracker.tacoapp.messaging.receiver.jms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import space.thefasttracker.tacoapp.domains.Order;

// Push message receiver
//@Profile("jms-listener")
@Slf4j
@Component
public class OrderListener {

    /*private KitchenUI ui;

    @Autowired
    public OrderListener(KitchenUI ui) {
        this.ui = ui;
    }*/

    @JmsListener(destination = "tacocloud.order.queue")
    public void receiveOrder(Order order) {
//        ui.displayOrder(order);
        log.info("--- Push message receiver OrderListener got order: {}", order);
    }
}