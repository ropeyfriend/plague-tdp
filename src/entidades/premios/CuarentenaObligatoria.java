package entidades.premios;

import entidades.EntidadGrafica;
import entidades.personajes.Jugador;
import entidades.visitor.Visitor;
import juego.Juego;

public class CuarentenaObligatoria extends EfectoTemporal {
	/**Crea una nueva cuarentena obligatoria
	 * @param duracion, duracion dele efecto
	 * @param g, juego donde aplica el efecto
	 * */
	public CuarentenaObligatoria(int duracion, int x, int y) {
		super(duracion);
		ruta_dibujo_moviendose = "recursos/Premios/EfectosTemporales/efecto_cuarentena.gif";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x ,y);
	}

	@Override
	public void accept(Visitor v) {
		v.visitarPremio(this);	
	}
	
	public void startEffect(Jugador j) {
		/*game.obtenerListaEntidades
		 * for(Entidad e: lista){
		 * 	if(e es un infectado){
		 * 		activo el efecto(hago q se detenga por cierto tiempo)
		 * }
		 * }*/
	}
	

}