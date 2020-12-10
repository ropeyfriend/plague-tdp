package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.SuperArmaSanitaria;
import entidades.proyectiles.Proyectil;

/** Clase que representa al visitor del jugador */

public class PocionVisitor extends Visitor {
	/** Jugador del visitor */
	private Pocion p;

	/** Crea un nuevo visitor del jugador */
	public PocionVisitor(Pocion pocion) {
		this.p = pocion;
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

	@Override
	public void visitarCuarentena(CuarentenaObligatoria p) {

	}

	@Override
	public void visitarPocion(Pocion p) {

	}

	@Override
	public void visitarSuperArma(SuperArmaSanitaria p) {

	}

}
