package concurrent;

public class Thread1 {


    public static void main(String[] args) {
        Thread t= new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e){}
            System.out.println("hola soy la hebra "+Thread.currentThread().getName());

        });
        t.setName("Mi-HEBRA");
        t.start();
        System.out.println("saliendo "+Thread.currentThread().getName());

    }

}
