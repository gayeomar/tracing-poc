package com.magenic.poc.trace.util;

import com.magenic.poc.trace.endpoint.Service1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MdcTemplate {

    Logger log = LoggerFactory.getLogger(Service1.class);

    public static final String TRACE_ID_NAME = "X-B3-TraceId";
    public static final String SPAN_ID_NAME = "X-B3-SpanId";

    @Scheduled(initialDelay = 20000, fixedRate = 40000)
    public void bootstrapMDC(){

        log.info(" ** Generated Trace and Span IDs");

        MDC.put(TRACE_ID_NAME, UUID.randomUUID().toString().replaceAll("-", ""));
        MDC.put(SPAN_ID_NAME, UUID.randomUUID().toString().replaceAll("-", ""));

        log.info(" ** Overrided Trace and Span IDs");
    }

}
