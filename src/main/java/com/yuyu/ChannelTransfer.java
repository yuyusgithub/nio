package com.yuyu;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * Created by yuyu on 2017/7/7.
 */
public class ChannelTransfer {

    public static void main(String[] args) {
        ChannelTransfer transfer = new ChannelTransfer();
        try {
            transfer.transferFrom();
            transfer.transferTo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transferFrom() throws Exception{
        RandomAccessFile fromFile = new RandomAccessFile("D:/BugReport.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("D:/BugReport_copy.txt", "rw");
        FileChannel      toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        toChannel.transferFrom(fromChannel,position, count);
    }

    public void transferTo() throws Exception{
        RandomAccessFile fromFile = new RandomAccessFile("BugReport.txt", "rw");
        FileChannel      fromChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("BugReport_copy.txt", "rw");
        FileChannel      toChannel = toFile.getChannel();
        long position = 0;
        long count = fromChannel.size();
        fromChannel.transferTo(position, count, toChannel);

    }
}
