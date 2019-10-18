package p4_3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Test
 * @description: 多个线程等待多个线程
 * @author: shishi
 * @create: 2019-10-08 18:12
 **/

public class CyclicBarrierExample {
    public static void main(String[] args) {
        final int threadNum = 3;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i=0;i<threadNum;i++){
            executorService.execute(() -> {
                try {
                    System.out.println("before..");
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("after..");
            });
        }
        executorService.shutdown();
    }
}
