package Visitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import EntidadLogica.SuperArma;
import Fabrica.FabricaProyectilBasico;
import Fabrica.FabricaSuperProyectil;
import EntidadLogica.ArmaBasica;
import EntidadLogica.DetenerTiempo;
import EntidadLogica.EfectoTemporal;
import EntidadLogica.Entidad;
import EntidadLogica.EntidadProyectil;
import EntidadLogica.MejorarArma;
import EntidadLogica.ProyectilBeta;
import EntidadLogica.PersonajePrincipal;
import EntidadLogica.Pocion;
import EntidadLogica.PortadorAlpha;
import EntidadLogica.PortadorBeta;

public class VisitorMejorarArma extends Visitor {
	protected MejorarArma entidadActual;
	private Timer timer;
	protected PersonajePrincipal personaje;
	public VisitorMejorarArma(MejorarArma entidad) {
		entidadActual = entidad;
		// TODO Auto-generated constructor stub
	}
	
	public void visitarPersonajePrincipal(PersonajePrincipal pp) {
		personaje = pp;
		entidadActual.getJuego().EliminarEntidades(entidadActual);
		personaje.setProyectil(new FabricaSuperProyectil(personaje.getJuego()));
		ActionListener accion = new ActionListener() {
    		public void actionPerformed(ActionEvent ae) {
    			personaje.setProyectil(new FabricaProyectilBasico(personaje.getJuego()));
    			timer.stop();
    		}
    	};
    	timer = new Timer( entidadActual.getTiempo(), accion);
    	timer.start();
    	
	}
}
