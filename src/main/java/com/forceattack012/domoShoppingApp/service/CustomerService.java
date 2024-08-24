package com.forceattack012.domoShoppingApp.service;

import com.forceattack012.domoShoppingApp.adaptor.Producer;
import com.forceattack012.domoShoppingApp.entity.Customer;
import com.forceattack012.domoShoppingApp.model.request.CustomerRequest;
import com.forceattack012.domoShoppingApp.repository.CustomerRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CustomerService {
    private static final Logger logger = LogManager.getFormatterLogger(Producer.class);
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(CustomerRequest customerRequest){
        logger.info("==== Create ======");
        Customer customer = new Customer();
        customer.setName(customerRequest.getName());
        customer.setLastName(customerRequest.getLastName());
        customer.setCreatedAt(LocalDateTime.now());
        customer.setModifiedAt(LocalDateTime.now());

        customerRepository.save(customer);
    }
}
