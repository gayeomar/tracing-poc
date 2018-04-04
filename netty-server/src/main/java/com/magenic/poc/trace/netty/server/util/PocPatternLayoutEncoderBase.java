package com.magenic.poc.trace.netty.server.util;


import ch.qos.logback.classic.PatternLayout;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

/**
 * @author <a href="mailto:omarg@magenic.com">Omar Gaye</a>
 */
public class PocPatternLayoutEncoderBase extends PatternLayoutEncoderBase<ILoggingEvent> {

    @Override
    public void start() {
        final PatternLayout patternLayout = new PatternLayout();
        patternLayout.setContext(this.context);
        patternLayout.setPattern(this.getPattern());
        patternLayout.setOutputPatternAsHeader(this.outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
        super.start();
    }

}
