package com.dawn.spring.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 服务类
 *
 * @author yuliming
 * @create 2017-12-05 10:35
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback")
    public String helloService(){
        long start=System.currentTimeMillis();
        String result=restTemplate.getForEntity("http://DAWNBOOT/hello",String.class).getBody();
        long end=System.currentTimeMillis();
        System.out.println("spend time :"+(end-start));
        return result;
    }

    public String helloFallback(){
        return "error";
    }

}
