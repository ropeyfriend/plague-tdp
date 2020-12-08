package gui;

import juego.Juego;
import mapa.Mapa;
import javax.swing.JProgressBar;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JTextPane;

public class GUI extends JFrame {
	
	protected Juego juego;
	
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
		panel_informacion.setLayout(null);
		
		//Barra de carga viral
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(145, 24, 207, 25);
		progressBar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		progressBar.setForeground(Color.GREEN);
		progressBar.setValue(50);
		panel_informacion.add(progressBar);
		// Hay que setearle oyente cuando lo ataquen nomas
		
		//Pocion1
		JButton pocion1 = new JButton(" ");
		pocion1.setBounds(464, 11, 57, 38);
		pocion1.setIcon(new ImageIcon("D:\\TDP\\plague-tdp\\src\\recursos\\Premios\\ObjetosPreciosos\\PocionVida.png"));
		pocion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.getJugador().curar(25);
				pocion1.setEnabled(false);
			}
		});
		pocion1.setEnabled(true);
		panel_informacion.add(pocion1);
		
		//Pocion2
		JButton pocion2 = new JButton(" ");
		pocion2.setBounds(531, 11, 57, 38);
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
		pocion3.setBounds(598, 11, 57, 38);
		pocion3.setIcon(new ImageIcon("D:\\TDP\\plague-tdp\\src\\recursos\\Premios\\ObjetosPreciosos\\PocionVida.png"));
		pocion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				juego.getJugador().curar(25);
				pocion3.setEnabled(false);
			}
		});
		pocion3.setEnabled(true);
		panel_informacion.add(pocion3);
		
		JLabel labelCargaViral = new JLabel("CARGA VIRAL:");
		labelCargaViral.setForeground(Color.WHITE);
		labelCargaViral.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelCargaViral.setBounds(21, 23, 115, 26);
		panel_informacion.add(labelCargaViral);
		
		JLabel labelPremios = new JLabel("PREMIOS:");
		labelPremios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelPremios.setForeground(Color.WHITE);
		labelPremios.setBounds(377, 24, 77, 25);
		panel_informacion.add(labelPremios);
		
		JLabel labelNivel = new JLabel("NIVEL:");
		labelNivel.setHorizontalAlignment(SwingConstants.TRAILING);
		labelNivel.setForeground(Color.WHITE);
		labelNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNivel.setBounds(677, 24, 69, 25);
		panel_informacion.add(labelNivel);
		//Hay que setear oyente cuando cambia de nivel
		
		Mapa panel_mapa = juego.getMapa();
		getContentPane().add(panel_mapa);
		
	}
}