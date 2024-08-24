package com.forceattack012.domoShoppingApp.adaptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forceattack012.domoShoppingApp.model.request.CustomerRequest;
import com.forceattack012.domoShoppingApp.service.CustomerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private static final Logger logger = LogManager.getFormatterLogger(Consumer.class);
    private final CustomerService customerService;
    private final ObjectMapper objectMapper;

    public Consumer(CustomerService customerService, ObjectMapper objectMapper) {
        this.customerService = customerService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "shopping-group", groupId = "shoppingGroup")
    public void consume(String message) throws JsonProcessingException {
        logger.info("Consume message: %s", message);

        customerService.createCustomer(objectMapper.readValue(message, CustomerRequest.class));
    }
}
