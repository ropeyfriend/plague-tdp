package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;

public class JugadorVisitor extends Visitor {
	
	private Jugador j;

	public JugadorVisitor(Jugador j) {
		this.j = j;
	}

	@Override
	public void visitarInfectado(Infectado i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarJugador(Jugador J) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPremio(Premio gift) {
		// TODO Auto-generated method stub
		
	}

	

}
