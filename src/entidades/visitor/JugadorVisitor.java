package entidades.visitor;

import entidades.Entidad;
import entidades.personajes.InfectadoAlpha;
import entidades.personajes.InfectadoBeta;
import entidades.personajes.Jugador;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;

public class JugadorVisitor extends Visitor {

	public JugadorVisitor(Entidad o) {
		super(o);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visitarInfectadoAlpha(InfectadoAlpha ea) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarInfectadoBeta(InfectadoBeta eb) {
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
