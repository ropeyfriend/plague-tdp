package entidades.premios;

public class SuperArmaSanitaria extends EfectoTemporal {
	
	private double da�oExtra;
	private int duracion;
	
	public SuperArmaSanitaria(String path, int da�oExtra, int duracion) {
		super(path);
		this.da�oExtra = da�oExtra;
		this.duracion = duracion;
	}
	
	public double getDa�oExtra() {
		return da�oExtra;
	}
	
	public void setDa�oExtra(double d) {
		da�oExtra = d;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int d) {
		duracion = d;
	}

}