package quickhull.practica11.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.Point;
import java.util.Random;

/**
 * Clase generadora de puntos de forma aleatoria entre un rango fijado.
 * @author Sabato
 *
 */
public class RandomPointGenerator {
	Random engine;		// Motor aleatorio.
	int leftBound;		//
	int upperBound;		//	Rangos para las coordenadas.
	int rightBound;		//
	int bottomBound;	//
	
	public RandomPointGenerator(int left, int up, int right, int bot) {
		setEngine(new Random());
		setLeftBound(left);
		setUpperBound(up);
		setRightBound(right);
		setBottomBound(bot);
		
	}

	/**
	 * Genera un punto de forma aleatoria.
	 * @return
	 */
	public Point generatePoint() {
		int min = getLeftBound();
		int max = getRightBound();
		
		int x = getEngine().nextInt((max - min) + 1) + min;
		min = getUpperBound();
		max = getBottomBound();
		int y = getEngine().nextInt((max - min) + 1) + min;
		
		return new Point(x, y);
	}
	/**
	 * ******************************************************************Getters and Setters************************************************************************************************************************
	 * @return
	 */
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
