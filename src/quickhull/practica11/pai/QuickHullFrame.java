package quickhull.practica11.pai;
/**
 * 
 * @author Sabato Ceruso
 * mail: sab7093@gmail.com
 * Programación de aplicaciones interactivas.
 * Universiad de La Laguna, Santa Cruz de Tenerife, España.
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class QuickHullFrame extends JFrame{
	private JPanel buttonsPanel;							// Panel con los botones.
	private JButton inicializar;							// Boton que continuar� con la simulaci�n hasta el final sin mostrar la animaci�n.
	
	private JButton startStop;								// Boton de parar o continuar con la animaci�n.
	private JButton siguiente;
	private QuickHullPanel quickHullPanel;					// Panel donde se dibujar� el camino.
	private Timer temporizador;								// Temporizador utilizado en la animaci�n.

	private  int npoints = 500;
	public final Color DEFAULT_COLOR = Color.RED;
	private  int delay = 10;
	
	public QuickHullFrame(int npoints, int delay) {
		setButtonsPanel(new JPanel());
		setInicializar(new JButton("Inicializar"));
		setNpoints(npoints);
		setDelay(delay);
		setStartStop(new JButton("Ejecutar"));
		setQuickHullPanel(new QuickHullPanel());
		setTemporizador(new Timer(getDelay(), new TimerHandler()));
		setSiguiente(new JButton("Siguiente"));
		
		getInicializar().addActionListener(new ButtonsHandler());
		getStartStop().addActionListener(new ButtonsHandler());
		
		getSiguiente().addActionListener(new ButtonsHandler());
		
		getButtonsPanel().setLayout(new GridLayout(1, 5));
		
		getButtonsPanel().add(getInicializar());
		getButtonsPanel().add(getStartStop());
		getButtonsPanel().add(getSiguiente());
	
		getQuickHullPanel().setBackground(Color.WHITE);
	
		this.add(getQuickHullPanel());
		this.add(getButtonsPanel(), BorderLayout.SOUTH);
		this.addComponentListener(new WindowHandler());
	}
	
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		getQuickHullPanel().initialize(getNpoints());
	}
	
	public QuickHullPanel getQuickHullPanel() {
		return quickHullPanel;
	}

	
	public JButton getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(JButton siguiente) {
		this.siguiente = siguiente;
	}

	public void setQuickHullPanel(QuickHullPanel quickHullPanel) {
		this.quickHullPanel = quickHullPanel;
	}


	public JPanel getButtonsPanel() {
		return buttonsPanel;
	}

	public void setButtonsPanel(JPanel buttonsPanel) {
		this.buttonsPanel = buttonsPanel;
	}

	public JButton getInicializar() {
		return inicializar;
	}

	public void setInicializar(JButton ini) {
		this.inicializar = ini;
	}

	public JButton getStartStop() {
		return startStop;
	}

	public void setStartStop(JButton startStop) {
		this.startStop = startStop;
	}

	public Timer getTemporizador() {
		return temporizador;
	}

	public void setTemporizador(Timer temporizador) {
		this.temporizador = temporizador;
	}

	
	public int getNpoints() {
		return npoints;
	}

	public void setNpoints(int npoints) {
		this.npoints = npoints;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}


	/**
	 * Clase utilizada para el manejo de los botones.
	 * @author Sabato
	 *
	 */
	class ButtonsHandler implements ActionListener  {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == getStartStop()) {
				if (getTemporizador().isRunning()) {
					getTemporizador().stop();
					getStartStop().setText("Ejecutar");
				}
				else {
					getTemporizador().start();
					getStartStop().setText("Pausar");
				}
			}
			 if(e.getSource() == getInicializar()) {
				 getQuickHullPanel().initialize(getNpoints());
				 getTemporizador().stop();
				 getStartStop().setText("Ejecutar");
				 repaint();
			}
			else if (e.getSource() == getSiguiente()) {
				getTemporizador().stop();
				getStartStop().setText("Ejecutar");
				getQuickHullPanel().nextSolution();
				}
		
		}
		
	}
	
	/**
	 * Clase utilizada para manejar las acciones del temporizdor.
	 * @author Sabato
	 *
	 */
	class TimerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			getQuickHullPanel().nextStep();
		}
		
	}
	
	class WindowHandler implements ComponentListener {

		@Override
		public void componentHidden(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentMoved(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void componentResized(ComponentEvent arg0) {
			 getQuickHullPanel().initialize(getNpoints());
			 getTemporizador().stop();
			 getStartStop().setText("Ejecutar");
			 repaint();	
		}

		@Override
		public void componentShown(ComponentEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
