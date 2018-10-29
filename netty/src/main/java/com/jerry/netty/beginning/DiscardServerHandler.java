package com.jerry.netty.beginning;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * @author Jerry
 * @date 2018/10/9
 * 描述：discard协议
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    //ChannelInboundHandlerAdapter 实现自ChannelInboundHandler,提供各种事件处理程序方法

    @Override
    public void channelRead(ChannelHandlerContext ctx ,Object msg){
        //每次从客户端收到消息都会调用此方法，
        //ByteBuf就是这个消息的数据类型
        //ByteBuf是一个引用计数对象,处理程序有责任释放传递给他的对象
        //((ByteBuf)msg).release();
//        try{
//            ByteBuf in = (ByteBuf) msg;
//            while (in.isReadable()){
//            System.out.print((char) in.readByte());
//            System.out.flush();
//            }
//        }finally {
//            ReferenceCountUtil.release(msg);
//        }

        ctx.write(msg);
        ctx.flush();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){

        cause.printStackTrace();
        ctx.close();
    }
}
