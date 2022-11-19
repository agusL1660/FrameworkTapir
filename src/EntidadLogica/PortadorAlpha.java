package EntidadLogica;

import EntidadGrafica.*;
import Fabrica.FabricaProyectilAlpha;
import Juego.*;
import Visitor.*;

public class PortadorAlpha extends Enemigo{
	private boolean actualizoVelocidad;
	public PortadorAlpha(Juego juego){
		super(juego);
		visitor = new VisitorPortadorAlpha(this);
		entidadGrafica = new EntidadGraficaPortadorAlpha(this);
		velocidad = 3;
		proyectil = new FabricaProyectilAlpha(juego);
		cargaViral = 100;
		actualizoVelocidad = false;
	}
	
	@Override
	public void aceptarVisitor(Visitor v) {
		v.visitarPortadorAlpha(this);
	}
	
	public void controlarCargaViral(){
		if(!actualizoVelocidad && cargaViral < 20){
			velocidad = velocidad*2;
			actualizoVelocidad = true;
		}
	}
}
