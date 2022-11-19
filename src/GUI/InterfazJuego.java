package GUI;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import EntidadLogica.*;
import Hilos.ControladorJuego;
import Juego.Juego;

public class InterfazJuego extends JFrame {
	
	private JPanelBackground mapa;
	private Juego juego;
	private PersonajePrincipal personaje;
	private JLabel vida;
	private JLabel nivel;
	private JLabel oleada;
	private JPanel ventana;
	private Clip sonido;

	public static void main(String[] args) {
		mostrarSplash("/Graficas/Splash/SplashInicio.png",3000,10,10);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazJuego frame = new InterfazJuego();
					frame.iniciarSonido();
					frame.cargarEntidades();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InterfazJuego() {
		Font customFont = null;
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuentes/halloweek.ttf")).deriveFont(25f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/Fuentes/halloweek.ttf")));
		} catch (IOException e) {
		       e.printStackTrace();
		} catch(FontFormatException e) {
		       e.printStackTrace();
		}
		
		juego = new Juego(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(10, 10, juego.getAncho(), juego.getAltura()+80);
		setTitle("Ghostbusters");
		setIconImage(new ImageIcon(getClass().getResource("/Graficas/Mapas/Icono.png")).getImage());
		
		ventana = new JPanel();
		ventana.setBounds(100, 100, juego.getAncho(), juego.getAltura()+80);
		ventana.setLayout(new BorderLayout());
		
		mapa = new JPanelBackground();
		mapa.setLayout(null);
		mapa.setBounds(100, 100, juego.getAncho(), juego.getAltura());
		
		vida = new JLabel("",SwingConstants.CENTER);
		vida.setFont(customFont);
		vida.setForeground(Color.WHITE);
		
		nivel = new JLabel("",SwingConstants.CENTER);
		nivel.setFont(customFont);
		nivel.setForeground(Color.WHITE);
		
		oleada = new JLabel("",SwingConstants.CENTER);
		oleada.setFont(customFont);
		oleada.setForeground(Color.WHITE);
		
		Dimension d = new Dimension(juego.getAncho(),80);
		JPanelBackground panelSuperior = new JPanelBackground(); 
		panelSuperior.setLayout(new GridLayout(0,3,0,0));
		panelSuperior.setPreferredSize(d);
		panelSuperior.setBackground("/Graficas/Mapas/BarraSuperior.png");
		panelSuperior.add(vida);
		panelSuperior.add(nivel);
		panelSuperior.add(oleada);
		ventana.add(panelSuperior,BorderLayout.NORTH);
		ventana.add(mapa,BorderLayout.CENTER);

		juego.inicializarNivel();
		
		mapa.setBackground(juego.getNivelActual().getMapa());

		
		personaje = new PersonajePrincipal(juego);
		juego.agregarEntidad(personaje);
		this.addKeyListener(personaje.getInteligencia());
		setContentPane(ventana);
		setVisible(true);
	}
	
	private void iniciarSonido(){
		try {
			sonido = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResource("/Audio/Fondo.wav"));
		    sonido.open(inputStream);
		    FloatControl gainControl = (FloatControl) sonido.getControl(FloatControl.Type.MASTER_GAIN);        
		    gainControl.setValue(20f * (float) Math.log10(0.01f));
		    sonido.loop(sonido.LOOP_CONTINUOUSLY);
		    sonido.start();
		} catch (LineUnavailableException e) {
		} catch (UnsupportedAudioFileException e) {
		} catch (IOException e) {
		}	
	}
	
	public void cargarEntidades() {
		ControladorJuego me=new ControladorJuego(juego,personaje,vida,nivel,oleada);
        me.start();
    }
	
	public void removerEntidad(Entidad entidad) {
		mapa.remove(entidad.getEntidadGrafica().getJLabel());
	}
	
	public void ponerMapa() {
        String ruta=juego.getNivelActual().getMapa();
        mapa.setBackground(ruta);
    }
	
	public JPanelBackground getMapa(){
		return mapa;
	}
	
	public static void mostrarSplash(String ruta, int tiempo,int x, int y){
		SplashScreen splash = new SplashScreen(tiempo, ruta,x,y);
        splash.showSplash();
	}
	
	public void salir(){
		System.exit(0);
	}
	
	
}



