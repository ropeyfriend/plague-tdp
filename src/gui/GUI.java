package gui;

import juego.Juego;
import mapa.Mapa;

import javax.swing.JProgressBar;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entidades.premios.Pocion;

import java.awt.SystemColor;

public class GUI extends JFrame {

	private static final long serialVersionUID = 2116746884888994591L;
	protected Juego juego;
	protected MovimientoJugadorListener mv;
	protected JButton pocion1;
	protected JButton pocion2;
	protected JButton pocion3;
	protected JProgressBar progressBar;
	protected JLabel labelNivel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI() {
		setVentana();
		setPanelInformacion();
		// juego y mapa
		juego = new Juego(this);
		Mapa panel_mapa = juego.getMapa();
		
		// ventana y panel info

		// movimiento
		this.setFocusable(true);
		getContentPane().add(panel_mapa);
		mv = new MovimientoJugadorListener(juego.getJugador());
		this.addKeyListener(new Adapter());

		Thread hilo = new Thread(juego);
		hilo.start();
	}

	public void setVentana() {
		getContentPane().setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		setResizable(false);
	}

	public void setPanelInformacion() {
		// Panel de informacion de jugador
		JPanel panel_informacion = new JPanel();
		panel_informacion.setBackground(SystemColor.activeCaptionBorder);
		panel_informacion.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_informacion.setBounds(0, 0, 786, 51);
		getContentPane().add(panel_informacion);
		panel_informacion.setLayout(null);

		// Barra de carga viral
		progressBar = new JProgressBar();
		progressBar.setBounds(135, 16, 207, 25);
		progressBar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		progressBar.setForeground(Color.GREEN);
		progressBar.setValue(0);
		panel_informacion.add(progressBar);

		// Pocion1
		pocion1 = new JButton(" ");
		pocion1.setBounds(466, 11, 43, 38);
		pocion1.setIcon(new ImageIcon(this.getClass().getResource("/recursos/Premios/ObjetosPreciosos/PocionVida.png")));
		pocion1.setEnabled(true);
		pocion1.setFocusable(false);
		pocion1.setMargin(new Insets(0, 0, 0, 0));
		panel_informacion.add(pocion1);

		// LISTENER POCION VIDA
		pocion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				if (juego.buscarPocion(0) != null) {
					juego.setCantPociones(juego.getCantPociones() - 1);
					juego.buscarPocion(0).startEffect(juego.getJugador());
					juego.eliminarPocion(0); 		
					progressBar.setValue((int) (juego.getJugador().getCargaViral()));
					pocion1.setEnabled(false);
				}

			}
		});

		// Pocion2
		pocion2 = new JButton(" ");
		pocion2.setBounds(519, 11, 43, 38);
		ImageIcon icon2 = new ImageIcon(this.getClass().getResource("/recursos/Premios/ObjetosPreciosos/PocionVida.png"));
		pocion2.setIcon(icon2);
		pocion2.setEnabled(true);
		pocion2.setFocusable(false);
		pocion2.setMargin(new Insets(0, 0, 0, 0));
		panel_informacion.add(pocion2);

		pocion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				if (juego.buscarPocion(1) != null) {
					juego.setCantPociones(juego.getCantPociones() - 1);
					juego.buscarPocion(1).startEffect(juego.getJugador());
					juego.eliminarPocion(1);
					progressBar.setValue((int) (juego.getJugador().getCargaViral()));
					pocion2.setEnabled(false);
				}
			}
		});

		JLabel labelCargaViral = new JLabel("CARGA VIRAL:");
		labelCargaViral.setForeground(Color.WHITE);
		labelCargaViral.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCargaViral.setBounds(10, 15, 115, 26);
		panel_informacion.add(labelCargaViral);

		JLabel labelPremios = new JLabel("PREMIOS:");
		labelPremios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPremios.setForeground(Color.WHITE);
		labelPremios.setBounds(379, 16, 77, 25);
		panel_informacion.add(labelPremios);

		labelNivel = new JLabel("NIVEL: 1");
		labelNivel.setHorizontalAlignment(SwingConstants.TRAILING);
		labelNivel.setForeground(Color.WHITE);
		labelNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNivel.setBounds(696, 16, 69, 25);
		panel_informacion.add(labelNivel);

		// Pocion3
		pocion3 = new JButton(" ");
		pocion3.setBounds(571, 11, 43, 38);
		panel_informacion.add(pocion3);
		pocion3.setIcon(new ImageIcon(this.getClass().getResource("/recursos/Premios/ObjetosPreciosos/PocionVida.png")));
		pocion3.setEnabled(true);
		pocion3.setFocusable(false);
		pocion3.setMargin(new Insets(0, 0, 0, 0));
		pocion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				if (juego.buscarPocion(2) != null) {
					juego.setCantPociones(juego.getCantPociones() - 1);
					juego.buscarPocion(2).startEffect(juego.getJugador());
					juego.eliminarPocion(2);
					progressBar.setValue((int) (juego.getJugador().getCargaViral()));
					pocion3.setEnabled(false);
				}
			}
		});
	}

	public void cambiarNivel(int i) {
		labelNivel.setText("NIVEL: " + i);
	}

	// CUANDO ATACAN AL JUGADOR
	public void modificarBarra(int vida) {
		progressBar.setValue(vida);
	}
	
	/**
	 * Mensaje al jugador mencionando su victoria o derrota
	 * @param gameover resultado del juego, si es true es que obtuvo la victoria, caso contrario false
	 */
	public void ganar(boolean gameover) {
		if(!gameover) {
			JOptionPane.showMessageDialog(this, "¡Felicitaciones, ganaste el juego!");
		}
		else {
			JOptionPane.showMessageDialog(this, "GAME OVER");
		}
		Timer t = new Timer();
		TimerTask exit = new TimerTask() {
			@Override
			public void run() {
				System.exit(0);
			}
		};
		t.schedule(exit, 1000);
		
	}

	private class Adapter extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			mv.keyPressed(e);
		}

		public void keyReleased(KeyEvent e) {
			mv.keyReleased(e);
		}
	}

	/**
	 * Setea enabled al boton para poder activar una pocion dentro del juego
	 * @param p pocion a agregar
	 */
	public void agregarPocionBoton(Pocion p) {
		int i = juego.agregarPocion(p);
		if(i == 0) {
			pocion1.setEnabled(true);
		} else
			if(i == 1) {
				pocion2.setEnabled(true);
			} else
				if(i == 2) {
					pocion3.setEnabled(true);
				}
	}
}