package entidades.premios;

import java.util.Timer;
import java.util.TimerTask;

import entidades.EntidadGrafica;
import entidades.visitor.CuarentenaVisitor;
import entidades.personajes.Jugador;
import entidades.visitor.Visitor;
import juego.Juego;

public class CuarentenaObligatoria extends EfectoTemporal {
	/**Crea una nueva cuarentena obligatoria
	 * @param duracion, duracion dele efecto
	 * @param g, juego donde aplica el efecto
	 * */
	public CuarentenaObligatoria(Juego g, int duracion, int x, int y) {
		super(duracion,g);
		ruta_dibujo_moviendose = "src/recursos/Premios/EfectosTemporales/efecto_cuarentena.png";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x ,y);
		visitor = new CuarentenaVisitor(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitarCuarentena(this);	
	}
	
	public void startEffect() {
	}

	public void startEffect(Jugador j) {
		
	}

}