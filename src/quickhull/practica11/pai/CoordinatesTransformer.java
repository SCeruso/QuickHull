package quickhull.practica11.pai;

import java.awt.Point;

public class CoordinatesTransformer {
	private int rowSize;
	private int colSize;
	
	public CoordinatesTransformer(int rowsize, int colsize) {
		setRowSize(rowsize);
		setColSize(colsize);
	}
	public Point transform (Point point) {
		return new Point ((int)(point.getX() * getColSize()), (int)(point.getY() * getRowSize()));
	}
	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public int getColSize() {
		return colSize;
	}

	public void setColSize(int colSize) {
		this.colSize = colSize;
	}
	
	
}
