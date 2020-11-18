package entidades.visitor;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;

public class InfectadoVisitor extends Visitor{

	public InfectadoVisitor(Entidad o) {
		super(o);
	}

	@Override
	public void visitarInfectado(Infectado i) {
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		//((InfectadoAlpha) obj).recibirDanio();
	}

	@Override
	public void visitarPremio(Premio gift) {
		
	}
	
}
