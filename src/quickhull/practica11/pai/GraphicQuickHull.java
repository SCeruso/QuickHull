package quickhull.practica11.pai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

public class GraphicQuickHull {
	private QuickHull quickHull;
	private ArrayList<ArrayList<Point>> resultList;
	private int index;
	private CoordinatesTransformer transformer;
	
	public GraphicQuickHull(int npoints, int left, int up, int right, int bot,  CoordinatesTransformer ctransformer) {
		int i = 0;
		int j = 0;
		boolean newResult = true;
		
		setTransformer(ctransformer);
		setIndex(0);
		setQuickHull(new QuickHull(npoints, left, up, right, bot));
		setResultList(new ArrayList<ArrayList<Point>>());
		
		getResultList().add(new ArrayList<Point>());
		do {
			i++;
			getQuickHull().calculate(i);
			if (getQuickHull().getResult().size() != getResultList().get(j).size()) {
				getResultList().add(getQuickHull().getResult());
				getQuickHull().setResult(new ArrayList<Point>());
				j++;
			}
			else
				newResult = false;
			
		}while(newResult);
		getQuickHull().calculate(i);
		getResultList().add(getQuickHull().getResult());
	}
	
	public void drawAll(Graphics g) {
		Polygon polygon = new Polygon();
		
		if (getIndex() >= getResultList().size())
			setIndex(getResultList().size() - 1);
		
		drawPoints(g);
		
		for (int j = getIndex() - 1; j <= getIndex(); j++) {
			g.setColor(Color.RED);
			if (j == getIndex())
				g.setColor(Color.BLUE);
			if (j >= 0) {
				for (int i = 0; i < getResultList().get(j).size(); i++) {
					polygon.addPoint((int)getResultList().get(j).get(i).getX(), (int)getResultList().get(j).get(i).getY());
				}
				g.drawPolygon(polygon);
				polygon = new Polygon();
			}
		}

	}
	
	public void drawActual(Graphics g) {
		Polygon polygon = new Polygon();
		
		if (getIndex() >= getResultList().size())
			setIndex(getResultList().size() - 1);
		drawPoints(g);
		for (int i = 0; i < getResultList().get(getIndex()).size(); i++) {
			polygon.addPoint((int)getResultList().get(getIndex()).get(i).getX(), (int)getResultList().get(getIndex()).get(i).getY());
		}
		
		g.drawPolygon(polygon);
	}
	
	public void drawPoints(Graphics g) {
		GraphicPoint graphicPoint = new GraphicPoint(new Point(0, 0), Color.BLUE, 2, new CoordinatesTransformer(1, 1));
		
		for (int i = 0; i < getQuickHull().getTotalPoints().size(); i++) {
			graphicPoint.setPoint(getQuickHull().getTotalPoints().get(i));
			graphicPoint.drawPoint(g.create());
		}
		
	}
	public QuickHull getQuickHull() {
		return quickHull;
	}

	public void setQuickHull(QuickHull quickHull) {
		this.quickHull = quickHull;
	}

	public ArrayList<ArrayList<Point>> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<ArrayList<Point>> resultList) {
		this.resultList = resultList;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public CoordinatesTransformer getTransformer() {
		return transformer;
	}

	public void setTransformer(CoordinatesTransformer transformer) {
		this.transformer = transformer;
	}
	
	
	
}
