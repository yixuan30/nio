package com.yixuan.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author by whs
 * @date 2022/8/4.
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel =  SocketChannel.open(new InetSocketAddress("www.baidu.com", 80));
        socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(10);
        int number = socketChannel.read(buffer);
        while (number != -1){
            buffer.flip();
            while (buffer.hasRemaining()) {
                System.out.println((char) buffer.get());
            }
            buffer.clear();
            number = socketChannel.read(buffer);
        }

        socketChannel.close();
        System.out.println("over");
    }
}
