package com.example.demo.service.inte;

import com.example.demo.model.document.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ICustomer
{
    Mono<Customer> create(final Customer location);

    Flux<Customer> readAll();

    Mono<Customer> readByCodeLocation(String codeLocation);

    Mono<Customer> updateById(final String id, final Customer location);

    Mono<Void> deleteById(final String id);
}