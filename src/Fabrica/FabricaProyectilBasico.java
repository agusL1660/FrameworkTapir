package Fabrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import EntidadLogica.ArmaBasica;
import EntidadLogica.EntidadProyectil;
import Juego.Juego;

public class FabricaProyectilBasico extends FabricaProyectil{
	protected int delay;
	protected Timer timer;
	
	public FabricaProyectilBasico(Juego j){
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
			p = new ArmaBasica(juego, x,y);
			delay = 5;
		}
		return p;
	}

}
