package EntidadLogica;

import Juego.Juego;

public abstract class EntidadProyectil extends Entidad {
	protected int danio;
	
	public EntidadProyectil(Juego juego) {
		super(juego);
	}

	public int getDanio() {
		return danio;
	}
	
	public abstract void daniar(EntidadPersonaje ep);
	
	public void setDanio(int d){
		danio = d;
	}
}
