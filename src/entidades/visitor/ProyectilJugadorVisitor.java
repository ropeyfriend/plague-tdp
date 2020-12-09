package entidades.visitor;

import entidades.personajes.Infectado;
import entidades.personajes.Jugador;
import entidades.premios.CuarentenaObligatoria;
import entidades.premios.Pocion;
import entidades.premios.SuperArmaSanitaria;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilJugador;

public class ProyectilJugadorVisitor extends Visitor{
	protected ProyectilJugador p;
	
	public ProyectilJugadorVisitor(ProyectilJugador p) {
		this.p = p;
	}

	@Override
	public void visitarInfectado(Infectado i) {
		i.recibirDanio(p);
	}

	@Override
	public void visitarJugador(Jugador j) {
		// TODO Auto-generated method stub
		
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
