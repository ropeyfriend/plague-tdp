package niveles;

public class Tanda1 extends Tanda {

	public Tanda1(Nivel nivel, int n) {
		super(nivel,n);
		next = new Tanda2(nivel,n);
		
		init(nivel.getfabricas(),0);
	}
	//Metodos
}