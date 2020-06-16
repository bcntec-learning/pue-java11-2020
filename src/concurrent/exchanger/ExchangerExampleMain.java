package concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExampleMain {

    public static void main(String[] args) {
        Exchanger<Country> exchanger = new Exchanger<>();
        // Starting two threads
        new Thread(new Producer(exchanger)).start();
        new Thread(new Consumer(exchanger)).start();
    }
}

