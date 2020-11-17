package entidades;

import javax.swing.JLabel;

import entidades.visitor.*;

public abstract class Entidad {
    protected EntidadGrafica grafico;
    protected Visitor visitor;
	protected String ruta_dibujo_moviendose;
	protected String ruta_dibujo_ataque;
	protected JLabel dibujo;
	protected int ancho; 
	protected int largo; 
	
	public Entidad(){
	}
    
    public abstract void accept(Visitor v);

}
