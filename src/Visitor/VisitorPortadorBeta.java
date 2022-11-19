package Visitor;

import EntidadLogica.*;

public class VisitorPortadorBeta extends Visitor {
	protected PortadorBeta entidadActual;
	public VisitorPortadorBeta(PortadorBeta entidad) {
		entidadActual = entidad;
		// TODO Auto-generated constructor stub
	}
}
