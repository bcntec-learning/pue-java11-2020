package nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathSamples {

    public static void main(String[] args) {

        System.getenv().entrySet().forEach(e->System.out.println(e.getKey()+" = "+e.getValue()));

        System.out.println("======================================================");
        System.getProperties().entrySet().forEach(e->System.out.println(e.getKey()+" = "+e.getValue()));


        System.out.println(System.getProperty("cwd"));
        System.out.flush();
        Path path1 = Paths.get("out");
        Path path_clone = Paths.get("out");
        System.err.println("path1.equals(path_clone)) is:" + (path1.equals(path_clone)));

        Path path2 = Paths.get("/Users/fphilip/learning/pue-java11-2020/out");
        System.err.println("(path1.compareTo(path2) == 0) is:"
                + (path1.compareTo(path2) == 0));
        System.err.println("path1.equals(path2) is: " + path1.equals(path2));
        System.err.println("path2.equals(path1.toAbsolutePath()) is " + path2.toAbsolutePath().equals(path1.toAbsolutePath()));
    }
    // System.out y System.err son bufferizados  --> System.out.flush() sincrinizar el buffer
    //comando <FICHERO   stdin --> System.in  (valor por defecto es teclado, o entrada PIPELINE   "|")
    //comando >FICHERO   stdout --> System.out  (valor por defecto pantalla)
    //comando 1>FICHERO   stdout --> System.out (valor por defecto pantalla)
    //comando 2>FICHERO   stderr --> System.err (valor por defecto pantalla) --> Los IDE sulen ponerlo de otro color

}
