package com.magenic.poc.trace.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
//@Slf4j
public class Service1 {

    Logger log = LoggerFactory.getLogger(Service1.class);

    @Autowired
    private RestTemplate restTemplate;

    @Value("${trace.service-1.url}")
    private String service1Url;

    @Value("${trace.service-2.url}")
    private String service2Url;

    @GetMapping("/ep1")
    public String getXyz() {
        log.info(" ****** Hello from Service 1, ep1 end-point");

        return "\n Done! \n ";
    }

    @GetMapping("/ep2")
    public String getAbc() {
        log.info(" ****** Before calling end-point ep1 from end-point ep2");
        String response = restTemplate.getForObject(service1Url + "/ep1", String.class);
        log.info(" ****** Response from ep1 service: {}", response);

        return response;
    }

    @GetMapping("/ep3")
    public String getFromService2() {
        log.info(" ****** Before calling Service2, ep1 from Sevice1 ep3");

        //Calling Service 2 end-point 1
        String response = restTemplate.getForObject(service2Url + "/ep1", String.class);
        log.info(" ****** Response from Service1 ep3: {}", response);

        return response;
    }

}
