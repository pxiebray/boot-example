package com.ztest.boot.mvc.manager;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/25 0025 32
 */
public class SocketManager {

    public static void main(String[] args) {
        SocketManager.ioSocket();
    }

    /**
     * 典型的IO模式
     * 如果想要并行处理请求，必须为每个Connection创建一个线程，即使连接未进行数据请求。
     */
    public static void ioSocket() {
        try {
            System.out.println("IO模式，一个连接通过一个线程处理");
            ServerSocket serverSocket = new ServerSocket(80);
            while (true) {
                Socket socket = serverSocket.accept();
                new SocketHandle(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class SocketHandle extends Thread {
        private final Socket socket;

        public SocketHandle(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                StringBuilder sb = new StringBuilder();
                int len;
                while ((len = inputStream.read(bytes)) != -1) {
                    sb.append(new String(bytes, 0, len, "UTF-8"));
                }

                System.out.println("recive : " + sb.toString());
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * NIO模式下，一个线程处理所有连接。仅仅当有数据请求时，使用异步线程进行处理。
     * 提高连接数
     * 提高cpu使用效率 (1W/3ms, 10W/10ms)
     */

}
