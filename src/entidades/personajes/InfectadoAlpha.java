package entidades.personajes;

import java.util.Random;

import entidades.EntidadGrafica;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela a un infectado Alpha del juego*/

public class InfectadoAlpha extends Infectado{
	
	/**Crea un nuevo infectado Alpha*/
	public InfectadoAlpha(Juego g, int vel, int r, int x, int y){
		super(vel, r, g);
		danio = 20;
		//danio_a_recibir = 12.5F;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_ataque = "src/recursos/Infectados/InfectadoAlpha_ataque.gif";
		ruta_dibujo_moviendose = "src/recursos/Infectados/InfectadoAlpha_caminar.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x, y);
	}
	
	public InfectadoAlpha(int vel, int r, Juego g) {
		super(vel,r,g);
		danio = 20;
		visitor = new InfectadoVisitor(this);
		activo = true;
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose);
		ruta_dibujo_moviendose = "src/recursos/Infectados/InfectadoBeta_caminar.gif";
		ruta_dibujo_ataque = "src/recursos/Infectados/InfectadoBeta_ataque.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose);
	}
	
	//Methods
	public void recibirDanio(int danio_a_recibir){	//(Como le resto de a 12.5 entonces se muere en 8 golpes)
		if(cargaViral >= danio_a_recibir) {//Si la cargaViral es cero, no sigo desinfectandolo
			cargaViral -= danio_a_recibir;
			
			if(cargaViral == 0) {
				activo = false;
				//Lo tengo q eliminar del juego
			}
			
			if(cargaViral < 20 && cargaViral != 0) {//Si la cargaV es menor a 20 y esta infectado, duplican su velocidad
				velocidad = velocidad*2;
			}
		}
	}
	
	public void atacar() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
		//p.disparar(j);
	}
	
	public void accept(Visitor v){
		v.visitarInfectado(this);
	}

	
	public boolean fueraDelMapa(int y) {
		boolean toret = false;
		if (y < 0 || y + this.getEntidadGrafica().getLabel().getHeight() > game.getMapa().getHeight())
			toret = true;
		return toret;
	}

}
