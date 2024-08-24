package com.forceattack012.domoShoppingApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.forceattack012.domoShoppingApp.adaptor.Producer;
import com.forceattack012.domoShoppingApp.model.request.CustomerRequest;
import com.forceattack012.domoShoppingApp.model.response.EmptyResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final Producer producer;
    private final ObjectMapper objectMapper;

    public CustomerController(Producer producer, ObjectMapper objectMapper) {
        this.producer = producer;
        this.objectMapper = objectMapper;
    }

    @PostMapping
    public void createCustomer(@RequestBody CustomerRequest customerRequest) throws JsonProcessingException {
        this.producer.produce(objectMapper.writeValueAsString(customerRequest));
    }
}
