package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorsSample1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        BlockingQueue<Runnable> queue= new LinkedBlockingQueue<>();
        ExecutorService executorService =   new ThreadPoolExecutor(1, 1, 0L,
                TimeUnit.MILLISECONDS,     queue);

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
         executorService.execute(runnableTask); //no hay un objeto a devolver es void
         executorService.execute(runnableTask); //no hay un objeto a devolver es void
         executorService.execute(runnableTask); //no hay un objeto a devolver es void
         executorService.execute(runnableTask); //no hay un objeto a devolver es void


        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            return "Task's execution "+ Thread.currentThread().getName();
        };

        Future<String> future =  executorService.submit(callableTask); //hay un objeto a devolver
        executorService.execute(runnableTask); //no hay un objeto a devolver

        System.out.println("Queue size: "+queue.size());
        System.out.println( future.isDone()+"/"+future.isCancelled());


        try {
            System.out.println("'"+future.get(3000, TimeUnit.MILLISECONDS)+"'  -->"+ future.isDone()+"/"+future.isCancelled());
        } catch (TimeoutException e) {
            System.out.println("timed out");
        }


        /*
        Future<?> runnableFuture = executorService.submit(runnableTask); ///




        List<Callable<String>> callableTasks = new ArrayList<>();
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        callableTasks.add(callableTask);
        List<Future<String>> litOfFuturesAll =  executorService.invokeAll(callableTasks);
        //List<Future<String>> litOfFuturesAny =  executorService.invokeAny(callableTasks);
*/

        executorService.shutdown();
        //executorService.shutdownNow();
        System.out.println("bye "+Thread.currentThread().getName());

    }
}
