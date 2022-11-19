package EntidadLogica;

import EntidadGrafica.*;
import Juego.Juego;
import Visitor.*;

public class MejorarArma extends EfectoTemporal {

	public MejorarArma(Juego juego, int x) {
		super(juego);
		visitor = new VisitorMejorarArma(this);
		entidadGrafica = new EntidadGraficaMejorarArma(this, x);
		velocidad = 20;
		tiempo = 10000;
	}

	@Override
	public void aceptarVisitor(Visitor v) {
		v.visitarMejorarArma(this);
	}

}
