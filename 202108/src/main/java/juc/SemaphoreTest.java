package juc;

import java.util.concurrent.Semaphore;

/**
 * @ClassName SemaphoreTest
 * Description TODO
 * @Author hqgor
 * @Date 2021/9/279:59
 * @Version 1.0
 */
public class SemaphoreTest {
    private final Semaphore semaphoreA = new Semaphore(1);
    private final Semaphore semaphoreB = new Semaphore(1);
    private final Semaphore semaphoreC = new Semaphore(1);

    public void start() throws InterruptedException {
        semaphoreB.acquire();//ABC线程启动之前 获取SemaphoreB的1个资源，保证线程A最先执行
        semaphoreC.acquire();//ABC线程启动之前 获取SemaphoreC的1个资源，保证线程A最先执行
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphoreA.acquire();
                        System.out.print("A");
                        semaphoreB.release();//之前说的特性：可以在ThreadA释放ThreadB的Semaphore资源， 下同
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphoreB.acquire();
                        System.out.print("B");
                        semaphoreC.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        semaphoreC.acquire();
                        System.out.println("C");
                        semaphoreA.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        c.start();
        b.start();
        a.start();
    }

    public static final void main(String arsg[]) throws InterruptedException {
        SemaphoreTest semaphoreTest = new SemaphoreTest();
        semaphoreTest.start();
    }
}
