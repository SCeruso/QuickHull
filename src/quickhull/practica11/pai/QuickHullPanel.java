package quickhull.practica11.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programacion de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;
/**
 * Panel para dibujar el comportiamiento del algoritmo quickhull.
 * @author Sabato
 *
 */
public class QuickHullPanel extends JPanel{
	
	private GraphicQuickHull quickHull;		// Clase que contiente el algoritmo junto con las esctructuras que definen el problema.

	public QuickHullPanel () {
		
	}
	/**
	 * Inicializa el problema.
	 * @param npoints
	 */
	public void initialize(int npoints) {
		
		setQuickHull(new GraphicQuickHull(npoints, (int)(this.getWidth() * 0.01), (int)(this.getHeight() * 0.01), 
					(int)(this.getWidth() * 0.99), (int)(this.getHeight() * 0.95),  new CoordinatesTransformer(1, 1)));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		getQuickHull().drawAll(g.create());
	}
	/**
	 * Muestra el siguiente "fotograma" de la simulacion.
	 */
	public void nextStep() {
		getQuickHull().nextStep();
		repaint();
	}
	/**
	 * Muestra la siguiente solucion pintando de golpe todos los puntos.
	 */
	public void nextSolution() {
		getQuickHull().nextSolution();
		repaint();
	}
	/**
	 * ***********************************************************Getters and Setters****************************************************************************************************************************
	 * @return
	 */
	public GraphicQuickHull getQuickHull() {
		return quickHull;
	}

	public void setQuickHull(GraphicQuickHull quickHull) {
		this.quickHull = quickHull;
	}
	
	
}
	