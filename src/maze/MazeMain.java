package maze;

import maze.domain.Maze;
import maze.francisco.MazeBuiderImpl;
import maze.francisco.MazePrinterImpl;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MazeMain {
    public static void main(String[] args) {
        //MazeBuilder builder = new JoseBuilder();
        //MazeSolver solver = new FatimaSolver();
        //MazePrinter printer = new XavierPriner();
        //solver.trace();
        MazeBuilder builder = new MazeBuiderImpl();
        var maze = builder.build(100,100);
        new MazePrinterImpl(2).print(maze);

    }
}
