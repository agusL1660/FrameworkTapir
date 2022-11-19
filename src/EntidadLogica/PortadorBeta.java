package EntidadLogica;

import EntidadGrafica.*;
import Fabrica.FabricaProyectilBeta;
import Juego.*;
import Visitor.*;

public class PortadorBeta extends Enemigo {

	public PortadorBeta(Juego juego) {
		super(juego);
		visitor = new VisitorPortadorBeta(this);
		entidadGrafica = new EntidadGraficaPortadorBeta(this);
		velocidad = 3;
		proyectil = new FabricaProyectilBeta(juego);
		cargaViral = 75;
	}

	@Override
	public void aceptarVisitor(Visitor v) {
		v.visitarPortadorBeta(this);
	}

	@Override
	public EntidadProyectil getNuevoProyectil() {
		return new ProyectilBeta(juego,entidadGrafica.getPosicionX()+(entidadGrafica.getAncho()/2),entidadGrafica.getPosicionY()+entidadGrafica.getAltura());
	}
	

}
