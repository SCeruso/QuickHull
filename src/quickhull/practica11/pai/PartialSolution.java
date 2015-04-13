package quickhull.practica11.pai;

import java.awt.Point;
import java.util.ArrayList;

public class PartialSolution {
	private ArrayList<Point> totalPoints;
	private ArrayList<Point> upperPoints;
	private ArrayList<Point> lowerPoints;
	private ArrayList<Point> result;
	
	public PartialSolution(ArrayList<Point> totals, ArrayList<Point> uppers, ArrayList<Point> lowers, ArrayList<Point> result) {
		setTotalPoints(totals);
		setUpperPoints(uppers);
		setLowerPoints(lowers);
		setResult(result);
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

	public ArrayList<Point> getResult() {
		return result;
	}

	public void setResult(ArrayList<Point> result) {
		this.result = result;
	}
	
	

}
