package EntidadGrafica;

import javax.swing.JLabel;

import EntidadLogica.Entidad;
import Juego.Juego;

public class EntidadGraficaDetenerTiempo extends EntidadGrafica {

	public EntidadGraficaDetenerTiempo(Entidad entidad, int x){
		super(entidad);
		this.imagenes = new String[]{"/Graficas/Premios/Efecto Temporal/PararTiempo.gif"};
		this.altura = 50;
		this.ancho = 50;
		this.label.setSize(ancho,altura);
		agregarImagen(this.getImagenDefault());
		posicionX = x;
		posicionY = -altura;
		this.label.setLocation(posicionX,posicionY);
	}

}
