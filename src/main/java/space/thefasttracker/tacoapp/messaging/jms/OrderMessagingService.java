package space.thefasttracker.tacoapp.messaging.jms;

import space.thefasttracker.tacoapp.domains.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);

}
