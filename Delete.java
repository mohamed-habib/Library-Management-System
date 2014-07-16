
package fcis;

import Connection.Connectins;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Delete extends JFrame {

	protected JPanel contentPane;
	protected JTextField textField = new JTextField();
	protected JTextField textField_1 = new JTextField();
	protected JLabel lblNewJgoodiesTitle = DefaultComponentFactory
			.getInstance()
			.createTitle(
					"Please chose one key and enter the value you wnt to delete");
	protected JRadioButton rdbtnNewRadioButton = new JRadioButton("ID");
	protected JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Name");
	protected JButton btnNewButton = new JButton("Delete");
	protected JButton btnNewButton_1 = new JButton("Cancel");
	private String screen;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Delete(String s) {
		textField_1.setVisible(false);
		textField.setVisible(false);
		textField_1.setBounds(243, 122, 109, 33);
		textField_1.setColumns(10);
		textField.setBounds(6, 122, 86, 33);
		textField.setColumns(10);
		screen = s;
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 234);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(textField);

		contentPane.add(textField_1);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewJgoodiesTitle.setBounds(49, 24, 459, 14);

		contentPane.add(lblNewJgoodiesTitle);
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!rdbtnNewRadioButton.isSelected()
						&& !rdbtnNewRadioButton_1.isSelected()) {
					textField.setVisible(false);
					textField_1.setVisible(false);
				} else {
					rdbtnNewRadioButton_1.setSelected(false);
					textField.setVisible(true);
					textField_1.setVisible(false);
				}
			}
		});
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(6, 67, 46, 23);

		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!rdbtnNewRadioButton.isSelected()
						&& !rdbtnNewRadioButton_1.isSelected()) {
					textField.setVisible(false);
					textField_1.setVisible(false);
				} else {
					rdbtnNewRadioButton.setSelected(false);
					textField_1.setVisible(true);
					textField.setVisible(false);
				}
			}
		});
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setBounds(243, 69, 76, 23);

		contentPane.add(rdbtnNewRadioButton_1);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Connectins conn = new Connectins();
				if (rdbtnNewRadioButton.isSelected())

				{
					if (screen.equalsIgnoreCase("books")) {
						conn.Delete("id", textField.getText(), "books");
					} else if (screen.equalsIgnoreCase("Borrowers")) {
						conn.Delete("id", textField.getText(), "borrow");
					} else if (screen.equalsIgnoreCase("Visitors")) {
						conn.Delete("id", textField.getText(), "guest");
					}

				} else if (rdbtnNewRadioButton_1.isSelected()) {
					if (screen.equalsIgnoreCase("books")) {
						conn.Delete("Name", textField_1.getText(), "books");
					} else if (screen.equalsIgnoreCase("Borrowers")) {
						conn.Delete("Name", textField_1.getText(), "borrow");
					} else if (screen.equalsIgnoreCase("Visitors")) {
						conn.Delete("Name", textField_1.getText(), "guest");
					}

				}

			}

		});
		btnNewButton.setBounds(451, 71, 89, 23);

		contentPane.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(451, 146, 89, 23);

		contentPane.add(btnNewButton_1);
	}
}
