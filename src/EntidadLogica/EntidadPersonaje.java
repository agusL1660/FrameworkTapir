package EntidadLogica;

import Fabrica.FabricaProyectil;
import Juego.*;

public abstract class EntidadPersonaje extends Entidad {
	protected int cargaViral;
	protected FabricaProyectil proyectil;
	
	public EntidadPersonaje(Juego juego) {
		super(juego);
	}
	
	public int getCargaViral() {
		return this.cargaViral;
	}
	
	public void setCargaViral(int cv) {
		this.cargaViral = cv;
	}
	
	public FabricaProyectil getProyectil() {
		return this.proyectil;
	}
	
	public void setProyectil(FabricaProyectil ps) {
		this.proyectil = ps;
	}
	public boolean estaVivo() {
		return cargaViral != 0;
	}
	
	public void disparar(){
		this.getJuego().agregarEntidad(this.getNuevoProyectil());
	}
	
	public void morir(){
		
	}
	
	public abstract EntidadProyectil getNuevoProyectil();
	
}
