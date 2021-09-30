package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName Jiaoti
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/2710:09
 * @Version 1.0
 */
public class Jiaoti {
    //保证flag的线程可见性
    private static volatile Boolean flag = true;

    private static AtomicInteger num = new AtomicInteger();

    private static final Integer TOTAL = 100;

    private static void method3() {

        Thread jsThread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (num.get() <= TOTAL - 1) {
                    if (!flag) {
                        System.out.println(Thread.currentThread().getName() + ": "
                                + num.getAndIncrement());
                        flag = true;
                    }
                }
            }
        });

        jsThread.setName("奇数线程");

        Thread osThread = new Thread(new Runnable() {

            @Override
            public void run() {

                while (num.get() <= TOTAL) {
                    if (flag) {
                        System.out.println(Thread.currentThread().getName() + ":"
                                + num.getAndIncrement());
                        flag = false;
                    }
                }
            }
        });

        osThread.setName("偶数线程");

        osThread.start();
        jsThread.start();

    }

    public static void main(String[] args) {
        method3();
    }
}
