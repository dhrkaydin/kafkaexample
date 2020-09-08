package com.kamil.consumerexample.controller;

import com.kamil.consumerexample.consumer.ExampleTopicConsumer;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {
    private ExampleTopicConsumer exampleTopicConsumer;

    public KafkaController(ExampleTopicConsumer myTopicConsumer) {
        this.exampleTopicConsumer = myTopicConsumer;
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }
    @GetMapping("/kafka/messages")
    public List<String> getMessages() {
        return exampleTopicConsumer.getMessages();
    }

}
