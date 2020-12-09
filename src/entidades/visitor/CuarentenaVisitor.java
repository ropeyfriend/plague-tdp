package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import entidades.premios.SuperArmaSanitaria;
import entidades.proyectiles.Proyectil;

public class CuarentenaVisitor extends Visitor{
	
	private CuarentenaObligatoria c;
	
	@Override
	public void visitarInfectado(Infectado i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarCuarentena(CuarentenaObligatoria p) {
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


}
