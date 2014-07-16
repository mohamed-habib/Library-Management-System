package fcis;

import Connection.Connectins;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class Update extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3670980451358207027L;
	Connectins conn = new Connectins();
	private JPanel contentPane;
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JLabel lblNewJgoodiesTitle = DefaultComponentFactory
			.getInstance().createTitle("Id");
	private final JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory
			.getInstance().createTitle("Name");
	private final JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory
			.getInstance().createTitle("Author");
	private final JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory
			.getInstance().createTitle("Edition");
	private final JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory
			.getInstance().createTitle("Release Date");
	private final JLabel lblNewJgoodiesTitle_5 = DefaultComponentFactory
			.getInstance().createTitle("Publisher");
	private final JRadioButton rdbtnNewRadioButton = new JRadioButton("Id");
	private final JTextField textField_6 = new JTextField();
	private final JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Name");
	private final JTextField textField_7 = new JTextField();
	private final JLabel lblNewJgoodiesTitle_6 = DefaultComponentFactory
			.getInstance()
			.createTitle(
					"Please check the key youwant youpdate with and then enter the values you want to edite");
	private final JButton btnNewButton = new JButton("Update");
	private final JButton btnNewButton_1 = new JButton("Cancel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Update() {
		textField_7.setBounds(446, 77, 86, 20);
		textField_7.setColumns(10);
		textField_6.setBounds(188, 77, 96, 20);
		textField_6.setColumns(10);
		textField_5.setBounds(559, 221, 96, 20);
		textField_5.setColumns(10);
		textField_4.setBounds(331, 226, 96, 20);
		textField_4.setColumns(10);
		textField_3.setBounds(98, 226, 96, 20);
		textField_3.setColumns(10);
		textField_2.setBounds(559, 175, 96, 20);
		textField_2.setColumns(10);
		textField_1.setBounds(331, 175, 96, 20);
		textField_1.setColumns(10);
		textField.setBounds(98, 175, 96, 20);
		textField.setColumns(10);
		textField.setVisible(false);
		textField_1.setVisible(false);
		textField_2.setVisible(false);
		textField_3.setVisible(false);
		textField_4.setVisible(false);
		textField_5.setVisible(false);
		textField_6.setVisible(false);
		textField_7.setVisible(false);
		lblNewJgoodiesTitle.setVisible(false);
		lblNewJgoodiesTitle_1.setVisible(false);
		lblNewJgoodiesTitle_2.setVisible(false);
		lblNewJgoodiesTitle_3.setVisible(false);
		lblNewJgoodiesTitle_4.setVisible(false);
		lblNewJgoodiesTitle_5.setVisible(false);
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField.setEditable(false);
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 412);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		contentPane.add(textField);

		contentPane.add(textField_1);

		contentPane.add(textField_2);

		contentPane.add(textField_3);

		contentPane.add(textField_4);

		contentPane.add(textField_5);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesTitle.setBounds(42, 176, 88, 14);

		contentPane.add(lblNewJgoodiesTitle);
		lblNewJgoodiesTitle_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesTitle_1.setBounds(233, 176, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_1);
		lblNewJgoodiesTitle_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesTitle_2.setBounds(461, 176, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_2);
		lblNewJgoodiesTitle_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesTitle_3.setBounds(42, 227, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_3);
		lblNewJgoodiesTitle_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesTitle_4.setBounds(233, 227, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_4);
		lblNewJgoodiesTitle_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewJgoodiesTitle_5.setBounds(461, 222, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_5);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!rdbtnNewRadioButton.isSelected()
						&& !rdbtnNewRadioButton_1.isSelected()) {
					textField.setVisible(false);
					textField_1.setVisible(false);
					textField_2.setVisible(false);
					textField_3.setVisible(false);
					textField_4.setVisible(false);
					textField_5.setVisible(false);
					textField_6.setVisible(false);
					textField_7.setVisible(false);
					lblNewJgoodiesTitle.setVisible(false);
					lblNewJgoodiesTitle_1.setVisible(false);
					lblNewJgoodiesTitle_2.setVisible(false);
					lblNewJgoodiesTitle_3.setVisible(false);
					lblNewJgoodiesTitle_4.setVisible(false);
					lblNewJgoodiesTitle_5.setVisible(false);

				} else if (rdbtnNewRadioButton.isSelected()) {
					rdbtnNewRadioButton_1.setSelected(false);
					textField.setVisible(true);
					textField_1.setVisible(true);
					textField_2.setVisible(true);
					textField_3.setVisible(true);
					textField_4.setVisible(true);
					textField_5.setVisible(true);
					textField_6.setVisible(true);
					textField_7.setVisible(false);
					lblNewJgoodiesTitle.setVisible(true);
					lblNewJgoodiesTitle_1.setVisible(true);
					lblNewJgoodiesTitle_2.setVisible(true);
					lblNewJgoodiesTitle_3.setVisible(true);
					lblNewJgoodiesTitle_4.setVisible(true);
					lblNewJgoodiesTitle_5.setVisible(true);

				}
			}
		});
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton.setBounds(123, 74, 46, 23);

		contentPane.add(rdbtnNewRadioButton);

		contentPane.add(textField_6);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (!rdbtnNewRadioButton.isSelected()
						&& !rdbtnNewRadioButton_1.isSelected()) {
					textField.setVisible(false);
					textField_1.setVisible(false);
					textField_2.setVisible(false);
					textField_3.setVisible(false);
					textField_4.setVisible(false);
					textField_5.setVisible(false);
					textField_6.setVisible(false);
					textField_7.setVisible(false);
					lblNewJgoodiesTitle.setVisible(false);
					lblNewJgoodiesTitle_1.setVisible(false);
					lblNewJgoodiesTitle_2.setVisible(false);
					lblNewJgoodiesTitle_3.setVisible(false);
					lblNewJgoodiesTitle_4.setVisible(false);
					lblNewJgoodiesTitle_5.setVisible(false);

				} else if (rdbtnNewRadioButton_1.isSelected()) {
					rdbtnNewRadioButton.setSelected(false);
					textField.setVisible(true);
					textField_1.setVisible(true);
					textField_2.setVisible(true);
					textField_3.setVisible(true);
					textField_4.setVisible(true);
					textField_5.setVisible(true);
					textField_6.setVisible(false);
					textField_7.setVisible(true);
					lblNewJgoodiesTitle.setVisible(true);
					lblNewJgoodiesTitle_1.setVisible(true);
					lblNewJgoodiesTitle_2.setVisible(true);
					lblNewJgoodiesTitle_3.setVisible(true);
					lblNewJgoodiesTitle_4.setVisible(true);
					lblNewJgoodiesTitle_5.setVisible(true);
				}
			}
		});
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnNewRadioButton_1.setBounds(362, 74, 65, 23);

		contentPane.add(rdbtnNewRadioButton_1);

		contentPane.add(textField_7);
		lblNewJgoodiesTitle_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewJgoodiesTitle_6.setBounds(72, 21, 613, 23);

		contentPane.add(lblNewJgoodiesTitle_6);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnNewRadioButton.isSelected()) {
					String id = textField_6.getText();
					String[][] fields = conn.Search("id", id, "books");
					String[] textfields = new String[6];
					textfields[0] = textField.getText();
					textfields[1] = textField_1.getText();
					textfields[2] = textField_2.getText();
					textfields[3] = textField_3.getText();
					textfields[4] = textField_4.getText();
					textfields[5] = textField_5.getText();
					for (int i = 0; i < 6; i++) {
						if (textfields[i].equalsIgnoreCase(""))
							textfields[i] = fields[0][i];
						else
							System.out.println(textfields[i]);
					}

					conn.Update(id, textfields[1], textfields[2],
							textfields[3], textfields[4], textfields[5]);
				} else if (rdbtnNewRadioButton_1.isSelected()) {
					String name = textField_7.getText();
					String[][] fields = conn.Search("name", name, "books");
					String[] textfields = new String[6];
					textfields[0] = textField.getText();
					textfields[1] = textField_1.getText();
					textfields[2] = textField_2.getText();
					textfields[3] = textField_3.getText();
					textfields[4] = textField_4.getText();
					textfields[5] = textField_5.getText();
					for (int i = 0; i < 6; i++) {
						if (textfields[i].equalsIgnoreCase(""))
							textfields[i] = fields[0][i];
						else
							System.out.println(textfields[i]);
					}

					conn.Update(fields[0][0], textfields[1], textfields[2],
							textfields[3], textfields[4], textfields[5]);
				}

			}
		});
		btnNewButton.setBounds(264, 322, 89, 23);

		contentPane.add(btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(460, 322, 89, 23);

		contentPane.add(btnNewButton_1);
	}
}
