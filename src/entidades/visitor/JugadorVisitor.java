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
		i.atacar(j);
	}

	@Override
	public void visitarJugador(Jugador J) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		j.recibirDanio(p.getDanio());
	}

	@Override
	public void visitarPremio(Premio p) {
		p.startEffect(j);
	}
	
}
