package entidades.premios;

import entidades.EntidadGrafica;
import entidades.visitor.Visitor;

public class CuarentenaObligatoria extends EfectoTemporal {
	
	public CuarentenaObligatoria(int duracion) {
		super(duracion);
		entidadGrafica = new EntidadGrafica();
		ruta_dibujo_moviendose = "recursos/Premios/EfectosTemporales/efecto_cuarentena.gif";
	}
	
	//Getter
	public int getDuracion() {
		return duracion;
	}
	
	//Setter
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public void accept(Visitor v) {
		v.visitarPremio(this);	
	}
	
	public void updateImagen() {
		entidadGrafica.updateImagen(ruta_dibujo_moviendose);
	}
	
	public void startEffect() {}
	

}