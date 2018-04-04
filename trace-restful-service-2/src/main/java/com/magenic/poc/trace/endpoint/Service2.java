package com.magenic.poc.trace.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@Slf4j
public class Service2 {

    Logger log = LoggerFactory.getLogger(Service2.class);


    @Autowired private RestTemplate restTemplate;

    @Value("${trace.service-3.url}")
    private String service3Url;

    @GetMapping("/ep1")
    public String getXyz() {
        log.info(" ****** Hello from Service 2, end-point ep1");
        log.info(" ****** Now calling Service 3, end-point ep1");
        //Calling Service 3 end-point 1
        String response = restTemplate.getForObject(service3Url + "/ep1", String.class);
        log.info(" ****** Response from Service 3 ep1: {}", response);

        return response;
    }

}
