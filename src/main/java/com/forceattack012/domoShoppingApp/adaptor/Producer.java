package com.forceattack012.domoShoppingApp.adaptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forceattack012.domoShoppingApp.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private static final Logger logger = LogManager.getFormatterLogger(Producer.class);
    @Value("${kafka-config.topic}")
    private String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public Producer(KafkaTemplate<String, String> kafkaTemplate, CustomerService customerService, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(String data) throws JsonProcessingException {
        logger.info("Produce Topic: %s - Message: %s", topic, data);
        kafkaTemplate.send(topic, data);
    }

}
