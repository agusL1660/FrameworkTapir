package Visitor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import EntidadLogica.DetenerTiempo;
import EntidadLogica.Entidad;
import EntidadLogica.MejorarArma;
import EntidadLogica.ProyectilBeta;
import Fabrica.FabricaProyectilBasico;
import Fabrica.FabricaSuperProyectil;
import EntidadLogica.PersonajePrincipal;
import EntidadLogica.Pocion;
import EntidadLogica.PortadorAlpha;
import EntidadLogica.PortadorBeta;

public class VisitorPocion extends Visitor{
	protected Pocion entidadActual;
	
	public VisitorPocion(Pocion entidad) {
		entidadActual = entidad;
	}
	
	public void visitarPersonajePrincipal(PersonajePrincipal pp) {
		pp.setCargaViral(0);
		entidadActual.getJuego().EliminarEntidades(entidadActual);
	}
}
