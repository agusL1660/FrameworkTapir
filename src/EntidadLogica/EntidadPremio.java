package EntidadLogica;

import Inteligencia.*;
import Juego.Juego;

public abstract class EntidadPremio extends Entidad {

	public EntidadPremio(Juego juego) {
		super(juego);
		inteligencia = new InteligenciaPremio(this);
	}
	
	public void setInteligencia(Inteligencia inteligencia) {//no hace nada, para que al detener el tiempo pueda seguir moviendose

	}
	
}
