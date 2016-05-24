package com.chang.sim900a;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class RxtxClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush("AT+COPS?\r");
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, String msg) {
        if (msg!=null&&msg.length()>0)
	{
	    msg = msg.trim();
	    System.out.println(msg);
	}
        ctx.close();
    }
}
