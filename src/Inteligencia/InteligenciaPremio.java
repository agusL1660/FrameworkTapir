package Inteligencia;

import java.awt.event.KeyEvent;

import EntidadLogica.Entidad;
import EntidadLogica.EntidadPremio;

public class InteligenciaPremio extends Inteligencia{
	private EntidadPremio premio;
	
	public InteligenciaPremio(EntidadPremio premio) {
		super(null);
		this.premio = premio;
	}

	public void accionar() {
		int y = premio.getEntidadGrafica().getPosicionY();
		int x = premio.getEntidadGrafica().getPosicionX();
        int alturaJuego = premio.getJuego().getAltura();
        int velocidad = premio.getVelocidad();
        if(y + velocidad >= alturaJuego){
        	premio.getJuego().EliminarEntidades(premio);
        }
        else{
        	y = y + velocidad;
        	premio.getEntidadGrafica().setPosicionY(y);
        	premio.getEntidadGrafica().getJLabel().setLocation(x, y);
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
