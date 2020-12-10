package entidades.premios;

import entidades.EntidadGrafica;
import entidades.personajes.Jugador;
import entidades.visitor.CuarentenaVisitor;
import entidades.visitor.Visitor;
import juego.Juego;

public class CuarentenaObligatoria extends EfectoTemporal {
	/**Crea una nueva cuarentena obligatoria
	 * @param duracion, duracion dele efecto
	 * @param g, juego donde aplica el efecto
	 * */
	public CuarentenaObligatoria(Juego g, int duracion, int x, int y) {
		super(duracion,g);
		ruta_dibujo_moviendose = "/recursos/Premios/EfectosTemporales/efecto_cuarentena.png";
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose, x ,y);
		visitor = new CuarentenaVisitor(this);
	}

	@Override
	public void accept(Visitor v) {
		v.visitarCuarentena(this);	
	}
	

	@Override
	public void startEffect(Jugador j) {
		// TODO Auto-generated method stub
		
	}

}