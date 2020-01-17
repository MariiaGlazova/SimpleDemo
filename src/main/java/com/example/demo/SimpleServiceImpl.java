package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Value("${spring.application.name}")
    String name;

    @Override
    public void doSomething() {
        Logger logger = LoggerFactory.getLogger(SimpleService.class);
        logger.info("User Id = {}.", name);
    }
}
