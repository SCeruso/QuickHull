package quickhull.practica11.pai;

import java.awt.Point;
import java.util.ArrayList;


/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
public class QuickHull {
	private ArrayList<Point> totalPoints;
	private ArrayList<Point> result;
	private ArrayList<Point> upperPoints;
	private ArrayList<Point> lowerPoints;
	private ArrayList<Point> analyzedPoints;
	private int recursionLimit;
	
	public QuickHull(int npoints, int left, int up, int right, int bot) {
		setTotalPoints(new ArrayList<Point>());
		setResult(new ArrayList<Point>());
		setUpperPoints(new ArrayList<Point>());
		setLowerPoints(new ArrayList<Point>());
		setAnalyzedPoints(new ArrayList<Point>());
		
		RandomPointGenerator generator = new RandomPointGenerator(left, up, right, bot);
		
		for (int i = 0; i < npoints; i++)
			getTotalPoints().add(generator.generatePoint());
	}

	public QuickHull() {
		setTotalPoints(new ArrayList<Point>());
		setResult(new ArrayList<Point>());
		setUpperPoints(new ArrayList<Point>());
		setLowerPoints(new ArrayList<Point>());
		setAnalyzedPoints(new ArrayList<Point>());
	}
	
	public void calculate(int n) {
		int minX = 0;
		int maxX = 0;

		ArrayList<Point> upperPoints;
		ArrayList<Point> lowerPoints;
		recursionLimit = n;
		
		for (int i = 0; i < getTotalPoints().size(); i++) {
			if (getTotalPoints().get(minX).getX() > getTotalPoints().get(i).getX())
				minX = i;
			if (getTotalPoints().get(maxX).getX() < getTotalPoints().get(i).getX())
				maxX = i;
		}
	
		result.add(getTotalPoints().get(maxX));
	
		upperPoints = upperPoints(getTotalPoints(), getTotalPoints().get(minX), getTotalPoints().get(maxX));
		lowerPoints = lowerPoints(getTotalPoints(), getTotalPoints().get(minX), getTotalPoints().get(maxX));
		
		recursionLimit--;
		
		setUpperPoints(upperPoints);
		setLowerPoints(lowerPoints);
		setAnalyzedPoints(getTotalPoints());
		
		recursiveUpperQuickHull(upperPoints, getTotalPoints().get(minX), getTotalPoints().get(maxX));
		result.add(getTotalPoints().get(minX));
		recursiveLowerQuickHull(lowerPoints, getTotalPoints().get(minX), getTotalPoints().get(maxX));
	}
	
	public void recursiveUpperQuickHull(ArrayList<Point> pointList, Point p1, Point p2) {
		ArrayList<Point> upperRights = null;
		ArrayList<Point> upperLefts = null;
		Line lineR;
		Line lineL;
		
		if (pointList.size() == 0 || recursionLimit <= 0)
			return;
		else {
			recursionLimit--;
			Point farthest = farthestPoint (pointList, new Line(p1, p2));
			lineR = new Line(farthest, p2);
			lineL = new Line(farthest, p1);
			if (lineR.getPendiente() != null)
				upperRights = upperPoints(pointList, farthest, p2);
			else {
				upperRights = rightsPoints(pointList, farthest, p2);
			}
			
			if(lineL.getPendiente() != null)
				upperLefts = upperPoints(pointList, farthest, p1);
			else
				upperLefts = leftsPoints(pointList, farthest, p1);
			
			setUpperPoints(upperLefts);
			setLowerPoints(upperRights);
			setAnalyzedPoints(pointList);
			//Llamada recursiva.
			recursiveUpperQuickHull(upperRights, farthest, p2);
			
			result.add(farthest);
			
			recursiveUpperQuickHull(upperLefts, p1, farthest);
	
		}
	}
	
	public void recursiveLowerQuickHull(ArrayList<Point> pointList, Point p1, Point p2) {
		ArrayList<Point> lowerRights = null;
		ArrayList<Point> lowerLefts = null;
		Line lineR;
		Line lineL;
		
		if (pointList.size() == 0 || recursionLimit <= 0)
			return;
		else {
			recursionLimit--;
			Point farthest = farthestPoint (pointList, new Line(p1, p2));
			lineR = new Line(farthest, p2);
			lineL = new Line(farthest, p1);
			
			if (lineR.getPendiente() != null)
				lowerRights = lowerPoints(pointList, farthest, p2);
			else
				lowerRights = rightsPoints(pointList, farthest, p2);
			if (lineL.getPendiente() != null)
				lowerLefts = lowerPoints(pointList, farthest, p1);
			else
				lowerLefts = leftsPoints(pointList, farthest, p1);
			
			setUpperPoints(lowerLefts);
			setLowerPoints(lowerRights);
			setAnalyzedPoints(pointList);
				
			//Llamada recursiva.
			recursiveLowerQuickHull(lowerLefts, p1, farthest);
	
			result.add(farthest);
			
			recursiveLowerQuickHull(lowerRights, farthest, p2);
		}
	}
	
	public Point farthestPoint(ArrayList<Point> pointList, Line recta) {
		int farthest = 0;
		for (int i = 0; i < pointList.size(); i++) {
			if (recta.pointDistance(pointList.get(farthest)) < recta.pointDistance(pointList.get(i)))
					farthest = i;
		}
		
		return pointList.get(farthest);
	}
	
	
	public ArrayList<Point> upperPoints(ArrayList<Point> totalPointList, Point p1, Point p2) {
		ArrayList<Point> pointList = new ArrayList<Point>();
		Line recta = new Line(p1, p2);
		Boolean eval;
		for (int i = 0; i < totalPointList.size(); i++) {
			eval = pointIsOverLine(totalPointList.get(i), recta);
			if (eval!= null && eval)
				pointList.add(totalPointList.get(i));
		}
		
		return pointList;
	}
	
	public ArrayList<Point> lowerPoints(ArrayList<Point> totalPointList, Point p1, Point p2) {
		ArrayList<Point> pointList = new ArrayList<Point>();
		Line recta = new Line(p1, p2);
		Boolean eval;
		for (int i = 0; i < totalPointList.size(); i++) {
			eval = pointIsOverLine(totalPointList.get(i), recta);
			if (eval!= null && !eval)
				pointList.add(totalPointList.get(i));
		}
		
		return pointList;
	}
	public ArrayList<Point> leftsPoints(ArrayList<Point> totalPointList, Point p1, Point p2) {
		ArrayList<Point> pointList = new ArrayList<Point>();
		Line recta = new Line(p1, p2);
		
		for (int i = 0; i < totalPointList.size(); i++) {
			if (totalPointList.get(i).getX() < recta.getOrdenadaEnElOrigen())
				pointList.add(totalPointList.get(i));
		}
		
		return pointList;
	}
	
	public ArrayList<Point> rightsPoints(ArrayList<Point> totalPointList, Point p1, Point p2) {
		ArrayList<Point> pointList = new ArrayList<Point>();
		Line recta = new Line(p1, p2);
		
		for (int i = 0; i < totalPointList.size(); i++) {
			if (totalPointList.get(i).getX() > recta.getOrdenadaEnElOrigen())
				pointList.add(totalPointList.get(i));
		}
		
		return pointList;
	}
	
	public Boolean pointIsOverLine(Point p, Line linea){
		Double evaluation = linea.evaluate(p.getX());
		try {
			evaluation = (double) Math.round(evaluation);	
		}							//Pensar Despues.
		catch(Exception e) {

			return null;
		}
		if (evaluation == null || p.getY() == evaluation)
			return null;
		else if (evaluation < p.getY())
			return true;
		else 
			return false;
	}
	public ArrayList<Point> getResult() {
		return result;
	}

	public void setResult(ArrayList<Point> result) {
		this.result = result;
	}

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

	public ArrayList<Point> getAnalyzedPoints() {
		return analyzedPoints;
	}

	public void setAnalyzedPoints(ArrayList<Point> analyzedPoints) {
		this.analyzedPoints = analyzedPoints;
	}
	
	
}
