package com.dawn.spring.controller;

import com.dawn.spring.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 消费者控制器
 *
 * @author yuliming
 * @create 2017-11-29 10:50
 */
@RestController
public class ConsumerController {

    private static final String HELLO = "hello";
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HelloService helloService;


    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.helloService() + HELLO;
    }

}
