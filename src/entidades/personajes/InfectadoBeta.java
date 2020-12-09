package entidades.personajes;

import entidades.EntidadGrafica;
import entidades.visitor.InfectadoVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela a un infectado Beta del juego*/

public class InfectadoBeta extends Infectado{
	
	/**Crea un nuevo infectado Beta*/
	public InfectadoBeta(Juego g, int vel, int r, int x, int y) {
		super(vel, r,g);
		danio = 10;//Danio q le hace al jugador
		//danio_a_recibir = 10;
		activo = true;
		visitor = new InfectadoVisitor(this);
		ruta_dibujo_moviendose = "src/recursos/Infectados/InfectadoBeta_caminar.gif";
		ruta_dibujo_ataque = "src/recursos/Infectados/InfectadoBeta_ataque.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x, y);
	}
	
	public InfectadoBeta(int vel, int r, Juego g) {
		super(vel,r,g);
		danio = 10;
		visitor = new InfectadoVisitor(this);
		activo = true;
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose);
		ruta_dibujo_moviendose = "src/recursos/Infectados/InfectadoBeta_caminar.gif";
		ruta_dibujo_ataque = "src/recursos/Infectados/InfectadoBeta_ataque.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose);
	}
	
	//Methods
	public void recibirDanio(int danio_a_recibir) {//(Como le resto de a 10 entonces se muere en 10 golpes)
		if(cargaViral - danio_a_recibir>= 10) { //Si la cargaViral es cero, no sigo desinfectandolo
			cargaViral -= danio_a_recibir;
			
			if(cargaViral == 0) {
				activo = false;
				//Lo tengo q eliminar del juego
			}
		}
	}
	
	public void accept(Visitor v){
		v.visitarInfectado(this);
	}

	@Override
	public void atacar() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);	
	}
	
}
