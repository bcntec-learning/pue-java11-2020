package concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchMain {

    public static void main(String[] args) {
        try {
            CountDownLatch latch = new CountDownLatch(3);

            // Initializing three dependent thread i.e. UI, database and logging

            UIInitialization uiInitialization = new UIInitialization(latch);
            Thread uiThread = new Thread(uiInitialization);

            DatabaseInitialization dataBaseInitialization = new DatabaseInitialization(latch);
            Thread databaseThread = new Thread(dataBaseInitialization);

            LoggingInitialization loggingInitialization = new LoggingInitialization(latch);
            Thread loggingThread = new Thread(loggingInitialization);

            uiThread.start();
            databaseThread.start();
            loggingThread.start();

            latch.await();

            System.out.println("Initialization has been completed, main thread can proceed now");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }
}