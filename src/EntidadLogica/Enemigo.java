package EntidadLogica;

import java.util.Random;

import Inteligencia.*;
import Juego.Juego;

public abstract class Enemigo extends EntidadPersonaje {

	public Enemigo(Juego juego) {
		super(juego);
		inteligencia = new InteligenciaEnemigos(this);
	}
	
	public void setInteligenciaPropia() {
		inteligencia = new InteligenciaEnemigos(this);
	}
	
	public void morir() {
		this.juego.EliminarEntidades(this);
		Random rnd = new Random();
		int crearPremio = rnd.nextInt(5)+1;//entre 1 y 5
		if (crearPremio == 1) {
			juego.crearPremio(entidadGrafica.getPosicionX());
		}
	}
	
	public EntidadProyectil getNuevoProyectil() {
		return proyectil.devolverProyectil(entidadGrafica.getPosicionX()+(entidadGrafica.getAncho()/2),entidadGrafica.getPosicionY()+entidadGrafica.getAltura());
	}	
	
	public void controlarCargaViral(){
		
	}
}
