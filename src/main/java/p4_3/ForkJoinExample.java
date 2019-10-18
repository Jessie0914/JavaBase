package p4_3;

import java.util.concurrent.*;

/**
 * @program: Test
 * @description: 并发计算
 * @author: shishi
 * @create: 2019-10-08 20:17
 **/

public class ForkJoinExample extends RecursiveTask<Integer> {
    private final int thershold = 5;
    private int first = 1;
    private int last = 5;

    public ForkJoinExample(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected Integer compute() {
        Integer result = 0;
        // 任务拆分到足够小了，就可以计算了
        if (last-first<=thershold){
            for (int i=first;i<=last;i++){
                result += i;
            }
        }
        // 否则，就拆分成小任务
        else {
            int middle = first + (last-first)/2;
            ForkJoinExample leftTask = new ForkJoinExample(first, middle);
            ForkJoinExample rightTask = new ForkJoinExample(middle, last);
            ForkJoinTask<Integer> leftFork = leftTask.fork();
            ForkJoinTask<Integer> rightFork = rightTask.fork();
//            result = leftTask.join() + rightTask.join();
            try {
                result = leftFork.get()+rightFork.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinExample forkJoinExample = new ForkJoinExample(1, 100);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future task = forkJoinPool.submit(forkJoinExample);
        System.out.println(task.get());
    }
}
