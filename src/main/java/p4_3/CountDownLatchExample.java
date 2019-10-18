package p4_3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Test
 * @description: 一个线程等待多个线程
 * @author: shishi
 * @create: 2019-10-08 17:59
 **/

public class CountDownLatchExample {
    public static void main(String[] args) throws InterruptedException {
        final int threadNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<threadNum;i++){
            System.out.println("run..");
            countDownLatch.countDown();
        }
        countDownLatch.await();
        System.out.println("end..");
        executorService.shutdown();
    }
}
