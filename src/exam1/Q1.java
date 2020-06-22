package exam1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Q1 {

    public static void main(String[] args) throws IOException {
        Path currentFile = Paths.get("/tmp/scratch/exam/temp.txt");
        Path outputFile = Paths.get("/tmp/scratch/exam/new.txt");
        Path directory = Paths.get("/tmp/scratch/");
        Files.copy(currentFile, outputFile);
        Files.copy(outputFile, directory);
        Files.delete (outputFile);
    }
}
