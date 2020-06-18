package maze.domain;

public class Maze {
    private boolean data[][];

    public Maze(int height, int width) {
        if(height<=0){
            throw new IllegalArgumentException("height invalid");
        }
        if(width<=0){
            throw new IllegalArgumentException("width invalid");
        }
        data = new boolean[width][height];
    }

    public int getHeight() {
        return data[0].length;
    }

    public int getWidth() {
        return data.length;
    }

    public boolean isWall(int x, int y){
        if(y<0 || y>=getHeight()){
            throw new IllegalArgumentException("y invalid");
        }
        if(x<0 || x>=getWidth()){
            throw new IllegalArgumentException("x invalid");
        }
        return data[x][y];
    }

    public boolean buildWall(int x, int y){
        if(y<0 || y>=getHeight()){
            throw new IllegalArgumentException("y invalid");
        }
        if(x<0 || x>=getWidth()){
            throw new IllegalArgumentException("x invalid");
        }
        return data[x][y]=true;
    }

}
