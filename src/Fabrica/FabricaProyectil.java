package Fabrica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import EntidadLogica.EntidadProyectil;
import Juego.Juego;

public abstract class FabricaProyectil {
	protected Juego juego;
	
	public FabricaProyectil(Juego j){
		juego = j;
	}
	
	public abstract EntidadProyectil devolverProyectil(int x, int y);
}
