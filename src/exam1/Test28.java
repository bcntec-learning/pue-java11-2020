package exam1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Test28 {
    static String INPUT_FILE_NAME = "";
    public static void main(String[] args) throws IOException {
        //A
        var lines = Files.lines(Paths.get(INPUT_FILE_NAME));  //devuelve un Stream<String>
        //b var lines = Files.readAllLines(Paths.get(INPUT_FILE_NAME));  devuelve una lista
        //C readAllLines no devuelve flujo
        //Stream<String> lines = Files.lines(INPUT_FILE_NAME);
        lines.map(l->l.toUpperCase());
    }
}
