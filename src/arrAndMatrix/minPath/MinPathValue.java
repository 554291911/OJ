package arrAndMatrix.minPath;

import java.util.LinkedList;

public class MinPathValue {
	
	public int minPathValue(int[][] m) {
		if (m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1 || m[m.length - 1][m[0].length - 1] != 1)
			return 0;
		int res = 0;
		int[][] map = new int[m.length][m[0].length];
		map[0][0] = 1;
		LinkedList<Integer> rowQ = new LinkedList<Integer>();
		LinkedList<Integer> colQ = new LinkedList<Integer>();
		rowQ.add(0);
		colQ.add(0);
		int row = 0;
		int col = 0;
		while (!rowQ.isEmpty()) {
			row = rowQ.poll();
			col = colQ.poll();
			if (row == m.length - 1 && col == m[0].length - 1)
				return map[row][col];
			walkTo(map[row][col], row - 1, col, m, map, rowQ, colQ);// up
			walkTo(map[row][col], row + 1, col, m, map, rowQ, colQ);// down
			walkTo(map[row][col], row, col - 1, m, map, rowQ, colQ);// left
			walkTo(map[row][col], row, col + 1, m, map, rowQ, colQ);// right
		}
		return res;
	}
	
	private void walkTo(int pre, int toRow, int toCol, int[][] m, int[][] map, LinkedList<Integer> rowQ,
	        LinkedList<Integer> colQ) {
		if (toRow < 0 || toRow == m.length || toCol < 0 || toCol == m[0].length || m[toRow][toCol] != 1
		        || map[toRow][toCol] != 0)
			return;
		map[toRow][toCol] = pre + 1;
		rowQ.add(toRow);
		colQ.add(toCol);
	}
}
