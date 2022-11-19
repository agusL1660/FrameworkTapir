package EntidadLogica;

import EntidadGrafica.*;
import Juego.*;
import Visitor.*;

public class Pocion extends ObjetoPrecioso {

	public Pocion(Juego juego, int x) {
		super(juego);
		visitor = new VisitorPocion(this);
		entidadGrafica = new EntidadGraficaPocion(this, x);
		velocidad = 15;
	}

	@Override
	public void aceptarVisitor(Visitor v) {
		v.visitarPocion(this);
	}

}
