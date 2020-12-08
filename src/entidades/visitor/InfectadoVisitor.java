package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;

/**Clase que modela al visitor de un infectado*/

public class InfectadoVisitor extends Visitor{
	/**Infectado del visitor*/
	private Infectado inf;
	
	/**Crea un nuevo visitor del infectado*/
	public InfectadoVisitor(Infectado i) {
		inf = i;
	}

	@Override
	public void visitarInfectado(Infectado i) {
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		inf.atacar(j);
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		inf.recibirDanio(p.getDanio()); 
	}

	@Override
	public void visitarPremio(Premio p) {
		// TODO Auto-generated method stub
		
	}
}
