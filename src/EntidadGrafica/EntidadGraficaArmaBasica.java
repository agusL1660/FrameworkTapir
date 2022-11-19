package EntidadGrafica;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import EntidadLogica.Entidad;
import Juego.Juego;

public class EntidadGraficaArmaBasica extends EntidadGrafica{

    public EntidadGraficaArmaBasica(Entidad entidad,int x,int y){
        super(entidad);
        this.imagenes = new String[]{"/Graficas/Proyectiles/ProyectilBasico.gif"};
        this.altura = 40;
        this.ancho = 40;
		this.label.setSize(ancho,altura);
        agregarImagen(this.getImagenDefault());
        posicionX = x-ancho/2;
        posicionY = y;
		this.label.setLocation(posicionX,posicionY);
    }

 
}
