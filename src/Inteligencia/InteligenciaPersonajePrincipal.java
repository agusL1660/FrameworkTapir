package Inteligencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import EntidadGrafica.EntidadGraficaPersonajePrincipal;
import EntidadLogica.Entidad;
import EntidadLogica.PersonajePrincipal;

public class InteligenciaPersonajePrincipal extends Inteligencia{
	private PersonajePrincipal personajePrincipal;
	private Timer timer;

    public InteligenciaPersonajePrincipal(PersonajePrincipal personajePrincipal) {
        super(null);
        this.personajePrincipal = personajePrincipal;
    }

    public void keyPressed(KeyEvent arg0) {
        switch(arg0.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A: {
                moverIzquierda();
                break;
            }
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D: {
                moverDerecha();
                break;
            }
            case KeyEvent.VK_SPACE:
            case KeyEvent.VK_X: {
            	personajePrincipal.disparar();
                break;
            }
        }
    }

    public void moverDerecha() {
    	EntidadGraficaPersonajePrincipal entidadGrafica = (EntidadGraficaPersonajePrincipal) personajePrincipal.getEntidadGrafica();
    	if(entidadGrafica.getImagenActual() != entidadGrafica.getImagenes(2)){
    		entidadGrafica.setImagenActual(personajePrincipal.getEntidadGrafica().getImagenes(2));
    		entidadGrafica.getJLabel().setIcon(entidadGrafica.getImagenMovientoDerecha());
    		entidadGrafica.agregarImagen(entidadGrafica.getImagenMovientoDerecha());
    	}
        int x = entidadGrafica.getPosicionX();
        int anchoEntidad = entidadGrafica.getAncho();
        int anchoJuego = personajePrincipal.getJuego().getAncho();
        int velocidad = personajePrincipal.getVelocidad();
        x = x + anchoEntidad + velocidad <= anchoJuego ? x + velocidad : anchoJuego - anchoEntidad;
        int y = entidadGrafica.getPosicionY();
        entidadGrafica.getJLabel().setLocation(x, y);
        entidadGrafica.setPosicionX(x);
    }

    public void moverIzquierda() {
    	EntidadGraficaPersonajePrincipal entidadGrafica = (EntidadGraficaPersonajePrincipal) personajePrincipal.getEntidadGrafica();
    	if(entidadGrafica.getImagenActual() != entidadGrafica.getImagenes(1)){
    		entidadGrafica.setImagenActual(entidadGrafica.getImagenes(1));
    		entidadGrafica.getJLabel().setIcon(entidadGrafica.getImagenMovientoIzquierda());
    		entidadGrafica.agregarImagen(entidadGrafica.getImagenMovientoIzquierda());
    	}
        int x = entidadGrafica.getPosicionX();
        int velocidad = personajePrincipal.getVelocidad();
        x = x  - velocidad >= 0 ? x  - velocidad : 0;
        int y = entidadGrafica.getPosicionY();
        entidadGrafica.getJLabel().setLocation(x, y);
        entidadGrafica.setPosicionX(x);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent e) {
    	EntidadGraficaPersonajePrincipal entidadGrafica = (EntidadGraficaPersonajePrincipal) personajePrincipal.getEntidadGrafica();
    	entidadGrafica.setImagenActual(entidadGrafica.getImagenes(0));
    	entidadGrafica.getJLabel().setIcon(entidadGrafica.getImagenDefault());
		entidadGrafica.agregarImagen(entidadGrafica.getImagenDefault());

    }

}
