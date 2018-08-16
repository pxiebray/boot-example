package com.ztest.boot.mvc.manager;

import java.io.*;

/**
 * I/O
 * 对称：input-output  byte-char
 * 模式：装饰模式，适配器模式
 *
 * File 文件系统
 * Serializable 序列化
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/25 0025 42
 */
public class StreamManager {


    /**
     * InputStream
     *
     * 原始流处理器：FileInputStream、ByteArrayInputStream、StringBufferInputStream、PipedInputStream
     * 链接流处理器：FilterInputStream: BufferInputStream、DataInputStream、LineNumberInputStream、PushbackInputStream
     *              ObjectInputStream
     *              SequenceInputStream
     *
     * 装饰：Component-InputStream，Decorator-FilterInputStream
     *
     * todo 文件、网络、内存数据、其他等应用场景
     */
    public void inputTest() {
        try {
            //原始流处理器
            FileInputStream fileInputStream = new FileInputStream("");
            StringBufferInputStream stringBufferInputStream = new StringBufferInputStream("abceefg");
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("abcdefg".getBytes());

            //链接流处理器 decorator
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);
            LineNumberInputStream lineNumberInputStream = new LineNumberInputStream(fileInputStream);

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void outputTest() throws IOException {
        FileOutputStream fileOutputStream = null;
        try {
             fileOutputStream = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\1.json");
             fileOutputStream.write("abcdefg".getBytes());

             File file = new File("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public void readerTest() throws IOException {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader("C:\\Users\\Administrator\\Desktop\\1.json");
            char[] chars = new char[1024];
            while(fileReader.read(chars) != -1) {
                System.out.print(String.valueOf(chars));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
    }


    public static void main(String[] args) {
        StreamManager streamManager = new StreamManager();
        try {
            streamManager.readerTest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
