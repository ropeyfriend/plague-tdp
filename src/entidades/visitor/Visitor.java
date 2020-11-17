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

		public abstract void visitarInfectado(Infectado infectado);
		
		public abstract void visitarJugador(Jugador jugador);
		
		public abstract void visitarProyectil(Proyectil proyectil);
		
		public abstract void visitarPremio(Premio premio);
	
}