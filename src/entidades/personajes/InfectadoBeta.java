package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.proyectiles.Proyectil;
import entidades.proyectiles.ProyectilInfectado;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela a un infectado Beta del juego*/

public class InfectadoBeta extends Infectado{
	
	/**Crea un nuevo infectado Beta*/
	public InfectadoBeta(Juego g, int vel, int r, int x, int y) {
		super(vel, r,g);
		danio = 10; //Danio q le hace al jugador
		//danio_a_recibir = 10;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_moviendose = "src/recursos/Infectados/InfectadoBeta_caminar.gif";
		ruta_dibujo_ataque = "src/recursos/Infectados/InfectadoBeta_ataque.gif";
		ruta_dibujo_hit = "src/recursos/Infectados/InfectadoBeta_hit.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x, y);
	}
	
	//Methods
	public void recibirDanio(Proyectil p) {//(Como le resto de a 10 entonces se muere en 10 golpes)
		entidadGrafica.updateImagen(ruta_dibujo_hit);
		cargaViral -= p.getDanio();
		game.eliminarEntidad(p);
		if(cargaViral <= 0) {
			activo = false;
			morir();
		}
	}
	
	public void accept(Visitor v){
		v.visitarInfectado(this);
	}

	@Override
	public void disparar() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
		int x = this.entidadGrafica.getX() + 8;
		Proyectil disparo = new ProyectilInfectado(game, x, this.getEntidadGrafica().getY(), danio);
		game.agregarEntidad(disparo);
	}
	
}
