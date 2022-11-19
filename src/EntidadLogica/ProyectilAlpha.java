package EntidadLogica;

import EntidadGrafica.*;
import Inteligencia.*;
import Juego.*;
import Visitor.*;

public class ProyectilAlpha extends ProyectilInfectado {
	
	public ProyectilAlpha(Juego juego, int x, int y){
		super(juego);
		visitor = new VisitorProyectilAlpha(this);
		entidadGrafica = new EntidadGraficaProyectilAlpha(this,x,y);
		velocidad = 5;
		danio = 10;
	}
	
	@Override
	public void aceptarVisitor(Visitor v) {
		v.visitarProyectilAlpha(this);
	}

}
