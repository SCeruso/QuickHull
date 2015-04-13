package quickhull.practica11.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
/**
 * Clase utilizada para pintar puntos 2D.
 * @author Sabato
 *
 */
public class GraphicPoint {
	private Point point;
	private Color color;
	private int radius;
	private CoordinatesTransformer transformer;
	
	public GraphicPoint(Point p, Color c, int r, CoordinatesTransformer ctransformer) {
		setPoint(p);
		setColor(c);
		setRadius(r);
		setTransformer(ctransformer);
	}

	public void drawPoint(Graphics g) {
		g.setColor(color);
		Point tpoint = transformer.transform(getPoint());
		g.fillOval((int)tpoint.getX() - getRadius(), (int)tpoint.getY() - getRadius(), getRadius() * 2, getRadius() * 2);
	}
	/**
	 * ********************************************************************* Getters ands Setters *****************************************************************************************************************
	 * @return
	 */
	public Point getPoint() {
		return point;
	}

	public void setPoint(Point point) {
		this.point = point;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public CoordinatesTransformer getTransformer() {
		return transformer;
	}

	public void setTransformer(CoordinatesTransformer transformer) {
		this.transformer = transformer;
	}
	
}
