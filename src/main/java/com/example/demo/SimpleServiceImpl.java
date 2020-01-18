package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceImpl implements SimpleService {

    @Value("${default.name}")
    String name;

    @Override
    public void doSomething() {
        Logger logger = LoggerFactory.getLogger(SimpleService.class);
        logger.info("User Id = {}.", name);
    }
}
