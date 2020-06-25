package maze;

import maze.domain.Maze;
import maze.domain.MazeSolution;

public interface MazePrinter {

    void print(Maze maze);
    default void print(Maze maze, MazeSolution solution){
        print(maze);
    }
}
