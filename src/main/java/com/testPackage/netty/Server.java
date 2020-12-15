package com.testPackage.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * bootstrap  绑定端口是要加上 sync()  并且关闭时也要加上
 */
public class Server {

    public static void main(String[] args) throws Exception {
        //用来处理连接的工作组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        // 用来处理客户端的工作组
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        // 服务端辅助类
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        // 将两个工作线程组进行绑定
        serverBootstrap.group(bossGroup, workGroup)
                // 我要指定用的哪种  类型的通道
                .channel(NioServerSocketChannel.class)
                // 一定要使用childHandler  来选择具体的使用哪种事件处理器
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addLast(new ServerHandler());
                    }
                });
        // 异步的
        ChannelFuture future = serverBootstrap.bind(8765).sync();
        // 保持server端线程不停止
        future.channel().closeFuture().sync();

        bossGroup.shutdownGracefully();
        workGroup.shutdownGracefully();


    }
}
