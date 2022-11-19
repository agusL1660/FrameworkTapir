package Fabrica;

import EntidadLogica.Enemigo;
import EntidadLogica.PortadorBeta;
import Juego.Juego;

public class FabricaPortadorBeta extends FabricaEnemigo {

	public FabricaPortadorBeta(Juego juego) {
		super(juego);
	}

	@Override
	public Enemigo devolverEnemigo() {
		return new PortadorBeta(juego);
	}

}
