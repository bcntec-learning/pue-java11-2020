package maze.jgo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ByteBlockMatrix {
	
	private int n;
	private List<ByteBlockList> rows;

	public ByteBlockMatrix(int n, int numRows, int numCols) {
		init(n, numRows, numCols);
	}
	
	public ByteBlockMatrix(int width, int height) {
		
		var w = width%2==0?width:width-1;
		var h = height%2==0?height:height-1;
		var n=2;
		var numCols = w/n;
		var numRows = h/n;
		
		init(n, numRows, numCols);
	}
	
	private void init(int n, int numRows, int numCols) {
		this.n=n;
		rows = new ArrayList<>();
		for (int i=0; i<numRows; i++) {
			rows.add(new ByteBlockList(n, numCols));
		}
		link();
	}
	
	private void link() {
//		byte z = 1;
		ByteBlockList bblLast = null;
		for (int r=0; r<rows.size(); r++) {
			ByteBlockList bbl = rows.get(r);
			ByteBlock bbLast = null;
			for (int c=0; c<bbl.size(); c++) {
				ByteBlock bb = bbl.get(c);
//				bb.data[0][0] = z++;
				if (bbLast!=null) {
					bb.left = bbLast;
					bbLast.right = bb;
				}
				if (bblLast!=null) {
					bb.top = bblLast.get(c);
					bblLast.get(c).bottom = bb;
				}
				bbLast = bb;
			}
			bblLast = bbl;
		}
	}
	
	public ByteBlock get(int row, int col) {
		try {
			return rows.get(row).get(col);
		} catch (RuntimeException e) {
			return null;
		}
	}
	
	public void print(int row, int col) {
		try {
			ByteBlock curr = get(row,col);
			System.out.println("curr: \n"+curr);
			System.out.println("curr.top: \n"+curr.top);
			System.out.println("curr.right: \n"+curr.right);
			System.out.println("curr.bottom: \n"+curr.bottom);
			System.out.println("curr.left: \n"+curr.left);
		} catch (RuntimeException e) {
		}
	}

	@Override
	public String toString() {
		if (rows.isEmpty()) return "";
		StringBuilder ret = new StringBuilder();
		int numRows = rows.size();
		int numCols = rows.get(0).size();
		for (ByteBlockList bbl : rows) {
			ret.append(bbl.toString());
		}
		ret.append(String.format("n: %s, rows x cols: %s x %s, matrix: %s x %s", 
			n, numRows, numCols, n*numRows, n*numCols));
		return ret.toString();
	}
	
	public boolean[][] getBooleans() {
		
		int w = n*rows.size();
		int h = n*rows.get(0).size();
		
		boolean[][] ret = new boolean[w][h];
		
		String s = toString().replaceAll(" ", "").replaceAll("\\.", "").replaceAll("\n\n", "\n");
//		System.out.println(s);
//		System.out.println("---");

		
		AtomicInteger x = new AtomicInteger();
		AtomicInteger y = new AtomicInteger();
		
		s.chars()
		.filter(num->num==48||num==49)
		.forEach(num->{
			boolean ko = x.get()>=w || y.get()>=h;
			if (!ko) {
				
			ret[x.get()][y.getAndIncrement()] = num==49;
			System.out.print(num==49 ? '1' : '0');
			if (y.get()==h) {
				System.out.println();
				y.set(0);
				x.incrementAndGet();
			}
			}
		});
			
		
		return ret;
	}

	public static void main(String[] args) {
//		System.out.println(new ByteBlockMatrix(2, 2, 4).toString());  // w=2x2=4 h=2x4=8
//		System.out.println(new ByteBlockMatrix(5, 2, 4).toString());
		
//		ByteBlockMatrix matrix = new ByteBlockMatrix(2, 3, 3);
		ByteBlockMatrix matrix = new ByteBlockMatrix(10,6);
		System.out.println(matrix.toString());

//		matrix.print(1,1);
		
		matrix.getBooleans();
		
	}
	
}