package EntidadLogica;

import EntidadGrafica.*;
import Visitor.*;
import Inteligencia.*;
import Juego.Juego;

public abstract class  Entidad {
	protected Visitor visitor;
	protected EntidadGrafica entidadGrafica;
	protected Inteligencia inteligencia;
	protected Juego juego;
	protected int velocidad;
	
	public Entidad(Juego juego){
		this.juego = juego;
	}
	
	public Visitor getVisitor() {
		return this.visitor;
	}
	
	public EntidadGrafica getEntidadGrafica() {
		return this.entidadGrafica;
	}
	
	public  Inteligencia getInteligencia() {
		return this.inteligencia;
	}
		
	public Juego getJuego() {
		return this.juego;
	}
	
	public int getVelocidad() {
		return this.velocidad;
	}
	
	public void desaparecer() {
		this.juego.getMapa().removerEntidad(this);
	}
	
	public void eliminar() {
		this.juego.getListaEntidades().remove(this);
	}
	
	public abstract void aceptarVisitor(Visitor v);
		
	public void setInteligencia(Inteligencia nuevaInteligencia) {
		this.inteligencia = nuevaInteligencia;
	}
	
	public void accionar() {
		inteligencia.accionar();
	}
}
