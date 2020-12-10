package niveles;

import java.util.Random;
import entidades.personajes.Infectado;
import fabricas.Fabrica;
import fabricas.FabricaAlpha;
import fabricas.FabricaBeta;
import juego.Juego;

public class Tanda {
	//Atributes
	/**Indica la cantidad de infectados de la tanda*/
	protected int cant;
	/**Arreglo donde se guardan los infectados de la tanda*/
	protected Infectado[] array;
	/**Representa al juego donde esta la tanda*/
	protected Juego game;
	/**Fabricas de infectados*/
	protected Fabrica[] fabricas;
	
	protected boolean tandaFinalizada;
	
	/**Crea una nueva tanda de infectados*/
	public Tanda(Juego g, int n) {
		game = g;
		cant = 0;
		tandaFinalizada = false;
		array = new Infectado[n];
		fabricas = new Fabrica[2];
		fabricas[0] = new FabricaAlpha(game);
		fabricas[1] = new FabricaBeta(game);
	}
	
	//Methods
	/**Inicializa las tandas
	 * */
	public void init() {
		int fabricaRnd;
		
		for (int i = 0; i < array.length; i++) { //Lleno la tanda con infectados
			Random aleatorio = new Random();
			fabricaRnd = aleatorio.nextInt(2);
			
			array[i] = fabricas[fabricaRnd].crearInfectado();//Creo infectados aleatorios (Alpha o Beta)
			cant++;
		}
	}
	
	/**Elimina los infectados muertos de la tanda*/
	public void delete() {
			
		for(int i = 0; i<array.length; i++) {
			if (array[i]!=null && !array[i].getActivo()) {//Si el infectado esta muerto
				array[i] = null;//Lo elimino del arreglo
				game.eliminarEntidad(array[i]);//Lo elimino del juego
				cant--;
			}
		}
		if(cant == 0) {
			tandaFinalizada = true;
		}
	}
	
	//Getters
	/**Devuleve si la tanda tiene o no infectados
	 * @return true si la tanda esta vacia
	 * */
	public boolean isEmpty() { 
		return cant == 0; 
	}
	
	/**Obtiene la cantidad de infectados de la tanda
	 * @return infectados de la tanda
	 * */
	public int getCant() { 
		return cant;
	}

	public boolean getTandaFinalizada() {
		return tandaFinalizada;
	}
	
	/**Retorna el arreglo de infectados de la tanda
	 * @return infectados de la tanda
	 * */
	public Infectado[] getArray() {	
		return array; 
	}
	
	//Setters
	/**Modifica el arreglo de infectados por el pasado por parametro
	 * @param a, arreglo de infectados a modificar
	 * */
	public void setArreglo(Infectado[] a) { 
		array = a;; 
	}
}