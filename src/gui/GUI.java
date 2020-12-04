package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.LineBorder;

import juego.Juego;
import mapa.Mapa;

public class GUI extends JFrame {
	protected Juego juego;
	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		juego = new Juego();
		
		JPanel panel_informacion = new JPanel();
		panel_informacion.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_informacion.setBounds(0, 0, 786, 60);
		getContentPane().add(panel_informacion);
		
		Mapa panel_mapa = juego.getMapa();
		getContentPane().add(panel_mapa);
		
	}
}
