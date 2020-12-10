package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
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
		// TODO Auto-generated method stub
	}

	/**
	 * Metodo que se encarga de la interaccion entre un infectado y un jugador
	 */
	public void visitarJugador(Jugador j) {
		j.recibirDanio(inf.getDanio()*2);
		inf.setActivo(false);
		j.getJuego().eliminarEntidad(inf);
	}

	@Override
	public void visitarProyectil(Proyectil p) {
		
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
