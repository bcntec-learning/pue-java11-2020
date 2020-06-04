package excepciones2;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchingExceptions {

    FileInputStream throws1() throws FileNotFoundException{
        return null;
    }
    FileInputStream throws2() throws IOException {
        throw  new IOException();
    }
    FileInputStream throws3() throws EOFException {
        return null;
    }


    public static void main(String[] args) {
        CatchingExceptions c = new CatchingExceptions();

        try {
            c.throws1();
            System.out.println("post throws1()");
            try (FileInputStream z =c.throws2();) {

            }  catch (EOFException e){
                //si eel final copy el fichero
                //throw e; // si lo descomentamos, captura IOExcpetion
                //throw new RuntimeException(e); //si la descomentamos, no captura nadie
            }
            System.out.println("post throws2()");
            c.throws3();
            System.out.println("final de bloque try");
        } catch (FileNotFoundException e) {
            System.out.println("catch FileNotFoundException");
        } catch (IOException e) {
            System.out.println("catch EOFException");
        } finally {
            System.out.println("finally");
        }

    }
}
