package space.thefasttracker.tacoapp.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import space.thefasttracker.tacoapp.domains.Order;
import space.thefasttracker.tacoapp.domains.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<List<Order>> findByDeliveryZip(String deliveryZip);

    Optional<List<Order>> readOrdersByDeliveryZipAndPlacedAtBetween(
            String deliveryZip, Date startDate, Date endDate);

    Optional<List<Order>> findByDeliveryNameAndDeliveryCityIgnoreCase(
            String deliveryTo, String deliveryCity);

    Optional<List<Order>> findByDeliveryCityOrderByDeliveryName(String city);

    List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);

    @Query("select o from Order o where o.deliveryCity='Seattle'")
    Optional<List<Order>> customQuerySelect();

}
