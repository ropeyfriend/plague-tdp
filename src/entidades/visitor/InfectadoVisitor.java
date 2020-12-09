package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.Premio;
import entidades.premios.SuperArmaSanitaria;
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
		//se modela desde el lado del jugador
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		inf.recibirDanio(p.getDanio()); 
	}

	@Override
	public void visitarCuarentena(CuarentenaObligatoria p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarPocion(Pocion p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitarSuperArma(SuperArmaSanitaria p) {
		// TODO Auto-generated method stub
		
	}
}
