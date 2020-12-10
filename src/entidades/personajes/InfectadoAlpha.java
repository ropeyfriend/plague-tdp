package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/** Clase que modela a un infectado Alpha del juego */

public class InfectadoAlpha extends Infectado {

	/** Crea un nuevo infectado Alpha */
	public InfectadoAlpha(Juego g, int vel, int r, int x, int y) {
		super(vel, r, g);
		danio = 20;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_ataque = "src/recursos/Infectados/InfectadoAlpha_ataque.gif";
		ruta_dibujo_moviendose = "src/recursos/Infectados/InfectadoAlpha_caminar.gif";
		ruta_dibujo_hit = "src/recursos/Infectados/InfectadoAlpha_hit.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x, y);
	}
	
	public InfectadoAlpha(Juego g, int vel, int r) {
		super(vel, r, g);
		danio = 20;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_ataque = "src/recursos/Infectados/InfectadoAlpha_ataque.gif";
		ruta_dibujo_moviendose = "src/recursos/Infectados/InfectadoAlpha_caminar.gif";
		ruta_dibujo_hit = "src/recursos/Infectados/InfectadoAlpha_hit.gif";
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

	public boolean fueraDelMapa(int y) {
		boolean toret = false;
		if (y < 0 || y + this.getEntidadGrafica().getLabel().getHeight() > game.getMapa().getHeight())
			toret = true;
		return toret;
	}

	public void disparar() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
		int x = this.entidadGrafica.getX() + 20;
		Proyectil disparo = new ProyectilInfectado(game, x, this.getEntidadGrafica().getY(), danio);
		game.agregarEntidad(disparo);
	}

}
