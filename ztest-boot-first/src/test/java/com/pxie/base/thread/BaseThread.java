package com.pxie.base.thread;

/**
 * @author Administrator
 * @version 1.0
 * @data 2018/7/26 0026 32
 */
public class BaseThread {

    public static class CountThread extends Thread {
        @Override
        public void run() {
            int i = 1000;
            while (--i > 0) {
                System.out.println("a");
            }
        }
    }

    public static class CountRunnable implements  Runnable {
        @Override
        public void run() {
            int i = 1000;
            while (--i > 0) {
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new CountThread();
        Thread runnable = new Thread(new CountRunnable());

        //监控runnable线程状态
        new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.State lastState = null;
                while (runnable.isAlive()) {
                    Thread.State currentState = runnable.getState();
                    if (!currentState.equals(lastState)) {
                        lastState = currentState;
                        System.out.println(lastState);
                    }
                }
            }
        }).start();

        //启动线程
        thread.start();
        runnable.start();

        thread.join();
        runnable.join();
        System.out.println("end");

        //join，将指定线程串行到当前线程
        //static currentThread, 获取当前线程
        //static yield, 释放资源后共同竞争
        //static sleep，当前线程短暂睡眠，线程不释放占用锁资源

        //object wait，释放synchronized的锁，多线程进入等待
        //object notify，通知等待的线程执行
    }
}
