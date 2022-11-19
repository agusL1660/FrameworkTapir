package Inteligencia;

import java.awt.event.KeyEvent;
import java.util.Random;

import EntidadLogica.Enemigo;
import EntidadLogica.Entidad;

public class InteligenciaEnemigos extends Inteligencia {
	private Enemigo enemigo;
	private int delay;
	
	public InteligenciaEnemigos(Enemigo enemigo) {
		super(null);
		this.enemigo = enemigo;
		Random rnd = new Random();
		delay = rnd.nextInt(40)+20;
	}
	
	public void accionar(){
		Random rnd = new Random();
		if(delay == 0){
			enemigo.disparar();
			delay = rnd.nextInt(40)+20;
		}else{
			delay--;
		}
		enemigo.controlarCargaViral();
        int y = enemigo.getEntidadGrafica().getPosicionY();
        int alturaEntidad = enemigo.getEntidadGrafica().getAltura();
        int alturaJuego = enemigo.getJuego().getAltura();
        int velocidad = enemigo.getVelocidad();
        //si supera la altura del juego, arranca en la parte superior en -alturaEntidad
        y = y + velocidad <= alturaJuego ? y + velocidad : -alturaEntidad;
        int x = enemigo.getEntidadGrafica().getPosicionX();
        enemigo.getEntidadGrafica().getJLabel().setLocation(x, y);
        enemigo.getEntidadGrafica().setPosicionY(y);
    }

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
