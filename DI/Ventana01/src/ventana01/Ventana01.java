package ventana01;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana01 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public Ventana01() {
		
		Toolkit miSistema = Toolkit.getDefaultToolkit();
		Image logo = miSistema.getImage("Logo.png");
		this.setIconImage(logo);
		this.setResizable(false);
		this.setTitle("Manuel");
		Dimension dimension = miSistema.getScreenSize();
		JLabel etiqueta = new JLabel();
		etiqueta.setText("hola"+dimension.getHeight()+" "+dimension.getWidth());
		this.add(etiqueta);
		this.setBounds(0, 0 , dimension.width , dimension.height);
		this.setMinimumSize(new Dimension(200,200));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		
	}

	public static void main(String[] args) {
		
		Ventana01 ventana = new Ventana01();
		ventana.setVisible(true);
		
	}

}
