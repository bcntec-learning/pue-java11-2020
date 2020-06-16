package concurrent;

public class CurrentThreadSample {
    public static void main(String[] args) {
        String title = "Hola hebra";

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println(title+" '" + threadName+"'");
        };

        task.run(); //se ejecuta sobre main


        Thread thread1 = new Thread(task); //paso el runnable que quiero utilziar como target
        thread1.start(); //lanzo la ejecucion

        System.out.println("Done!");

        //en esta caso creo una clase anonima interna
        Thread thread2 =new Thread(){ //implementa runnable
            @Override
            public void run() {
                task.run();
            }
        };
    }
}
