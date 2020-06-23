package maze.jgo;

import java.util.ArrayList;
import java.util.List;

public class ByteBlockParser {
	
	private int n;
	private boolean[][] data;
	private int w, h;
	private List<List<ByteBlock>> groups = new ArrayList<>();
	

	public ByteBlockParser(int n, boolean[][] data) {
		this.data = data;
		this.n = n;
		var width = data[0].length;
		var height = data.length;
		this.w = width%2==0 ? width : width-1;
		this.h = height%2==0 ? height : height-1;
		
		System.out.println(String.format("n: %s, width x height: %s x %s", n, width, height));
		
		loadGroups();
		
		
	}
	
	private void loadGroups() {
		groups.clear();
		for (int a=0; a<w; a+=n) {
			List<ByteBlock> row = new ArrayList<>();
			List<ByteBlock> rowLast = null;
			ByteBlock item = null;
			ByteBlock itemLast = null;
			for (int b=0; b<h; b+=n) {
				item = new ByteBlock(n);
				if (itemLast!=null) {
					item.left = itemLast;
					itemLast.right = item;
				}
				if (rowLast!=null) {
					item.top = rowLast.get(b);
					rowLast.get(b).bottom = item;
				}
				row.add(item);
				itemLast = item;
			}
			groups.add(row);
			rowLast = row;
		}
	}
	
	public void printGroups() {
		
	}

}
