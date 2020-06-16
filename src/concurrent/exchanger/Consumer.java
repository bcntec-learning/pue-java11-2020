package concurrent.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class Consumer implements Runnable {

    Exchanger<Country> ex;

    Consumer(Exchanger<Country> ex) {
        this.ex = ex;
    }

    @Override
    public void run() {
        Stream.iterate(1,a->a+1).limit(2).forEach(i->{
            try {
                // Getting Country object from producer thread
                // giving dummy country object in return

                Country country = ex.exchange(new Country("Dummy"));
                System.out.println("Got country object from Producer thread : " + country.getCountryName());

            } catch (InterruptedException e) {
                System.out.println(e);
            }
        });

    }
}
