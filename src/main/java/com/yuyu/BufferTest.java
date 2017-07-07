package com.yuyu;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yuyu on 2017/7/6.
 */
public class BufferTest {

    public static void main(String[] args) {
        BufferTest test = new BufferTest();
        try {
            test.test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test1() throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("D:/BugReport.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf); //read into buffer.
        while (bytesRead != -1) {
            buf.flip();  //make buffer ready for read
            while (buf.hasRemaining()) {//是否已经到达临界值，即，是否已经读完数据
                System.out.print((char) buf.get()); // read 1 byte at a time//这个地方有挺多正get方法可以使用的
            }
            buf.clear(); //make buffer ready for writing
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
