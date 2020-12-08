package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.border.LineBorder;

import juego.Juego;
import mapa.Mapa;
import javax.swing.JProgressBar;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

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
		getContentPane().setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);
		
		juego = new Juego();
		
		//Panel de informacion de jugador
		JPanel panel_informacion = new JPanel();
		panel_informacion.setBackground(Color.BLACK);
		panel_informacion.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_informacion.setBounds(0, 0, 786, 60);
		getContentPane().add(panel_informacion);
		panel_informacion.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
		
		// texto "CARGA VIRAL:"
		JTextPane txtpnCargaViral = new JTextPane();
		txtpnCargaViral.setForeground(Color.WHITE);
		txtpnCargaViral.setText("CARGA VIRAL  :");
		txtpnCargaViral.setBackground(Color.BLACK);
		panel_informacion.add(txtpnCargaViral);
		
		//Barra de carga viral
		JProgressBar progressBar = new JProgressBar();
		progressBar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		progressBar.setForeground(Color.GREEN);
		progressBar.setValue(50);
		panel_informacion.add(progressBar);
		// Hay que setearle oyente cuando lo ataquen nomas
		
		//Pocion1
		JButton pocion1 = new JButton(" ");
		pocion1.setIcon(new ImageIcon("D:\\TDP\\plague-tdp\\src\\recursos\\Premios\\ObjetosPreciosos\\PocionVida.png"));
		pocion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.getJugador().curar(25);
				pocion1.setEnabled(false);
			}
		});
		
		//Texto "POCIONES:"
		JTextPane txtpnPociones = new JTextPane();
		txtpnPociones.setText("POCIONES :");
		txtpnPociones.setBackground(Color.BLACK);
		txtpnPociones.setForeground(Color.WHITE);
		panel_informacion.add(txtpnPociones);
		pocion1.setEnabled(true);
		panel_informacion.add(pocion1);
		
		//Pocion2
		JButton pocion2 = new JButton(" ");
		pocion2.setIcon(new ImageIcon("D:\\TDP\\plague-tdp\\src\\recursos\\Premios\\ObjetosPreciosos\\PocionVida.png"));
		pocion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.getJugador().curar(25);
				pocion2.setEnabled(false);
			}
		});
		pocion2.setEnabled(true);
		panel_informacion.add(pocion2);
		
		//Pocion3
		JButton pocion3 = new JButton(" ");
		pocion3.setIcon(new ImageIcon("D:\\TDP\\plague-tdp\\src\\recursos\\Premios\\ObjetosPreciosos\\PocionVida.png"));
		pocion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.getJugador().curar(25);
				pocion3.setEnabled(false);
			}
		});
		pocion3.setEnabled(true);
		panel_informacion.add(pocion3);
		
		//Texto "NIVEL : X"
		JTextPane nivel = new JTextPane();
		nivel.setForeground(Color.WHITE);
		nivel.setBackground(Color.BLACK);
		nivel.setText("NIVEL: X");
		nivel.setFont(new Font("Verdana", Font.PLAIN, 14));
		panel_informacion.add(nivel);
		//Hay que setear oyente cuando cambia de nivel
		
		Mapa panel_mapa = juego.getMapa();
		getContentPane().add(panel_mapa);
		
		
		
	}
}