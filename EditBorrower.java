/**
*EditBorrower.java
*
*
**/
package fcis;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditBorrower extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewJgoodiesTitle = DefaultComponentFactory
			.getInstance().createTitle("Please choose a key to edite with");
	private final JComboBox comboBox = new JComboBox();
	private final JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory
			.getInstance().createTitle("Key");
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JTextField textField_4 = new JTextField();
	private final JTextField textField_5 = new JTextField();
	private final JTextField textField_6 = new JTextField();
	private final JTextField textField_7 = new JTextField();
	private final JTextField textField_8 = new JTextField();
	private final JTextField textField_9 = new JTextField();
	private final JTextField textField_10 = new JTextField();
	private final JTextField textField_11 = new JTextField();
	private final JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory
			.getInstance().createTitle("Book Id :");
	private final JLabel lblNewJgoodiesTitle_3 = DefaultComponentFactory
			.getInstance().createTitle("Name :");
	private final JLabel lblNewJgoodiesTitle_4 = DefaultComponentFactory
			.getInstance().createTitle("SNN :\r\n");
	private final JLabel lblNewJgoodiesTitle_5 = DefaultComponentFactory
			.getInstance().createTitle("Date of Borrow:");
	private final JLabel lblNewJgoodiesTitle_6 = DefaultComponentFactory
			.getInstance().createTitle("Date of Return:");
	private final JLabel lblReturned = DefaultComponentFactory.getInstance()
			.createTitle("Returned :");
	private final JLabel lblNewJgoodiesTitle_7 = DefaultComponentFactory
			.getInstance().createTitle("Returned:");
	private final JLabel lblNewJgoodiesTitle_8 = DefaultComponentFactory
			.getInstance().createTitle("Phone :");
	private final JLabel lblAdress = DefaultComponentFactory.getInstance()
			.createTitle("Adress :");
	private final JLabel lblNewJgoodiesTitle_9 = DefaultComponentFactory
			.getInstance().createTitle("Email :");
	private final JLabel lblNewJgoodiesTitle_10 = DefaultComponentFactory
			.getInstance().createTitle("Faculty :");
	private final JLabel lblClass = DefaultComponentFactory.getInstance()
			.createTitle("Class :");
	private final JButton btnSave = new JButton("Save");
	private final JButton btnNewButton = new JButton("Cancel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditBorrower frame = new EditBorrower();
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
	public EditBorrower() {
		textField_11.setBounds(256, 148, 86, 20);
		textField_11.setColumns(10);
		textField_10.setBounds(89, 148, 86, 20);
		textField_10.setColumns(10);
		textField_9.setBounds(366, 117, 86, 20);
		textField_9.setColumns(10);
		textField_8.setBounds(223, 117, 86, 20);
		textField_8.setColumns(10);
		textField_7.setBounds(65, 86, 86, 20);
		textField_7.setColumns(10);
		textField_6.setBounds(366, 86, 86, 20);
		textField_6.setColumns(10);
		textField_5.setBounds(223, 86, 86, 20);
		textField_5.setColumns(10);
		textField_4.setBounds(65, 117, 86, 20);
		textField_4.setColumns(10);
		textField_3.setBounds(366, 55, 86, 20);
		textField_3.setColumns(10);
		textField_2.setBounds(223, 55, 86, 20);
		textField_2.setColumns(10);
		textField_1.setBounds(65, 55, 86, 20);
		textField_1.setColumns(10);
		textField.setBounds(348, 9, 104, 20);
		textField.setColumns(10);
		initGUI();
	}

	private void initGUI() {
		setTitle("Edit Borrower");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewJgoodiesTitle.setBounds(10, 11, 218, 14);

		contentPane.add(lblNewJgoodiesTitle);
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "ID", "Name" }));
		comboBox.setBounds(268, 9, 70, 20);

		contentPane.add(comboBox);
		lblNewJgoodiesTitle_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewJgoodiesTitle_1.setBounds(238, 11, 31, 14);

		contentPane.add(lblNewJgoodiesTitle_1);

		contentPane.add(textField);

		contentPane.add(textField_1);

		contentPane.add(textField_2);

		contentPane.add(textField_3);

		contentPane.add(textField_4);

		contentPane.add(textField_5);

		contentPane.add(textField_6);

		contentPane.add(textField_7);

		contentPane.add(textField_8);

		contentPane.add(textField_9);

		contentPane.add(textField_10);

		contentPane.add(textField_11);
		lblNewJgoodiesTitle_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewJgoodiesTitle_2.setBounds(10, 58, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_2);
		lblNewJgoodiesTitle_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewJgoodiesTitle_3.setBounds(161, 57, 80, 14);

		contentPane.add(lblNewJgoodiesTitle_3);
		lblNewJgoodiesTitle_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewJgoodiesTitle_4.setBounds(319, 57, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_4);
		lblNewJgoodiesTitle_5.setBounds(10, 151, 80, 14);

		contentPane.add(lblNewJgoodiesTitle_5);
		lblNewJgoodiesTitle_6.setBounds(178, 151, 80, 14);

		contentPane.add(lblNewJgoodiesTitle_6);
		lblReturned.setBounds(268, 151, 88, 14);

		contentPane.add(lblReturned);
		lblNewJgoodiesTitle_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewJgoodiesTitle_7.setBounds(309, 119, 57, 14);

		contentPane.add(lblNewJgoodiesTitle_7);
		lblNewJgoodiesTitle_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewJgoodiesTitle_8.setBounds(10, 92, 57, 14);

		contentPane.add(lblNewJgoodiesTitle_8);
		lblAdress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdress.setBounds(161, 86, 88, 14);

		contentPane.add(lblAdress);
		lblNewJgoodiesTitle_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewJgoodiesTitle_9.setBounds(319, 89, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_9);
		lblNewJgoodiesTitle_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewJgoodiesTitle_10.setBounds(10, 120, 88, 14);

		contentPane.add(lblNewJgoodiesTitle_10);
		lblClass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClass.setBounds(161, 120, 88, 14);

		contentPane.add(lblClass);
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setBounds(268, 199, 80, 23);

		contentPane.add(btnSave);
		btnNewButton.setBounds(363, 199, 89, 23);

		contentPane.add(btnNewButton);
	}
}
