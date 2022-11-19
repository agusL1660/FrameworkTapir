package Fabrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import EntidadLogica.EntidadProyectil;
import EntidadLogica.SuperArma;
import Juego.Juego;

public class FabricaSuperProyectil extends FabricaProyectil{
	protected int delay;
	protected Timer timer;
	public FabricaSuperProyectil(Juego j){
		super(j);
		delay = 5;
		ActionListener accion = new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			delay--;
    		}
    	};
    	timer = new Timer(100, accion);
    	timer.start();
	}
	
	public EntidadProyectil devolverProyectil(int x, int y){
		EntidadProyectil p = null;
		if(delay <= 0){
			p = new SuperArma(juego, x,y);
			delay = 5;
		}
		return p;
	}

}
