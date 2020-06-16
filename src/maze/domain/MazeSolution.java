package maze.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MazeSolution {
    List<Coordinate> coordinates;

    public MazeSolution(List<Coordinate> coordinates) {
        this.coordinates = Collections.unmodifiableList(coordinates);
    }

    public List<Coordinate> getCoordinates() {
        return coordinates;
    }
    public void trace(){
        getCoordinates().forEach(System.out::println);
    }


}
