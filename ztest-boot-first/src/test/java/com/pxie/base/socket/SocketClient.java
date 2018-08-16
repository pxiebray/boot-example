package com.pxie.base.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/26 0026 18
 */
public class SocketClient {

    public static void sendMsg(String msg) {
        try {
            Socket socket = new Socket("127.0.0.1", 80);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(msg.getBytes());
            reciveMsgAndClose(socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reciveMsgAndClose(Socket socket) {
        System.out.println(socket.isClosed());
        try {
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = -1;
            StringBuilder builder = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                builder.append(new String(bytes,  "UTF-8"));
                if (builder.toString().contains("end")) break;
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        sendMsg("im client. #end");
    }
}
