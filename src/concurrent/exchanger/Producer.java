package concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class Producer implements Runnable {

    Exchanger<Country> ex;

    Producer(Exchanger<Country> ex) {
        this.ex = ex;

    }

    @Override
    public void run() {

        Stream.of(new Country("India"), new Country("Bhutan"))
                .forEach(country -> {
                            try {
                                // exchanging with an dummy Country object
                                TimeUnit.MILLISECONDS.sleep(300);
                                Country dummyCountry = ex.exchange(country);
                                System.out.println("Got country object from Consumer thread : " + dummyCountry.getCountryName());
                            } catch (InterruptedException e) {
                                System.out.println(e);
                            }
                        }
                );

    }
}
