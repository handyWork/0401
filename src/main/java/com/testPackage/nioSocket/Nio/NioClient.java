package com.testPackage.nioSocket.Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class NioClient {

    private final static String ip = "localhost";
    private final static int port = 8081;
    private Selector selector;

    private void innit() throws IOException {

        //1. 首先创建一个客户端的 socket 通道
        SocketChannel channel = SocketChannel.open();
        // 设置通道为非阻塞  TODO
        channel.configureBlocking(false);
        // 打开一个 多路复用器(通道管理器)
        selector = Selector.open();
        // 连接通道
        channel.connect(new InetSocketAddress(ip, port));
        // 将channel  注册到通道管理器上  并且设置当前通道的key为 连接
        channel.register(selector, SelectionKey.OP_CONNECT);

    }

    private void listen() throws IOException {

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                // 删除已选的key,以防重复处理
                iterator.remove();
                //  如果是连接的时候
                if (key.isConnectable()) {
                    //  获取当前的channel
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    //  如果是正在连接   则进行连接
                    if (socketChannel.isConnectionPending()) {
                        socketChannel.finishConnect();
                    }

                    // 设置成非阻塞  TODO
                    socketChannel.configureBlocking(false);
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("ScannerTest, Please Enter Name:");
                    String name = scanner.nextLine();
                    socketChannel.write(ByteBuffer.wrap(("To Server:" + name).getBytes()));

                    socketChannel.register(selector, SelectionKey.OP_READ);
                }

                if (key.isReadable()) {
                    // 进行读取的操作
                }

            }


        }

    }

    public static void main(String[] args) throws IOException {
        NioClient nioClient = new NioClient();
        nioClient.innit();
        nioClient.listen();

    }
}
