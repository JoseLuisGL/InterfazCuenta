
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
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
import javax.swing.Icon;
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
		this.setSize(500, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Interfaz Cuenta");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.white);
		this.setLayout(null);
	
		
		limpiarVentana();
		
		
		
		
		
		
		
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
	
	public JPanel login()
	{
		
		anterior = actual;
		actual = "login";
		
		JPanel jp1 = new JPanel();
		jp1.setSize(500, 600);
		jp1.setLocation(0, 0);
		jp1.setLayout(null);
		jp1.setBackground(Color.decode("#FFB4B5"));
		
		JPanel jp3 = new JPanel();
		jp3.setSize(500, 600);
		jp3.setLocation(0, 0);
		jp3.setLayout(null);
		jp3.setBackground(Color.GRAY);
		
		//titulo
		JLabel title = new JLabel("Accede a tu cuenta",JLabel.CENTER);
		title.setFont(new Font("Comic Sans", Font.BOLD,24));
		title.setSize(280, 40);
		title.setLocation(100, 20);
		title.setOpaque(true);
		title.setForeground(Color.white);
		title.setBackground(Color.decode("#FFB4B5"));
		jp1.add(title);
		
		JLabel image1 = new JLabel();
		image1.setSize(100, 100);
		image1.setLocation(180, 80);
		ImageIcon imagen = new ImageIcon("img/login.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(image1.getWidth(), image1.getHeight(), Image.SCALE_DEFAULT));
		image1.setIcon(icono);
		jp1.add(image1);
		
		JLabel tag1 = new JLabel("Ingrese el nombre de usuario: ",JLabel.CENTER);
		tag1.setFont(new Font("Comic Sans", Font.BOLD,16));
		tag1.setSize(250, 20);
		tag1.setLocation(120, 200);
		tag1.setOpaque(true);
		tag1.setBackground(Color.decode("#FFB4B5"));
		tag1.setForeground(Color.white);
		jp1.add(tag1);
		
		JTextField username = new JTextField("");
		username.setSize(250, 40);
		username.setLocation(120, 230);
		jp1.add(username);
		
		JLabel tag2 = new JLabel("Ingrese la contraseña: ",JLabel.CENTER);
		tag2.setFont(new Font("Comic Sans", Font.BOLD,16));
		tag2.setSize(250, 20);
		tag2.setLocation(120, 280);
		tag2.setOpaque(true);
		tag2.setBackground(Color.decode("#FFB4B5"));
		tag2.setForeground(Color.white);
		jp1.add(tag2);
		
		JPasswordField password = new JPasswordField();
		password.setSize(250, 40);
		password.setLocation(120, 310);
		jp1.add(password);
		
		JButton btnAccess = new JButton("Ingresar");
		btnAccess.setSize(250,40);
		btnAccess.setLocation(120,400);
		jp1.add(btnAccess);
		
		btnAccess.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				remove(jp1);
				anterior = actual;
				actual = "registro";
				
				add(jp3);
				String email = username.getText();
				String pwd = new String (password.getPassword());
				
				BufferedReader reader;
				
				Boolean flag = false;
				
				try{
					
					FileReader file = new FileReader("users.txt");
					reader = new BufferedReader(file);
					
					String line = reader.readLine();
					
					while(line != null) {
						
						String data [] = line.split(",");
						 
						if( email.equals(data[2]) ) {
							if( pwd.equals(data[3]) ) {
								flag = true;
							}
						} 
						
						line = reader.readLine();
						
					}
					
					if(flag) {
						JOptionPane.showMessageDialog(null,"Bienvenido " + username.getText(),
						"Ingresando al sistema...", JOptionPane.INFORMATION_MESSAGE );
						JLabel bienvenida = new JLabel("<html>Bienvenido has hecho sesion como:<p><html>" + username.getText(),JLabel.CENTER);
						bienvenida.setFont(new Font("Comic Sans", Font.BOLD,18));
						bienvenida.setSize(350, 160);
						bienvenida.setLocation(80, 50);
						bienvenida.setOpaque(true);
						bienvenida.setBackground(Color.GRAY);
						
						JButton btnVolver = new JButton("Cerrar sesion");
						btnVolver.setSize(250,40);
						btnVolver.setLocation(120,205);
						jp3.add(btnVolver);
						//Barra
						JMenuBar barra = new JMenuBar();
						jp3.add(barra);
						JMenu Cuenta = new JMenu("Cuenta");
						barra.add(Cuenta);
						JMenu Usuarios = new JMenu("Usuarios");
						barra.add(Usuarios);
						JMenu Ayuda = new JMenu("Ayuda");
						barra.add(Ayuda);
						setJMenuBar(barra);
						//Items y Acciones
						JMenuItem i1 = new JMenuItem("Mi cuenta");
						i1.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								remove(jp1);
								remove(jp3);
								add(jp1);
								repaint();
								revalidate();
							}
							
						});
						Cuenta.add(i1);
						JMenuItem i2 = new JMenuItem("Cerrar sesion");
						i2.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								anterior = actual;
								actual = "login";
								remove(jp3);
								remove(barra);
								limpiarVentana();
							}
			
						});
						Cuenta.add(i2);
						jp3.add(bienvenida);
						repaint();
						revalidate();
					}else {
						JOptionPane.showMessageDialog(null,"Error",
						"El usuario y la contraseña no coinciden!", JOptionPane.ERROR_MESSAGE );
					}
					
					
				} catch(IOException e1) {
					e1.printStackTrace();
				}
			}
			
		});
		this.add(jp1);
		return jp1;	
				
		}
			
		
	
		public JPanel registro() {

		
			anterior = actual;
			actual = "registro";
			
			JPanel jp2 = new JPanel();
			jp2.setSize(500, 600);
			jp2.setLocation(0, 0);
			jp2.setLayout(null);
			jp2.setBackground(Color.decode("#C45EDF"));
			
			//titulo
			JLabel titleR = new JLabel("Registro nuevo usuario",JLabel.CENTER);
			titleR.setFont(new Font("Comic Sans", Font.BOLD,20));
			titleR.setSize(280, 40);
			titleR.setLocation(100, 20);
			titleR.setOpaque(true);
			titleR.setBackground(Color.green);
			jp2.add(titleR);
			
			JLabel tag1R = new JLabel("Ingrese el nombre de usuario: ",JLabel.CENTER);
			tag1R.setSize(250, 20);
			tag1R.setLocation(120, 80);
			tag1R.setOpaque(true);
			tag1R.setBackground(Color.black);
			tag1R.setForeground(Color.white);
			jp2.add(tag1R);
			
			JTextField usernameR = new JTextField("");
			usernameR.setSize(250, 40);
			usernameR.setLocation(120, 100);
			jp2.add(usernameR);
			
			JLabel tag2R = new JLabel("Ingrese el correo electrónico: ",JLabel.CENTER);
			tag2R.setSize(250, 20);
			tag2R.setLocation(120, 140);
			tag2R.setOpaque(true);
			tag2R.setBackground(Color.black);
			tag2R.setForeground(Color.white);
			jp2.add(tag2R);
			
			JPasswordField passwordR = new JPasswordField();
			passwordR.setSize(250, 40);
			passwordR.setLocation(120, 160);
			jp2.add(passwordR);
			
			JLabel tag3 = new JLabel("Ingrese el nombre: ",JLabel.CENTER);
			tag3.setSize(250, 20);
			tag3.setLocation(120, 210);
			tag3.setOpaque(true);
			tag3.setBackground(Color.black);
			tag3.setForeground(Color.white);
			jp2.add(tag3);
			
			JTextField name = new JTextField("");
			name.setSize(250, 40);
			name.setLocation(120, 250);
			jp2.add(name);
			
			JLabel tag4 = new JLabel("Ingrese el nombre: ",JLabel.CENTER);
			tag4.setSize(250, 20);
			tag4.setLocation(120, 300);
			tag4.setOpaque(true);
			tag4.setBackground(Color.black);
			tag4.setForeground(Color.white);
			jp2.add(tag4);
			
			JTextField lastname = new JTextField("");
			lastname.setSize(250, 40);
			lastname.setLocation(120, 340);
			jp2.add(lastname);
			
			JButton btnAdd = new JButton("Registrate!");
			btnAdd.setSize(250,40);
			btnAdd.setLocation(120, 390);
			jp2.add(btnAdd);
			
			btnAdd.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					anterior = actual;
					actual = "login";
					
					limpiarVentana();
					
				}
				
			});
			
			return jp2;
		
			}
		
		public void limpiarVentana() {
		
		if(panel!= null) {
			this.remove(panel);
		}
		
		if(actual.equals("login")){
			panel = login(); 
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
		
		if(actual.equals("registro")){
			panel = registro();
			
			this.add(panel);
			
			this.repaint();
			this.revalidate();
		}
	
}
	
	
	
	
	
	
}
