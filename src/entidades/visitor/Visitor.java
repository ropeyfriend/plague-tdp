package entidades.visitor;
import entidades.Entidad;
import entidades.personajes.*;
import entidades.proyectiles.*;
import entidades.premios.*;

public abstract class Visitor {
	
		protected Entidad obj;
	
		public Visitor(Entidad o) {
			obj = o;		
		}

		public abstract void visitarInfectado(Infectado i);

		public abstract void visitarJugador(Jugador J);
		
		public abstract void visitarProyectil(Proyectil p);
		
		public abstract void visitarPremio(Premio gift);
	
}

