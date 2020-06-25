package maze;

import maze.domain.Maze;
import maze.domain.MazeSolution;

import java.util.ServiceLoader;

public class MazeMain {
    public static void main(String[] args) {

        var builder = ServiceLoader.load(MazeBuilder.class).findFirst().get();
        var printer = ServiceLoader.load(MazePrinter.class).findFirst().get();
        var solver = ServiceLoader.load(MazeSolver.class).findFirst().get();

        Maze maze = null;
        MazeSolution solution = null;
        do {
            maze = builder.build(20, 20);
            solution = solver.solve(maze);
        } while (solution.getCoordinates().isEmpty());
        printer.print(maze, solution);
        solution.trace();

    }
}

