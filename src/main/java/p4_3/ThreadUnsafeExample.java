package p4_3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: Test
 * @description: 不安全线程举例
 * @author: shishi
 * @create: 2019-10-08 20:50
 **/

public class ThreadUnsafeExample {
    private int cnt = 0;

    public synchronized void add(){
        cnt++;
    }

    public int getCnt(){
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i=0;i<threadSize;i++){
            executorService.execute(()->{
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.getCnt());
    }
}
