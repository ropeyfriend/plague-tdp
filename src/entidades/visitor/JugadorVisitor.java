package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import entidades.premios.SuperArmaSanitaria;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;

public class JugadorVisitor extends Visitor {
	
	private Jugador j;

	public JugadorVisitor(Jugador j) {
		this.j = j;
	}

	@Override
	public void visitarInfectado(Infectado i) {
		i.atacar(j);
		i.updateImagenAtaque();
	}

	@Override
	public void visitarJugador(Jugador J) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		if(p instanceof ProyectilInfectado) {
			((ProyectilInfectado)p).disparar(j);
		}
	}

	@Override
	public void visitarPremio(Premio p) {
		if(p instanceof Pocion ) {
			((Pocion) p).curar(j);
		}
		else {
			if(p instanceof SuperArmaSanitaria) {
				((SuperArmaSanitaria) p).startEffect(j);
			}
			else {
				((CuarentenaObligatoria) p).startEffect();
			}
		}
	}


	
}
