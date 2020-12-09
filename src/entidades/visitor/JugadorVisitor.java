package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;

/**Clase que representa al visitor del jugador*/

public class JugadorVisitor extends Visitor {
	/**Jugador del visitor*/
	private Jugador j;

	/**Crea un nuevo visitor del jugador*/
	public JugadorVisitor(Jugador j) {
		this.j = j;
	}

	@Override
	public void visitarInfectado(Infectado i) {
		//i.atacar();
		j.recibirDanio(i.getDanio());
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
