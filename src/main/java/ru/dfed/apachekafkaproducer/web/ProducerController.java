package ru.dfed.apachekafkaproducer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dfed.apachekafkaproducer.model.InputMessage;

@RestController
public class ProducerController {

    private static final String TOPIC = "zfront_incoming";
    @Autowired
    KafkaTemplate<String, InputMessage> kafkaTemplate;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody InputMessage inputMessage) {
        kafkaTemplate.send(TOPIC, inputMessage);
        return "Published Successfully!";
    }
}
