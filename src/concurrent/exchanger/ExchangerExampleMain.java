package concurrent.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExampleMain {

    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();
        // Starting two threads
        new Thread(new Producer(exchanger)).start();
        new Thread(new Consumer(exchanger)).start();
    }
}

class Producer implements Runnable {

    Exchanger<Country> ex;

    Producer(Exchanger<Country> ex) {
        this.ex = ex;

    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            Country country = null;
            if (i == 0)
                country = new Country("India");
            else
                country = new Country("Bhutan");

            try {
                // exchanging with an dummy Country object
                Country dummyCountry = ex.exchange(country);
                System.out.println("Got country object from Consumer thread : " + dummyCountry.getCountryName());
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer implements Runnable {

    Exchanger<Country> ex;

    Consumer(Exchanger<Country> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            try {
                // Getting Country object from producer thread
                // giving dummy country object in return
                Country country = ex.exchange(new Country("Dummy"));
                System.out.println("Got country object from Producer thread : " + country.getCountryName());

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}