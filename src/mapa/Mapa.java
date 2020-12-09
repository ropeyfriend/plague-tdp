package mapa;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import entidades.Entidad;
import juego.Juego;

public class Mapa extends JLayeredPane {
	/**Fondo del mapa*/
	protected JLabel fondo;
	/**Ruta donde se ubica el fondo del mapa*/
	protected String ruta_fondo = "src\\recursos\\Mapa\\mapa.png";
	
	public final int y_infectados = 0;
	public final int y_proyectiles_jugador = 400;

	/**Crea un nuevo mapa*/
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

	/**Agrega una entidad al mapa
	 * @param e, entidad a agregar
	 * */
	public void agregarEntidad(Entidad e) {
		this.add(e.getEntidadGrafica().getLabel(), 0);
		this.repaint();
	}
	
	/**Elimina una entidad del mapa
	 * @param e, entidad a eliminar
	 * */
	public void eliminarEntidad(Entidad e) {
		this.remove(e.getEntidadGrafica().getLabel());
		this.repaint();
	}
	
	/**Modifica el fondo del mapa por el pasado por parametro
	 * @param ruta, String que representa la ruta donde se guarda el nuevo fondo
	 * */
	public void setFondo(String ruta) {
		ruta_fondo = ruta;
		ImageIcon original = new ImageIcon(ruta_fondo);
		fondo.setIcon(new ImageIcon(
				original.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH)));
		this.repaint();
	}
}
