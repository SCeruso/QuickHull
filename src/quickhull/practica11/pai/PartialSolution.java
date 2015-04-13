package quickhull.practica11.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.Point;
import java.util.ArrayList;
/**
 * Clase que representa soluciones parciales del algoritmo quickhull.
 * @author Sabato
 *
 */
public class PartialSolution {
	private ArrayList<Point> totalPoints;		// Total de puntos analizados en esta solucion.
	private ArrayList<Point> upperPoints;		// Puntos superiores.
	private ArrayList<Point> lowerPoints;		// Puntos inferiores.
	private ArrayList<Point> result;			// Resultado.
	
	public PartialSolution(ArrayList<Point> totals, ArrayList<Point> uppers, ArrayList<Point> lowers, ArrayList<Point> result) {
		setTotalPoints(totals);
		setUpperPoints(uppers);
		setLowerPoints(lowers);
		setResult(result);
	}
	/**
	 * ********************************************************************* Getters ands Setters *****************************************************************************************************************
	 */
	public ArrayList<Point> getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(ArrayList<Point> totalPoints) {
		this.totalPoints = totalPoints;
	}

	public ArrayList<Point> getUpperPoints() {
		return upperPoints;
	}

	public void setUpperPoints(ArrayList<Point> upperPoints) {
		this.upperPoints = upperPoints;
	}

	public ArrayList<Point> getLowerPoints() {
		return lowerPoints;
	}

	public void setLowerPoints(ArrayList<Point> lowerPoints) {
		this.lowerPoints = lowerPoints;
	}

	public ArrayList<Point> getResult() {
		return result;
	}

	public void setResult(ArrayList<Point> result) {
		this.result = result;
	}

}
