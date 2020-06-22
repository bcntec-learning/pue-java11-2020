package maze.jgo;

public interface Constants {
	
	String ANSI_RESET = "\u001B[0m";
	String ANSI_BLACK = "\u001B[30m";
	String ANSI_RED = "\u001B[31m";
	String ANSI_GREEN = "\u001B[32m";
	String ANSI_YELLOW = "\u001B[33m";
	String ANSI_BLUE = "\u001B[34m";
	String ANSI_PURPLE = "\u001B[35m";
	String ANSI_CYAN = "\u001B[36m";
	String ANSI_WHITE = "\u001B[37m";
	
	String ANSI_REMOVE_LINE = "\033[2K";
	
	int CHAR_CODE_WAY = 48; //'0'
	int CHAR_CODE_WALL = 49; //'1'
	int CHAR_CODE_START = 65; //'A'
	int CHAR_CODE_GOAL = 66; //'B'
	
	char BLOCK_WALL = 9608;
	char BLOCK_WAY = 9619;
	char BLOCK_START = 9608;
	char BLOCK_GOAL = 9608;
	char BLOCK_SOLUTION = 9608;
	char BLOCK_DEBUG = 9608;
	
	int GHOST = -100;
	int WAY = 0;
	int WALL = 1;
	int VISITED = 2;
	int VISITED_UNMARKED = 3;
	
	int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

}