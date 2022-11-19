  
package Inteligencia;

import java.awt.event.KeyEvent;

import EntidadLogica.*;

public class InteligenciaProyectilInfectado extends Inteligencia{
	private ProyectilInfectado proyectil;
	
	public InteligenciaProyectilInfectado(ProyectilInfectado proyectil) {
		super(null);
		this.proyectil = proyectil;
	}
	
	public void accionar() {
		int y = proyectil.getEntidadGrafica().getPosicionY();
		int x = proyectil.getEntidadGrafica().getPosicionX();
        int alturaJuego = proyectil.getJuego().getAltura();
        int velocidad = proyectil.getVelocidad();
        int rango = proyectil.getRango();
        if(rango == 0){
        	proyectil.getJuego().EliminarEntidades(proyectil);
		}else{
			if(rango > velocidad){
				proyectil.setRangoActual(rango-velocidad);
				y = y + velocidad;
				proyectil.getEntidadGrafica().setPosicionY(y);
			}else{
				proyectil.setRangoActual(0);
				y = y + rango;
				proyectil.getEntidadGrafica().setPosicionY(y);
			}
			proyectil.getEntidadGrafica().getJLabel().setLocation(x, y);
		}
        if(y >= alturaJuego){
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