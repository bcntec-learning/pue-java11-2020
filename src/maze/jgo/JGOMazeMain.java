package maze.jgo;

import maze.MazeBuilder;
import maze.MazePrinter;
import maze.MazeSolver;
import maze.domain.Maze;

public class JGOMazeMain {

    public static void main(String[] args) throws Exception {
    	
    	String path = args!=null && args.length>0 ? args[0] : "src/maze/jgo/input/maze4"; 
        MazeBuilder builder = new FileMazeBuilderImpl(path);
        Maze maze = builder.build(1,1);
        
        MazePrinter printer = new JGOMazePrinterImpl();
        printer.print(maze);
        
        MazeSolver solver = new JGOMazeSolverImpl();
        solver.solve(maze);

        printer.print(maze);
    	
    }

}