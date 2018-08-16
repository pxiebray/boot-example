package com.pxie.base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/26 0026 18
 */
public class SocketProvider {

    public static void startService() {
        try {
            ServerSocket serverSocket = new ServerSocket(80);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("connection..");
                new Thread(new HandlerSocketTask(socket)).run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class HandlerSocketTask implements Runnable {

        private  Socket socket;

        public HandlerSocketTask(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            read();
            writeAndClose();
        }

        public void read() {
            try {
                InputStream inputStream = socket.getInputStream();
                byte[] bytes = new byte[1024];
                int len = -1;
                StringBuilder builder = new StringBuilder();
                while ((len = inputStream.read(bytes)) != -1) {
                    builder.append(new String(bytes,  "UTF-8"));
                    if (builder.toString().contains("#end")) break;
                }
                System.out.println(builder.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void writeAndClose() {
            try {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("im server. #end".getBytes());
                outputStream.close();

                System.out.println(socket.isClosed());
//                socket.shutdownOutput();
//                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SocketProvider.startService();
    }
}
