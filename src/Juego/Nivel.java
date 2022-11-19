package Juego;
import Fabrica.*;

import java.util.LinkedList;
import java.util.List;

import EntidadLogica.Entidad;


public abstract class Nivel {
	
	protected List<FabricaEnemigo> listaFabricas;
	protected List<Entidad> listaEntidades;
	protected int[] cantidad;
	protected Nivel siguiente;
	protected Juego juego;
	protected int oleadaActual, cantOleadas;
	protected String mapa;
	protected int numero;
	protected String Splash;
	
	public Nivel(Juego juego){
		this.juego = juego;
		listaEntidades = new LinkedList<Entidad>();
		listaFabricas = new LinkedList<FabricaEnemigo>();
		oleadaActual = 0;
	}
	
	public List<Entidad> getListaEntidades() {
		return listaEntidades;
	}
	
	public Nivel getNivelSiguiente() {
		return siguiente;
	}
	
	public void cargarEnemigos(){
		FabricaEnemigo fabricaActual;
		oleadaActual++;
		for(int i = 0; i < cantidad.length; i++){
			fabricaActual = listaFabricas.get(i);
			for(int j = 0; j < cantidad[i]; j++){
				Entidad e = fabricaActual.devolverEnemigo();
				juego.agregarEntidad(e);
				listaEntidades.add(e);
			}
		}
	}
	
	public boolean enemigosMuertos() {
		return listaEntidades.isEmpty();
	}
	
	public int getOleadaActual() {
		return oleadaActual;
	}
	
	public int getCantOleadas() {
		return cantOleadas;
	}
	
	public String getMapa(){
		return mapa;
	}
	
	public int getNumero(){
		return numero;
	}
	
	public String getSplash(){
		return Splash;
	}
}
