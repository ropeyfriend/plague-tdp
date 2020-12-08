package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entidades.EntidadGrafica;
import entidades.personajes.Jugador;

public class MovimientoJugadorListener implements KeyListener {
	Jugador jugador;
	public MovimientoJugadorListener(Jugador jugador) {
		this.jugador = jugador;
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("key pressed");
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && !fueraDelMapa(jugador.getEntidadGrafica().getX() + jugador.getVelocidad())) {
			System.out.println("key pressed RIGHT");
			jugador.mover(1);
		} else
			if(e.getKeyCode() == KeyEvent.VK_LEFT && !fueraDelMapa(jugador.getEntidadGrafica().getX() - jugador.getVelocidad())) {
				System.out.println("key pressed LEFT");
				jugador.mover(-1);
			}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		jugador.mover(0);
	}
	
	public boolean fueraDelMapa(int x) {
		boolean toret = false;
		if (x < 0 || x + jugador.getEntidadGrafica().getLabel().getWidth() > jugador.getJuego().getMapa().getWidth())
			toret = true;
		return toret;
	}
}