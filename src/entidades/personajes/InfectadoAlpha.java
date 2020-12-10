package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/** Clase que modela a un infectado Alpha del juego */

public class InfectadoAlpha extends Infectado {

	/** Crea un nuevo infectado Alpha en una posicion 
	 * @param g El juego al que pertenece
	 * @param vel Su velocidad
	 * @param r Su rango
	 * @param x Su posicion x en el mapa
	 * @param x Su posicion y en el mapa
	 * */
	public InfectadoAlpha(Juego g, int vel, int r, int x, int y) {
		super(vel, r, g);
		danio = 20;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_ataque = "/recursos/Infectados/InfectadoAlpha_ataque.gif";
		ruta_dibujo_moviendose = "/recursos/Infectados/InfectadoAlpha_caminar.gif";
		ruta_dibujo_hit = "/recursos/Infectados/InfectadoAlpha_hit.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x, y);
	}
	
	/** Crea un nuevo infectado Alpha
	 * @param g El juego al que pertenece
	 * @param vel Su velocidad
	 * @param r Su rango
	 * */
	public InfectadoAlpha(Juego g, int vel, int r) {
		super(vel, r, g);
		danio = 20;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_ataque = "/recursos/Infectados/InfectadoAlpha_ataque.gif";
		ruta_dibujo_moviendose = "/recursos/Infectados/InfectadoAlpha_caminar.gif";
		ruta_dibujo_hit = "/recursos/Infectados/InfectadoAlpha_hit.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose);
	}

	// Methods
	public void recibirDanio(Proyectil p) { // (Como le resto de a 12.5 entonces se muere en 8 golpes)
		entidadGrafica.updateImagen(ruta_dibujo_hit);
		cargaViral -= p.getDanio();
		game.eliminarEntidad(p);

		if (cargaViral <= 0 && activo) {
			activo = false;
			morir();
		} else if (cargaViral <= 20 && activo) {// Si la cargaV es menor a 20 y esta vivo, duplican su velocidad
			velocidad = velocidad * 2;
		}

	}

	public void accept(Visitor v) {
		v.visitarInfectado(this);
	}

	public void disparar() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
		int x = this.entidadGrafica.getX() + 20;
		Proyectil disparo = new ProyectilInfectado(game, x, this.getEntidadGrafica().getY(), danio, rango);
		game.agregarEntidad(disparo);
	}

}
