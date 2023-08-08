package com.fragile.kafkainstallation.controller;

import com.fragile.kafkainstallation.services.KafkaMesagePublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer-app")
@RequiredArgsConstructor
public class KafkaPublisherController {


    private final KafkaMesagePublisher publisher;

    @PostMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable("message") String message) {
        try {
            for(int i = 0; i<=100000; i++){
                publisher.sendMessageToTopic(message  + i);
            }
            return ResponseEntity.ok("Message sent successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
