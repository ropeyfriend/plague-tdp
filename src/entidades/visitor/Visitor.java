package entidades.visitor;
import entidades.personajes.*;
import entidades.proyectiles.*;
import entidades.premios.*;

public interface Visitor {

		public void visitarInfectadoAlpha(InfectadoAlpha ea);
		
		public void visitarInfectadoBeta(InfectadoBeta eb);
		
		public void visitarJugador(Jugador J);
		
		public void visitarProyectil(Proyectil p);
		
		public void visitarPrecio(Premio gift);
	
}

