package GUI;

import java.awt.*;

import javax.swing.*;

public class SplashScreen extends JWindow {
	private int duration;
	private String ruta;
	private int x;
	private int y;

	public SplashScreen(int d, String r, int x, int y) {
		duration = d;
		ruta = r;
		this.x = x;
		this.y = y;
	}

	public void showSplash() {
		this.setLocationByPlatform(true);
		 JPanel content = (JPanel)getContentPane();
		 content.setBackground(new java.awt.Color(191,191,191));
		 content.setLayout(null);
		 JLabel label = new JLabel();

		 Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		 this.setBounds(x, y, 600, 780);
		
		 content.add(label);
		 label.setIcon(new ImageIcon(getClass().getResource(ruta)));
		 label.setBounds(0, 0, 600, 780);

		 setVisible(true);
		
		 try { Thread.sleep(duration); } catch (Exception e) {}
		
		 setVisible(false);
		 getContentPane().setBackground(new java.awt.Color(0,0,0));
		 this.setOpacity(0.0f);
		 content.add(label, "West");
	}

	public void showSplashAndExit() {
		showSplash();
		
	}
}
