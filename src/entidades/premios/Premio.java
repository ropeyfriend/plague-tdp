package entidades.premios;

import entidades.Entidad;
import entidades.movimiento.EstrategiaMovimiento;
import entidades.personajes.Jugador;
import juego.Juego;

/**Clase que modela a un premio del juego*/

public abstract class Premio extends Entidad{
	
	protected EstrategiaMovimiento mv;
	
	/**Crea un nuevo premio*/
	public Premio(Juego g) {
		game = g;
	}
	
	public void mover() {
		this.mv.mover();
	}
	
	public void jugar() {
		if (!fueraDelMapa(this.entidadGrafica.getY()))
			this.mv.mover();
		else
			game.eliminarEntidad(this);
	}
	
	public void setDireccion(int i) {
		if (i == 1 || i == -1)
			this.mv.setDireccion(i);
	}
	
	public boolean fueraDelMapa(int y) {
		boolean toret = false;
		if (y < 0 || y + this.getEntidadGrafica().getLabel().getHeight() > game.getMapa().getHeight())
			toret = true;
		return toret;
	}
    
	/**Activa el efecto del premio
	 * @param j, jugador donde aplica el efecto
	 * */
	public abstract void startEffect(Jugador j);
}
