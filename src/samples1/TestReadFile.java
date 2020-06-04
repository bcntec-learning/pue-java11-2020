package samples1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;


public class TestReadFile {
    //static y class solo es viable cuando es una inner
    public void readFile(String fName) throws IOException {
        Path p=Paths.get(fName); //devuelve un objeto con el camino al fichero
// Line n1
        Stream<String> content = Files.lines(p); // lo devuelve como un flujo de lineas txt
        content.forEach(s1 -> System.out.println(s1)); //iterar el flujo por cada linea del fichero
    }

    public static void main(String[] args) throws IOException {
        TestReadFile trf = new TestReadFile();
        trf.readFile("TestResult.txt ");
    }
}
/*
    Which code fragment at Line n1 compiles?
        A)Path p=new Path(fName); new Paths()  no es posiblc
        B)Path p=Paths.get(fName);
        C)Path p= Paths.toPath(fName); no existe el metodo
        D)Path p=Paths.get(new  File(fName)); no existe el metodo

 */