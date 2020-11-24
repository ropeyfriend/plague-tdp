package entidades.visitor;

import entidades.Entidad;
import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;

public class Jugador_Visitor extends Visitor {

	public Jugador_Visitor(Entidad o) {
		super(o);
	}

	public void visitarInfectado(Infectado infectado) {
		
	}

	public void visitarJugador(Jugador jugador) {
		
	}

	public void visitarProyectil(Proyectil proyectil) {
		
	}

	public void visitarPremio(Premio premio) {
		
	}

}