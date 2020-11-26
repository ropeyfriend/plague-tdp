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
	public void visitarProyectil(Proyectil p) { //el proyectil inf necesita un infectado x parametro y el proyectil jugador necesita un jugador x parametro
		//p.disparar(j);
	}

	@Override
	public void visitarPremio(Premio p) {
		p.startEffect(j);
	}


	
}
