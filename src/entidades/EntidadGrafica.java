package entidades;

import java.awt.Image;

import javax.swing.ImageIcon;

/**Clase encargada de la parte grafica de la entidad*/

import javax.swing.JLabel;

/**Clase que modela la parte grafica de una entidad*/

public class EntidadGrafica {
	/**Coordenada x donde se ubica la entidad*/
    protected int x;
    /**Coordenada y donde se ubica la entidad*/
    protected int y;
    /**Icono de la entidad*/
    protected JLabel dibujo;
    /**Ancho de la imagen*/
	protected int ancho; 
	/**Largo de la imagen*/
	protected int largo; 
    
	/**Crea una nueva entidad grafica*/
    public EntidadGrafica(String rutaDibujo) {
    	x =0;
    	y = 0;
    	ancho = 40;
    	largo = 60;
    	ImageIcon original = new ImageIcon(rutaDibujo);
    	dibujo = new JLabel(original);
    	dibujo.setBounds(x, y, original.getIconWidth(), original.getIconHeight());
    	//dibujo.setIcon(new ImageIcon(original.getImage().getScaledInstance(ancho, largo, Image.SCALE_SMOOTH)));
	}
    
    /**Actualiza la imagen de la entidad por la que esta en la ruta pasada por parametro
     * @param rutaDibujo, ruta del gif.
     * */
	public void updateImagen(String rutaDibujo) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(rutaDibujo));
		dibujo = new JLabel(imagen);
		ancho = imagen.getIconWidth();
		largo = imagen.getIconHeight();
	}
	
    /**Vuleve a iniciar la imagen de la entidad por la que esta en la ruta pasada por parametro
     * @param rutaDibujo, ruta del gif.
     * */
	public void flushImagen(String rutaDibujo) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(rutaDibujo));
		imagen.getImage().flush();  // el flush() vuelve a iniciar el gif
		dibujo.setIcon(imagen);	
	}
   
	/**Retorna el icono de la entidad
	 * @return icono de la entidad
	 * */
    public JLabel getIcon() {
        return dibujo;
    }
    
    /**Retorna la coordenada Y donde se ubica la entidad
     * @return coordenada Y
     * */
    public int getY() {
        return y;
    }
    
    /**Retorna la coordenada X donde se ubica la entidad
     * @return coordenada X
     * */
    public int geyX() {
        return x;
    }
    
    public JLabel getLabel() {
    	return dibujo;
    }
    

}
