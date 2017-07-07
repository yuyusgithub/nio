package com.yuyu.nioTimeServerDemo;

/**
 * Created by yuyu on 2017/7/7.
 */
public class TimeClient {


    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8765;
        new Thread(new TimeClientHandler(host,port)).start();
    }
}
