
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame {
	private int duracion;
	private String anterior = "login";
	private String actual = "login";
	public JPanel panel = null;
	
	public Ventana() {
		
		this.setVisible(true);
		this.setSize(600, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("Interfaz Cuenta");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		this.setLayout(null);
	
		
		
		
		
		
		
		
		
		
		}
	
	public void Splash(int duracion) {
		duracion = 4000;
		this.duracion = duracion;
		JPanel panel = (JPanel) getContentPane();
		ImageIcon img = new ImageIcon("img/sol.png");
		
		panel.add(new JLabel(img),BorderLayout.CENTER);
		setSize(img.getIconWidth(), img.getIconHeight());
		setLocationRelativeTo(null);
		setVisible(true);
		setTitle("Pantalla de carga");
		
		try {
			Thread.sleep(duracion);
		}catch(Exception e) {
			e.printStackTrace();
		}
		setVisible(false);
		
	}
	

	
	
	
	
	
	
	
	
	
	
}
