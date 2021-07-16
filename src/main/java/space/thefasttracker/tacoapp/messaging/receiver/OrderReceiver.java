package space.thefasttracker.tacoapp.messaging.receiver;

import space.thefasttracker.tacoapp.domains.Order;

public interface OrderReceiver {

    Order receiveOrder();

}