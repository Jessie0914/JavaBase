package p4_3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @program: Test
 * @description: 信号量
 * @author: shishi
 * @create: 2019-10-08 18:22
 **/

public class SemaphoreExample {
    public static void main(String[] args) {
        final int clientNum = 3;
        final int totalRequest = 10;
        Semaphore semaphore = new Semaphore(clientNum);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0;i<totalRequest;i++){
            executorService.execute(()->{
                try {
                    semaphore.acquire();
                    System.out.print(semaphore.availablePermits()+" ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            });
        }

        executorService.shutdown();
    }
}
