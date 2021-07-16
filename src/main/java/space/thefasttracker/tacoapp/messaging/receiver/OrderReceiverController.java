package space.thefasttracker.tacoapp.messaging.receiver;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import space.thefasttracker.tacoapp.domains.Order;

// Pull message receiver
@Slf4j
@Profile({"jms-template", "rabbitmq-template"})
@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderReceiverController {

    private final OrderReceiver orderReceiver;

    @GetMapping("/receive")
    public String receiveOrder() {
        Order order = orderReceiver.receiveOrder();
        log.info("--- Pull message receiver OrderReceiverController Received order: {}", order);
        if (order != null) {
//            model.addAttribute("order", order);
            return "receiveOrder";
        }
        return "noOrder";
    }


}