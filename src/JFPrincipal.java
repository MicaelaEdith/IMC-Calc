import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;


public class JFPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textAltura;
	private JTextField textPeso;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFPrincipal frame = new JFPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
		double altura, peso, imc;
		String sPeso, sAltura, respuesta,stringIMC;

	public JFPrincipal() {
		setResizable(false);
		setBackground(new Color(144, 238, 144));
		setTitle("IMC-Calc");
		setForeground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 332, 386);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseAlturaEn = new JLabel("Ingrese altura en CMs:");
		lblIngreseAlturaEn.setFont(new Font("SimSun", Font.PLAIN, 14));
		lblIngreseAlturaEn.setBounds(16, 41, 161, 36);
		contentPane.add(lblIngreseAlturaEn);
		
		JLabel lblIngresePeso = new JLabel("Ingrese peso:");
		lblIngresePeso.setFont(new Font("SimSun", Font.PLAIN, 14));
		lblIngresePeso.setBounds(80, 97, 97, 22);
		contentPane.add(lblIngresePeso);
		
		textAltura = new JTextField();
		textAltura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		textAltura.setBounds(179, 50, 86, 20);
		contentPane.add(textAltura);
		textAltura.setColumns(10);
		
		textPeso = new JTextField();
		textPeso.setText("");
		textPeso.setBounds(179, 99, 86, 20);
		contentPane.add(textPeso);
		textPeso.setColumns(10);
		
		JLabel labelResultado = new JLabel(" ");
		labelResultado.setFont(new Font("SimSun", Font.PLAIN, 14));
		labelResultado.setHorizontalAlignment(SwingConstants.CENTER);
		labelResultado.setBounds(43, 243, 221, 51);
		contentPane.add(labelResultado);
		labelResultado.setText("Ingrese sus datos");
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("SimSun", Font.PLAIN, 14));
		label.setBounds(54, 188, 210, 36);
		contentPane.add(label);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCalcular.setForeground(Color.BLACK);
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				altura=Integer.parseInt(textAltura.getText());
				peso=Integer.parseInt(textPeso.getText());
				altura=altura/100;
				imc = peso/(altura*altura);
				
				if (imc<16)  respuesta= "Necesita ingresar en un hospital";
				 else if (imc<17)  respuesta = "Usted tiene infrapeso";
				 else if (imc<18)  respuesta = "Usted tiene bajo peso";
				 else if (imc<26)  respuesta = "Usted tiene un peso saludable";
				 else if (imc<30)  respuesta = "Tiene sobrepeso de grado I";
				 else if (imc<35)  respuesta = "Tiene sobrepeso de grado II";
				 else if (imc<40)  respuesta = "Tiene sobrepeso de grado (III)";
				 else  respuesta= "Usted tiene obesidad de grado IV";
				stringIMC="Su IMC es: "+ String.format("%.2f", imc);
				labelResultado.setText(respuesta);
				label.setText(stringIMC);
			
			}
		});
		btnCalcular.setBounds(115, 149, 89, 23);
		contentPane.add(btnCalcular);
		
	
	}
	}
