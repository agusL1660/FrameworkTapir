package Visitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import EntidadLogica.DetenerTiempo;
import EntidadLogica.EfectoTemporal;
import EntidadLogica.Entidad;
import EntidadLogica.MejorarArma;
import EntidadLogica.ProyectilBeta;
import EntidadLogica.PersonajePrincipal;
import EntidadLogica.Pocion;
import EntidadLogica.PortadorAlpha;
import EntidadLogica.PortadorBeta;
import Inteligencia.Inteligencia;
import Inteligencia.InteligenciaTiempoDetenido;

public class VisitorDetenerTiempo extends Visitor {
	private Timer timer;
	protected DetenerTiempo entidadActual;
	
	public VisitorDetenerTiempo(DetenerTiempo entidad) {
		entidadActual = entidad;
	}

	public void visitarPersonajePrincipal(PersonajePrincipal pp) {
    	entidadActual.getJuego().EliminarEntidades(entidadActual);
		pp.getJuego().detenerTiempo();
		ActionListener accion = new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			entidadActual.getJuego().reanudarTiempo();
    			timer.stop();
    		}
    	};
    	timer = new Timer( entidadActual.getTiempo(), accion);
    	timer.start();
	}
}
