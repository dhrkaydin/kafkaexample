package com.kamil.producerexample.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> template;

    public KafkaController(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @GetMapping("/test")
    public void test(){
        System.out.println("test");
    }

    @PostMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("exampleTopic", message);
    }
}
