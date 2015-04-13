package quickhull.practica11.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.Point;

/**
 * Clase utilizada para pasar de un sistema de coordenadas a otro.
 * @author Sabato
 *
 */
public class CoordinatesTransformer {
	private int rowSize;
	private int colSize;
	
	public CoordinatesTransformer(int rowsize, int colsize) {
		setRowSize(rowsize);
		setColSize(colsize);
	}
	/**
	 * Transforma un punto de un sistema a otro.
	 */
	public Point transform (Point point) {
		return new Point ((int)(point.getX() * getColSize()), (int)(point.getY() * getRowSize()));
	}
	/**
	 * ********************************************************************* Getters ands Setters *****************************************************************************************************************
	 * @return
	 */
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
