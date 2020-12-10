package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.SuperArmaSanitaria;
import entidades.proyectiles.Proyectil;

/**Clase que modela al visitor de el superArmaSanitaria*/
public class SuperArmaVisitor extends Visitor{
	
	/** superArmaSanitaria del visitor */
	protected SuperArmaSanitaria arma;
	
	/**
	 * Crea un Visitor de superArmaSanitaria
	 * @param a
	 */
	public SuperArmaVisitor(SuperArmaSanitaria a) {
		arma = a;
	}
	
	@Override
	public void visitarInfectado(Infectado i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPocion(Pocion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSuperArma(SuperArmaSanitaria p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarCuarentena(CuarentenaObligatoria p) {
		// TODO Auto-generated method stub
		
	}

}
