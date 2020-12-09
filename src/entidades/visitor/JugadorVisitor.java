package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import entidades.premios.SuperArmaSanitaria;
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
	public void visitarCuarentena(CuarentenaObligatoria p) {
		p.startEffect();
		
	}

	@Override
	public void visitarPocion(Pocion p) {
		p.startEffect(j);
		
	}

	@Override
	public void visitarSuperArma(SuperArmaSanitaria p) {
		p.startEffect(j);
		
	}
	
}
