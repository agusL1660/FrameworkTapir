package Hilos;

import javax.swing.JLabel;

import EntidadLogica.PersonajePrincipal;
import Juego.Juego;

public class ControladorJuego extends Thread {
	protected Juego juego;
	protected PersonajePrincipal personaje;
	protected JLabel labelVida;
	protected JLabel labelNivel;
	protected JLabel labelOleada;
	
	public ControladorJuego(Juego juego, PersonajePrincipal personaje, JLabel labelVida, JLabel labelNivel, JLabel labelOleada) {
		this.juego = juego;
		this.personaje = personaje;
		this.labelVida = labelVida;
		this.labelNivel = labelNivel;
		this.labelOleada = labelOleada;
	}
	
	public void run() {
		while(true) {
			try {
				this.sleep(150);
			} 
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			juego.verificarColisiones();
			juego.accionarEntidades();
			juego.getListaEntidades().addAll(juego.getEntidadesEnEspera());
			juego.getListaEntidades().removeAll(juego.getEntidadesEliminar());
			juego.reiniciarListas();
			juego.chequearNivel();
			labelVida.setText("Carga Viral: "+personaje.getCargaViral());
			labelNivel.setText("Nivel: "+juego.getNivelActual().getNumero());
			labelOleada.setText("Oleada: "+juego.getNivelActual().getOleadaActual());
		}
	}
}
