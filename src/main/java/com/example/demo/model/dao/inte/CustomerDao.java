package com.example.demo.model.dao.inte;

import com.example.demo.model.document.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CustomerDao extends ReactiveMongoRepository<Customer, String> {

    Mono<Customer> readById(String codeCoinBank);
    Mono<Customer> readByCustomer(String codeCoinBank);
}
