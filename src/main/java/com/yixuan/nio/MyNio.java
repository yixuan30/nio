package com.yixuan.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author by whs
 * @date 2022/8/3.
 */
public class MyNio {
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("D:\\demo\\file\\test.txt","rw");

        FileChannel channel = randomAccessFile.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(9);

        int number = channel.read(buffer);

        while (number != -1){
            System.out.println("读取了：" + number);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            number = channel.read(buffer);
        }
        randomAccessFile.close();
        System.out.println("结束了");
    }
}
