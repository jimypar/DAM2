package main;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Main extends JFrame{
	private static final long serialVersionUID = 1L;
	private static final DecimalFormat df = new DecimalFormat("0.00");
	JPanel panel;
	JLabel titulo,capital,interes,plazo,mensualidad,interesesTotales;
	JTextField calculoCapital,calculoInteres,calculoPlazo,calculoMensualidad,calculoInteresesTot;
	JSlider jslCapital,jslInteres,jslPlazo,jslMensualidad;
	String texto;
	
	
	public Main() {
		this.setTitle("JSlider");
		this.setSize(640, 480);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		initC();
		
	}

	private void initC() {
		
		panel = new JPanel(new GridBagLayout());
		
		GridBagConstraints config = new GridBagConstraints();
		
		config.insets = new Insets(3, 3, 3, 3);
				
		config.gridx = 0;			
		config.gridy = 0;
		config.gridwidth = 3;
		
		titulo = new JLabel("Cálculo de hipoteca (Jaime Pardo)");
		panel.add(titulo,config);
		
		//CAPITAL-------------------
		
		config.gridx = 0;			
		config.gridy = 1;
		config.gridwidth = 1;
		
		capital = new JLabel("Capital: ");
		panel.add(capital,config);
		
		config.gridx = 1;			
		config.gridy = 1;
		
		calculoCapital = new JTextField("200000", 5);
		calculoCapital.setEditable(false);
		calculoCapital.setHorizontalAlignment(JTextField.CENTER);
		panel.add(calculoCapital,config);
		
		config.gridx = 2;			
		config.gridy = 1;		
		
		jslCapital = new JSlider(0,1000000,200000);
		jslCapital.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculoCapital.setText(String.valueOf(jslCapital.getValue()));
				calcularMensualidad();
			}
		});	
		panel.add(jslCapital,config);
		
		//INTERES-------------------
		
		config.gridx = 0;			
		config.gridy = 2;
		config.gridwidth = 1;
		
		interes = new JLabel("Interés %: ");
		panel.add(interes,config);
		
		config.gridx = 1;			
		config.gridy = 2;
		
		calculoInteres = new JTextField("4.5", 5);
		calculoInteres.setEditable(false);
		calculoInteres.setHorizontalAlignment(JTextField.CENTER);
		panel.add(calculoInteres,config);
		
		config.gridx = 2;			
		config.gridy = 2;		
		
		jslInteres = new JSlider(0,8,4);
		jslInteres.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculoInteres.setText(String.valueOf(jslInteres.getValue()));
				calcularMensualidad();
			}
		});	
		panel.add(jslInteres,config);
		
		//PLAZO-------------------

		config.gridx = 0;			
		config.gridy = 3;
		
		plazo = new JLabel("Plazo: ");
		panel.add(plazo,config);
		
		config.gridx = 1;			
		config.gridy = 3;
		
		calculoPlazo = new JTextField("30", 5);
		calculoPlazo.setEditable(false);
		calculoPlazo.setHorizontalAlignment(JTextField.CENTER);
		panel.add(calculoPlazo,config);
		
		config.gridx = 2;			
		config.gridy = 3;		
		
		jslPlazo = new JSlider(0,30,30);
		jslPlazo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				calculoPlazo.setText(String.valueOf(jslPlazo.getValue()));
				calcularMensualidad();
			}
		});	
		panel.add(jslPlazo,config);
		
		//MENSUALIDAD------------
		
		config.gridx = 0;			
		config.gridy = 4;
		
		mensualidad = new JLabel("Mensualidad: ");
		panel.add(mensualidad,config);
		
		config.gridx = 1;			
		config.gridy = 4;
		
		calculoMensualidad = new JTextField("", 5);
		calculoMensualidad.setEditable(false);
		calculoMensualidad.setHorizontalAlignment(JTextField.CENTER);
		panel.add(calculoMensualidad,config);
		
		calcularMensualidad();		
			
		panel.setBounds(10, 10, 600, 200);
		this.add(panel);
		
		
	}
	
	
	protected void calcularMensualidad() {
		
		float capital = Float.parseFloat(calculoCapital.getText());
		float interes =Float.parseFloat(calculoInteres.getText());
		float plazo = Float.parseFloat(calculoPlazo.getText());
		
		float cuota = ((capital*(interes/12))/(100*(1-(1+(interes/(12*100))-(plazo*12)))));
		
		calculoMensualidad.setText(df.format(cuota)+"");
		
	}

	public static void main(String[] args) {

		Main tf = new Main();
		tf.setVisible(true);
		
	}


}
