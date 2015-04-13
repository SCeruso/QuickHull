package quickhull.practica11.pai;

import java.awt.Point;

/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */

public class Line {
	private Double pendiente;
	private Double ordenadaEnElOrigen;
	
	/**
	 * Crea una recta.
	 * @param nuevaPendiente pendiente de la recta.
 	 * @param nuevaOrdenadaEnElOrigen ordenada en el origen de la recta.
	 */
	public Line(double nuevaPendiente, double nuevaOrdenadaEnElOrigen) {
		pendiente = nuevaPendiente;
		ordenadaEnElOrigen = nuevaOrdenadaEnElOrigen;
	}
	/**
	 * Crea una recta que pasa por "x" y por "y"
	 * @param x Primer punto.
	 * @param y Segundo punto.
	 */
	public Line (Point x, Point y) throws IllegalArgumentException {
		if (x.x == y.x && x.y == y.y)
			throw new IllegalArgumentException("No se puede formar una recta a partir de dos puntos iguales!");
		if (x.x != y.x) {
			pendiente = ((double)(x.y - y.y)) / ((double)(x.x - y.x));
			ordenadaEnElOrigen = x.y - x.x * pendiente;
		}
		else {
			pendiente = null;
			ordenadaEnElOrigen = x.getX();
		}
	}
	/**
	 * Evalua la recta para un determinado valor de "x", si el resultado de "y" no es un valor entero
	 * devuelve null.
	 * @return Punto para el valor de la variable independiente = "x"
	 * 			cuando la "y" es entera, null en otro caso.  
	 */ 
	public Point integerEvaluation(int x) {
		double y = x * getPendiente() + getOrdenadaEnElOrigen();
		
		if ((int)y == y) 	
			return new Point(x, (int)y);
		
		return null;
	}
	
	public Double evaluate(double x) {
		if (pendiente != null)
			return x * getPendiente() + getOrdenadaEnElOrigen();
		else
			return null;
	}
	
	public Double pointDistance(Point p) {
		if (pendiente == null)
			return Math.abs(ordenadaEnElOrigen - p.getX());
		else {
			Double num = Math.abs(getPendiente() * p.getX() - p.getY() + getOrdenadaEnElOrigen());
			Double denom = Math.sqrt(getPendiente() * getPendiente() + 1);
			return num / denom;
		}
	}
	public Double getPendiente() {
		return pendiente;
	}
	public double getOrdenadaEnElOrigen() {
		return ordenadaEnElOrigen;
	}
	
}
