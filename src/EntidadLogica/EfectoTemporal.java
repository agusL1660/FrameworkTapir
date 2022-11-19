package EntidadLogica;

import Juego.Juego;

public abstract class EfectoTemporal extends EntidadPremio {
	protected int tiempo;
	
	
	public EfectoTemporal(Juego juego) {
		super(juego);
	}

	public int getTiempo() {
		return this.tiempo;
	}

}
