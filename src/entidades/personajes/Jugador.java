package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.movimiento.MovimientoHorizontal;
import entidades.proyectiles.*;
import entidades.visitor.*;
import juego.Juego;

public class Jugador extends Personaje {

	// Atributes
	/* Arma del jugador para desinfectar a los infectados */
	protected ProyectilJugador armaSanitaria;
	protected MovimientoHorizontal mh;
	protected String ruta_dibujo_moviendose_i;

	/**
	 * Crea un nuevo jugador
	 * 
	 * @param p,   proyectil del jugador
	 * @param vel, velocidad del jugador
	 */
	public Jugador(int x, int y, Juego g) {
		game = g;
		ruta_dibujo_moviendose = "src/recursos/Jugador/JugadorCaminandoDerecha.gif";
		ruta_dibujo_ataque = "src/recursos/Jugador/JugadorQuieto.png";
		ruta_dibujo_moviendose_i = "src/recursos/Jugador/JugadorCaminandoIzquierda.gif";
		ruta_dibujo_hit = "src/recursos/Jugador/JugadorHit.gif";
		cargaViral = 0;
		velocidad = 10;
		danio = 15;
		activo = true;
		visitor = new JugadorVisitor(this);
		entidadGrafica = new EntidadGrafica(ruta_dibujo_ataque, x, y);
		mh = new MovimientoHorizontal(this, MovimientoHorizontal.DERECHA);
	}
	
	public Juego getJuego() {
		return game;
	}
	
	/**
	 * Suma la carga viral del jugador con la pasada por parametro.
	 * 
	 * @param danio, danio a sumar.
	 */
	public void recibirDanio(Proyectil p) {
		entidadGrafica.updateImagen(ruta_dibujo_hit);
		cargaViral += p.getDanio();
		System.out.println("[JUGADOR] vida+daño: " + cargaViral);
		game.eliminarEntidad(p);
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
		System.out.println("[JUGADOR] vida-cura: " + cargaViral);
	}
	
	/**
	 * Le otorga mayor capacidad de desinfeccion al arma del jugador
	 * 
	 * @param valor a multiplicar a la capacidad de desinfeccion.
	 */
	public void efectoSuper(int cant) {
		armaSanitaria.efectoSuper(cant);
	}
	
	

	public void accept(Visitor v) {
		v.visitarJugador(this);
	}

	/**
	 * Cambia el dibujo dependiendo del entero recibido. Si es menor a 1, carga el
	 * dibujo viendo hacia la izquierda Si es 0, carga el dibujo mirando al frente
	 * Si es mayor a 0, carga el dibujo mirando hacia la derecha
	 * 
	 * @param i
	 */
	public void cambiarDibujo(int i) {
		if (i == 0)
			entidadGrafica.updateImagen(ruta_dibujo_ataque);
		else if (i > 0)
			entidadGrafica.updateImagen(ruta_dibujo_moviendose);
		else if (i < 0)
			entidadGrafica.updateImagen(ruta_dibujo_moviendose_i);
	}

	// Setters
	/**
	 * Modifica al arma sanitaria por la pasada por parametro
	 * 
	 * @param a, arma sanitaria a modificar.
	 */
	public void setArmaSanitaria(ProyectilJugador a) {
		armaSanitaria = a;
	}

	// Getters
	/**
	 * Retorna el arma sanitaria del jugador
	 * 
	 * @return arma sanitaria
	 */
	public ProyectilJugador getArmaSanitaria() {
		return armaSanitaria;
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

	@Override
	public void jugar() {
		// TODO Auto-generated method stub
	}

	@Override
	public void disparar() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
		int x = this.entidadGrafica.getX() + 13; //-18 para q este centrado
		Proyectil p = new ProyectilJugador(game, x, game.getMapa().y_proyectiles_jugador);
		
		game.agregarEntidad(p);
	}

	
}
