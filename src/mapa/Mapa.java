package mapa;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import entidades.Entidad;

public class Mapa extends JLayeredPane {
	protected JLabel fondo;
	protected String ruta_fondo = "src\\recursos\\Mapa\\mapa.png";

	public Mapa() {
		super();
		this.setBounds(0, 49, 786, 514);
		fondo = new JLabel();
		fondo.setBounds(0, 0, 786, 514);
		ImageIcon original = new ImageIcon(ruta_fondo);
		fondo.setIcon(new ImageIcon(
				original.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
		this.repaint();
		this.add(fondo);
	}

	public void agregarEntidad(JLabel e) {
		this.add(e,0);
		this.repaint();
	}

	public void eliminarEntidad(Entidad e) {

	}

	public void setFondo(String ruta) {
		ruta_fondo = ruta;
		ImageIcon original = new ImageIcon(ruta_fondo);
		fondo.setIcon(new ImageIcon(
				original.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
		this.repaint();
	}
}
