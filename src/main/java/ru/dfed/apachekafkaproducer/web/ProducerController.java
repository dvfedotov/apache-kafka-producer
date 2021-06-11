package ru.dfed.apachekafkaproducer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dfed.apachekafkaproducer.model.Book;

@RestController
public class ProducerController {

    private static final String TOPIC = "NewTopic";
    @Autowired
    KafkaTemplate<String, Book> kafkaTemplate;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book) {
        kafkaTemplate.send(TOPIC, book);
        return "Published Successfully!";
    }
}
