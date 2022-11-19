package EntidadLogica;

import EntidadGrafica.EntidadGraficaSuperArma;

import Juego.Juego;
import Visitor.Visitor;
import Visitor.VisitorSuperArma;

public class SuperArma extends ProyectilSanitario {
	
	public SuperArma(Juego juego, int x, int y) {
		super(juego);
        visitor = new VisitorSuperArma(this);
        entidadGrafica = new EntidadGraficaSuperArma(this,x,y);
        velocidad = 15;
        danio = 40;
    }

    @Override
    public void aceptarVisitor(Visitor v) {
        v.visitarSuperArma(this);
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }
    
    @Override
    public void daniar(EntidadPersonaje ep) {
        int nuevaCargaViral = ep.cargaViral - danio;
        if(nuevaCargaViral <= 0) {
            ep.morir();
        }
        else {
            ep.setCargaViral(nuevaCargaViral);
        }
    }
}