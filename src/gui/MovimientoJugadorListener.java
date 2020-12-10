package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entidades.personajes.Jugador;

/**
 * Listener movimiento del jugador
 * @author nicob
 *
 */
public class MovimientoJugadorListener implements KeyListener {
	/**
	 * El jugador
	 */
	Jugador jugador;

	/**
	 * Crea un nuevo movimientoJugadorListener
	 * @param jugador El jugador al que se atribuye el movimiento
	 */
	public MovimientoJugadorListener(Jugador jugador) {
		this.jugador = jugador;
	}
	
	/**
	 * Dada una tecla presionada, reacciona generando movimiento y el disparo
	 */
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT
				&& !fueraDelMapa(jugador.getEntidadGrafica().getX() + jugador.getVelocidad())) {
			jugador.mover(1);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT
				&& !fueraDelMapa(jugador.getEntidadGrafica().getX() - jugador.getVelocidad())) {
			jugador.mover(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jugador.disparar();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		jugador.mover(0);
	}
	
	/**
	 * Dado un valor x evuelve true si el jugador se encuentra fuera del mapa
	 * @param x El valor x
	 * @return true si se encuentra fuera del mapa
	 */
	public boolean fueraDelMapa(int x) {
		boolean toret = false;
		if (x < 0 || x + jugador.getEntidadGrafica().getLabel().getWidth() > jugador.getJuego().getMapa().getWidth())
			toret = true;
		return toret;
	}
}