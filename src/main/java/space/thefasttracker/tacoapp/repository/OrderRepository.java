package space.thefasttracker.tacoapp.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import space.thefasttracker.tacoapp.domains.Order;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findByDeliveryZip(String deliveryZip);

    List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

    List<Order> findByDeliveryNameAndDeliveryCityIgnoreCase(
            String deliveryTo, String deliveryCity);

    List<Order> findByDeliveryCityOrderByDeliveryName(String city);

    @Query("select o from Order o where o.deliveryCity='Seattle'")
    List<Order> customQuerySelect();

}
