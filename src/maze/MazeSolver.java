package maze;

import maze.domain.Maze;
import maze.domain.MazeSolution;

public interface MazeSolver {
    MazeSolution solve(Maze maze);
}
