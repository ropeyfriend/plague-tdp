package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.SuperArmaSanitaria;
import entidades.proyectiles.Proyectil;

/** Clase que representa al visitor del jugador */

public class JugadorVisitor extends Visitor {
	/** Jugador del visitor */
	private Jugador j;

	/** Crea un nuevo visitor del jugador */
	public JugadorVisitor(Jugador j) {
		this.j = j;
	}

	@Override
	public void visitarInfectado(Infectado i) {

	}

	@Override
	public void visitarJugador(Jugador J) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitarProyectil(Proyectil p) {
	}

	/**
	 * Visitor que se encarga de la interaccion entre un Jugador y el efectoCuarentena
	 */
	public void visitarCuarentena(CuarentenaObligatoria p) {
		j.getJuego().setCuarentena(p.getDuracion());
		j.getJuego().eliminarEntidad(p);
	}

	/**
	 * Visitor que se encarga de la interaccion entre el Jugador y una pocion
	 */
	public void visitarPocion(Pocion p) {
		j.getJuego().getGUI().agregarPocionBoton(p);
		j.getJuego().eliminarEntidad(p);
	}

	/**
	 * Visitor que se encarga de la interaccion entre el Jugador y el superArmaSanitaria
	 */
	public void visitarSuperArma(SuperArmaSanitaria p) {
		p.startEffect(j);
		j.getJuego().eliminarEntidad(p);
	}

}
