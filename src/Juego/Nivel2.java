package Juego;

import Fabrica.FabricaPortadorAlpha;
import Fabrica.FabricaPortadorBeta;

public class Nivel2 extends Nivel {

	public Nivel2(Juego juego) {
		super(juego);
		cantidad = new int[2];
		cantidad[0] = 7;
		cantidad[1] = 7;
		siguiente = null;
		listaFabricas.add(new FabricaPortadorAlpha(juego));
		listaFabricas.add(new FabricaPortadorBeta(juego));
		cantOleadas = 2;
		mapa = "/Graficas/Mapas/mapa2.png";
		numero = 2;
		Splash = "/Graficas/Splash/SplashNivel2.png";
	}

}
