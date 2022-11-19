package EntidadLogica;

import EntidadGrafica.*;
import Fabrica.FabricaProyectilBasico;
import Inteligencia.*;
import Juego.Juego;
import Visitor.*;

public class PersonajePrincipal extends EntidadPersonaje{
	
	public PersonajePrincipal(Juego juego) {
		super(juego);
		inteligencia = new InteligenciaPersonajePrincipal(this);
		visitor = new VisitorPersonajePrincipal(this);
		entidadGrafica = new EntidadGraficaPersonajePrincipal(this);
		proyectil = new FabricaProyectilBasico(juego);
		velocidad = 3;
		cargaViral = 0;
	}

	@Override
	public void aceptarVisitor(Visitor v) {
		v.visitarPersonajePrincipal(this);
	}
	
	public void setInteligencia(Inteligencia inteligencia) {//no hace nada, para que al detener el tiempo pueda seguir moviendose

	}

	@Override
	public EntidadProyectil getNuevoProyectil() {
		return proyectil.devolverProyectil(entidadGrafica.getPosicionX()+entidadGrafica.getAncho()/2,entidadGrafica.getPosicionY());
	}
	
	
	public void morir(){
		juego.getMapa().mostrarSplash(juego.getSplashMuerte(), 5000,juego.getMapa().getX(),juego.getMapa().getY());
		juego.getMapa().salir();
	}
	
	public void disparar(){
		EntidadProyectil p = this.getNuevoProyectil();
		if(p != null){
			this.getJuego().agregarEntidad(p);
		}
	}
	
}
