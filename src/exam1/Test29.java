package exam1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class Test29 {

    public static void main(String[] args) {
       //ya esta abierto PrintStream m =  System.out;
       // es final System.in = new ByteArrayInputStream("hola mundo".getBytes());
        //OutputStrema out = System.out;  no, es un PrintStream y permite encoding y formateo \n
        InputStream f  =  System.in;
    }
}
