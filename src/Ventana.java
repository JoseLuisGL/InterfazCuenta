
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Scanner;

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
	private static final ActionListener ActionListener = null;
	private int duracion;
	private String anterior = "login";
	private String actual = "login";
	private String cuenta = "login";
	private String ayuda = "login";
	private String tabla = "login";
	private String usuarioSeleccionado;
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
						anterior = actual;
						actual = "cuenta";
						add(cuenta());
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
			
	public JPanel cuenta() {
			JLabel bienvenida = new JLabel("<html>Bienvenido has iniciado sesion correctamente<p><html>" ,JLabel.CENTER);
			bienvenida.setFont(new Font("Comic Sans", Font.BOLD,18));
			bienvenida.setSize(350, 160);
			bienvenida.setLocation(80, 20);
			bienvenida.setOpaque(true);
			bienvenida.setBackground(Color.GRAY);
			
			JPanel jp3 = new JPanel();
			jp3.setSize(500, 600);
			jp3.setLocation(0, 0);
			jp3.setLayout(null);
			jp3.setBackground(Color.GRAY);
			
			JLabel image1 = new JLabel();
			image1.setSize(200, 200);
			image1.setLocation(160, 150);
			ImageIcon imagen = new ImageIcon("img/inicio.png");
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(image1.getWidth(), image1.getHeight(), Image.SCALE_DEFAULT));
			image1.setIcon(icono);
			jp3.add(image1);
			
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
					anterior = actual;
					actual = "micuenta";
					remove(jp3);
					limpiarVentana();
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
					limpiarVentana();
				}

			});
			Cuenta.add(i2);
			JMenuItem i3 = new JMenuItem("Lista de usuarios");
			i3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					anterior = actual;
					actual = "tabla";
					remove(jp3);
					limpiarVentana();
				}
				
			});
			Usuarios.add(i3);
			JMenuItem i4 = new JMenuItem("Crear cuenta");
			i4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					remove(jp3);
					remove(login());
					anterior = actual;
					actual = "registro";
					
					limpiarVentana();
				}
				
			});
			Usuarios.add(i4);
			JMenuItem i5 = new JMenuItem("¿Como crear usuarios?");
			i5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					remove(jp3);
					remove(login());
					anterior = actual;
					actual = "ayuda";
					
					limpiarVentana();
				}
				
			});
			Ayuda.add(i5);
			jp3.add(bienvenida);
			return jp3;
		}
		
	public JPanel registro() {

		
			anterior = actual;
			actual = "registro";
			
			JPanel jp2 = new JPanel();
			jp2.setSize(500, 600);
			jp2.setLocation(0, 0);
			jp2.setLayout(null);
			jp2.setBackground(Color.decode("#FFB4B5"));
			
			JLabel image1 = new JLabel();
			image1.setSize(90, 90);
			image1.setLocation(200, 30);
			ImageIcon imagen = new ImageIcon("img/perfil.png");
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(image1.getWidth(), image1.getHeight(), Image.SCALE_DEFAULT));
			image1.setIcon(icono);
			jp2.add(image1);
			
			//titulo
			JLabel titleR = new JLabel("Crear Usuario",JLabel.CENTER);
			titleR.setFont(new Font("Comic Sans", Font.BOLD,24));
			titleR.setSize(280, 20);
			titleR.setLocation(100, 10);
			titleR.setOpaque(true);
			titleR.setBackground(Color.decode("#FFB4B5"));
			jp2.add(titleR);
			
			JLabel tag1R = new JLabel("Nombre: ",JLabel.CENTER);
			tag1R.setSize(250, 20);
			tag1R.setLocation(120, 120);
			tag1R.setOpaque(true);
			tag1R.setBackground(Color.decode("#FFB4B5"));
			tag1R.setForeground(Color.white);
			jp2.add(tag1R);
			
			JTextField nombres = new JTextField("");
			nombres.setSize(250, 40);
			nombres.setLocation(120, 140);
			jp2.add(nombres);
			
			JLabel tag2R = new JLabel("Usuario: ",JLabel.CENTER);
			tag2R.setSize(250, 20);
			tag2R.setLocation(120, 180);
			tag2R.setOpaque(true);
			tag2R.setBackground(Color.decode("#FFB4B5"));
			tag2R.setForeground(Color.white);
			jp2.add(tag2R);
			
			JTextField usuarios = new JTextField();
			usuarios.setSize(250, 40);
			usuarios.setLocation(120, 200);
			jp2.add(usuarios);
			
			JLabel tag3 = new JLabel("Email: ",JLabel.CENTER);
			tag3.setSize(250, 20);
			tag3.setLocation(120, 240);
			tag3.setOpaque(true);
			tag3.setBackground(Color.decode("#FFB4B5"));
			tag3.setForeground(Color.white);
			jp2.add(tag3);
			
			JTextField correo = new JTextField();
			correo.setSize(250, 40);
			correo.setLocation(120, 260);
			jp2.add(correo);
			
			JLabel tag4 = new JLabel("Contraseña: ",JLabel.CENTER);
			tag4.setSize(250, 20);
			tag4.setLocation(120, 300);
			tag4.setOpaque(true);
			tag4.setBackground(Color.decode("#FFB4B5"));
			tag4.setForeground(Color.white);
			jp2.add(tag4);
			
			JPasswordField contraseña1 = new JPasswordField();
			contraseña1.setSize(250, 40);
			contraseña1.setLocation(120, 320);
			jp2.add(contraseña1);
			
			JLabel tag5 = new JLabel("Confirmar contraseña: ",JLabel.CENTER);
			tag5.setSize(250, 20);
			tag5.setLocation(120, 360);
			tag5.setOpaque(true);
			tag5.setBackground(Color.decode("#FFB4B5"));
			tag5.setForeground(Color.white);
			jp2.add(tag5);
			
			JPasswordField contraseña2 = new JPasswordField();
			contraseña2.setSize(250, 40);
			contraseña2.setLocation(120, 380);
			jp2.add(contraseña2);
			
			JButton btnCrear = new JButton("Crear usuario");
			btnCrear.setSize(120,40);
			btnCrear.setLocation(250, 450);
			jp2.add(btnCrear);
			
			btnCrear.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        // Verificar que todos los campos estén llenos
			        if (nombres.getText().isEmpty() || usuarios.getText().isEmpty() ||
			                correo.getText().isEmpty() || contraseña1.getPassword().length == 0 || contraseña2.getPassword().length == 0) {
			            JOptionPane.showMessageDialog(jp2, "Por favor, llene todos los campos.");
			            return;
			        }
			        
			        String nombre = nombres.getText();
			        String usuario = usuarios.getText();
			        String email = correo.getText();
			        String pwd = new String(contraseña1.getPassword());
			        
			        // Verificar si ya existe un correo electrónico igual
			        try {
			            Scanner scanner = new Scanner(new File("users.txt"));
			            while (scanner.hasNextLine()) {
			                String line = scanner.nextLine();
			                String[] parts = line.split(",");
			                if (parts.length >= 3 && parts[2].equals(email)) {
			                    JOptionPane.showMessageDialog(jp2, "No se pudo crear el usuario. Ya existe un correo electrónico igual.");
			                    scanner.close();
			                    return;
			                }
			            }
			            scanner.close();
			        } catch (FileNotFoundException ex) {
			            ex.printStackTrace();
			        }
			        
			        // Guardar el nuevo usuario en el archivo
			        try {
			            FileWriter writer = new FileWriter("users.txt", true);
			            PrintWriter linea = new PrintWriter(writer);
			            linea.println(nombre + "," + usuario + "," + email + "," + pwd);
			            linea.close();
			            writer.close();
			            
			            JOptionPane.showMessageDialog(jp2, "Usuario creado");
			        } catch (IOException e1) {
			            e1.printStackTrace();
			            JOptionPane.showMessageDialog(jp2, "El usuario no se ha podido crear");
			        }
			    }
			});
			
			JButton btnVolver = new JButton("Cancelar");
			btnVolver.setSize(120,40);
			btnVolver.setLocation(120, 450);
			jp2.add(btnVolver);
			
			btnVolver.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					anterior = actual;
					actual = "cuenta";
					
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
			if(actual.equals("cuenta")){
				panel = cuenta();
				
				this.add(panel);
				
				this.repaint();
				this.revalidate();
			}
			if(actual.equals("ayuda")){
				panel = ayuda();
				
				this.add(panel);
				
				this.repaint();
				this.revalidate();
			}
			if(actual.equals("micuenta")){
				panel = Micuenta();
				
				this.add(panel);
				
				this.repaint();
				this.revalidate();
			}
			if(actual.equals("tabla")){
				panel = tabla();
				
				this.add(panel);
				
				this.repaint();
				this.revalidate();
			}
	
		}
	
	public JPanel ayuda() {
			anterior = actual;
			actual = "ayuda";
			JPanel jp4 = new JPanel();
			jp4.setSize(500, 600);
			jp4.setLocation(0, 0);
			jp4.setLayout(null);
			jp4.setBackground(Color.decode("#FFB4B5"));
			
			JLabel ayudatitulo = new JLabel("¿Como crear un usuario?" ,JLabel.CENTER);
			ayudatitulo.setFont(new Font("Comic Sans", Font.BOLD,24));
			ayudatitulo.setSize(350, 30);
			ayudatitulo.setLocation(80, 10);
			ayudatitulo.setOpaque(true);
			ayudatitulo.setForeground(Color.white);
			ayudatitulo.setBackground(Color.decode("#FFB4B5"));
			
			JLabel image1 = new JLabel();
			image1.setSize(120, 120);
			image1.setLocation(190, 50);
			ImageIcon imagen = new ImageIcon("img/ayuda.png");
			Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(image1.getWidth(), image1.getHeight(), Image.SCALE_DEFAULT));
			image1.setIcon(icono);
			jp4.add(image1);
			
			JPanel jpinstrucciones = new JPanel();
			jpinstrucciones.setSize(460, 330);
			jpinstrucciones.setLocation(10, 200);
			jpinstrucciones.setLayout(null);
			jpinstrucciones.setBackground(Color.decode("#FE8486"));
			
			JLabel instruccion1 = new JLabel("<html>1.- Hacer click en la opcion (Usuarios) en el<p> menu superior<html> " ,JLabel.LEFT);
			instruccion1.setFont(new Font("Comic Sans", Font.BOLD,16));
			instruccion1.setSize(500, 50);
			instruccion1.setLocation(10, 10);
			instruccion1.setOpaque(true);
			instruccion1.setForeground(Color.white);
			instruccion1.setBackground(Color.decode("#FE8486"));
			
			JLabel instruccion2 = new JLabel("<html>2.- Hacer click en la opcion (Crear Usuario) en el<p> menu desplegado<html> " ,JLabel.LEFT);
			instruccion2.setFont(new Font("Comic Sans", Font.BOLD,16));
			instruccion2.setSize(500, 50);
			instruccion2.setLocation(10, 60);
			instruccion2.setOpaque(true);
			instruccion2.setForeground(Color.white);
			instruccion2.setBackground(Color.decode("#FE8486"));
			
			JLabel instruccion3 = new JLabel("<html>3.- Llenar los campos solicitados<html> " ,JLabel.LEFT);
			instruccion3.setFont(new Font("Comic Sans", Font.BOLD,16));
			instruccion3.setSize(500, 50);
			instruccion3.setLocation(10, 100);
			instruccion3.setOpaque(true);
			instruccion3.setForeground(Color.white);
			instruccion3.setBackground(Color.decode("#FE8486"));
			
			JLabel instruccion4 = new JLabel("<html>4.- Escribe una pequeña descripcion de ti<html> " ,JLabel.LEFT);
			instruccion4.setFont(new Font("Comic Sans", Font.BOLD,16));
			instruccion4.setSize(500, 50);
			instruccion4.setLocation(10, 130);
			instruccion4.setOpaque(true);
			instruccion4.setForeground(Color.white);
			instruccion4.setBackground(Color.decode("#FE8486"));
			
			JLabel instruccion5 = new JLabel("<html>5.- Seleccionar tu comida favorita<html> " ,JLabel.LEFT);
			instruccion5.setFont(new Font("Comic Sans", Font.BOLD,16));
			instruccion5.setSize(500, 50);
			instruccion5.setLocation(10, 160);
			instruccion5.setOpaque(true);
			instruccion5.setForeground(Color.white);
			instruccion5.setBackground(Color.decode("#FE8486"));
			
			JLabel instruccion6 = new JLabel("<html>6.- Seleccionar tu color favorito<html> " ,JLabel.LEFT);
			instruccion6.setFont(new Font("Comic Sans", Font.BOLD,16));
			instruccion6.setSize(500, 50);
			instruccion6.setLocation(10, 190);
			instruccion6.setOpaque(true);
			instruccion6.setForeground(Color.white);
			instruccion6.setBackground(Color.decode("#FE8486"));
			
			JLabel instruccion7 = new JLabel("<html>7.-Hacer click en el boton (Crea Usuario)<html> " ,JLabel.LEFT);
			instruccion7.setFont(new Font("Comic Sans", Font.BOLD,16));
			instruccion7.setSize(500, 50);
			instruccion7.setLocation(10, 220);
			instruccion7.setOpaque(true);
			instruccion7.setForeground(Color.white);
			instruccion7.setBackground(Color.decode("#FE8486"));
			
			JLabel instruccion8 = new JLabel("<html>8.- Listo el usuario se ha creado<html> " ,JLabel.LEFT);
			instruccion8.setFont(new Font("Comic Sans", Font.BOLD,16));
			instruccion8.setSize(500, 50);
			instruccion8.setLocation(10, 250);
			instruccion8.setOpaque(true);
			instruccion8.setForeground(Color.white);
			instruccion8.setBackground(Color.decode("#FE8486"));
			
			JButton btn1 = new JButton("Crear un usuario ahora");
			btn1.setBackground(Color.cyan);
			btn1.setForeground(Color.white);
			btn1.setSize(230,30);
			btn1.setLocation(120,295);
			btn1.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					remove(jp4);
					remove(login());
					anterior = actual;
					actual = "registro";
					
					limpiarVentana();
				}
				
			});
			
			jp4.add(ayudatitulo);
			jpinstrucciones.add(instruccion1);
			jpinstrucciones.add(instruccion2);
			jpinstrucciones.add(instruccion3);
			jpinstrucciones.add(instruccion4);
			jpinstrucciones.add(instruccion5);
			jpinstrucciones.add(instruccion6);
			jpinstrucciones.add(instruccion7);
			jpinstrucciones.add(instruccion8);
			jpinstrucciones.add(btn1);
			
			jp4.add(jpinstrucciones);
			return jp4;
		}
	
	public JPanel Micuenta() {
		anterior = actual;
		actual = "micuenta";
		JLabel bienvenida = new JLabel("<html>Mi cuenta personal<html>" ,JLabel.CENTER);
		bienvenida.setFont(new Font("Comic Sans", Font.BOLD,20));
		bienvenida.setSize(350, 130);
		bienvenida.setLocation(70, 0);
		bienvenida.setOpaque(true);
		bienvenida.setBackground(Color.decode("#FFB4B5"));
		
		JPanel jp5 = new JPanel();
		jp5.setSize(500, 600);
		jp5.setLocation(0, 0);
		jp5.setLayout(null);
		jp5.setBackground(Color.decode("#FFB4B5"));
		
		JLabel image1 = new JLabel();
		image1.setSize(100, 100);
		image1.setLocation(200, 80);
		ImageIcon imagen = new ImageIcon("img/inicio.png");
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(image1.getWidth(), image1.getHeight(), Image.SCALE_DEFAULT));
		image1.setIcon(icono);
		jp5.add(image1);
		
		JLabel tag1R = new JLabel("Nombre: ",JLabel.CENTER);
		tag1R.setSize(250, 20);
		tag1R.setLocation(120, 180);
		tag1R.setOpaque(true);
		tag1R.setBackground(Color.decode("#FFB4B5"));
		tag1R.setForeground(Color.white);
		jp5.add(tag1R);
		
		JTextField nombres = new JTextField("");
		nombres.setSize(250, 40);
		nombres.setLocation(120, 200);
		jp5.add(nombres);
		
		JLabel tag2R = new JLabel("Apellidos: ",JLabel.CENTER);
		tag2R.setSize(250, 20);
		tag2R.setLocation(120, 240);
		tag2R.setOpaque(true);
		tag2R.setBackground(Color.decode("#FFB4B5"));
		tag2R.setForeground(Color.white);
		jp5.add(tag2R);
		
		JTextField apellidos = new JTextField();
		apellidos.setSize(250, 40);
		apellidos.setLocation(120, 260);
		jp5.add(apellidos);
		
		JLabel tag3 = new JLabel("Email: ",JLabel.CENTER);
		tag3.setSize(250, 20);
		tag3.setLocation(120, 300);
		tag3.setOpaque(true);
		tag3.setBackground(Color.decode("#FFB4B5"));
		tag3.setForeground(Color.white);
		jp5.add(tag3);
		
		JTextField correo = new JTextField();
		correo.setSize(250, 40);
		correo.setLocation(120, 320);
		jp5.add(correo);
		
		JLabel tag4 = new JLabel("Contraseña: ",JLabel.CENTER);
		tag4.setSize(250, 20);
		tag4.setLocation(120, 360);
		tag4.setOpaque(true);
		tag4.setBackground(Color.decode("#FFB4B5"));
		tag4.setForeground(Color.white);
		jp5.add(tag4);
		
		JPasswordField contraseña = new JPasswordField();
		contraseña.setSize(250, 40);
		contraseña.setLocation(120, 380);
		jp5.add(contraseña);
		
		
		JButton btnVolver = new JButton("Cancelar");
		btnVolver.setSize(100, 30);
		btnVolver.setLocation(120, 450);
		btnVolver.setBackground(Color.red);
		btnVolver.setForeground(Color.white);
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "cuenta";
				
				limpiarVentana();
			}
			
		});
		
		JButton btnActualizar = new JButton("Actualizar datos");
		btnActualizar.setSize(140, 30);
		btnActualizar.setLocation(230, 450);
		btnActualizar.setBackground(Color.blue);
		btnActualizar.setForeground(Color.white);

		btnActualizar.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Leer los datos del archivo users.txt y guardarlos en un ArrayList de objetos Usuario
		        ArrayList<Usuario> usuarios = new ArrayList<>();
		        try {
		            BufferedReader br = new BufferedReader(new FileReader("users.txt"));
		            String line;
		            while ((line = br.readLine()) != null) {
		                String[] data = line.split(",");
		                Usuario user = new Usuario(data[0], data[1], data[2], data[3]);
		                usuarios.add(user);
		            }
		            br.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		        
		        // Obtener los nuevos datos del formulario
		        String nombre = nombres.getText();
		        String apellido = apellidos.getText();
		        String email = correo.getText();
		        String password = new String(contraseña.getPassword());
		        
		        // Actualizar los datos del objeto Usuario correspondiente
		        boolean encontrado = false;
		        for (Usuario user : usuarios) {
		            if (user.getCorreo().equals(email)) {
		                user.setNombre(nombre);
		                user.setApellidos(apellido);
		                user.setContraseña(password);
		                encontrado = true;
		                break;
		            }
		        }
		        
		        // Escribir los nuevos datos en el archivo users.txt
		        try {
		            PrintWriter pw = new PrintWriter(new FileWriter("users.txt"));
		            for (Usuario user : usuarios) {
		                pw.println(user.toString());
		            }
		            pw.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "La información no se ha podido actualizar", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        if (encontrado) {
		            // Limpiar los campos del formulario
		            nombres.setText("");
		            apellidos.setText("");
		            correo.setText("");
		            contraseña.setText("");
		            
		            JOptionPane.showMessageDialog(null, "Informacion Actulizada", "Correcto", JOptionPane.INFORMATION_MESSAGE);
		        } else {
		            JOptionPane.showMessageDialog(null, "No se encontró ningún usuario con ese correo electrónico.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});

		jp5.add(btnActualizar);
		jp5.add(btnVolver);
		jp5.add(bienvenida);
		return jp5;
	}
	
	public JPanel tabla() {
		anterior = actual;
	    actual = "tabla";
	    JLabel bienvenida = new JLabel("<html>Lista de usuarios<html>", JLabel.CENTER);
	    bienvenida.setFont(new Font("Comic Sans", Font.BOLD, 20));
	    bienvenida.setSize(350, 100);
	    bienvenida.setLocation(70, 0);
	    bienvenida.setOpaque(true);
	    bienvenida.setForeground(Color.white);
	    bienvenida.setBackground(Color.decode("#FFB4B5"));

	    JPanel jp6 = new JPanel();
	    jp6.setSize(500, 600);
	    jp6.setLocation(0, 0);
	    jp6.setLayout(null);
	    jp6.setBackground(Color.decode("#FFB4B5"));

	    JLabel edit = new JLabel("<html>Editar<html>", JLabel.LEFT);
	    edit.setFont(new Font("Comic Sans", Font.BOLD, 16));
	    edit.setSize(350, 130);
	    edit.setLocation(50, 60);
	    edit.setOpaque(true);
	    edit.setForeground(Color.white);
	    edit.setBackground(Color.decode("#FFB4B5"));

	    JComboBox<String> lista = new JComboBox();
	    lista.setSize(350, 30);
	    lista.setLocation(50, 150);
	    lista.setOpaque(true);
	    lista.setBackground(Color.white);
	    lista.setForeground(Color.black);

	    ArrayList<String> nombresUsuarios = new ArrayList<>();
	    try {
	        BufferedReader br = new BufferedReader(new FileReader("users.txt"));
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] data = line.split(",");
	            nombresUsuarios.add(data[0]);
	        }
	        br.close();
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }

	    for (String nombre : nombresUsuarios) {
	        lista.addItem(nombre);
	    }
	    
	    usuarioSeleccionado = (String) lista.getSelectedItem();
	    JButton editarUsuario = new JButton("Editar a " + usuarioSeleccionado);
	    editarUsuario.setSize(150, 30);
	    editarUsuario.setLocation(50, 190);
	    jp6.add(editarUsuario);

	    lista.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            usuarioSeleccionado = (String) lista.getSelectedItem();
	            editarUsuario.setText("Editar a " + usuarioSeleccionado);
	            editarUsuario.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "micuenta";
						remove(jp6);
						limpiarVentana();
					}
	            	
	            });
	        }
	    });
	    
	    
	    
	    
	    jp6.add(lista);
	    jp6.add(bienvenida);
	    jp6.add(edit);
	    return jp6;
	}
}
