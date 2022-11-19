package Visitor;

import EntidadLogica.*;

public class VisitorArmaBasica extends Visitor {
	protected ArmaBasica entidadActual;
	
	public VisitorArmaBasica(ArmaBasica entidad) {
		entidadActual = entidad;
	}


	public void visitarPortadorAlpha(PortadorAlpha pa) {
		entidadActual.daniar(pa);
		entidadActual.getJuego().EliminarEntidades(entidadActual);
	}


	public void visitarPortadorBeta(PortadorBeta pb) {
		entidadActual.daniar(pb);
		entidadActual.getJuego().EliminarEntidades(entidadActual);
	}


}