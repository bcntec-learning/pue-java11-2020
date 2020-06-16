package concurrent.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

class QueryThread implements Runnable {
    private String threadName;
    private int param;
    private Phaser ph;

    QueryThread(String threadName, int param, Phaser ph) {
        this.threadName = threadName;
        this.param = param;
        this.ph = ph;
        ph.register();
        new Thread(this).start();
    }

    @Override
    public void run() {

        System.out.println("This is phase " + ph.getPhase());
        System.out.println("Querying DB using param " + param
                + " Thread " + threadName);

        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ph.arriveAndAwaitAdvance();
        System.out.println("Threads finished");
        ph.arriveAndDeregister();
    }
}
