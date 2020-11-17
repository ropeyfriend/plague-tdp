package entidades.visitor;

import entidades.Entidad;
import entidades.personajes.InfectadoAlpha;
import entidades.personajes.InfectadoBeta;
import entidades.personajes.Jugador;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;

public class InfectadoVisitor extends Visitor{

	public InfectadoVisitor(Entidad o) {
		super(o);
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ea) {
		
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta eb) {
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		//hago cosas
		
	}

	@Override
	public void visitarPremio(Premio gift) {
		
	}
	
}
