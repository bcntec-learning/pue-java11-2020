package maze.francisco;

import maze.MazePrinter;
import maze.domain.Maze;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MazePrinterImpl implements MazePrinter {
    private int mode;

    public MazePrinterImpl() {
        this(3);
    }

    public MazePrinterImpl(int mode) {
        this.mode = mode;
    }

    @Override
    public void print(Maze maze) {
        switch (mode) {
            case 1:
                for (int x = 0; x < maze.getWidth(); x++) {
                    for (int y = 0; y < maze.getHeight(); y++) {
                        System.out.print(maze.isWall(x, y) ? "#" : " ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                Stream.iterate(0, x -> x + 1).limit(maze.getWidth()).forEach(x -> {
                    Stream.iterate(0, y -> y + 1).limit(maze.getHeight()).forEach(y -> {
                        System.out.print(maze.isWall(x, y) ? "#" : " ");
                    });
                    System.out.println();
                });


                break;
            case 3:

                IntStream.range(0, maze.getWidth()).forEach(x -> {
                    IntStream.range(0, maze.getHeight()).forEach(y -> {
                        System.out.print(maze.isWall(x, y) ? "#" : " ");
                    });
                    System.out.println();
                });
                //IntStream.range(0, maze.getWidth()).summaryStatistics()

        }


    }
}
