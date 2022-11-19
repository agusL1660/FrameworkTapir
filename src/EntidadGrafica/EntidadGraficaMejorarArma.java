package EntidadGrafica;

import javax.swing.JLabel;

import EntidadLogica.Entidad;
import Juego.Juego;

public class EntidadGraficaMejorarArma extends EntidadGrafica {

	public EntidadGraficaMejorarArma(Entidad entidad, int x) {
		super(entidad);
		this.imagenes = new String[]{"/Graficas/Premios/Objeto Precioso/SuperArma.gif"};
		this.altura = 50;
		this.ancho = 50;
		this.label.setSize(ancho,altura);
		agregarImagen(this.getImagenDefault());
		posicionX = x;
		posicionY = -altura;
		this.label.setLocation(posicionX,posicionY);
	}
}
