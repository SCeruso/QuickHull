package quickhull.practica11.pai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

import javax.swing.JPanel;

public class QuickHullPanel extends JPanel{
	private GraphicQuickHull quickHull;

	public QuickHullPanel () {
		
	}
	public void initialize(int npoints) {
		
		setQuickHull(new GraphicQuickHull(npoints, (int)(this.getWidth() * 0.01), (int)(this.getHeight() * 0.01), 
					(int)(this.getWidth() * 0.99), (int)(this.getHeight() * 0.95),  new CoordinatesTransformer(1, 1)));
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		getQuickHull().drawAll(g.create());
	}

	public void nextStep() {
		getQuickHull().nextStep();
		repaint();
	}
	public void nextSolution() {
		getQuickHull().nextSolution();
		repaint();
	}
	public GraphicQuickHull getQuickHull() {
		return quickHull;
	}

	public void setQuickHull(GraphicQuickHull quickHull) {
		this.quickHull = quickHull;
	}
	
	
}
	