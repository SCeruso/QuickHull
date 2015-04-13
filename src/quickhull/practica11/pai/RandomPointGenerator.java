package quickhull.practica11.pai;

import java.awt.Point;
import java.util.Random;

public class RandomPointGenerator {
	Random engine;
	int leftBound;
	int upperBound;
	int rightBound;
	int bottomBound;
	
	public RandomPointGenerator(int left, int up, int right, int bot) {
		setEngine(new Random());
		setLeftBound(left);
		setUpperBound(up);
		setRightBound(right);
		setBottomBound(bot);
		
	}

	public Point generatePoint() {
		int min = getLeftBound();
		int max = getRightBound();
		
		int x = getEngine().nextInt((max - min) + 1) + min;
		min = getUpperBound();
		max = getBottomBound();
		int y = getEngine().nextInt((max - min) + 1) + min;
		
		return new Point(x, y);
	}
	
	public int getLeftBound() {
		return leftBound;
	}

	public void setLeftBound(int leftBound) {
		this.leftBound = leftBound;
	}

	public int getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(int topBound) {
		this.upperBound = topBound;
	}

	public int getRightBound() {
		return rightBound;
	}

	public void setRightBound(int rightBound) {
		this.rightBound = rightBound;
	}

	public int getBottomBound() {
		return bottomBound;
	}

	public void setBottomBound(int bottomBound) {
		this.bottomBound = bottomBound;
	}

	public Random getEngine() {
		return engine;
	}

	public void setEngine(Random engine) {
		this.engine = engine;
	}
}
