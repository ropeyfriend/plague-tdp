package entidades.personajes;
import entidades.EntidadGrafica;
import entidades.proyectiles.*;
import entidades.visitor.*;

public class Jugador extends Personaje{
	
	//Atributes
	/*Arma para desinfectar a los infectados*/
	protected ProyectilJugador armaSanitaria;
	
	/**Crea un nuevo jugador
	 * @param p, proyectil del jugador
	 * @param vel, velocidad del jugador
	 * */
	public Jugador(ProyectilJugador p, int vel) {
		ruta_dibujo_moviendose = "recursos/Jugador/JugadorCaminandoDerecha.gif"; //*** HAY Q FIJARSE SI VA PARA LA DERECHA O IZQUIERDA ***
		ruta_dibujo_ataque = "recursos/Jugador/JugadorQuieto.png";
		cargaViral = 0;
		velocidad = vel;
		danio = 15;
		armaSanitaria = p;
		muerto = false;
		visitor = new JugadorVisitor(this);
		entidadGrafica = new EntidadGrafica(ruta_dibujo_moviendose);
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
				//Lo tengo q eliminar del juego
				muerto = true;
			}
		}
	}
	
	/**Le otorga mayor capacidad de desinfeccion al arma del jugador
	 * @param valor a multiplicar a la capacidad de desinfeccion.
	 * */
	public void efectoSuper(int cant) {
		armaSanitaria.efectoSuper(cant);
	}
	
	/**Cura al jugador restando el valor pasado por parametro a la carga viral
	 * @param vida, valor a restar a la carga viral
	 * */
	public void curar(int vida) {
		if(cargaViral != 100) {//Si no esta muerto
			if(cargaViral - vida >= 0) {
				cargaViral -= vida;
			}
			else {
				cargaViral = 0;
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
	/**Modifica al arma sanitaria por la pasada por parametro
	 * @param a, arma sanitaria a modificar.
	 * */
	public void setArmaSanitaria(ProyectilJugador a) {
		armaSanitaria = a;
	}
	
	//Getters
	/**Retorna el arma sanitaria del jugador
	 * @return arma sanitaria
	 * */
	public ProyectilJugador getArmaSanitaria() {
		return armaSanitaria;
	}
}
