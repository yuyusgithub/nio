package com.yuyu.nioTimeServerDemo;

/**
 * Created by yuyu on 2017/7/7.
 */
public class TimeServer {

    public static void main(String[] args) {
        MultiplexerTimeServer server = new MultiplexerTimeServer(8765);
        Thread thread = new Thread(server,"Time Server");
        thread.start();

    }

}
