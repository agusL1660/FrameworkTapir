package Inteligencia;

import java.awt.event.KeyListener;

import EntidadLogica.Entidad;

public abstract class Inteligencia implements KeyListener{
	protected Inteligencia inteligenciaAnterior;
	
	public Inteligencia(Inteligencia anterior) {
		inteligenciaAnterior = anterior;
	}
	
	public void accionar(){
		
	}
	
	public Inteligencia getInteligenciaAnterior() {
		return this;
	}
}
