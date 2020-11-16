package entidades;

import javax.swing.JLabel;

public class EntidadGrafica {
    protected JLabel icono;
    protected int x;
    protected int y;

    public EntidadGrafica() {
        icono = new JLabel();
    }

    public EntidadGrafica(String path) {
        icono = new JLabel(path);
    }

    public void update() {

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
