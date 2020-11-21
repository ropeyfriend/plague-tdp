package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EntidadGrafica{

	protected JLabel icono;
    protected int x;
    protected int y;
    protected JLabel dibujo;
	protected int ancho; 
	protected int largo; 
    
    public EntidadGrafica() {
	}
    
	public void updateImagen(String rutaDibujo) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(rutaDibujo));
		dibujo = new JLabel(imagen);
		ancho = imagen.getIconWidth();
		largo = imagen.getIconHeight();
	}
	
	public void flushImagen(String rutaDibujo) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(rutaDibujo));
		imagen.getImage().flush();  // el flush() vuelve a iniciar el gif
		dibujo.setIcon(imagen);	
	}
   
    public JLabel getIcon() {
        return icono;
    }

    public int getY() {
        return y;
    }

    public int geyX() {
        return x;
    }

}
