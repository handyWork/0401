package com.testPackage.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 注意事项   bootstrap  绑定端口是要加上 sync()  并且关闭时也要加上
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {

        NioEventLoopGroup workGroup = new NioEventLoopGroup();
        // Client 端   辅助类
        Bootstrap bootstrap = new Bootstrap();
        // 绑定 工作组
        bootstrap.group(workGroup)
                // 指定用哪个通道进行连接
                .channel(NioSocketChannel.class)
                // 指定用哪个处理器进行处理
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel sc) throws Exception {
                        sc.pipeline().addLast(new ClientHandler());
                    }
                });
        ChannelFuture future = bootstrap.connect("127.0.0.1", 8765).sync();
        // 写数据并进行刷新
        future.channel().writeAndFlush(Unpooled.copiedBuffer("1111111".getBytes()));
        future.channel().closeFuture().sync();

        workGroup.shutdownGracefully();

    }
}
