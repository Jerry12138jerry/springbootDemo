package com.jerry.netty.beginning;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
/**
 * @author Jerry
 * @date 2018/10/9
 * 描述：
 * */
public class DiscardServer {

    private int port;

    public DiscardServer(int port) {
        this.port = port;
    }

    public void run(){

        //NioEventLoopGroup是一个处理I/O操作的多线程事件循环
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        //ServerBootstrap是一个帮助类,用于设置服务器
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup,workerGroup)
                //指定通过NioServerSocketChannel来为每一个连接服务端的客户端提供一个channel
                .channel(NioServerSocketChannel.class)
                //添加自己定义的channel初始化
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast(new DiscardServerHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG,128)
                .childOption(ChannelOption.SO_KEEPALIVE,true);

        try {
            ChannelFuture future = b.bind(port).sync();
        } catch (InterruptedException e) {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
    public static void main(String[] args){

        int port;

        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new DiscardServer(port).run();

    }
}
