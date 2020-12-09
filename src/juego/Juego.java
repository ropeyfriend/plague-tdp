package juego;

import java.util.LinkedList;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.InfectadoAlpha;
import entidades.personajes.InfectadoBeta;
import entidades.personajes.Jugador;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;
import entidades.proyectiles.ProyectilJugador;
import mapa.Mapa;
import niveles.Nivel;
import niveles.Tanda1;
import niveles.Tanda2;

public class Juego implements Runnable {
	protected LinkedList<Entidad> entidades;
	protected Mapa mapa;
	protected Jugador jugador;
	protected Nivel nivel;
	protected Infectado a;
	protected Infectado b;
	protected Proyectil p;
	protected Proyectil p1;

    public Juego() {
		mapa = new Mapa();
		jugador = new Jugador(393, 440, this);
		mapa.agregarEntidad(jugador);
		
		entidades = new LinkedList<Entidad>();		
		a = new InfectadoAlpha(this, 10, 3, 150 , 0);
		b = new InfectadoBeta(this, 10, 3, 400, 0);
		p = new ProyectilInfectado(this, 300, 0);
		p1 = new ProyectilJugador(this, 375, 400);
		mapa.agregarEntidad(a);
		mapa.agregarEntidad(b);
		mapa.agregarEntidad(p);
		mapa.agregarEntidad(p1);
		
		mapa.repaint();	
    }

  	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(250);
				a.jugar();
				b.jugar();
				p.jugar();
				//p1.jugar();
				
				for(Entidad e : entidades) {
					e.jugar();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}

  	public void agregarEntidad(Entidad e) {
  		entidades.add(e);
  		mapa.agregarEntidad(e);
  	}
  	
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
    	nivel = new Nivel(this,cant,n);
    	nivel.setSiguiente(siguiente);
		nivel.setTanda(new Tanda1(nivel, cant/2));
		nivel.setTanda(new Tanda2(nivel, cant/2));	
    }
    
    //Getters
    /**Retorna el nivel del juego
     * @return nivel del juego
     * */
    public int getNivel() {
    	return nivel.getNivel();
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
}
