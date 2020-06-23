package maze.jgo;

import java.util.Random;

public class ByteBlock {

	byte[][] data;
	ByteBlock top, right, bottom, left;
	
	ByteBlock(int n) {
		if (n<1) new RuntimeException("n is invalid");
		data = new byte[n][n];
		ByteBlock.setRandom(this);
	}
	
	ByteBlock(int n, byte[][] data) {
		if (getN(data)!=n) new RuntimeException("n is invalid");
		this.data = data;
	}
	
	static int getN(byte[][] data) {
		if (data==null) new RuntimeException("data must be not null");
		var h = data[0].length;
		var w = data.length;
		if (h!=w) new RuntimeException("w and h must be same");
		return w;
	}
	
	static void setRandom(ByteBlock g) {
		Random r = new Random();
		final int n = getN(g.data);
		for (int x=0; x<n; x++) 
		for (int y=0; y<n; y++)  {
//			g.data[x][y] = r.nextInt(2) == 1;
			g.data[x][y] = (byte) r.nextInt(2);
		}
	}

	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		final int n = getN(data);
		for (int x=0; x<n; x++) {
			for (int y=0; y<n; y++) {
//				ret.append(data[x][y] ? '1' : '0');
				ret.append(data[x][y]);
			}
			ret.append(" \n");
		}
		ret.append(String.format("%1$"+(n+1)+"s\n", '.'));
		return ret.toString();
	}
	
	
	public static void main(String[] args) {
		ByteBlock b = new ByteBlock(2);
		System.out.println(b.toString());
	}
	
	
}
