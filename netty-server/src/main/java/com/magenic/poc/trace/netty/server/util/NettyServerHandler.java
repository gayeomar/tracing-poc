package com.magenic.poc.trace.netty.server.util;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.DefaultChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * Handles a server-side netty channel.
 *
 * @author <a href="mailto:omarg@magenic.com">Omar Gaye</a>
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<Object> {

    Logger log = LoggerFactory.getLogger(NettyServerHandler.class);

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object payload) throws Exception {
        if (payload instanceof ByteBuf) {
            ByteBuf buf = (ByteBuf) payload;

            //No traceId, spanId at this time
            log.info("Got a message: {} !", buf.toString(Charset.defaultCharset()));

            buf.retain();
            Thread.sleep(2 * 1000);
            ctx.writeAndFlush(payload, new DefaultChannelPromise(ctx.channel()));

            //Adding traceId, spanId
            MdcTemplate.bootstrapMDC();

            //Now logs will show traceId, spanId
            log.info("Echoed message back to caller...");
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}