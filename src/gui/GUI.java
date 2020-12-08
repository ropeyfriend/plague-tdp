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

import entidades.premios.Pocion;
import entidades.premios.Premio;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class GUI extends JFrame {
	
	protected Juego juego;
	protected int vida;
	protected JButton pocionVida;


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
		vida = 0;
		
		//Panel de informacion de jugador
		JPanel panel_informacion = new JPanel();
		panel_informacion.setBackground(SystemColor.controlShadow);
		panel_informacion.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_informacion.setBounds(0, 0, 786, 60);
		getContentPane().add(panel_informacion);
		panel_informacion.setLayout(null);
		
		//Barra de carga viral
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(145, 24, 207, 25);
		progressBar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
		progressBar.setForeground(Color.GREEN);
		progressBar.setValue(0);
		panel_informacion.add(progressBar);
		// Hay que setearle oyente cuando lo ataquen nomas
		
		
		//Pocion vida
		pocionVida = new JButton(" ");
		pocionVida.setBounds(464, 11, 49, 38);
		pocionVida.setIcon(new ImageIcon("src/recursos/Premios/ObjetosPreciosos/PocionVida.png"));
		pocionVida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				juego.getJugador().curar(25);
				pocionVida.setEnabled(false);
			}
		});
		pocionVida.setEnabled(true);
		panel_informacion.add(pocionVida);
		
		//LISTENER POCION VIDA
		pocionVida.addActionListener(new ActionListener() {//---------------Cuando agarra una pocion de vida hay q sumarle 1 a la cant de pociones de vida
			public void actionPerformed(ActionEvent arg) {
				
				if(vida != 0) {
					vida--;//Consumo una de las pociones
					juego.getJugador().curar(25);//NO PUEDO USAR POCION PORQUE NO HAY NINGUNA CREADA
					progressBar.setValue((int)(juego.getJugador().getCargaViral()));
				}
				else {
					pocionVida.setEnabled(false);
				}
				
			}
		});
		
		
		//Pocion cuarentena
		JButton pocionCuarentena = new JButton(" ");
		pocionCuarentena.setBounds(531, 11, 49, 38);
		pocionCuarentena.setIcon(new ImageIcon("src/recursos/Premios/EfectosTemporales/efecto_cuarentena.png"));
		pocionCuarentena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				
			}
		});
		pocionCuarentena.setEnabled(true);
		panel_informacion.add(pocionCuarentena);
		
		//Pocion super
		JButton pocionSuper = new JButton("");
		pocionSuper.setBounds(598, 11, 49, 38);
		pocionSuper.setIcon(new ImageIcon("src/recursos/Premios/EfectosTemporales/efecto_super.png"));
		
		//LISTENER POCION SUPER
		pocionSuper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg) {
				
				
				
				
			}
		});
		pocionSuper.setEnabled(true);
		panel_informacion.add(pocionSuper);
		
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
		
		labelNivel.setText("NIVEL: "+juego.getNivel());//No puedo agregar actionlistener a una label
		
		
		
		Mapa panel_mapa = juego.getMapa();
		getContentPane().add(panel_mapa);
		
	}
	
	public void sumarPocionVida() {
		if(vida != 3) {
			vida++;
			pocionVida.setEnabled(true);
		}
	}
	
}