package main;

import java.awt.Font;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider extends JFrame implements ChangeListener{
	private static final long serialVersionUID = 1L;
	JPanel panel;
	JSlider jsl;
	JButton buttonjtf;
	JLabel labeljtf;
	String texto;
	
	
	
	public Slider() {
		this.setTitle("JSlider");
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		initC();
		
	}

	private void initC() {
		
		panel = new JPanel();
			
			
		jsl = new JSlider(0,100,50);
		jsl.setMinorTickSpacing(5);
		jsl.setMajorTickSpacing(25);
		jsl.setPaintTicks(true);
		jsl.setPaintLabels(true);
		jsl.setFont(new Font("Serif", Font.ITALIC,20));
		jsl.addChangeListener(this);
		
		panel.add(jsl);
		
		labeljtf = new JLabel();
		labeljtf.setText("Hola");
		panel.add(labeljtf);
		
		panel.setBounds(10, 10, 600, 200);
		this.add(panel);
		
		
	}
	
	
	public static void main(String[] args) {

		Slider tf = new Slider();
		tf.setVisible(true);
		
	}

	@Override
	public void stateChanged(ChangeEvent arg0) {
		
		labeljtf.setFont(new Font("Serif", Font.BOLD, jsl.getValue()));
		labeljtf.setText(jsl.getValue()+"");
		
	}

}
