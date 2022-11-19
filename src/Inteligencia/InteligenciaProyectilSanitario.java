package Inteligencia;

import java.awt.event.KeyEvent;

import EntidadLogica.*;

public class InteligenciaProyectilSanitario extends Inteligencia{
	private ProyectilSanitario proyectil;
	
	public InteligenciaProyectilSanitario(ProyectilSanitario proyectil) {
		super(null);
		this.proyectil = proyectil;
	}
	
	public void accionar() {
        int y = proyectil.getEntidadGrafica().getPosicionY();
        int x = proyectil.getEntidadGrafica().getPosicionX();
        int velocidad = proyectil.getVelocidad();
        if (y>=0) {//si esta en el mapa
            y = y - velocidad;
            proyectil.getEntidadGrafica().getJLabel().setLocation(x, y);
            proyectil.getEntidadGrafica().setPosicionY(y);
        }
        else {//se fue del mapa
        	proyectil.getJuego().EliminarEntidades(proyectil);
        }
    }

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}