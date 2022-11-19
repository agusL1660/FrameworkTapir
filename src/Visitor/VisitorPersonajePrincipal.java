package Visitor;

import EntidadLogica.*;

public class VisitorPersonajePrincipal extends Visitor {
	protected PersonajePrincipal entidadActual;
	
	public VisitorPersonajePrincipal(PersonajePrincipal entidad) {
		entidadActual = entidad;
		// TODO Auto-generated constructor stub
	}
}
