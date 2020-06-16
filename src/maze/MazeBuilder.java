package maze;

import maze.domain.Maze;

//@FunctionalInterface
public interface MazeBuilder {

    Maze build(int height, int width);
}
