package Fabrica;

import EntidadLogica.Enemigo;
import EntidadLogica.PortadorAlpha;
import Juego.Juego;

public class FabricaPortadorAlpha extends FabricaEnemigo {

	public FabricaPortadorAlpha(Juego juego) {
		super(juego);
	}

	@Override
	public Enemigo devolverEnemigo() {
		return new PortadorAlpha(juego);
	}

}
