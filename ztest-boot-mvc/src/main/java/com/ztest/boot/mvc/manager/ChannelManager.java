package com.ztest.boot.mvc.manager;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;

/**
 * NIO channel
 * FileChannel
 * SocketChannel
 * ServerSocketChannel
 * DatagramChannel
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/25 0025 14
 */
public class ChannelManager {

    /**
     * FileChannel通道不能切换到非租塞模式，因此注册到Selector使用。
     */
    public void testFileChannel(){
        try {
            ByteBuffer byteBuffer = ByteBuffer.allocate(8);

            Path path = Paths.get("C:\\Users\\Administrator\\Desktop\\1.json");
            FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);

            int len;
            while ((len = fileChannel.read(byteBuffer)) != -1) {
                byteBuffer.flip();
                System.out.println(new String(byteBuffer.array(), 0, len, "UTF-8"));
                byteBuffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Socket Channel
     * @throws IOException
     */
    public void testSocketChannel() throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(80));
        //注册channel到selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            //阻塞等待事件
            selector.select();
            Iterator ite =  selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                ite.remove();
                if (key.isAcceptable()) {
                    //here,与IO的差异：当新增connection时不需要分配新线程，直接使用channel即可。
                    System.out.println("接收client连接");
                    SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
                    socketChannel.configureBlocking(true);

                    doRead(socketChannel);
//                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    //当客户端有具体数据时，才需要在线程级别处理。
                    System.out.println("读取client数据");
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    doRead(socketChannel);
                }
            }
        }
    }

    private void doRead(SocketChannel socketChannel) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(128);
        int len = -1;
        try {
            while ((len = socketChannel.read(byteBuffer)) != -1) {
                System.out.println(new String(byteBuffer.array(), 0, len, "UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChannelManager channelManager = new ChannelManager();
        try {
//            channelManager.testSocketChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ChannelClient.sendSocket();
    }

    public static class ChannelClient {
        public static void sendSocket() {
            try {
                Socket socket = new Socket("localhost", 80);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("hello xiepeng".getBytes());
                outputStream.flush();

                socket.shutdownOutput();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


