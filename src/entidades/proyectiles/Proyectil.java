package entidades.proyectiles;

import entidades.Entidad;
import entidades.EntidadGrafica;

/**Clase que modela a un proyectil*/

public abstract class Proyectil extends Entidad{
	/*Representa la velocidad del proyectil*/
    protected int velocidad;
    /*Representa la direccion a la cual se mueve el proyectil*/
    protected int direccion;
    
    /**Crea un nuevo proyectil
     * @param v, velocidad del proyectil
     * @param d, direccion del proyectil
     * */
    public Proyectil(int v, int d) {
    	velocidad = v;
    	direccion = d;
    }
    
    public abstract void mover();
    
    //Getters
    /**Retorna la velocidad del proyectil
     * @return velocidad
     * */
    public int getVelocidad() {
    	return velocidad;
    }
    
    /**Retorna la direccion del proyectil
     * @return direccion
     * */
    public int getDireccion() {
    	return direccion;
    }

    /**Retorna la entidad grafica del proyectil
     * @return entidad grafica
     * */
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
	
	//Setters
	/**Modifica la entidad grafica del proyectil por la pasada por parametro
	 * @param entidad a modificar
	 * */
	public void setEntidadGrafica(EntidadGrafica e) {
		entidadGrafica = e;
	}
	
	/**Modifica la velocidad del proyectil por la pasada por parametro
	 * @param velocidad a modificar
	 * */
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	/**Modifica la direccion del proyectil por la pasada por parametro
	 * @param direccion a modificar
	 * */
	public void setDireccion(int d) {
		direccion = d;
	}
    
}
