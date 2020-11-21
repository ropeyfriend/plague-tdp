package entidades;

import entidades.visitor.*;

public abstract class Entidad {
    protected EntidadGrafica entidadGrafica;
    protected Visitor visitor;
	protected String ruta_dibujo_moviendose;
	protected String ruta_dibujo_ataque;
    
    public abstract void accept(Visitor v);

}
