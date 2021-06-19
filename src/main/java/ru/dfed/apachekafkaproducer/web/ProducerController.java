package ru.dfed.apachekafkaproducer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dfed.apachekafkaproducer.model.Message;

@RestController
public class ProducerController {

    private static final String TOPIC = "zfront_incoming";
    @Autowired
    KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Message message) {
        kafkaTemplate.send(TOPIC, message);
        return "Published Successfully!";
    }
}
