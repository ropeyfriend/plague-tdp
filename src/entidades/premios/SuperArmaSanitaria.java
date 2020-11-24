package entidades.premios;

public class SuperArmaSanitaria extends EfectoTemporal {
	
	private double dañoExtra;
	private int duracion;
	
	public SuperArmaSanitaria(String path, int dañoExtra, int duracion) {
		super(path);
		this.dañoExtra = dañoExtra;
		this.duracion = duracion;
	}
	
	public double getDañoExtra() {
		return dañoExtra;
	}
	
	public void setDañoExtra(double d) {
		dañoExtra = d;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int d) {
		duracion = d;
	}

}