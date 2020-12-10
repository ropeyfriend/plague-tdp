package niveles;

import juego.Juego;

public class Nivel {
	/**Entero que representa el nivel actual*/
	protected int nivel;
	/**Cantidad de niveles que puede haber*/
	protected int cantNiveles;
	/**Canridad de infectados del nivel*/
	protected int cantInfectados;
	/**Juego del nivel*/
	protected Juego game;
	/**Arreglo de tandas del nivel*/
	protected Tanda[] tandas;
	/**Entero que representa la tanda actual del nivel*/
	protected int tandaActual;
	/**Cantidad de tandas del nivel*/
	protected int cantTandas;
	
	/**Crea un nuevo nivel
	 * @param t, cantidad de tandas del nivel
	 * @param cantN, cantidad de niveles
	 * */
	public Nivel(int t, int cantN) {
		nivel = 1;
		cantNiveles = cantN;//Van a ser 2
		cantTandas = t;
		tandaActual = 1;
		tandas = new Tanda[t];
		tandas[0] = new Tanda(game, cantInfectados/2);
		tandas[1] = new Tanda(game, cantInfectados/2);
		initTanda();//Inicializo la primer tanda
	}
	
	//Methods
	/*Sube hacia la siguiente tanda**/
	public void subirTanda() {
		
		if(tandas[tandaActual].getTandaFinalizada()) {//Si la tanda actual fue eliminada

			if(tandaActual < cantTandas){//Si no estoy en la ultima tanda
				tandaActual++;
				initTanda();
			}
			else {
				subirNivel();
			}
		}
	}
	
	/**Sube hacia el siguiente nivel*/
	public void subirNivel() {
		if(this.nivel < cantNiveles && (tandas[0].getTandaFinalizada() && tandas[1].getTandaFinalizada()) ) {//Si no estoy en el ultimo nivel y elimine las dos tandas
			nivel++;
			tandaActual = 1;
			initTanda();	
		}
	}
	
	/**Inicializa la tanda actual*/
	public void initTanda() {
		tandas[tandaActual].init();
	}
	
	//Getters
	public int getNivel() {
		return nivel;
	}
	
	public Tanda getTandaActual() {
		return tandas[tandaActual];
	}
	
	//Setters


}