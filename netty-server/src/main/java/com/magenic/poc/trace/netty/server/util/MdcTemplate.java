package com.magenic.poc.trace.netty.server.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 * @author <a href="mailto:omarg@magenic.com">Omar Gaye</a>
 */
public class MdcTemplate {

    static  Logger log = LoggerFactory.getLogger(MdcTemplate.class);

    public static final String TRACE_ID_NAME = "X-B3-TraceId";
    public static final String SPAN_ID_NAME = "X-B3-SpanId";

    public static void bootstrapMDC(){

        log.info(" ** No Trace, Span IDs so far");

        MDC.put(TRACE_ID_NAME, UUID.randomUUID().toString().replaceAll("-", ""));
        MDC.put(SPAN_ID_NAME, UUID.randomUUID().toString().replaceAll("-", ""));

        log.info(" ** Now we should have Trace and Span IDs");
    }

}
