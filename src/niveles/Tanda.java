package niveles;

import entidades.personajes.Infectado;
import fabricas.Fabrica;

public abstract class Tanda {
	//Atributes
	/**Representa el nivel del juego*/
	protected Nivel level;
	/**Indica la cantidad de infectados de la tanda*/
	protected int cant;
	/**Arreglo donde se guardan los infectados de la tanda*/
	protected Infectado[] array;
	/**Tanda siguiente*/
	protected Tanda next;
	
	/**Crea una nueva tanda de infectados*/
	public Tanda(Nivel nivel, int n) {
		level = nivel;
		cant = 0;
		array = new Infectado[n];
	}
	
	//Methods
	/**Inicializa las tandas
	 * @param fabricas, fabricas de infectados
	 * @param f, tipo de fabrica de infectados (fabrica Alpha o Beta)
	 * */
	public void init(Fabrica[] fabricas, int f) {

		for (int i=0; i<array.length; i++) { //Lleno la tanda con infectados
			array[i] = fabricas[f].crearInfectado();
			cant++;
		}
		
		if (next!=null) {//Si hay tanda siguiente
			if (f+1 < fabricas.length) {//Si estoy en la fabrica 0 (Alpha)
				next.init(fabricas, f+1);
			}
			else {
				next.init(fabricas, f);
			}
		}
	}
	
	/**Elimina los infectados muertos de la tanda*/
	public void delete() {
		for(int i = 0; i<array.length; i++) {
			if (array[i].getMuerto() == true) {
				array[i] = null;
				cant--;
			}
		}
		comprimir();
	}
	
	/**Comprime el arreglo de infectados de la tanda*/
	private void comprimir() {
		int i = 0;
		int aux=0;
		boolean termino=false;
		boolean found=false;
		
		for (i=0; i<this.array.length && !termino; i++) {
			if (array[i] == null) {
				aux = i+1;
				found = false;
				while (aux < this.array.length && !found) {
					if (array[aux] != null) {
						array[i] = array[aux];
						array[aux] = null;
						found = true;
					}
					aux++;
				}
				termino=!found;
			}
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
	
	/**Devuelve la tanda siguiente a la actual
	 * @return tanda siguiente
	 * */
	public Tanda getNext() { 
		return next; 
	}
	
	/**Retorna el arreglo de infectados de la tanda
	 * @return infectados de la tanda
	 * */
	public Infectado[] getArray() {	
		return array; 
	}
	
	//Setters
	/**Modifica la tanda siguiente por la pasada por parametro
	 * @param next, tanda siguiente
	 * */
	public void setNext(Tanda next) {
		this.next = next; 
	}
	
	/**Modifica el arreglo de infectados por el pasado por parametro
	 * @param a, arreglo de infectados a modificar
	 * */
	public void setArreglo(Infectado[] a) { 
		array = a;; 
	}
}