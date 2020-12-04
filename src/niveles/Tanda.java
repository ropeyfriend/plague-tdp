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
	/**Tanda next*/
	protected Tanda next;
	
	/**Crea una nueva tanda de infectados*/
	public Tanda(Nivel nivel, int n) {
		level = nivel;
		cant = 0;
		array = new Infectado[n];
	}
	
	//Methods
	public void init(Fabrica[] fabricas, int j) {

		for (int i=0; i<array.length; i++) {
			array[i] = fabricas[j].crearInfectado(cant);
			cant++;
		}
		
		if (next!=null) {//Si hay tanda siguiente
			if (j+1<fabricas.length) {
				next.init(fabricas, j+1);
			}
			else {
				next.init(fabricas, j);
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
						array[i] = this.array[aux];
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
	public boolean isEmpty() { 
		return cant == 0; 
	}
	
	public int getCant() { 
		return cant;
	}
	
	public Tanda getNext() { 
		return next; 
	}
	
	public Infectado[] getArray() {	
		return array; 
	}
	
	//Setters
	public void setnext(Tanda next) {
		this.next = next; 
	}
	
	
	public void setarreglo(Infectado[] a) { 
		array = a;; 
	}
}