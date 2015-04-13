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

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		 QuickHullFrame frame = new QuickHullFrame();
		 frame.setTitle("QuickHull");
		 System.out.println(frame.getQuickHullPanel().getWidth());
		 frame.setSize(500, 500);
	 	 frame.setLocationRelativeTo(null); // Center the frame
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);
		 
		
		// frame.initialize();
		 /*ArrayList<Point> uno = new ArrayList<Point>();
		 ArrayList<Point> dos;
		 
		 uno.add(new Point(2, 1));
		 
		 dos = new ArrayList<Point>(uno);
		 
		 uno.clear();
		 System.out.println("Hola");*/
	}

}
