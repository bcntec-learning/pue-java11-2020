package maze.jgo;
import static maze.jgo.Constants.ANSI_BLACK;
import static maze.jgo.Constants.ANSI_BLUE;
import static maze.jgo.Constants.ANSI_CYAN;
import static maze.jgo.Constants.ANSI_GREEN;
import static maze.jgo.Constants.ANSI_RESET;
import static maze.jgo.Constants.ANSI_WHITE;
import static maze.jgo.Constants.ANSI_YELLOW;
import static maze.jgo.Constants.BLOCK_GOAL;
import static maze.jgo.Constants.BLOCK_SOLUTION;
import static maze.jgo.Constants.BLOCK_START;
import static maze.jgo.Constants.BLOCK_WALL;
import static maze.jgo.Constants.BLOCK_WAY;

import maze.MazePrinter;
import maze.domain.Maze;

public class JGOMazePrinterImpl implements MazePrinter {
	
	private PrintBlock printOneBlock = (a,b) -> {
		System.out.print( a );
		System.out.print( b );
		System.out.print( b );
		System.out.print( b );
		System.out.print( ANSI_RESET );
	};

	@Override
	public void print(Maze maze) {
		printAxisYHead(maze.getHeight());
		for (int x=0; x<maze.getWidth(); x++) {
			printAxisXLineHead(x);
			for (int y=0; y<maze.getHeight(); y++) {
				if (maze.isWall(x, y)) printOneBlock.doIt(ANSI_BLACK, BLOCK_WALL);
				else if (maze.isStart(x, y)) printOneBlock.doIt(ANSI_GREEN, BLOCK_START);
				else if (maze.isGoal(x, y)) printOneBlock.doIt(ANSI_BLUE, BLOCK_GOAL);
				else if (maze.isSolution(x, y)) printOneBlock.doIt(ANSI_YELLOW, BLOCK_SOLUTION);
				else printOneBlock.doIt(ANSI_WHITE, BLOCK_WAY);
			}
			System.out.println();
		}
	}
	
	private void printAxisYHead(int height) {
		System.out.print( ANSI_CYAN );
		System.out.print(String.format("%1$3s", ' '));
		for (int y=0; y<height; y++) {
			System.out.print(String.format("%1$3s", y));
		}
		System.out.println( ANSI_RESET );
	}
	
	private void printAxisXLineHead(int x) {
		System.out.print( ANSI_CYAN );
		System.out.print(String.format("%1$3s", x)); 
		System.out.print( ANSI_RESET );
	}

	interface PrintBlock {
		void doIt(String ansi, char block);
	}

}