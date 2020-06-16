package concurrent.smaphore;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SemaphoreExample {

    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
        ExecutorService executorService = new ThreadPoolExecutor(100, 100, 0L,
                TimeUnit.MILLISECONDS, queue);


        Semaphore semaphore = new Semaphore(20);
        Random random = new Random();

        Callable<Long> callable = () -> {
            Long ret;
            semaphore.acquire(); //control de situacion mediante un semaforoe
            try {
                System.out.println("hola " + Thread.currentThread().getName());
                ret = random.nextLong(); //ejecutaremo un max de 20 en simultaneo
                TimeUnit.MILLISECONDS.sleep(1000);
            } finally {
                semaphore.release();
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
