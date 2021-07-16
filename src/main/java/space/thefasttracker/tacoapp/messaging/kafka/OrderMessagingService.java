package space.thefasttracker.tacoapp.messaging.kafka;

import space.thefasttracker.tacoapp.domains.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);

}