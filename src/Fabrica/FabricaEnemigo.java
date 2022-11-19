package Fabrica;

import EntidadLogica.Enemigo;
import Juego.Juego;

public abstract class FabricaEnemigo {
	protected Juego juego;
	
	public FabricaEnemigo(Juego juego){
		this.juego = juego;
	}
	
	public abstract Enemigo devolverEnemigo();
	
}
