package EntidadGrafica;

import javax.swing.JLabel;

import EntidadLogica.Entidad;
import Juego.Juego;

public class EntidadGraficaPocion extends EntidadGrafica {
	
	public EntidadGraficaPocion(Entidad entidad, int x) {
		super(entidad);
		this.imagenes = new String[]{"/Graficas/Premios/Objeto Precioso/Curacion.gif"};
		this.altura = 50;
		this.ancho = 50;
		this.label.setSize(ancho,altura);
		agregarImagen(this.getImagenDefault());
		posicionX = x;
		posicionY = -altura;
		this.label.setLocation(posicionX,posicionY);
	}
}
