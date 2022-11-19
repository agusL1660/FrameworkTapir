package Visitor;

import EntidadLogica.DetenerTiempo;
import EntidadLogica.Entidad;
import EntidadLogica.MejorarArma;
import EntidadLogica.PersonajePrincipal;
import EntidadLogica.Pocion;
import EntidadLogica.PortadorAlpha;
import EntidadLogica.PortadorBeta;
import EntidadLogica.ProyectilAlpha;
import EntidadLogica.ProyectilBeta;

public class VisitorProyectilAlpha extends Visitor {
	protected ProyectilAlpha entidadActual;
	public VisitorProyectilAlpha(ProyectilAlpha entidad) {
		entidadActual = entidad;
		// TODO Auto-generated constructor stub
	}
	
	public void visitarPersonajePrincipal(PersonajePrincipal pp) {
		entidadActual.daniar(pp);
		entidadActual.getJuego().EliminarEntidades(entidadActual);
	}
}
