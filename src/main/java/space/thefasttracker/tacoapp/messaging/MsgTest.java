package space.thefasttracker.tacoapp.messaging;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import space.thefasttracker.tacoapp.messaging.jms.JmsOrderMessagingService;

@Component
public class MsgTest implements CommandLineRunner {

    private final RestTemplate restTemplate;
    private final JmsOrderMessagingService jmsOrderMessagingService;

    public MsgTest(RestTemplate restTemplate, JmsOrderMessagingService jmsOrderMessagingServic) {
        this.restTemplate = restTemplate;
        this.jmsOrderMessagingService = jmsOrderMessagingServic;
    }

    @Override
    public void run(String... args) throws Exception {
       /* Order order1 = new Order();
        Order order2 = new Order();
        order1.setId(100L);
        order2.setId(200L);
        System.out.println("------order1: " + order1.toString());
        System.out.println("------order2: " + order2.toString());

        jmsOrderMessagingService.sendOrder(order1);
        System.out.println("---222 oderrest" + restTemplate.exchange("http://localhost:8080/orders/receive/",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Ingredient>>() {})
                .getBody());*/

    }
}
/*
@Service
public class JmsProducer {

  @Autowired
  private JmsTemplate jmsTemplate;

  public void send(String message) {
    jmsTemplate.convertAndSend(message);
    log.info("Sent message='{}'", message);
  }
}

@Service
public class JmsConsumer {

    @JmsListener(destination = "${spring.jms.template.default-destination}")
    public void receive(String message) {
	log.info("Received message='{}'", message);
    }
}

@RestController
public class MyRestController {

    @Autowired
    JmsProducer jmsProducer;

    @PostMapping("/send")
    public void sendDataToJms(@RequestParam String message) {
	jmsProducer.send(message);
    }
}

---
spring.artemis.mode=EMBEDDED
spring.artemis.host=localhost
spring.artemis.port=61616

spring.artemis.embedded.enabled=true

spring.jms.template.default-destination=my-queue-1

logging.level.org.apache.activemq.audit.base=WARN
logging.level.org.apache.activemq.audit.message=WARN
---
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-artemis</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>org.apache.activemq</groupId>
    <artifactId>artemis-jms-server</artifactId>
</dependency>
---
curl -i -X POST http://localhost:8080/send?message=hello
 */
