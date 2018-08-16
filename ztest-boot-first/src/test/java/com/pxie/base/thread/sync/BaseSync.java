package com.pxie.base.thread.sync;

/**
 * 原子性
 * 可见性
 * 有序性
 *
 *
 * @author Administrator
 * @version 1.0
 * @data 2018/7/26 0026 35
 */
public class BaseSync {

    /**
     * unThreadSafe
     * 共享资源对象
     */
    protected static class Counter {
        private int i;

        public void inc(int inc) {
            i += inc;
            System.out.println(i);
        }
    }

    protected static class Monitor implements Runnable {
        private Counter counter;

        public Monitor(Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            int i = 1000;
            while (i-- > 0) {
                counter.inc(1);
            }
        }
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        int i = 100;
        while (i-- > 0) {
            new Thread(new Monitor(counter)).start();
        }
    }

}
