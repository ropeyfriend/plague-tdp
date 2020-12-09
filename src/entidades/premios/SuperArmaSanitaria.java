package entidades.premios;

import java.util.Timer;
import java.util.TimerTask;

import entidades.EntidadGrafica;
import entidades.personajes.Jugador;
import entidades.visitor.SuperArmaVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

/**Clase que modela a un super arma sanitaria*/

public class SuperArmaSanitaria extends EfectoTemporal {
	
	/**Danio extra del arma sanitaria*/
	private int danioExtra;
	
	/**Crea una super arma sanitaria nueva*/
	public SuperArmaSanitaria(int danioExtra, int duracion, Juego g, int x, int y) {
		super(duracion,g);
		this.danioExtra = danioExtra;
		ruta_dibujo_moviendose = "recursos/Premios/EfectosTemporales/efecto_super.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose,x , y);
		visitor = new SuperArmaVisitor(this);
	}
	
	//Methods
	@Override
	public void accept(Visitor v) {
		v.visitarSuperArma(this);	
	}
	
	
	/**Activa el efecto de super arma sanitaria al jugador
	 * @param j, jugador
	 * */
	public void startEffect(Jugador j) {
		j.efectoSuper(danioExtra);
	}
	
	//Getter
	/**Obtiene el valor del danio extra
	 * @return danio extra del arma
	 * */
	public double getDanioExtra() {
		return danioExtra;
	}
	
	//Setter
	/**Modidica el valor del danio extra por el pasado por parametro
	 * @param d, danio extra a modificar
	 * */
	public void setDanioExtra(int d) {
		danioExtra = d;
	}

	@Override
	public void jugar() {
		Premio actual = this;
		int posInicial = entidadGrafica.getY();
		entidadGrafica.setY(posInicial + velocidad);

		if(entidadGrafica.getY()>786) {//Si se pasa del mapa
			Timer timer = new Timer();
			TimerTask tarea = new TimerTask() {
				@Override
				public void run() {
					game.getMapa().eliminarEntidad(actual);
				}	
			};
			timer.schedule(tarea,10000);
		}
}

}