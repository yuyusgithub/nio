package com.yuyu;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yuyu on 2017/7/6.
 */
public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        try {
            test.test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test1() throws Exception{
        RandomAccessFile aFile = new RandomAccessFile("D:/BugReport.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
