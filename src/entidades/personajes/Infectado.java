package entidades.personajes;

import java.util.Random;

import entidades.movimiento.MovimientoVertical;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import entidades.premios.SuperArmaSanitaria;
import entidades.proyectiles.ProyectilInfectado;
import juego.Juego;

/** Clase que modela a un infectado del juego */

public abstract class Infectado extends Personaje {
	// Atributes
	/** Representa el rango donde se exparcen las particulas del infectado */
	protected int rango;
	/** Cantidad de danio que recibe al ser golpeado por el jugador */
	protected float danio_a_recibir;
	protected MovimientoVertical mv;

	/**
	 * Crea un nuevo infectado
	 * 
	 * @param vel, velocidad del infectado
	 * @param r,   rango del infectado
	 */
	public Infectado(int vel, int r, Juego g) {
		cargaViral = 100;
		velocidad = vel;
		mv = new MovimientoVertical(this, MovimientoVertical.ABAJO);
		game = g;
		// p = new ProyectilInfectado();
		rango = r;
	}

	@Override
	public void jugar() {
		Random rnd = new Random();
		int probabilidad = rnd.nextInt(15);
		if (probabilidad == 0) {
			this.disparar();
		} else if (!fueraDelMapa(this.entidadGrafica.getY()))
			this.mover();
		else
			game.eliminarEntidad(this);
	}

	public boolean fueraDelMapa(int y) {
		boolean toret = false;
		if (y < 0 || y + this.getEntidadGrafica().getLabel().getHeight() > game.getMapa().getHeight())
			toret = true;
		return toret;
	}
	
	public void morir() {
		Random rnd1 = new Random();
		Random rnd2 = new Random();
		int n1 = rnd1.nextInt(3); // determina si se agrega premio o no
		int n2 = rnd2.nextInt(3); // determina que premio agregar
		int x = this.getEntidadGrafica().getX();
		int y = this.getEntidadGrafica().getY();
		if(n1 == 0) { // si agrego un premio
			if(n2 == 0) { // o agrego una pocion
				Premio p = new Pocion(x, y, game);
				game.getMapa().agregarEntidad(p);
				p.mover();
			} else
				if(n2 == 1) { // o agrego una cuarentena obligatoria
					Premio p = new CuarentenaObligatoria(5, game, x, y);
					game.getMapa().agregarEntidad(p);
					p.mover();
				} else
					if(n2 == 2) { // o agrego un super arma sanitaria
						Premio p = new SuperArmaSanitaria(10, 15, game, x, y);
						game.getMapa().agregarEntidad(p);
						p.mover();
					}
		} else {
			// no agrego nada
		}
	}


	// Getters
	/**
	 * Retorna el rango del infectado
	 * 
	 * @return rango del infectado
	 */
	public int getRango() {
		return rango;
	}

	public void mover() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
		this.mv.mover();
	}

	public void setDireccion(int i) {
		if (i == 1 || i == -1)
			this.mv.setDireccion(i);
	}

	/*
	 * /**Retorna la cantidad de danio que recibe el infectado
	 * 
	 * @return danio que recibe el infectado
	 */
	/*
	 * public float getDanio_a_recibir() { return danio_a_recibir; }
	 */

	// Setters
	/**
	 * Actualiza el valor del rango por el pasado por parametro
	 * 
	 * @param r, rango a actualizar
	 */
	public void setRango(int r) {
		rango = r;
	}

	/**
	 * Actualiza el valor del danio que recibe el infectado por el pasado por
	 * parametro
	 * 
	 * @param d, danio a actualizar.
	 */
	/*
	 * public void setDanio_a_recibir(float d) { danio_a_recibir = d; }
	 */

}
