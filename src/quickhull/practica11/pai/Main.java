package quickhull.practica11.pai;

/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * ProgramaciÃ³n de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, EspaÃ±a.
 */
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		Integer npuntos;
		Integer delay;
		try {
			npuntos = new Integer(args[0]);
			delay = new Integer(args[1]);
		}
		catch (Exception e) {
			System.err.println("Número erróneo de argumentos; invocar: java Main NUMERO_DE_PUNTOS DELAY_EN_MILISEGUNDOS");
			return;
		}
		 QuickHullFrame frame = new QuickHullFrame(npuntos, delay);
		 frame.setTitle("QuickHull");
		 System.out.println(frame.getQuickHullPanel().getWidth());
		 frame.setSize(500, 500);
	 	 frame.setLocationRelativeTo(null); // Center the frame
	     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setVisible(true);

	}

}
