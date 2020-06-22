package maze.domain;

import java.util.ArrayList;
import java.util.List;

public class Maze {
	
    private boolean data[][];
	private Coordinate start;
	private Coordinate goal;
	private List<Coordinate> path = new ArrayList<>(0);

    public Maze(int width, int height) {
        if(height<=0){
            throw new IllegalArgumentException("height invalid");
        }
        if(width<=0){
            throw new IllegalArgumentException("width invalid");
        }
        data = new boolean[width][height];
    }
    
    public void setStart(Coordinate c) {
    	start = c;
    }
    
    public Coordinate getStart() {
    	return start;
    }
    
    public void setGoal(Coordinate c) {
    	goal = c;
    }
    
    public Coordinate getGoal() {
    	return goal;
    }

    public List<Coordinate> getPath() {
		return path;
	}

	public void setPath(List<Coordinate> path) {
		this.path = path;
	}

	public int getHeight() {
        return data[0].length;
    }

    public int getWidth() {
        return data.length;
    }
    
    public boolean isWall(int x, int y){
    	check(x,y);
        return data[x][y];
    }

    public boolean buildWall(int x, int y){
    	check(x,y);
        return data[x][y]=true;
    }
    
    public boolean isStart(int x, int y){
    	check(x,y);
        return start.getX()==x && start.getY()==y;
    }
    
    public boolean isGoal(int x, int y){
    	check(x,y);
        return goal.getX()==x && goal.getY()==y;
    }
    
	public boolean isSolution(int x, int y) {
		check(x,y);
		return path.contains(new Coordinate(x, y));
	}
    
    private void check(int x, int y){
        if(y<0 || y>=getHeight()){
            throw new IllegalArgumentException("y invalid");
        }
        if(x<0 || x>=getWidth()){
            throw new IllegalArgumentException("x invalid");
        }
    }
    
}