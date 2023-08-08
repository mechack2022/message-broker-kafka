package com.fragile.kafkainstallation.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic createTopic(){
        return new NewTopic("config-topic", 5,(short) 1 );
    }
}
