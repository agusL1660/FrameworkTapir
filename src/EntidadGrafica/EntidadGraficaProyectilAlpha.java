package EntidadGrafica;

import javax.swing.JLabel;

import EntidadLogica.Entidad;
import Juego.Juego;

public class EntidadGraficaProyectilAlpha extends EntidadGrafica{
	
	public EntidadGraficaProyectilAlpha(Entidad entidad, int x , int y){
		super(entidad);
		this.imagenes = new String[]{"/Graficas/Proyectiles/ProyectilAlpha.gif"};
		this.altura = 40;
		this.ancho = 40;
		this.label.setSize(ancho,altura);
		agregarImagen(this.getImagenDefault());
		posicionX = x-ancho/2;
		posicionY = y+altura/2;
		this.label.setLocation(posicionX,posicionY);
	}
}
