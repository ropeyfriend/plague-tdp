package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.Premio;
import entidades.proyectiles.Proyectil;

/**Clase que modela al visitor de un infectado*/

public class InfectadoVisitor extends Visitor{
	/**Representa a un infectado*/
	private Infectado inf;

	public InfectadoVisitor(Infectado i) {
		inf = i;
	}

	@Override
	public void visitarInfectado(Infectado i) {
		
	}

	@Override
	public void visitarJugador(Jugador j) {
		inf.updateImagenAtaque();
		inf.atacar(j);
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		inf.recibirDanio(); 
	}

	@Override
	public void visitarPremio(Premio p) {
		// TODO Auto-generated method stub
		
	}
}
