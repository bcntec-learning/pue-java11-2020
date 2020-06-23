package maze.jgo;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class ByteBlockList extends ArrayList<ByteBlock> {
	
	public ByteBlockList() {
		super();
	}
	
	public ByteBlockList(int n, int size) {
		for (int x=0; x<size; x++) add(new ByteBlock(n));
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "";
		int n = get(0).toString().split("\n").length;
		StringBuilder ret = new StringBuilder();
		for (int x=0; x<n; x++) {
			for (ByteBlock bg : this) {
				ret.append(bg.toString().split("\n")[x]);
			}
			ret.append("\n");
		}
		return ret.toString();
	}

	public static void main(String[] args) {
		ByteBlockList b = new ByteBlockList(4, 10);
		System.out.println(b.toString());
	}

}