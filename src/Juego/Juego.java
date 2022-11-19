package Juego;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import EntidadLogica.*;
import Fabrica.*;
import GUI.InterfazJuego;
import GUI.SplashScreen;
import Inteligencia.InteligenciaTiempoDetenido;

public class Juego {
	private List<Entidad> listaEntidades;
	private List<Entidad> entidadesEnEspera;
	private List<Entidad> entidadesEliminar;
 	private Nivel nivelActual;
	private int ancho,altura;
	private InterfazJuego mapa;
	private String[] Splash;
			
	public Juego(InterfazJuego mapa) {
		nivelActual = new Nivel1(this);
		listaEntidades = new LinkedList<Entidad>();
		entidadesEnEspera = new LinkedList<Entidad>();
		entidadesEliminar = new LinkedList<Entidad>();
		ancho = 600;
		altura = 700;
		this.mapa = mapa;
		Splash = new String[]{"/Graficas/Splash/SplashInicio.png","/Graficas/Splash/SplashDerrota.png","/Graficas/Splash/SplashVictoria.png"};
	}
	
	public void inicializarNivel() {
		nivelActual.cargarEnemigos();
	}
	
	public void chequearNivel() {
		if (nivelActual.enemigosMuertos()) {//si ya no quedan enemigos vivos en el nivel actual
			if (nivelActual.getOleadaActual() == nivelActual.getCantOleadas()) {
				if (nivelActual.getNivelSiguiente() != null) {
					nivelActual = nivelActual.getNivelSiguiente();
					mapa.mostrarSplash(nivelActual.getSplash(),3000,mapa.getX(),mapa.getY());
					mapa.ponerMapa();
				}
				else {
					mapa.mostrarSplash(getSplashVictoria(), 3000,mapa.getX(),mapa.getY());
					mapa.salir();
				}
			}
			else {
				nivelActual.cargarEnemigos();
			}
		}
	}
	
	public InterfazJuego getMapa() {
		return mapa;
	}
	
	public void verificarColisiones() {
		for (Entidad entidad1 : listaEntidades) {
			for (Entidad entidad2 : listaEntidades) {
				if (entidad1.getEntidadGrafica().getRectangulo().intersects(entidad2.getEntidadGrafica().getRectangulo())) {
					entidad1.aceptarVisitor(entidad2.getVisitor());
				}
			}
		}
	}
	
	public List<Entidad> getListaEntidades() {
		return listaEntidades;
	}
	
	public int getAltura() {
		return altura;
	}
	
	public int getAncho() {
		return ancho;
	}
	
	public void detenerTiempo() {
		for(Entidad e : listaEntidades){
			e.setInteligencia(new InteligenciaTiempoDetenido(e,e.getInteligencia()));
		}
	}
	
	public void reanudarTiempo() {
		for(Entidad e : listaEntidades){
			e.setInteligencia(e.getInteligencia().getInteligenciaAnterior());
		}
	}

	public void crearPremio(int x) {
        EntidadPremio premio = null;
        Random rnd = new Random();
        int indice = rnd.nextInt(3);
        switch(indice) {
            case 0: 
                premio = new DetenerTiempo(this, x);
                break;
            case 1: 
                premio = new Pocion(this, x);
                break;
            case 2: 
            	premio = new MejorarArma(this, x);
                break;
        }
        agregarEntidad(premio);
    }
	
	public void accionarEntidades() {
		for(Entidad e : listaEntidades) {
			e.accionar();
		}
	}
	
	public void agregarEntidad(Entidad e){
		entidadesEnEspera.add(e);
		mapa.getMapa().add(e.getEntidadGrafica().getJLabel());
		e.getEntidadGrafica().getJLabel().setLocation(e.getEntidadGrafica().getPosicionX(),e.getEntidadGrafica().getPosicionY());
	}
	
	public void EliminarEntidades(Entidad e){
		entidadesEliminar.add(e);
		nivelActual.getListaEntidades().remove(e);
		e.getEntidadGrafica().getJLabel().setVisible(false);
		mapa.remove(e.getEntidadGrafica().getJLabel());
	}
	
	public List<Entidad> getEntidadesEnEspera(){
		return entidadesEnEspera;
	}
	
	public List<Entidad> getEntidadesEliminar(){
		return entidadesEliminar;
	}
	
	public void reiniciarListas(){
		entidadesEnEspera = new LinkedList<Entidad>();
		entidadesEliminar = new LinkedList<Entidad>();
	}
	
	public Nivel getNivelActual(){
		return nivelActual;
	} 
	
	public String getSplashInicio(){
		return Splash[0];
	}
	
	public String getSplashMuerte(){
		return Splash[1];
	}
	
	public String getSplashVictoria(){
		return Splash[2];
	}
}
