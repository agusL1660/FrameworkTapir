package EntidadLogica;

import EntidadGrafica.EntidadGraficaArmaBasica;
import Inteligencia.InteligenciaPersonajePrincipal;
import Juego.Juego;
import Visitor.Visitor;
import Visitor.VisitorArmaBasica;

public class ArmaBasica extends ProyectilSanitario {
	
	public ArmaBasica(Juego juego, int x, int y) {
		super(juego);
        visitor = new VisitorArmaBasica(this);
        entidadGrafica = new EntidadGraficaArmaBasica(this,x,y);
        velocidad = 15;
        danio = 18;
    }

    @Override
    public void aceptarVisitor(Visitor v) {
        v.visitarArmaBasica(this);
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
