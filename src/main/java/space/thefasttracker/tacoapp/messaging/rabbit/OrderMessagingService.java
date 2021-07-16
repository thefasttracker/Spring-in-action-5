package space.thefasttracker.tacoapp.messaging.rabbit;

import space.thefasttracker.tacoapp.domains.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);

}