package Fabrica;

import EntidadLogica.EntidadProyectil;
import EntidadLogica.ProyectilBeta;
import Juego.Juego;

public class FabricaProyectilBeta extends FabricaProyectil{

	public FabricaProyectilBeta(Juego j){
		super(j);
	}
	public EntidadProyectil devolverProyectil(int x, int y){
		return new ProyectilBeta(juego, x,y);
	}

}

