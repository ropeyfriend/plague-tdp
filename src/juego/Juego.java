package juego;

import java.util.LinkedList;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;
import entidades.proyectiles.ProyectilJugador;
import mapa.Mapa;
import niveles.Nivel;

public class Juego implements Runnable {
	protected LinkedList<Entidad> entidades;
	protected Mapa mapa;
	protected Jugador jugador;
	protected Nivel nivel;
	
	protected Proyectil p;
	protected Proyectil p1;

	public Juego() {
		mapa = new Mapa();
		jugador = new Jugador(393, 440, this);
		mapa.agregarEntidad(jugador);
		
		entidades = new LinkedList<Entidad>();		
		
		p = new ProyectilJugador(this, 300, 435);
		p1 = new ProyectilInfectado(this, 376, 35);
		mapa.agregarEntidad(p);
		mapa.agregarEntidad(p1);
		
		mapa.repaint();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(200);
				p.mover();
				p1.mover();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel n) {
		nivel = n;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void agregarArreglo(Infectado[] array) {
		// TODO Auto-generated method stub
	}
}
