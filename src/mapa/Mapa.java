package mapa;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import entidades.Entidad;

/**Clase que modela al mapa del juego*/

public class Mapa extends JLayeredPane {

	private static final long serialVersionUID = -5615000609536713858L;
	/**Fondo del mapa*/
	protected JLabel fondo;
	/**Ruta donde se ubica el fondo del mapa*/
	protected String ruta_fondo = "/recursos/Mapa/mapa.png";
	/**Coordenada y donde aparecen los infectados*/
	public final int y_infectados = 65;
	/**Coordenada y donde aparecen los proyectiles del jugador*/
	public final int y_proyectiles_jugador = 400;
	/**Largo del mapa*/
	public final int largo_mapa = 514;
	/**Ancho del mapa*/
	public final int ancho_mapa = 786;
	

	/**Crea un nuevo mapa*/
	public Mapa() {
		super();
		this.setBounds(0, 49, ancho_mapa, largo_mapa);
		fondo = new JLabel();
		fondo.setBounds(0, 0, ancho_mapa, largo_mapa);
		ImageIcon original = new ImageIcon(this.getClass().getResource(ruta_fondo));
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
