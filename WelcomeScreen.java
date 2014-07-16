/**
 * WelcomeScreen.java
 * 
 */

package fcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WelcomeScreen extends JFrame {

	private JLabel lblWelcome;
	private JButton btnBooks, btnBorrowers, btnVisitors, btnWarnings, btnExit,
			btnLogout;
	private JLabel lblFor, lblForInsertingModifying,
			lblForInsertingModifying_1, lblForInsertingModifying_2;

	private JPanel contentPane;

	private String userName = LoginScreen.userName;

	public WelcomeScreen() {

		setVisible(true);
		setBounds(100, 100, 642, 490);
		setResizable(false);

		Init();

		Add();

		Action();

	}

	private void Init() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblWelcome = new JLabel("Welcome " + userName);
		lblWelcome.setBounds(10, 11, 200, 20);

		btnBooks = new JButton("Books");
		btnBooks.setBounds(345, 95, 89, 23);

		btnBorrowers = new JButton("Borrowers");
		btnBorrowers.setBounds(345, 145, 89, 23);

		btnVisitors = new JButton("Visitors");
		btnVisitors.setBounds(345, 206, 89, 23);

		btnWarnings = new JButton("Warnings");
		btnWarnings.setBounds(345, 269, 89, 23);

		btnExit = new JButton("Exit");
		btnExit.setBounds(527, 405, 89, 23);

		btnLogout = new JButton("Logout");
		btnLogout.setBounds(527, 10, 89, 23);

		lblFor = new JLabel(
				"For Inserting, Modifying, Retrieving, Books Data: ");
		lblFor.setBounds(10, 99, 300, 14);

		lblForInsertingModifying = new JLabel(
				"For Inserting, Modifying, Retrieving, Borrowers Data: ");
		lblForInsertingModifying.setBounds(10, 149, 300, 14);

		lblForInsertingModifying_1 = new JLabel(
				"For Inserting, Modifying, Retrieving, Visitors Data: ");
		lblForInsertingModifying_1.setBounds(10, 210, 300, 14);

		lblForInsertingModifying_2 = new JLabel(
				"For Inserting, Modifying, Retrieving, Warnings: ");
		lblForInsertingModifying_2.setBounds(10, 273, 300, 14);

	}

	private void Add() {
		contentPane.add(lblWelcome);
		contentPane.add(btnBooks);
		contentPane.add(btnBorrowers);
		contentPane.add(btnVisitors);
		contentPane.add(btnWarnings);
		contentPane.add(btnExit);
		contentPane.add(btnLogout);
		contentPane.add(lblFor);
		contentPane.add(lblForInsertingModifying);
		contentPane.add(lblForInsertingModifying_1);
		contentPane.add(lblForInsertingModifying_2);

	}

	private void Action() {
		btnBooks.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				Class.books();
			}
		});

		btnVisitors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				Class.visitors();

			}
		});

		btnBorrowers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				Class.borrowers();

			}
		});

		btnWarnings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				Class.warnings();

			}
		});

		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dispose();
				Class.Logout();
			}
		});

		btnExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				dispose();
				Class.Exit();
			}
		});

	}

}
