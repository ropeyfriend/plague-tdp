package niveles;

import juego.Juego;

public class Tanda1 extends Tanda {

	public Tanda1(Juego g, Nivel nivel, int n) {
		super(g, nivel, n);
		next = new Tanda2(g, nivel, n);

		init();
	}

}