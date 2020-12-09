package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.SuperArmaSanitaria;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;

public class ProyectilInfectadoVisitor extends Visitor{
	protected ProyectilInfectado p;
	
	public ProyectilInfectadoVisitor(ProyectilInfectado p) {
		this.p = p;
	}

	@Override
	public void visitarInfectado(Infectado i) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visitarJugador(Jugador j) {
		j.recibirDanio(p);
	}

	@Override
	public void visitarProyectil(Proyectil p) {
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

	@Override
	public void visitarCuarentena(CuarentenaObligatoria p) {
		// TODO Auto-generated method stub
		
	}

}
