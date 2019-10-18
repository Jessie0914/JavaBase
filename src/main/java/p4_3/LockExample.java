package p4_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Test
 * @description: juc包中的ReerantLock
 * @author: shishi
 * @create: 2019-10-09 19:32
 **/

public class LockExample {
    private Lock lock = new ReentrantLock();

    public void func() {
        lock.lock();
        try {
            for (int i = 0; i < 60; i++) {
                System.out.print(i + " ");
            }
            System.out.println();
        } finally {
            lock.unlock(); // 确保释放锁，从而避免发生死锁。
        }
    }

    public static void main(String[] args) {
        LockExample lockExample = new LockExample();
        LockExample lockExample1 = new LockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> lockExample.func());
        System.out.println();
        executorService.execute(() -> lockExample1.func());
        executorService.shutdown();
    }
}
