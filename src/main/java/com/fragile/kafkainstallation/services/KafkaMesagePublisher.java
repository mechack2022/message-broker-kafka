package com.fragile.kafkainstallation.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaMesagePublisher {

    private final KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("kafka-with-springboot-docker", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message : {} with offset {} : ", message, result.getRecordMetadata());
            } else {
                log.info("Unable to send message : {}  due to {} ", message, ex.getMessage());
            }
        });
    }
}
