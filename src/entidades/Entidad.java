package entidades;

import entidades.visitor.*;


public abstract class Entidad {
    protected EntidadGrafica grafico;
    protected Visitor visitor;

    public Entidad(String path) {
        grafico = new EntidadGrafica(path);
    }

}
