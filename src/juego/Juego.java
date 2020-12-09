package juego;

import java.awt.Rectangle;
import java.util.LinkedList;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
import entidades.personajes.InfectadoBeta;
import entidades.personajes.Jugador;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;
import entidades.proyectiles.ProyectilJugador;
import gui.GUI;
import mapa.Mapa;
import niveles.Nivel;
import niveles.Tanda1;
import niveles.Tanda2;

public class Juego implements Runnable {
	/**Lista de entidades del juego*/
	protected LinkedList<Entidad> entidades;
	/***/
	private LinkedList<Entidad> entidadesClone;
	/**Mapa del juego*/
	protected Mapa mapa;
	/**Jugador del juego*/
	protected Jugador jugador;
	/**Nivel del juego*/
	protected Nivel nivel;
	/**Pociones de curacion del juego*/
	protected Premio[] pociones;
	/**Gui del juego*/
	protected GUI gui;
	protected Infectado a;
	protected Infectado b;
	
	protected Premio premio;

    public Juego(GUI gui) {
		mapa = new Mapa();
		jugador = new Jugador(393, 440, this);
		mapa.agregarEntidad(jugador);
		pociones = new Premio[3];
		premio = new Pocion(200,200,this);
		
		entidades = new LinkedList<Entidad>();		
		
		System.out.println("x " + jugador.getEntidadGrafica().getX());
		System.out.println("y " + jugador.getEntidadGrafica().getY());
		System.out.println("width " + jugador.getEntidadGrafica().getAncho());
		System.out.println("height "+ jugador.getEntidadGrafica().getLargo());
		
		a = new InfectadoAlpha(this, 3, 3, 150 , 0);
		b = new InfectadoBeta(this, 3, 3, 400, 0);
		this.agregarEntidad(a);
		this.agregarEntidad(b);
		this.agregarEntidad(premio);
		
		mapa.repaint();	
    }

  	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(200);
				entidadesClone = (LinkedList<Entidad>) entidades.clone();
				for(Entidad e : entidadesClone) {
					e.jugar();
					
					LinkedList<Entidad> colisiones = getColisiones(e);
					for (Entidad entidadQueColisiona: colisiones) {
						System.out.println(entidadQueColisiona);
						e.accept(entidadQueColisiona.getVisitor());
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
  	
  	/**Agrega una pocion al arreglo de pociones del juego
  	 * @param p, pocion a agregar
  	 * */
  	public void agregarPocion(Premio p) {
  		boolean encontre = false;
  		
  			for(int i = 0; i<pociones.length && !encontre; i++) {
  				if(pociones[i] == null) {
  					encontre = true;
  					pociones[i] = p;
  					gui.agregarPocion(p);
  				}
  			}
  	}
  	
  	/**Elimina la pocion ubicada en la posicion pasada por parametro
  	 * @param n, posicion en el arreglo de pociones
  	 * */
  	public void eliminarPocion(int n) {
  		pociones[n] = null;
  	}

  	/**Agrega una entidad a la lista de entidades del juego
  	 * @param e, entidad a agregar
  	 * */
  	public void agregarEntidad(Entidad e) {
  		entidades.add(e);
  		mapa.agregarEntidad(e);
  	}
  	
  	/**Elimina una entidad de la lista de entidades del juego
  	 * @param e, entidad a eliminar
  	 * */
  	public void eliminarEntidad(Entidad e) {
  		entidades.remove(e);
  		mapa.eliminarEntidad(e);
  	}
    
    /**Crea un nuevo nivel del juego
     * @param n, es un entero que representa el nivel a crear
     * @param siguiente, nivel siguiente al actual
     * @param cant, cantidad de infectados a crear en ese nivel
     * */
    public void crearNivel(int n, Nivel siguiente, int cant) {
    	nivel = new Nivel(this,cant/*,n*/);
    	nivel.setSiguiente(siguiente);
		nivel.setTanda(new Tanda1(nivel, cant/2));
		nivel.setTanda(new Tanda2(nivel, cant/2));
		gui.cambiarNivel();
    }    

	public void agregarArreglo(Infectado[] array) {
		for(int i = 0; i< array.length; i++) {
			if(array[i] != null) {
				entidades.add(array[i]);
				mapa.agregarEntidad(array[i]);
			}
		}
	}
    
    //Getters
    /**Retorna el nivel del juego
     * @return nivel del juego
     * */
    public Nivel getNivel() {
    	return nivel;
    }
    
    /**Obtiene el jugador del juego
     * @return jugador
     * */
    public Jugador getJugador() {
    	return jugador;
    }
    
    /**Obtiene el mapa del juego
     * @return mapa
     * */
    public Mapa getMapa() {
    	return mapa;
    }
    
    //Setters
    /**Modifica el nivel del juego por el pasado por parametro
     * @param n, nivel a modificar
     * */
    public void setNivel(Nivel n) {
    	nivel = n;
    }

	public void agregarArreglo(Infectado[] array) {
		// TODO Auto-generated method stub
	}
	
	public LinkedList<Entidad> getColisiones(Entidad e) {
		LinkedList<Entidad> toret = new LinkedList<Entidad> ();
		for(Entidad entidad : entidades) {
			if (!e.equals(entidad) && verificarColision(e,entidad)) {
				toret.add(entidad);
			}
		}
		return toret;
	}
	
	private boolean verificarColision(Entidad entidad_1, Entidad entidad_2) {
		Rectangle r1= entidad_1.getEntidadGrafica().getLabel().getBounds();
		Rectangle r2= entidad_2.getEntidadGrafica().getLabel().getBounds();
		return r1.intersects(r2);
	}
}
