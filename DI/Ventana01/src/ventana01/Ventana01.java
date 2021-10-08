package ventana01;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Ventana01 extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	public Ventana01() {
		
		this.setTitle("Manuel");
		this.setBounds(-10, 0 , 1386 , 756);
		this.setMinimumSize(new Dimension(200,200));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		
		Ventana01 ventana = new Ventana01();
		ventana.setVisible(true);
		
	}

}