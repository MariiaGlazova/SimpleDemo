package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simple")

public class SimpleController {

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int SUCCESS_STATUS_CODE = 1;
    private static final int ERROR_STATUS_CODE = -1;

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, SUCCESS_STATUS_CODE);
    }

    @PostMapping("/post")
    public BaseResponse pay(@RequestParam(value = "key") String key, @RequestBody SimpleRequest request) {

        final BaseResponse response;
        String SOME_KEY = "KEY";

        if (SOME_KEY.equalsIgnoreCase(key)) {
            Logger logger = LoggerFactory.getLogger(SimpleRequest.class);
            logger.info("UserId = {}.", request.getUserId());
            logger.info("Name = {}.", request.getName());
            logger.info("SomeData = {}.", request.getSomeData());

            response = new BaseResponse(SUCCESS_STATUS, SUCCESS_STATUS_CODE);
        } else {
            response = new BaseResponse(ERROR_STATUS, ERROR_STATUS_CODE);
        }
        return response;
    }
}
