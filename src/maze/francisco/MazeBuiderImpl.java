package maze.francisco;

import maze.MazeBuilder;
import maze.domain.Coordinate;
import maze.domain.Maze;

import java.util.Arrays;
import java.util.Random;

public class MazeBuiderImpl implements MazeBuilder {


    @Override
    public Maze build(int height, int width) {
        var maze = new Maze(height, width);

        var in = randomBorderCoordinate(maze);
        var out = randomBorderCoordinate(maze);
        var minLength = minSize(maze);
        var maxLength = maxSize(maze);


        System.out.println(in);
        System.out.println(out);
        System.out.println("min length=" + minLength);
        System.out.println("max length=" + maxLength);


        //estructura temporal
        boolean[][] data = new boolean[maze.getWidth()][maze.getHeight()];

        for (int x = 0; x < maze.getWidth(); x++) {
            Arrays.fill(data[x], true);
        }

        data[in.getX()][in.getY()] = false;
        data[out.getX()][out.getY()] = false;
        //creacion del laberinto

        for (int x = 0; x < maze.getWidth(); x++) {
            for (int y = 0; y < maze.getHeight(); y++) {
                if (data[x][y]) {
                    maze.buildWall(x, y);
                }
            }
        }

        return maze;
    }


    int minSize(Maze maze) {
        int min = (int) (Math.max(maze.getWidth(), maze.getHeight()) * 1.5F);
        return min;
    }

    int maxSize(Maze maze) {
        int min = (int) (Math.max(maze.getWidth(), maze.getHeight()) * 2.8F);
        return min;
    }

    Coordinate randomBorderCoordinate(Maze maze) {
        int x = 0;
        int y = 0;
        Side s = Side.values()[new Random().nextInt(4)];
        switch (s) {
            case TOP:
                y = maze.getHeight() - 1;
            case BOTTOM:
                x = new Random().nextInt(maze.getWidth());
                break;
            case RIGHT:
                x = maze.getWidth() - 1;
            case LEFT:
                y = new Random().nextInt(maze.getHeight());
                break;
        }
        return new Coordinate(x, y);
    }


    enum Side {
        LEFT, RIGHT, TOP, BOTTOM
    }

}
