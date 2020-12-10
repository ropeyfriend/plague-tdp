package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/** Clase que modela la parte grafica de una entidad */

public class EntidadGrafica {
	/** Coordenada x donde se ubica la entidad */
	protected int x;
	/** Coordenada y donde se ubica la entidad */
	protected int y;
	/** Icono de la entidad */
	protected JLabel dibujo;
	/** Ancho de la imagen */
	protected int ancho;
	/** Largo de la imagen */
	protected int largo;
	/** Ruta del diubjo */
	protected String ruta;

	/**
	 * Crea una nueva entidad grafica
	 * 
	 * @param ruta, ruta de la imagen
	 * @param x,    coordenada donde se ubica la entidad
	 * @param y,    coordenada donde se ubica la entidad
	 */
	public EntidadGrafica(String ruta, int x, int y) {
		this.x = x;
		this.y = y;
		this.ruta = ruta;
		ImageIcon original = new ImageIcon(this.getClass().getResource(ruta));
		dibujo = new JLabel(original);
		dibujo.setBounds(x, y, original.getIconWidth(), original.getIconHeight());
		ancho = dibujo.getWidth();
		largo = dibujo.getHeight();
	}

	/**
	 * Crea una nueva entidad grafica
	 * 
	 * @param ruta, ruta de la imagen
	 */
	public EntidadGrafica(String ruta) {
		this.ruta = ruta;
		ImageIcon original = new ImageIcon(this.getClass().getResource(ruta));
		dibujo = new JLabel(original);
		dibujo.setBounds(x, y, original.getIconWidth(), original.getIconHeight());
		ancho = dibujo.getWidth();
		largo = dibujo.getHeight();
	}

	/**
	 * Actualiza la imagen de la entidad por la que esta en la ruta pasada por
	 * parametro
	 * 
	 * @param rutaDibujo, ruta del gif.
	 */
	public void updateImagen(String ruta) {
		dibujo.setIcon(new ImageIcon(this.getClass().getResource(ruta)));
		ancho = dibujo.getWidth();
		largo = dibujo.getHeight();
		dibujo.repaint();
	}

	// ----------- Getters -----------
	/**
	 * Retorna la coordenada X donde se ubica la entidad
	 * 
	 * @return coordenada X
	 */
	public int getX() {
		return x;
	}

	/**
	 * Retorna la coordenada Y donde se ubica la entidad
	 * 
	 * @return coordenada Y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Retorna el icono de la entidad
	 * 
	 * @return icono de la entidad
	 */
	public JLabel getLabel() {
		return dibujo;
	}

	/**
	 * Devuelve el ancho del dibujo de la entidad
	 * 
	 * @return la anchura de la entidad
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * Devuelve el largo del dibujo de la entidad
	 * 
	 * @return el valor anterior del largo de la entidad
	 */
	public int getLargo() {
		return largo;
	}

	/**
	 * Devuelve la ruta de la imagen de la entidad
	 * 
	 * @return Devuelve la ruta
	 */
	public String getRuta() {
		return ruta;
	}

	// ----------- Setters -----------
	/**
	 * Inserta un nuevo valor de x
	 * 
	 * @param x el valor anterior de x
	 */
	public int setX(int x) {
		int toret = this.x;
		this.x = x;
		dibujo.setLocation(this.x, this.y);
		return toret;
	}

	/**
	 * Inserta un nuevo valor de y
	 * 
	 * @param x el valor anterior de y
	 */
	public int setY(int y) {
		int toret = this.y;
		this.y = y;
		dibujo.setLocation(this.x, this.y);
		dibujo.repaint();
		return toret;
	}

	/**
	 * Inserta un nuevo dibujo
	 * 
	 * @param dibujo el nuevo dibujo a insertar
	 * 
	 * @return retorna el dibujo anterior
	 */
	public JLabel setLabel(JLabel dibujo) {
		JLabel toret = this.dibujo;
		this.dibujo = dibujo;
		return toret;
	}

	/**
	 * Modifica el ancho del dibujo
	 * 
	 * @param ancho el nuevo ancho
	 * 
	 * @return retorna el valor de la anchura anterior
	 */
	public int setAncho(int ancho) {
		int toret = this.ancho;
		this.ancho = ancho;
		return toret;
	}

	/**
	 * Modifica el largo del dibujo
	 * 
	 * @param largo el nuevo largo
	 * 
	 * @return retorna el valor del largo anterior
	 */
	public void setLargo(int largo) {
		this.largo = largo;
	}

	/**
	 * Modifica la ruta de la imagen de la entidad
	 * 
	 * @param ruta La nueva ruta de la imagen
	 * 
	 * @return La ruta anterior
	 */
	public String setRuta(String ruta) {
		String toret = this.ruta;
		this.ruta = ruta;
		return toret;
	}
}
