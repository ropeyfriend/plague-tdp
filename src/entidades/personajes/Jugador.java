package entidades.personajes;
import entidades.EntidadGrafica;
import entidades.proyectiles.*;
import entidades.visitor.*;

public class Jugador extends Personaje{
	
	//Atributes
	/*Arma para desinfectar a los infectados*/
	protected ProyectilJugador armaSanitaria;
	/*Indica si el jugador esta vivo o muerto*/
	protected boolean muerto;
	
	/**Crea un nuevo jugador
	 * @param p, proyectil del jugador
	 * @param vel, velocidad del jugador
	 * */
	public Jugador(ProyectilJugador p, int vel) {
		cargaViral = 0;
		velocidad = vel;
		armaSanitaria = p;
		muerto = false;
		visitor = new JugadorVisitor(this);
		entidadGrafica = new EntidadGrafica();
		/*ruta_dibujo_moviendose = "img/Jugador.gif";
		ruta_dibujo_ataque = "img/Jugador_ataque.gif";*/
	}

	//Methods
	/**Ataca al infectado pasado por parametro
	 * @param i, infectado a atacar
	 * */
	public void atacarInfectado(Infectado i) {
		armaSanitaria.desinfectar(i);
	}
	
	/**Suma la carga viral del jugador con la pasada por parametro. 
	 * @param danio, danio a sumar.
	 * */
	public void recibirDanio(int danio){
		if(cargaViral+danio < 100) {
			cargaViral += danio;
			
			if(cargaViral == 100) {
				muerto = true;
			}
		}
	}
	
	public void updateImagenAtaque() {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
	}
	
	public void updateImagenCaminar() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
	}
	
	public void accept(Visitor v){
		v.visitarJugador(this);
	}
	
	//Setters
	/*Modifica el valor de si el jugador esta muerto por el pasado por parametro
	 * @param m, indica si el jugador esta vivo o no.
	 * */
	public void setMuerto(boolean m) {
		muerto = m;
	}
	
	/**Modifica al arma sanitaria por la pasada por parametro
	 * @param a, arma sanitaria a modificar.
	 * */
	public void setArmaSanitaria(ProyectilJugador a) {
		armaSanitaria = a;
	}
	
	//Getters
	/**Retorna si el jugador esta vivo o muerto
	 * @return true si esta muerto
	 * */
	public boolean getMuerto() {
		return muerto;
	}
	
	/**Retorna el arma sanitaria del jugador
	 * @return arma sanitaria
	 * */
	public ProyectilJugador getArmaSanitaria() {
		return armaSanitaria;
	}
}
