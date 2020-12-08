package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entidades.EntidadGrafica;

public class MovimientoJugador implements KeyListener {
	EntidadGrafica jugadorGrafico;
	public MovimientoJugador(EntidadGrafica jugadorGrafico) {
		this.jugadorGrafico = jugadorGrafico;
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed");
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			jugadorGrafico.setX(jugadorGrafico.getX() + 2);
		} else
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				jugadorGrafico.setX(jugadorGrafico.getX() - 2);
			}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}