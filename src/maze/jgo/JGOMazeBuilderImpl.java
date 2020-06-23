package maze.jgo;

import static maze.jgo.Constants.CHAR_CODE_GOAL;
import static maze.jgo.Constants.CHAR_CODE_START;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

import maze.MazeBuilder;
import maze.domain.Coordinate;
import maze.domain.Maze;

/**
 * 
 * Agrupación tramos enlazados
 * 
 * 	00	>	00	>	11
 * 	01    	10		01
 *  v   	v		v
 *  11	>	01	>	01
 *  00		00		11
 *  
 *  
 */
public class JGOMazeBuilderImpl implements MazeBuilder {
	
//	private boolean data[][];
	
	@Override
	public Maze build(int height, int width) {
		
        Maze ret = new Maze(width, height);
        
        if (height<=2 && height<=2) return ret;
		
//		data = new boolean[width][height];
        
        int n = 2;
		int h = height%2==0 ? height : height-1;
		int w = width%2==0 ? width : width-1;
		
//		List<Coordinate> wayCoordinates = new ArrayList<>();
//		for (int a=0; a<w; a+=n) 
//			for (int b=0; b<h; b+=n) {
//				ByteBlock g = new ByteBlock(n);
//				if (g.data[0][0]) ret.buildWall(a, b); else wayCoordinates.add(new Coordinate(a, b));
//				if (g.data[0][1]) ret.buildWall(a, b+1); else wayCoordinates.add(new Coordinate(a, b+1));
//				if (g.data[1][0]) ret.buildWall(a+1, b);  else wayCoordinates.add(new Coordinate(a+1, b));
//				if (g.data[1][1]) ret.buildWall(a+1, b+1);  else wayCoordinates.add(new Coordinate(a+1, b+1));
//			}
//		Supplier<Coordinate> randomCoordinate = () -> wayCoordinates.get(new Random().nextInt(wayCoordinates.size()));
//		ret.setStart( randomCoordinate.get() );
//		ret.setGoal( randomCoordinate.get() );
        
        
		ByteBlockMatrix matrix = new ByteBlockMatrix(width,height);
//		System.out.println(matrix);
		boolean[][] data = matrix.getBooleans();
		
		List<Coordinate> wayCoordinates = new ArrayList<>();
		for (int a=0; a<data.length; a++) 
			for (int b=0; b<data[0].length; b++) 
				if (data[a][b]) ret.buildWall(a, b); else wayCoordinates.add(new Coordinate(a, b));
		Supplier<Coordinate> randomCoordinate = () -> wayCoordinates.get(new Random().nextInt(wayCoordinates.size()));
		ret.setStart( randomCoordinate.get() );
		ret.setGoal( randomCoordinate.get() );
		
		
		
//        List<List<Group>> groups = groups(n, w, h);
//        for (List<Group> lg: groups) {
//        	
//        	for (Group g : lg) {
//
//        		StringBuilder sb = new StringBuilder();
//        		for ( g.) {
//        			
//        		}
//        		
//        	}
//        	
//        }
        
		
		return ret;
	}
	
//	private List<List<Group>> groups(int n, int w, int h) {
//		List<List<Group>> ret = new ArrayList<>();
//		for (int a=0; a<w; a+=n) {
//			List<Group> row = new ArrayList<>();
//			List<Group> rowLast = null;
//			Group item = null;
//			Group itemLast = null;
//			for (int b=0; b<h; b+=n) {
//				item = new Group(n);
//				if (itemLast!=null) {
//					item.left = itemLast;
//					itemLast.right = item;
//				}
//				if (rowLast!=null) {
//					item.top = rowLast.get(b);
//					rowLast.get(b).bottom = item;
//				}
//				row.add(item);
//				itemLast = item;
//			}
//			rowLast = row;
//		}
//		return ret;
//	}

//	static class Group4 {
//		boolean[][] data = new boolean[2][2];
//		Group4 top, right, bottom, left;
//		Group4() {
//			Random r = new Random();
////			data[0][0] = r.nextInt(2) == 1;		data[0][1] = r.nextInt(2) == 1;
////			data[1][0] = r.nextInt(2) == 1;		data[1][1] = r.nextInt(2) == 1;
//			
//			boolean flag = r.nextInt(2) == 1;
//			data[0][0] = flag;		data[0][1] = r.nextInt(2) == 1;
//			data[1][0] = false;		data[1][1] = !flag;
//			if (data[0][0] && data[0][1] && data[1][0] && data[1][1])  data[0][r.nextInt(2)] = true;
//			
//		}		
//	}

//	static class Group {
//		boolean[][] data;
//		Group top, right, bottom, left;
//		Group(int n) {
//			data = new boolean[n][n];
//			Group.setRandom(this);
//		}
//		static void setRandom(Group g) {
//			Random r = new Random();
//			for (int x=0; x<g.data.length; x++) 
//			for (int y=0; y<g.data[0].length; y++)  {
//				g.data[x][y] = r.nextInt(2) == 1;
//			}
//		}
//	}
	
}
