package com.forceattack012.domoShoppingApp.repository;

import com.forceattack012.domoShoppingApp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
