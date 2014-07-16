/**
 *LoginScreen.java
 * @author Mohamed Habib
 * fcis package
 * 
 * This class makes a window that asks for username and password and enters the system normally if the username and password are correct  
 * 
 */

package fcis;
import Connection.Connectins;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginScreen extends JFrame {
  Connectins conn=new Connectins();
	private JLabel lblNewLabel_1;
	private JLabel userNameLabel;
	private JButton loginButton;
	private JLabel lblPassword;

	private JPanel contentPane;
	private JTextField userNameField;
	private JPasswordField passwordField;

	private Icon image = new ImageIcon("pic");
	private JLabel label = new JLabel(image);

	private JButton exitButton;
	private WelcomeScreen welcomeScreen;

	public static String userName ;
	public static String password ;

	private Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

	public LoginScreen() {
		super("Login Screen");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		setBounds((screen.width - 500) / 2, (screen.height - 350) / 2, 450, 300);

		Init();

		Add();

		Action();
	}

	public  String getUsername() {
		return userName;
	}

	private void Init() {

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel_1 = new JLabel("Welcome to Login Screen");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 11));
		lblNewLabel_1.setBounds(153, 0, 146, 49);

		userNameLabel = new JLabel("User Name:");
		userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		userNameLabel.setBounds(73, 74, 71, 29);

		userNameField = new JTextField();
		userNameField.setBackground(Color.WHITE);
		userNameField.setForeground(Color.BLACK);
		userNameField.setBounds(161, 78, 121, 20);
		userNameField.setColumns(10);

		loginButton = new JButton("Login");
		loginButton.setBackground(Color.WHITE);
		loginButton.setBounds(182, 160, 89, 23);

		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPassword.setBounds(73, 114, 71, 29);

		passwordField = new JPasswordField();
		passwordField.setBackground(Color.WHITE);
		passwordField.setForeground(Color.BLACK);
		passwordField.setColumns(10);
		passwordField.setBounds(161, 118, 121, 20);

		exitButton = new JButton("Exit");
		exitButton.setBounds(345, 198, 89, 23);

	}

	private void Add() {
	
		contentPane.add(lblNewLabel_1);
		contentPane.add(label);
		contentPane.add(userNameLabel);
		contentPane.add(userNameField);
		contentPane.add(loginButton);
		contentPane.add(lblPassword);
		contentPane.add(passwordField);
		contentPane.add(exitButton);

	}

	private void Action() {

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				password = passwordField.getText();
				userName = userNameField.getText();
				String realpass=conn.Login(userName);
				

				if (password.equalsIgnoreCase(realpass)) {

					JOptionPane.showMessageDialog(null, "Welcome " + userName
							+ " To Library Management System! ");
					
					dispose();
					welcomeScreen = new WelcomeScreen();
					welcomeScreen.setVisible(true);
				}

				else {
					JOptionPane.showMessageDialog(null,
							"Wrong User Name Or Password! ");
					password = "";
					userName = "";
				}
			}
		});

		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Class.Exit();
			}
		});

	}

}
