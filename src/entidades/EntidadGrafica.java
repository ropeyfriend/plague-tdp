package entidades;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import entidades.visitor.Visitor;

public class EntidadGrafica extends Entidad{

	protected JLabel icono;
    protected int x;
    protected int y;
    
    public EntidadGrafica() {
		super();
	}
    
	public void updateImagen(String rutaDibujo) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(rutaDibujo));
		dibujo = new JLabel(imagen);
		ancho = imagen.getIconWidth();
		largo = imagen.getIconHeight();
	}
	
	public void flushImagen(String rutaDibujo) {
		ImageIcon imagen = new ImageIcon(this.getClass().getClassLoader().getResource(ruta_dibujo_ataque));
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

	@Override
	public void accept(Visitor v) {
		// TODO Auto-generated method stub
		
	}
}
