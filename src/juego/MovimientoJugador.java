package juego;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entidades.EntidadGrafica;

public abstract class MovimientoJugador extends Movimiento implements KeyListener {
	
	public MovimientoJugador(EntidadGrafica jugador) {
		super(jugador);
	}

	public void keyPressed(KeyEvent e) {
		EntidadGrafica grafico = this.getJugador();
		
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			grafico.setX(grafico.getX() + 2);
		} else
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				grafico.setX(grafico.getX() - 2);
			}
	}
}