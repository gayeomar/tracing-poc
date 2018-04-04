package com.magenic.poc.trace.util;


import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

import java.util.Map;

public class PocPatternLayoutEncoderBase extends PatternLayoutEncoderBase<ILoggingEvent> {

    @Override
    public void start() {
        final PatternLayout patternLayout = new PciConformLayout();
        patternLayout.setContext(this.context);
        patternLayout.setPattern(this.getPattern());
        patternLayout.setOutputPatternAsHeader(this.outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
        super.start();
    }

    public class PciConformLayout extends PatternLayout {

        @Override
        public Map<String, String> getDefaultConverterMap() {
            final Map<String, String> defaultConverterMap = super.getDefaultConverterMap();
            //.remove("m");
            //defaultConverterMap.remove("msg");
            //defaultConverterMap.remove("message");
            //defaultConverterMap.put("m", PciConformMessageConverter.class.getName());
            //defaultConverterMap.put("msg", PciConformMessageConverter.class.getName());
           // defaultConverterMap.put("message", PciConformMessageConverter.class.getName());
            return defaultConverterMap;
        }

    }

}
