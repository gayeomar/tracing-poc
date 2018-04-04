package com.magenic.poc.trace.endpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class Service3 {

    Logger log = LoggerFactory.getLogger(Service3.class);

    private String service3Url;

    @GetMapping("/ep1")
    public String getSomethingFromService3Ep1() {
        log.info(" ****** Hello from Service 3, end-point ep1");

        return "\n Service 3, Done! \n ";
    }

}
