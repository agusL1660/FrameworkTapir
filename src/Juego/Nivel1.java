package Juego;

import Fabrica.FabricaPortadorAlpha;
import Fabrica.FabricaPortadorBeta;

public class Nivel1 extends Nivel {
	
	public Nivel1(Juego juego){
		super(juego);
		cantidad = new int[2];
		cantidad[0] = 5;
		cantidad[1] = 5;
		siguiente = new Nivel2(juego);
		listaFabricas.add(new FabricaPortadorAlpha(juego));
		listaFabricas.add(new FabricaPortadorBeta(juego));
		cantOleadas = 2;
		mapa = "/Graficas/Mapas/mapa1.png";
		numero = 1;
		Splash = null;
	}
	

}
