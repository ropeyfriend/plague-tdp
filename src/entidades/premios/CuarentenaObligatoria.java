package entidades.premios;

import java.util.Timer;
import java.util.TimerTask;

import entidades.EntidadGrafica;
import entidades.visitor.Visitor;
import juego.Juego;

public class CuarentenaObligatoria extends EfectoTemporal {
	/**Crea una nueva cuarentena obligatoria
	 * @param duracion, duracion dele efecto
	 * @param g, juego donde aplica el efecto
	 * */
	public CuarentenaObligatoria(int duracion,Juego g, int x, int y) {
		super(duracion,g);
		ruta_dibujo_moviendose = "recursos/Premios/EfectosTemporales/efecto_cuarentena.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x ,y);
	}

	@Override
	public void accept(Visitor v) {
		v.visitarCuarentena(this);	
	}
	
	public void startEffect() {
		/*game.obtenerListaEntidades
		 * for(Entidad e: lista){
		 * 	if(e es un infectado){
		 * 		activo el efecto(hago q se detenga por cierto tiempo)
		 * }
		 * }*/
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