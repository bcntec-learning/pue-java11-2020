package concurrent.phaser;

import java.util.concurrent.Phaser;

public class PhaserDemo {

    public static void main(String[] args) {
        Phaser ph = new Phaser(1);
        int curPhase;
        curPhase = ph.getPhase();
        System.out.println("Phase in Main " + curPhase + " started");
        // Threads for first phase
        new FileReaderThread("thread-1", "file-1", ph);
        new FileReaderThread("thread-2", "file-2", ph);
        new FileReaderThread("thread-3", "file-3", ph);
        //For main thread
        ph.arriveAndAwaitAdvance();
        System.out.println("New phase " + ph.getPhase() + " started");
        // Threads for second phase
        new QueryThread("thread-1", 40, ph);
        new QueryThread("thread-2", 40, ph);
        curPhase = ph.getPhase();
        ph.arriveAndAwaitAdvance();
        System.out.println("Phase " + curPhase + " completed");
        // deregistering the main thread
        ph.arriveAndDeregister();
    }
}

