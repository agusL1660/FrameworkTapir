package EntidadLogica;

import Inteligencia.*;
import Juego.Juego;

public abstract class ProyectilInfectado extends EntidadProyectil{
	
	protected int rango;
	
	public ProyectilInfectado(Juego juego) {
		super(juego);
		rango = 200;
		inteligencia = new InteligenciaProyectilInfectado(this);
	}
	
	public int getRango(){
		return rango;
	}
	
	public void setRangoActual(int rangoNuevo){
		rango = rangoNuevo;
	}
	
	public void daniar(EntidadPersonaje ep) {
		int nuevaCargaViral = (ep.getCargaViral() + this.getDanio());
		if (nuevaCargaViral >= 100) {
			ep.setCargaViral(100);
			ep.morir();
		}
		else {
			ep.setCargaViral(nuevaCargaViral);
		}
	}
	
}
