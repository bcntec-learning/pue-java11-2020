package samples3;

import java.io.Closeable;
import java.io.IOException;

class MyResource1 implements Closeable {
    public void close() {
        System.out.print("r1 ");
    }
}

class MyResource2 implements AutoCloseable {
    public void close() throws IOException {
        System.out.print("r2 ");
        throw new IOException();
    }
}

public class App2 {
    public static void main(String[] args) {
        try (
                MyResource2 r2 = new MyResource2();MyResource1 r1 = new MyResource1();) {
            System.out.print("try ");
        } catch (Exception e) {
            System.out.print("catch ");
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t.getClass().getName());
            }
        }
    }
}
