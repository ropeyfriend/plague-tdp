package entidades.personajes;
import entidades.EntidadGrafica;
import entidades.proyectiles.*;
import entidades.visitor.*;

public class Jugador extends Personaje{
	
	public Jugador(int x, int y) {
		ruta_dibujo_moviendose = "src/recursos/Jugador/JugadorCaminandoDerecha.gif"; //*** HAY Q FIJARSE SI VA PARA LA DERECHA O IZQUIERDA ***
		ruta_dibujo_ataque = "src/recursos/Jugador/JugadorQuieto.png";
		cargaViral = 0;
		velocidad = 10;
		danio = 15;
		muerto = false;
		visitor = new JugadorVisitor(this);
		entidadGrafica = new EntidadGrafica(ruta_dibujo_ataque, x, y);
	}

	//Methods
	/**Ataca al infectado pasado por parametro
	 * @param i, infectado a atacar
	 * */
	public void atacar(Infectado i) {
		entidadGrafica.updateImagen(ruta_dibujo_ataque);
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
		//armaSanitaria.efectoSuper(cant);
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

	/**
	 * Alterna entre el dibujo ataque y dibujo moviendose
	 */
	public void cambiarDibujo() {
		if(ruta_dibujo_moviendose.equals(entidadGrafica.getRuta()))
			entidadGrafica.updateImagen(ruta_dibujo_ataque);
		else
			entidadGrafica.updateImagen(ruta_dibujo_moviendose);

	}
	
	public void accept(Visitor v){
		v.visitarJugador(this);
	}

}
