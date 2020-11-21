package entidades.visitor;
import entidades.personajes.*;
import entidades.proyectiles.*;
import entidades.premios.*;

public abstract class Visitor {

		public abstract void visitarInfectado(Infectado i);

		public abstract void visitarJugador(Jugador j);
		
		public abstract void visitarProyectil(Proyectil p);
		
		public abstract void visitarPremio(Premio gift);
	
}

