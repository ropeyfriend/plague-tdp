package entidades.proyectiles;

import entidades.Entidad;
import entidades.EntidadGrafica;
import entidades.movimiento.EstrategiaMovimiento;
import entidades.personajes.Jugador;

/**Clase que modela a un proyectil*/

public abstract class Proyectil extends Entidad{
	/*Representa la velocidad del proyectil*/
    protected int velocidad;
    /*Representa la direccion a la cual se mueve el proyectil*/
    protected int direccion;
    /**Indica si el proyectil esta activo o no*/
    protected boolean activo;
    /**Indica la cantidad de danio que genera el proyectil*/
	protected int danio;
	protected EstrategiaMovimiento mv;
    
    /**Crea un nuevo proyectil
     * @param v, velocidad del proyectil
     * @param d, direccion del proyectil
     * */
    public Proyectil(int v, int d) {
    	velocidad = v;
    	direccion = d;
    }
    
    public void mover() {
		this.mv.mover();
	}
	
	public void setDireccion(int i) {
		if (i == 1 || i == -1)
			this.mv.setDireccion(i);
	}
    
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
    
    /**Retorna si el proyectil esta o no activo
     * @return activo
     * */
    public boolean getActivo() {
    	return activo;
    }
    
    /**Retorna el danio generado por el proyectil*/
    public int getDanio() {
    	return danio;
    }
	
    /**Retorna la entidad grafica del proyectil
     * @return entidad grafica
     * */
	public EntidadGrafica getEntidadGrafica() {
		return entidadGrafica;
	}
    
	//Setters
	/**Modifica la velocidad del proyectil por la pasada por parametro
	 * @param velocidad a modificar
	 * */
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	/**Modifica la variable activo por la pasada por parametro
	 * @param a, variable a modificar
	 * */
	public void setActivo(boolean a) {
		activo = a;
	}
	
	/**Modifica el danio por el pasado por parametro
	 * @param d, danio a modificar
	 * */
    public void setDanio(int d) {
    	danio = d;
    }
    
	/**Modifica la entidad grafica del proyectil por la pasada por parametro
	 * @param entidad a modificar
	 * */
	public void setEntidadGrafica(EntidadGrafica e) {
		entidadGrafica = e;
	}
    
}
