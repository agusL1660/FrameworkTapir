package EntidadGrafica;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import EntidadLogica.Entidad;
import Juego.Juego;

public abstract class EntidadGrafica {
	protected JLabel label;
	protected String[] imagenes;
	protected int altura,ancho;
	protected int posicionX,posicionY;
	protected Entidad entidad;
	protected String imagenActual;
	
	public EntidadGrafica(Entidad entidad) {
		this.label = new JLabel();
		this.entidad = entidad;
	}
	
	public int getPosicionX() {
		return this.posicionX;
	}
	
	public int getPosicionY() {
		return this.posicionY;
	}
	
	public int getAltura() {
		return this.altura;
	}
	
	public int getAncho() {
		return this.ancho;
	}
	
	public JLabel getJLabel() {
		return this.label;
	}
	
	public Rectangle getRectangulo() {
		return this.label.getBounds();
	}
	
	public ImageIcon getImagenDefault() {
		return new ImageIcon(getClass().getResource(this.imagenes[0]));
	}

	public void setPosicionX(int x) {
		this.posicionX = x;
	}
	
	public  void setPosicionY(int y) {
		this.posicionY = y;
	}
	
	public void agregarImagen(ImageIcon imagen){
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(this.label.getWidth(), this.label.getHeight(), Image.SCALE_DEFAULT));
		this.label.setIcon(icono);
	}
	
	public String getImagenActual(){
		return  imagenActual;
	}
	
	public void setImagenActual(String i){
		imagenActual = i;
	}
	
	public String getImagenes(int i){
		return imagenes[i];
	}
}
