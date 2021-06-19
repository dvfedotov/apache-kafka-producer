package ru.dfed.apachekafkaproducer.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.dfed.apachekafkaproducer.model.OutputMessage;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "#{'${spring.kafka.consumer.topic}'}", groupId = "#{'${spring.kafka.consumer.group-id}'}")
    public void consume(@Payload OutputMessage message) {
        System.out.println(message.toString());
    }


}