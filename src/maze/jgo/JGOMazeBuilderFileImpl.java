package maze.jgo;
import static maze.jgo.Constants.CHAR_CODE_GOAL;
import static maze.jgo.Constants.CHAR_CODE_START;
import static maze.jgo.Constants.CHAR_CODE_WALL;
import static maze.jgo.Constants.CHAR_CODE_WAY;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;

import maze.MazeBuilder;
import maze.domain.Coordinate;
import maze.domain.Maze;

/**
 * Generador de laberintos para pruebas.
 * 
 * Carga un laberinto a partir de un fichero.
 * Si el laberinto no tiene punto inicial o final los asigna aleatoriamente.
 * 
 * @author Jose
 *
 */
public class JGOMazeBuilderFileImpl implements MazeBuilder {
	
	interface PutInList {
		void doIt(int key, Coordinate coordinate);
	}
	
	private final String mazePath;
	
	public JGOMazeBuilderFileImpl(String path) {
		mazePath = path;
	}

	@Override
	public Maze build(int height, int width) {
		try {
			Map<Integer, Coordinate> map = new HashMap<>();
			Map<Integer, List<Coordinate>> mapList = new HashMap<>();
			AtomicInteger w = new AtomicInteger(0);
			AtomicInteger h = new AtomicInteger(0);
			Files.lines(Paths.get(mazePath)).forEach(line->{
				w.set(0);
				line.chars().forEach(c->{
					Coordinate coordinate = new Coordinate(h.get(), w.get());
					PutInList pil = (k, d) -> {
						List<Coordinate> list = mapList.containsKey(k) ? mapList.get(k) : new ArrayList<>();
						list.add(d);
						mapList.put(k, list);
					};
					if (c==CHAR_CODE_WAY) pil.doIt(CHAR_CODE_WAY, coordinate);
					else if (c==CHAR_CODE_WALL) pil.doIt(CHAR_CODE_WALL, coordinate);
					else if (c==CHAR_CODE_START) map.put(CHAR_CODE_START, coordinate);
					else if (c==CHAR_CODE_GOAL) map.put(CHAR_CODE_GOAL, coordinate);
					w.incrementAndGet();
				});
				h.incrementAndGet();
			});
			var ret = new Maze(w.get(),h.get());
			System.out.println(String.format("Maze: %s, Width: %s, Height: %s", mazePath, ret.getWidth(), ret.getHeight()));
			// posicion inicial y final, si no vienen se resuelven al azar
			List<Coordinate> wayCoordinates = mapList.get(CHAR_CODE_WAY);
			Supplier<Coordinate> randomCoordinate = () -> wayCoordinates.get(new Random().nextInt(wayCoordinates.size()));
			ret.setStart( Optional.ofNullable(map.get(CHAR_CODE_START)).orElseGet(randomCoordinate) );
			ret.setGoal( Optional.ofNullable(map.get(CHAR_CODE_GOAL)).orElseGet(randomCoordinate) );
			// posiciones de muro
			Optional.ofNullable(mapList.get(CHAR_CODE_WALL)).ifPresent(list->list.stream().forEach(c->ret.buildWall(c.getX(),c.getY())));
			return ret;
		} catch (IOException e) {
			System.err.println("ERROR: "+e.getClass().getName()+" "+e.getMessage());
		}
		return null;
	}

}