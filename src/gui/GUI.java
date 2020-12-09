package gui;

import juego.Juego;
import mapa.Mapa;
import niveles.Nivel;

import javax.swing.JProgressBar;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import entidades.premios.Pocion;
import entidades.premios.Premio;

import java.awt.SystemColor;

public class GUI extends JFrame {

	private static final long serialVersionUID = 2116746884888994591L;
	protected Juego juego;
	protected MovimientoJugadorListener mv;
	protected Pocion pociones[];
	protected int cantPociones;
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
		//juego y mapa
		juego = new Juego();
		Mapa panel_mapa = juego.getMapa();
		
		
		//ventana y panel info
		setVentana();
		setPanelInformacion();
		
		//movimiento
		this.setFocusable(true);
		getContentPane().add(panel_mapa);
		mv = new MovimientoJugadorListener(juego.getJugador());
		this.addKeyListener(new Adapter());
		
		//pociones
		pociones = new Pocion[3];
		
		//cantidad de pociones
		cantPociones = 0;
		
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
		//Panel de informacion de jugador
				JPanel panel_informacion = new JPanel();
				panel_informacion.setBackground(SystemColor.activeCaptionBorder);
				panel_informacion.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
				panel_informacion.setBounds(0, 0, 786, 51);
				getContentPane().add(panel_informacion);
				panel_informacion.setLayout(null);
				
				//Barra de carga viral
				progressBar = new JProgressBar();
				progressBar.setBounds(135, 16, 207, 25);
				progressBar.setFont(new Font("Yu Gothic UI", Font.PLAIN, 14));
				progressBar.setForeground(Color.GREEN);
				progressBar.setValue((int) juego.getJugador().getCargaViral());
				panel_informacion.add(progressBar);
				
				
				
				//Pocion1
				JButton pocion1 = new JButton(" ");
				pocion1.setBounds(466, 11, 43, 38);
				pocion1.setIcon(new ImageIcon("src/recursos/Premios/ObjetosPreciosos/PocionVida.png"));
				pocion1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						juego.getJugador().curar(25);
						pocion1.setEnabled(false);
					}
				});
				pocion1.setEnabled(true);
				pocion1.setFocusable(false);
				pocion1.setMargin(new Insets(0, 0, 0, 0));
				panel_informacion.add(pocion1);
				
				//LISTENER POCION VIDA
				pocion1.addActionListener(new ActionListener() {//---------------Cuando agarra una pocion de vida hay q sumarle 1 a la cant de pociones de vida
					public void actionPerformed(ActionEvent arg) {
						
						if(cantPociones != 0) {
							cantPociones--;//Consumo una de las pociones
							juego.eliminarPocion(1);//elimino la pocion 1
							pociones[0].startEffect(juego.getJugador());//Curo al jugador
							progressBar.setValue((int)(juego.getJugador().getCargaViral()));
							pocion1.setEnabled(false);
						}
						
					}
				});
				
				//Pocion2
				pocion2 = new JButton(" ");
				pocion2.setBounds(519, 11, 43, 38);
				ImageIcon icon2 = new ImageIcon("src/recursos/Premios/ObjetosPreciosos/PocionVida.png");
				pocion2.setIcon(icon2);
				pocion2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						juego.getJugador().curar(25);
						pocion2.setEnabled(false);
					}
				});
				pocion2.setEnabled(true);
				pocion2.setFocusable(false);
				pocion2.setMargin(new Insets(0, 0, 0, 0));
				panel_informacion.add(pocion2);
				
				pocion2.addActionListener(new ActionListener() {//---------------Cuando agarra una pocion de vida hay q sumarle 1 a la cant de pociones de vida
					public void actionPerformed(ActionEvent arg) {
						
						if(cantPociones != 0) {
							cantPociones--;//Consumo una de las pociones
							juego.eliminarPocion(2);//elimino la pocion 2
							pociones[0].startEffect(juego.getJugador());
							progressBar.setValue((int)(juego.getJugador().getCargaViral()));
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
				
				labelNivel = new JLabel("NIVEL: "/*+juego.getNivel()*/);
				labelNivel.setHorizontalAlignment(SwingConstants.TRAILING);
				labelNivel.setForeground(Color.WHITE);
				labelNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
				labelNivel.setBounds(696, 16, 69, 25);
				panel_informacion.add(labelNivel);
				
				//Pocion3
				pocion3 = new JButton(" ");
				pocion3.setBounds(571, 11, 43, 38);
				panel_informacion.add(pocion3);
				pocion3.setIcon(new ImageIcon("src/recursos/Premios/ObjetosPreciosos/PocionVida.png"));
				pocion3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						juego.getJugador().curar(25);
						pocion3.setEnabled(false);
					}
				});
				pocion3.setEnabled(true);
				pocion3.setFocusable(false);
				pocion3.setMargin(new Insets(0, 0, 0, 0));
				
				pocion3.addActionListener(new ActionListener() { 
					public void actionPerformed(ActionEvent arg) {
						
						if(cantPociones != 0) {
							cantPociones--;//Consumo una de las pociones
							juego.eliminarPocion(3);//elimino la pocion 3
							pociones[0].startEffect(juego.getJugador());
							progressBar.setValue((int)(juego.getJugador().getCargaViral()));
							pocion3.setEnabled(false);	
						}
						
					}
				});
				
	}

	
	private class Adapter extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			mv.keyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			mv.keyReleased(e);
		}
	}
	
	public void agregarPocion(Pocion p) {
		if(cantPociones < 3) {//Si no esta lleno de pociones (hasta 3)
			for(int i = 0; i< pociones.length; i++) {
				if(pociones[i] == null) {
					pociones[i] = p;
					
					if(i == 0) {
						pocion1.setEnabled(true);
					}
					else {
						if(i == 2) {
							pocion2.setEnabled(true);
						}
						else {
							pocion3.setEnabled(true);
						}
					}
					cantPociones++;
				}
			}
		}
	}
	
	public void cambiarNivel() {
		Nivel n = juego.getNivel();
		if(n.getSiguiente() == null) {//Si no hay siguiente estas en el nivel 2
			labelNivel.setText("NIVEL: "+2);
		}
		else {
			labelNivel.setText("NIVEL: "+1);
		}
	}
	
	//CUANDO ATACAN AL JUGADOR
	public void modificarBarra() {
		progressBar.setValue((int) juego.getJugador().getCargaViral());
	}
	
}