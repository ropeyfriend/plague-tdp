package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela a un infectado Beta del juego*/

public class InfectadoBeta extends Infectado{
	
	/**
	 * Crea un nuevo infectado beta en una posicion
	 * @param g El juego al que pertenece
	 * @param vel Su velocidad
	 * @param r Su rango
	 * @param x Su posicion x en el mapa
	 * @param y Su posicion y en el mapa
	 */
	public InfectadoBeta(Juego g, int vel, int r, int x, int y) {
		super(vel, r,g);
		danio = 10;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_moviendose = "/recursos/Infectados/InfectadoBeta_caminar.gif";
		ruta_dibujo_ataque = "/recursos/Infectados/InfectadoBeta_ataque.gif";
		ruta_dibujo_hit = "/recursos/Infectados/InfectadoBeta_hit.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x, y);
	}
	
	/**
	 * Crea un nuevo infectado beta
	 * @param g El juego al que pertenece
	 * @param vel Su velocidad
	 * @param r Su rango
	 */
	public InfectadoBeta(Juego g, int vel, int r) {
		super(vel, r,g);
		danio = 10;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_moviendose = "/recursos/Infectados/InfectadoBeta_caminar.gif";
		ruta_dibujo_ataque = "/recursos/Infectados/InfectadoBeta_ataque.gif";
		ruta_dibujo_hit = "/recursos/Infectados/InfectadoBeta_hit.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose);
	}
	
	
	//Methods
	public void recibirDanio(Proyectil p) {//(Como le resto de a 10 entonces se muere en 10 golpes)
		entidadGrafica.updateImagen(ruta_dibujo_hit);
		cargaViral -= p.getDanio()/2; 	//recibe menos daño
		game.eliminarEntidad(p);
		if(cargaViral <= 0 && activo) {
			activo = false;
			morir();
		}
	}
	
	public void accept(Visitor v){
		v.visitarInfectado(this);
	}

	@Override
	public void disparar() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
		int x = this.entidadGrafica.getX() + 8;
		Proyectil disparo = new ProyectilInfectado(game, x, this.getEntidadGrafica().getY(), danio, rango);
		game.agregarEntidad(disparo);
	}
	
}
