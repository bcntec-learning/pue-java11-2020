package maze.jgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import maze.MazeBuilder;
import maze.domain.Coordinate;
import maze.domain.Maze;

/**
 * Generador de laberintos usando algoritmo de Prim.
 * 
 * @author Jose
 *
 */
public class JGOMazeBuilderPrimImpl implements MazeBuilder {
		
	private boolean[][] data;
	private Set<Coordinate> lockedNeighbours = new HashSet<>();
	private Set<Coordinate> unlockedNeighbours = new HashSet<>();
	
	@Override
	public Maze build(int height, int width) {
        Maze ret = new Maze(width, height);
        data = new boolean[height][width];
        boolean tooSmall = width<=1 || height<=1;
        if (!tooSmall) build(ret);
        prepare(ret);
		return ret;
	}
	
	/**
	 * Generación de laberinto. 
	 * Inicialmente toda la matriz "data" está bloqueada (a TRUE, solo hay muros), el proceso de generación
	 * lo que hace es "excavar" el laberinto, es decir, desbloquear casillas (poner a FALSE, crear caminos).
	 * 
	 * Notas: 
	 * Las casilla de la matriz "data" se consideran: TRUE == Bloqueadas (muro), FALSE == Desbloqueadas (camino)
	 * Desbloquear una casilla es ponerla a valor FALSE, por tanto "excavar" camino.
	 * Se considera vecino de una casilla X a aquella casilla que está a 2 casillas arriba/abajo/izquierda/derecha de X.
	 * Se considera vecino bloqueado de una casilla X a aquella casilla con valor TRUE que está a 2 casillas arriba/abajo/izquierda/derecha de X.
	 * Se considera vecino desbloqueado de una casilla X a aquella casilla con valor FALSE que está a 2 casillas arriba/abajo/izquierda/derecha de X.
	 * 
	 * @param maze
	 */
	private void build(Maze maze) {
		
		var height = maze.getHeight();
		var width = maze.getWidth();
        System.out.println(String.format("Width: %s, Height: %s", width, height));
		
        // bloqueo de todas las casillas de la matriz
        for (int i=0; i<data.length; i++) Arrays.fill(data[i], true);

        // desbloqueo de una celda al azar
        Random r = new Random();
        var x = r.nextInt(height);
        var y = r.nextInt(width);
        unlockCell(x,y);
        // se agrega vecinos bloqueados a lista
        addNeighbours(true,x,y);

        // calculo que se repite hasta que no haya vecinos bloqueados en la lista
        while (!lockedNeighbours.isEmpty()) {
        	// obtener vecino bloqueado al azar
        	Coordinate lockedNeighbour = getNeighbour(true);
        	// se agrega vecinos desbloqueados de lockedNeighbour
        	Set<Coordinate> unlockedNeighboursFromLocked = addNeighbours(false,lockedNeighbour.getX(),lockedNeighbour.getY());
        	// si aplica, se elige al azar un vecino desbloqueado de unlockedNeighboursFromLocked
        	if (!unlockedNeighboursFromLocked.isEmpty()) {
        		Coordinate unlockedNeighbour = (Coordinate) unlockedNeighboursFromLocked.toArray()[r.nextInt(unlockedNeighboursFromLocked.size())];
        		// con la idea de desbloquear la celda que está entre lockedNeighbour y unlockedNeighbour
        		int factorX = (unlockedNeighbour.getX()-lockedNeighbour.getX())/2;
        		int factorY = (unlockedNeighbour.getY()-lockedNeighbour.getY())/2;
                var x2 = lockedNeighbour.getX() + factorX;
                var y2 = lockedNeighbour.getY() + factorY;
        		unlockCell(x2,y2);
        		// se agrega vecinos bloqueados de lockedNeighbour, y se desbloquea lockedNeighbour
        		addNeighbours(true,lockedNeighbour.getX(),lockedNeighbour.getY());
        		unlockCell(lockedNeighbour.getX(),lockedNeighbour.getY());
        		// se elimina lockedNeighbour del listado de bloqueados
        		lockedNeighbours.remove(lockedNeighbour);
        		// se elimina unlockedNeighboursFromLocked del listado de desbloqueados
        		unlockedNeighbours.removeAll(unlockedNeighboursFromLocked);
        	}
        }
	}
	
	/**
	 * Vuelca el laberinto generado en "data" en el objeto "maze".
	 * Se establecen aleatoriamente los puntos inicial y final.
	 * @param maze
	 */
	private void prepare(Maze maze) {
		List<Coordinate> unlockedCells = new ArrayList<>();
		for (int a=0; a<data.length; a++) 
			for (int b=0; b<data[0].length; b++) 
				if (data[a][b]) maze.buildWall(a, b); else unlockedCells.add(new Coordinate(a, b));
		if (!unlockedCells.isEmpty()) {
			Random r = new Random();
			Supplier<Coordinate> randomCoordinate = () -> unlockedCells.get(r.nextInt(unlockedCells.size()));
			maze.setStart( randomCoordinate.get() );
			maze.setGoal( randomCoordinate.get() );
		}
	}
	
	/**
	 * Se desbloquea una casilla.
	 * @param x
	 * @param y
	 */
	private void unlockCell(int x, int y) {
        data[x][y] = false;
	}
	
	/**
	 * A partir de una casilla, se agrega a lista sus vecinos bloqueados/desbloqueados.
	 * @param locked
	 * @param x
	 * @param y
	 * @return Devuelve los que ha agregado.
	 */
	private Set<Coordinate> addNeighbours(boolean locked, int x, int y) {
		return Arrays.asList(
			addNeighbour(locked,x-2,y), //vecino arriba
			addNeighbour(locked,x+2,y), //vecino abajo
			addNeighbour(locked,x,y-2), //vecino izquierda
			addNeighbour(locked,x,y+2)	//vecino derecha
		).stream().filter(predicate->predicate!=null).collect(Collectors.toSet());
	}
	
	/**
	 * Obtiene del listado de vecinos bloqueados/desbloqueados uno al azar.
	 * @param locked
	 * @return
	 */
	private Coordinate getNeighbour(boolean locked) {
		Set<Coordinate> set = locked ? lockedNeighbours : unlockedNeighbours;
		if (set.isEmpty()) return null;
		return (Coordinate) set.toArray()[new Random().nextInt(set.size())];
	}
	
	/**
	 * Agrega a lista un vecino bloqueados/desbloqueados.
	 * @param locked
	 * @param x
	 * @param y
	 * @return Coordenada correspondiente, en otro caso nulo.
	 */
	private Coordinate addNeighbour(boolean locked, int x, int y) {
		try {
			Coordinate ret = new Coordinate(x, y);
			if (locked && data[x][y])	lockedNeighbours.add(ret);
			if (!locked && !data[x][y]) unlockedNeighbours.add(ret);
			return ret;
		} catch (RuntimeException e) {
			return null;
		}
	}
	
}