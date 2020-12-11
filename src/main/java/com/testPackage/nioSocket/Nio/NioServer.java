package com.testPackage.nioSocket.Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

public class NioServer {

    private final static int port = 8081;

    private Selector selector;

    private void init(int port) {
        try {
            // 开启服务端的 socket
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 设置通道为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 将该通道绑定到端口上
            serverSocketChannel.socket().bind(new InetSocketAddress(port));
            // 开启多路复用器
            selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() throws IOException {
        System.out.println("服务端启动成功");
        while (true) {
            //当注册的事件到达时，方法返回；否则,该方法会一直阻塞
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 防止重复处理
                iterator.remove();
                // 客户端请求连接事件
                if (key.isAcceptable()) {
                    System.out.println("进入客户端连接····");
                    // 获取的是server端口的  通道
                    ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                    // 获取和客户端的链接 TODO
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 设置成非阻塞
                    socketChannel.configureBlocking(false);

//                    socketChannel.write(ByteBuffer.wrap(new String("To Client:22222222").getBytes()));
                    // 将获取到客户端的通道注册到   多路复用器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    read(key);
                }

            }
        }
    }

    private void read(SelectionKey key) throws IOException {
//        服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建buffer 缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.read(buffer);
        byte[] array = buffer.array();
        System.out.println("服务端收取到消息" + new String(array));

    }

    public static void main(String[] args) throws IOException {
        NioServer nioServer = new NioServer();
        nioServer.init(port);
        nioServer.listen();
    }

}
