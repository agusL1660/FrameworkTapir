package Visitor;

import EntidadLogica.*;

public class VisitorSuperArma extends Visitor {
	protected SuperArma entidadActual;
	
	public VisitorSuperArma(SuperArma entidad) {
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