package streams;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) throws InterruptedException {
        Stream<Integer> stream = Stream.iterate(1, n->n+1);
        //IntStream stream = Stream<Integer>..range(1, 10000000);
        //System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");
        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        forkJoinPool.submit(() -> {
                    stream.parallel().limit(100000).forEach(y->System.out.println(Thread.currentThread().getName()+" "+y));
                }
        );

        Thread.sleep(10000);



    }
}
