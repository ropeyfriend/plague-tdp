package niveles;

import fabricas.Fabrica;
import juego.Juego;


public abstract class Nivel {
	//Atributos
	/**Representa la tanda del nivel*/
	protected Tanda tanda;
	/**Representa al game donde esta la tanda*/
	protected Juego game;
	/**Representa al nivel siguiente*/
	protected Nivel siguiente;
	/**Fabricas de infectados*/
	protected Fabrica[] fabricas;
	
	/**Crea un nuevo nivel*/
	public Nivel(Juego g) {
		game = g;
	}
	
	//Methods
	/**Elimina los infectados muertos de la tanda, si todos los de la primer tanda murieron entonces pasa a la tanda siguiente*/
	public void delete() {
		
		tanda.delete();//elimina los infectados que estan muertos
		
		if (getTanda()!=null && getTanda().isEmpty()) {//Si todos los infectados de la tanda fueron eliminados
			tanda = tanda.getNext();
			if (tanda != null) {
				game.agregarArreglo(tanda.getArray());
			}
		}
	}
	
	//Getters
	public Tanda getTanda() { 
		return this.tanda;
	}
	
	public Nivel getsiguiente() { 
		return siguiente;
	}
	
	//Setters
	public Fabrica[] getfabricas() { 
		return fabricas;
	}
	
	public void setfabricas(Fabrica[] f) {
		fabricas = f; 
	}

	public void setTanda(Tanda t) {
		tanda = t;
	}
}
