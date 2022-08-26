package com.example.demo.controller;

import com.example.demo.model.document.Customer;
import com.example.demo.service.inte.ICustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/customers")
public class CustomerController
{
    @RequestMapping("name")
    public String getMicroserviceName()
    {
        return "Hello";
    }

    @Autowired
    private ICustomer coinbankServiceInte;

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    @GetMapping("getCustomers")
    public Flux<Customer> readAll() {
        log.debug("Begin RestController readAll Location");
        return coinbankServiceInte.readAll();
    }

    @PutMapping("update/{id}")
    public Mono<Customer> updateById(@RequestBody final Customer location, @PathVariable("id") final String id)
    {
        log.debug("Begin RestController updateById Location");
        return coinbankServiceInte.updateById(id, location);
    }

    @DeleteMapping("delete/{id}")
    public Mono<Void> deleteById(@PathVariable final String id)
    {
        log.debug("Begin RestController deleteById Location");
        return coinbankServiceInte.deleteById(id);
    }

    @PostMapping("create")
    public Mono<Customer> create(@RequestBody final Customer coinbank) {
        log.debug("Begin RestController create COinBank");
        return coinbankServiceInte.create(coinbank);
    }

}
