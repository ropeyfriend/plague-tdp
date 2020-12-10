package entidades.personajes;

import java.util.Timer;
import java.util.TimerTask;

import entidades.EntidadGrafica;
import entidades.movimiento.MovimientoHorizontal;
import entidades.proyectiles.*;
import entidades.visitor.*;
import juego.Juego;

public class Jugador extends Personaje {

	// Atributes
	/* Arma del jugador para desinfectar a los infectados */
	protected MovimientoHorizontal mh;
	/**String que representa la ruta donde se guarda el dibujo del jugador moviendose*/
	protected String ruta_dibujo_moviendose_i;
	/**Indica si el efecto esta o no activado*/
	protected boolean efectoSuperArmaSanitaria;

	/**
	 * Crea un nuevo jugador
	 * 
	 * @param p, proyectil del jugador
	 * @param vel, velocidad del jugador
	 */
	public Jugador(int x, int y, Juego g) {
		game = g;
		ruta_dibujo_moviendose = "/recursos/Jugador/JugadorCaminandoDerecha.gif";
		ruta_dibujo_ataque = "/recursos/Jugador/JugadorQuieto.png";
		ruta_dibujo_moviendose_i = "/recursos/Jugador/JugadorCaminandoIzquierda.gif";
		ruta_dibujo_hit = "/recursos/Jugador/JugadorHit.gif";
		efectoSuperArmaSanitaria = false;
		cargaViral = 0;
		velocidad = 10;
		danio = 10;
		activo = true;
		visitor = new JugadorVisitor(this);
		entidadGrafica = new EntidadGrafica(ruta_dibujo_ataque, x, y);
		mh = new MovimientoHorizontal(this, MovimientoHorizontal.DERECHA);
	}

	public void accept(Visitor v) {
		v.visitarJugador(this);
	}
	
	public void disparar() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
		int x = this.entidadGrafica.getX() + 13; //13 para q este centrado
		Proyectil p = new ProyectilJugador(game, x, game.getMapa().y_proyectiles_jugador, efectoSuperArmaSanitaria);
		game.agregarEntidad(p);
	}
	
	/**
	 * 
	 * Suma la carga viral del jugador con el del proyectil pasado por parametro.
	 * @param danio, danio a sumar.
	 */
	public void recibirDanio(Proyectil p) {
		entidadGrafica.updateImagen(ruta_dibujo_hit);
		cargaViral += p.getDanio();
		
		//morir
		if(cargaViral >= 100) {
			activo = false;
			game.eliminarEntidad(this);
		}
		game.eliminarEntidad(p);
		game.getGUI().modificarBarra((int) cargaViral);
	}
	
	/**
	 * Suma la carga viral del jugador con la pasada por parametro.
	 * @param danio_recibido
	 */
	public void recibirDanio(int danio_recibido) {
		entidadGrafica.updateImagen(ruta_dibujo_hit);
		cargaViral += danio_recibido;
		
		//morir
		if(cargaViral >= 100) {
			activo = false;
			game.eliminarEntidad(this);
		}
		game.getGUI().modificarBarra((int) cargaViral);
	}

	/**
	 * Cura al jugador restando el valor pasado por parametro a la carga viral
	 * 
	 * @param vida, valor a restar a la carga viral
	 */
	public void curar(int vida) {
		cargaViral -= vida;
		if(cargaViral < 0)
			cargaViral = 0;
		game.getGUI().modificarBarra((int)cargaViral);
	}
	
	/**
	 * Le otorga mayor capacidad de desinfeccion al arma del jugador
	 * 
	 * @param valor a multiplicar a la capacidad de desinfeccion.
	 */
	public void efectoSuper(int cant) {
		efectoSuperArmaSanitaria = true;
		Timer t = new Timer();
		TimerTask setFalse = new TimerTask() {
			@Override
			public void run() {
				efectoSuperArmaSanitaria = false;
			}
		};
		t.schedule(setFalse, 10000);
	}
	
	/**
	 * Cambia el dibujo dependiendo del entero recibido. Si es menor a 1, carga el
	 * dibujo viendo hacia la izquierda Si es 0, carga el dibujo mirando al frente
	 * Si es mayor a 0, carga el dibujo mirando hacia la derecha
	 * 
	 * @param i, entero que representa los distintos dibujos
	 */
	public void cambiarDibujo(int i) {
		if (i == 0)
			entidadGrafica.updateImagen(ruta_dibujo_ataque);
		else if (i > 0)
			entidadGrafica.updateImagen(ruta_dibujo_moviendose);
		else if (i < 0)
			entidadGrafica.updateImagen(ruta_dibujo_moviendose_i);
	}

	/**
	 * Dado el parametro i cambia el dibujo del jugador dependiendo si se mueve para la izquierda, derecha o no tiene movimiento (-1, 1 y 0)
	 * Luego indica la direccion y se mueve
	 * @param i Indica la dirección del movimiento realizado
	 */
	public void mover(int i) {
		cambiarDibujo(i);
		if (i == 1 || i == -1) {
			this.mh.setDireccion(i);
			this.mh.mover();
		}
	}
	
	/**Retorna el juego del jugador
	 * @return juego actual
	 * */
	public Juego getJuego() {
		return game;
	}

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
	}
	
}
