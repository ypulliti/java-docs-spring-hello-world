package com.example.demo.service.impl;

import com.example.demo.model.dao.inte.CustomerDao;
import com.example.demo.model.document.Customer;
import com.example.demo.service.inte.ICustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CustomerImpl implements ICustomer
{
    private static final Logger log = LoggerFactory.getLogger(CustomerImpl.class);

    @Autowired
    private CustomerDao customerDao;

    @Override
    public Mono<Customer> create(final Customer location) {

        return customerDao.save(location)
                .doFirst(() -> log.info("Begin create CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish create CoinBank"));
    }

    @Override
    public Flux<Customer> readAll() {

        return customerDao.findAll()
                .doFirst(() -> log.info("Begin readAll CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish readAll CoinBank"));
    }

    @Override
    public Mono<Customer> readByCodeLocation(String codeLocation) {
        return customerDao.readByCustomer(codeLocation)
                .doFirst(() -> log.info("Begin findByCodelocation CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish findByCodelocation CoinBank"));
    }

    @Override
    public Mono<Customer> updateById(final String id, final Customer location) {

        return customerDao.save(location)
                .doFirst(() -> log.info("Begin updateById CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish updateById CoinBank"));
    }

    @Override
    public Mono<Void> deleteById(final String id) {

        return customerDao.deleteById(id)
                .doFirst(() -> log.info("Begin deleteById CoinBank"))
                .doOnNext(a -> log.info(a.toString()))
                .doAfterTerminate(() -> log.info("Finish deleteById CoinBank"));
    }

}