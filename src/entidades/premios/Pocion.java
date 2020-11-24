package entidades.premios;

public class Pocion extends ObjetoPrecioso {

	private int cantCuracion;
	
	public Pocion(String path) {
		super(path);
		cantCuracion = 25;
	}

	public int getCantCuracion() {
		return cantCuracion;
	}
	
	public void setCantCuracion(int cant) {
		cantCuracion = cant;
	}
}