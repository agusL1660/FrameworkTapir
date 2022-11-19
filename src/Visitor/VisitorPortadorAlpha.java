package Visitor;

import EntidadLogica.*;

public class VisitorPortadorAlpha extends Visitor {
	protected PortadorAlpha entidadActual;
	
	public VisitorPortadorAlpha(PortadorAlpha entidad) {
		entidadActual = entidad;
		// TODO Auto-generated constructor stub
	}
}
