package concurrent;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LocksExample {

    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 0L,
                TimeUnit.MILLISECONDS, queue);

        final Object o = new Object();


        Lock lockObject = new ReentrantLock();
        Random random = new Random();

        Callable<Long> callable = () -> {
            Long ret;
            lockObject.lock(); //control de situacion mediante un objeto
            try {
                System.out.println("hola " + Thread.currentThread().getName());
                System.out.flush();
                ret = random.nextLong();

                TimeUnit.MILLISECONDS.sleep(500);
            } finally {
                lockObject.unlock();
            }

            return ret;
        };

        Callable<Long> callable2 = () -> {
            Long ret;
            synchronized (o) { //no tengo control
                System.out.println("hola " + Thread.currentThread().getName());
                ret = random.nextLong();
            }

            return ret;
        };


        List<Future<Long>> reults=  executorService.invokeAll(
                Stream.iterate(1, (n) -> n + 1)
                        .limit(100).map((i) -> callable)
                        .collect(Collectors.toList())
        );


    }


}
