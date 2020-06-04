package samples1;

import java.io.Closeable;
import java.io.IOException;

class MyResource1 implements AutoCloseable {
    public void close() throws IOException {
        System.out.print("1 ");
        throw new MyException();
    }
}

class MyException extends RuntimeException{}

class MyResource2 implements Closeable {
    public void close() throws IOException {
        throw new IOException();
    }
}
interface MyCloseable extends Closeable{}

class MyResource21 implements MyCloseable {
    public void close() throws IOException {
        throw new IOException();
    }
}
public
class TestRes {
    public static void main(String[] args) {
        try (MyResource1 r1 = new MyResource1();
             MyResource2 r2 = new MyResource2();
             MyResource21 r21 = new MyResource21();) {
            System.out.print("T ");
        } catch (MyException ioe) {
            System.out.print("MY ");
        } catch (IOException ioe) {
            System.out.print("IOE ");
        } finally {
            System.out.print("F ");
        }
    }
}
