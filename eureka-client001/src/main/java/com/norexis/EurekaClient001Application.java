package com.norexis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaClient001Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClient001Application.class, args);
    }

    @Value("${server.port}")
    private String port;

    @Value("${spring.application.name}")
    private String serviceName;

    @RequestMapping("/info")
    public String getInfo(@RequestParam String name) {
        return "Hello " + name + ", I am " + serviceName + ", from port:" + port;
    }

}
