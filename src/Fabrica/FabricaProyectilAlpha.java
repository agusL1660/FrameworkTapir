package Fabrica;

import EntidadLogica.EntidadProyectil;
import EntidadLogica.ProyectilAlpha;
import Juego.Juego;

public class FabricaProyectilAlpha extends FabricaProyectil{

	public FabricaProyectilAlpha(Juego j){
		super(j);
	}
	public EntidadProyectil devolverProyectil(int x, int y){
		return new ProyectilAlpha(juego, x,y);
	}

}