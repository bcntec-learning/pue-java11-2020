package maze.jgo;
import static maze.jgo.Constants.DIRECTIONS;
import static maze.jgo.Constants.GHOST;
import static maze.jgo.Constants.VISITED;
import static maze.jgo.Constants.VISITED_UNMARKED;
import static maze.jgo.Constants.WALL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import maze.MazeSolver;
import maze.domain.Coordinate;
import maze.domain.Maze;
import maze.domain.MazeSolution;

/**
 * 
 * Resolutor de laberintos.
 * 
 * Aplica algoritmo de Backtracking (fuerza bruta) para encontrar caminos posibles
 * entre un punto inicial y otro final.
 * 
 * @author Jose
 *
 */
public class JGOMazeSolverImpl implements MazeSolver {
	
	private final static long SHOW_EVERY = 2_000_000L;
	
	private Maze maze;
	private int[][] data;
	private List<List<Coordinate>> paths = new ArrayList<>();
	private long securityFlag = 1_00_000_000L;

	@Override
	public MazeSolution solve(Maze maze) {
		this.maze = maze;
		init();
		solve();
		return solution();
	}
	
	/**
	 * Inicializa la matriz
	 */
	private void init() {
		if (maze.getStart()==null||maze.getGoal()==null) 
			throw new IllegalArgumentException("Punto inicial/final no establecido");
		data = new int[maze.getHeight()][maze.getWidth()];
		for (int y=0; y<maze.getWidth(); y++) 
			for (int x=0; x<maze.getHeight(); x++) 
				data[x][y] = maze.isWall(x, y) ? 1 : 0;
		System.out.println(String.format("Inicio: (%s,%s), Meta: (%s,%s)", maze.getStart().getX(), maze.getStart().getY(), maze.getGoal().getX(), maze.getGoal().getY()));
	}
	
	/**
	 * Busca de forma recursiva caminos posibles entre A y B.
	 * Debido a que puede tardar mucho, se aplica un flag de seguridad que fuerza el fin de la búsqueda
	 * después de un máximo de iteraciones. 
	 * @return
	 */
	private List<Coordinate> solve() {
	    List<Coordinate> path = new ArrayList<>();
	    if (explore(maze.getStart().getX(), maze.getStart().getY(), path)) return path;
	    return Collections.emptyList();
	}
	
	/**
	 * Obtiene la solución con el camino más corto
	 * @return
	 */
	private MazeSolution solution() {
		System.out.println();
		if (!paths.isEmpty()) {
			if (timeoutReached()) System.out.println("Tiempo agotado");
			System.out.print("Caminos encontrados: "+paths.size()+", ");
			paths.sort((a,b) -> a.size()-b.size());
			List<Coordinate> min = paths.get(0);
			System.out.print("Camino mínimo: "+min.size()+" tramos");
			List<Coordinate> max = null;
			if (paths.size()>1) {
				max = paths.get(paths.size()-1);
				System.out.print(", Camino máximo: "+max.size()+" tramos");
			}
			System.out.println();
//			printPaths();
			maze.setPath(min);
		} else {
			System.out.println("No se ha encontrado solución");
		}
		return new MazeSolution(maze.getPath());
	}
	
	/**
	 * Evalua de forma recursiva casilla a casilla la matriz del laberinto.
	 * Si obtiene un camino entre A y B, lo agrega a listado de caminos encontrados y continúa
	 * hasta haber visitado todas las casillas a su alcance.
	 * @param row
	 * @param col
	 * @param path
	 * @return
	 */
	private boolean explore(int row, int col, List<Coordinate> path) {
		if (timeoutReached()) return false;
		if (!isValid(row, col) || isWall(row, col) || isVisited(row, col)) return false;
		if (isGoal(row, col)) {
			List<Coordinate> lst = new ArrayList<>(path);
			lst.add(new Coordinate(row, col));
			paths.add(lst);
			return false;
		}
		path.add(new Coordinate(row, col));
		setVisited(row, col);
		if (isExit(row, col)) return true;
		//TODO Optimizar en funcion del cuadrante donde esté GOAL
		for (int[] direction : DIRECTIONS) {
			Coordinate coordinate = getNext(row, col, direction[0], direction[1]);
			if (explore(coordinate.getX(), coordinate.getY(), path)) return true;
		}
		setVisitedUnmarked(row, col);
		path.remove(path.size() - 1);
		return false;
	}
	
	/**
	 * Obtiene una cordenada desplazada
	 * @param row
	 * @param col
	 * @param i
	 * @param j
	 * @return
	 */
	private Coordinate getNext(int row, int col, int i, int j) {
	    return new Coordinate(row + i, col + j);
	}
	
	/**
	 * Verifica si la casilla es valida
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isValid(int x, int y) {
		try {
			return data[x][y]!=GHOST;
		} catch (RuntimeException e) {
			return false;
		}
	}
	
	/**
	 * Verifica si la casilla es muro
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isWall(int x, int y) {
		return data[x][y]==WALL;
	}
	
	/**
	 * Verifica si la casilla está marcada como visitada
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isVisited(int x, int y) {
		return data[x][y]==VISITED || data[x][y]==VISITED_UNMARKED
				;	
	}
	
	/**
	 * Marca la casilla como visitada
	 * @param x
	 * @param y
	 */
	private void setVisited(int x, int y) {
		data[x][y]=VISITED;
	}
	
	/**
	 * Verifica si la casilla fue visitada en algún momento
	 * @param x
	 * @param y
	 */
	private void setVisitedUnmarked(int x, int y) {
		data[x][y]=VISITED_UNMARKED;
	}
	
	/**
	 * Verifica si la casilla es meta
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isGoal(int x, int y) {
		return maze.isGoal(x, y);
	}
	
	/**
	 * Verifica si hay casillas no visitadas
	 * @param r
	 * @param c
	 * @return
	 */
	private boolean isExit(int r, int c) {		
		int num = 0;
		for (int y=0; y<maze.getWidth(); y++) 
			for (int x=0; x<maze.getHeight(); x++)  
				if (data[x][y]==0) num++;
		return num==0;
	}
	
	/**
	 * Verifica se ha alcanzado el máximo de iteraciones antes de parar la búsqueda
	 * @return
	 */
	private boolean timeoutReached() {
		securityFlag--; 
		if(securityFlag%SHOW_EVERY==0) System.out.print(".");
		return securityFlag<=0;
	}
	
	/**
	 * Imprime todos los caminos encontrados
	 */
	@SuppressWarnings("unused")
	private void printPaths() {
		AtomicInteger n = new AtomicInteger();
		paths.stream().forEach(path->{
			System.out.print(String.format("#%s. %s tramos: ", n.incrementAndGet(), path.size()));
			path.stream().forEach(c->System.out.print(String.format("(%1$2s,%2$2s), ", c.getX(), c.getY())));
			System.out.println();
		});
	}
		
}