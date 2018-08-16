package com.pxie.base.io;

/**
 * @author xiepeng
 * @version 1.0
 * @data 2018/7/26 0026 53
 */
public class ByteStream {
    public static void main(String[] args) {
        //Source 原始流处理器
        TestFileStream.test();
        TestByteArrayStream.test();
        TestStringBufferStream.test();
        TestPipedStream.test();

        //Decorator 连接流处理器
    }

    private static class TestFileStream {
        static void test() {

        }
    }

    private static class TestByteArrayStream {
        static void test() {

        }
    }

    private static class TestStringBufferStream {
        static void test() {

        }
    }

    private static class TestPipedStream {
        static void test() {

        }
    }


}


