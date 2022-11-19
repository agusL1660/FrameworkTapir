package EntidadGrafica;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import EntidadLogica.Entidad;
import Juego.Juego;

public class EntidadGraficaPortadorAlpha extends EntidadGrafica{
	
	public EntidadGraficaPortadorAlpha(Entidad entidad) {
		super(entidad);
		this.imagenes = new String[]{"/Graficas/Enemigos/EnemigoAlphaDefault.gif","/Grafica/Enemigo/EnemigoAlphaMuerte.gif"};
		Random rnd = new Random();
	    this.altura = 75;
	    this.ancho = 75;
		this.label.setSize(ancho,altura);
	    this.posicionX = rnd.nextInt(entidad.getJuego().getAncho()-ancho+1);
	    this.posicionY = rnd.nextInt(altura+1)-altura*2;
	    agregarImagen(this.getImagenDefault());
	}
	
	public ImageIcon getImagenMuerte() {
		return new ImageIcon(this.getClass().getResource(this.imagenes[1]));
	}
}
