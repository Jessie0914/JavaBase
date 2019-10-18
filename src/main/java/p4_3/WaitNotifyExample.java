package p4_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Test
 * @description:
 * @author: shishi
 * @create: 2019-10-09 20:21
 **/

public class WaitNotifyExample {
    public synchronized void before() {
        System.out.println("before");
        notify();
    }

    public synchronized void after() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after");
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        WaitNotifyExample example = new WaitNotifyExample();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());
        executorService.shutdown();
    }

}
