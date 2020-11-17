package entidades.premios;

public class CuarentenaObligatoria extends EfectoTemporal {
	
	private int duracion; // tiempo

	public CuarentenaObligatoria(String path, int duracion) {
		super(path);
		this.duracion = duracion;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

}