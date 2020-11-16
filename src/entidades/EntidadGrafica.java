package entidades;

import javax.swing.ImageIcon;

public class EntidadGrafica {
    protected ImageIcon icono;
    protected int x;
    protected int y;

    public EntidadGrafica() {
        icono = new ImageIcon();
    }

    public EntidadGrafica(String path) {
        icono = new ImageIcon(path);
    }

    public void update() {

    }

    public ImageIcon getIcon() {
        return icono;
    }

    public int getY() {
        return y;
    }

    public int geyX() {
        return x;
    }
}
