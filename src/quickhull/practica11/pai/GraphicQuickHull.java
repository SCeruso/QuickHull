package quickhull.practica11.pai;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GraphicQuickHull {
	private QuickHull quickHull;
	private ArrayList<PartialSolution> resultList;
	private int index;
	private int pointIndex;
	private CoordinatesTransformer transformer;
	private Map<Point,GraphicPoint> graphicPoints;
	public static final int POINT_RADIUS = 3;
	
	public GraphicQuickHull(int npoints, int left, int up, int right, int bot,  CoordinatesTransformer ctransformer) {
		int i = 0;
		int j = 0;
		boolean newResult = true;
		
		setTransformer(ctransformer);
		setIndex(0);
		setQuickHull(new QuickHull(npoints, left, up, right, bot));
		setResultList(new ArrayList<PartialSolution>());
		setGraphicPoints(new HashMap <Point, GraphicPoint>());
		getResultList().add(new PartialSolution(getQuickHull().getTotalPoints(), new ArrayList<Point>(), new ArrayList<Point>(), new ArrayList<Point>()));
		
		do {
			i++;
			getQuickHull().calculate(i);
			if (getQuickHull().getResult().size() != getResultList().get(j).getResult().size()) {
				getResultList().add(new PartialSolution(getQuickHull().getAnalyzedPoints(), getQuickHull().getUpperPoints(), getQuickHull().getLowerPoints(),getQuickHull().getResult()));
				getQuickHull().setResult(new ArrayList<Point>());
				j++;
			}
			else
				newResult = false;
			
		}while(newResult);
		getQuickHull().calculate(i);
		getResultList().add(new PartialSolution(getQuickHull().getAnalyzedPoints(), getQuickHull().getUpperPoints(), getQuickHull().getLowerPoints(),getQuickHull().getResult()));
		addGraphicPoints(getQuickHull().getTotalPoints(), Color.BLACK);
		setPointIndex(getResultList().get(0).getTotalPoints().size() - 1);
	}
	
	public void drawAll(Graphics g1) {
		Polygon polygon = new Polygon();
		Graphics2D g = (Graphics2D) g1;
		g.setStroke(new BasicStroke(2));
		if (getIndex() >= getResultList().size())
			setIndex(getResultList().size() - 1);
		
		drawPoints(g1);
		
		for (int j = getIndex() - 1; j <= getIndex(); j++) {
			g.setColor(Color.RED);
			if (j == getIndex())
				g.setColor(Color.BLACK);
			if (j >= 0) {
				for (int i = 0; i < getResultList().get(j).getResult().size(); i++) {
					polygon.addPoint((int)getResultList().get(j).getResult().get(i).getX(), (int)getResultList().get(j).getResult().get(i).getY());
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
		for (int i = 0; i < getResultList().get(getIndex()).getResult().size(); i++) {
			polygon.addPoint((int)getResultList().get(getIndex()).getResult().get(i).getX(), (int)getResultList().get(getIndex()).getResult().get(i).getY());
		}
		
		g.drawPolygon(polygon);
	}
	
	public void drawPoints(Graphics g) {
		for (int i = 0; i < getQuickHull().getTotalPoints().size(); i++) 
			getGraphicPoints().get(getQuickHull().getTotalPoints().get(i)).drawPoint(g.create());
	}
	
	
	public void addGraphicPoints(ArrayList<Point> points, Color color) {
		for (int i = 0; i < points.size(); i++) {
			getGraphicPoints().put(points.get(i),new GraphicPoint(points.get(i), color, POINT_RADIUS, new CoordinatesTransformer(1, 1)));
		}
	}
	public QuickHull getQuickHull() {
		return quickHull;
	}

	public void setQuickHull(QuickHull quickHull) {
		this.quickHull = quickHull;
	}

	public ArrayList<PartialSolution> getResultList() {
		return resultList;
	}

	public void setResultList(ArrayList<PartialSolution> resultList) {
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


	public int getPointIndex() {
		return pointIndex;
	}

	public void setPointIndex(int pointIndex) {
		this.pointIndex = pointIndex;
	}
	
	public void nextStep() {
		setPointIndex(getPointIndex() + 1);
		GraphicPoint pointToChange;
		
		if (getPointIndex() >= getResultList().get(getIndex()).getTotalPoints().size()) {
			setPointIndex(0);
			setIndex(getIndex() + 1);
		}
		
		
		if (getIndex() >= getResultList().size()) {
			setIndex(getResultList().size() - 1);
			return;
		}
		
		pointToChange = getGraphicPoints().get(getResultList().get(getIndex()).getTotalPoints().get(getPointIndex()));
		
		if (getResultList().get(getIndex()).getUpperPoints().contains(pointToChange.getPoint())) {
			pointToChange.setColor(Color.RED);
		}
		else if (getResultList().get(getIndex()).getLowerPoints().contains(pointToChange.getPoint())) {
				pointToChange.setColor(Color.BLUE);
		}
		else
			pointToChange.setColor(Color.GRAY);
	}
	public void nextSolution() {
		int actual = getIndex();
		int np = 0;
		
		while (actual == getIndex() && getIndex() < getResultList().size() - 1)
			nextStep();
		for (int i = 0; i < getResultList().get(getIndex()).getTotalPoints().size() - 1; i++)
			nextStep();
		
		
	}
	public Map<Point, GraphicPoint> getGraphicPoints() {
		return graphicPoints;
	}

	public void setGraphicPoints(Map<Point, GraphicPoint> graphicPoints) {
		this.graphicPoints = graphicPoints;
	}
	
}
