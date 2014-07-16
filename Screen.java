/**
 * Screen.java
 * this class is used as a parent to make 4 child Classes from it, 
 * @author Mohamed Habib
 */

package fcis;

import java.sql.Connection;

//table & compoBox 
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Connection.Connectins;

public abstract class Screen extends JFrame {
	Connectins conn = new Connectins();

	protected JComboBox comboBox;

	protected JMenuBar menuBar;

	protected JMenu screenMenu;
	protected JMenuItem bookItem, visitorItem, borrowerItem, warningsItem;

	protected JMenu fileMenu;
	protected JMenuItem aboutItem, exitItem;

	protected JButton btnBack;
	protected JPanel panel; // contains @head label
	protected JPanel panel1;// contains @btnModify, @btnAdd, @btnDelete,
							// @lblSearch, @comboBox, @searchField and
							// @btnSearch
	protected JPanel panel2;// contains @labels and @textfields

	protected JLabel lblhead;

	protected JButton btnModify, btnAdd, btnDelete, btnSearch;
	protected JButton btnSave;
	protected JLabel lblSearch;

	protected JTable table;
	protected JScrollPane scrollPane;

	protected JPanel contentPane;
	protected JTextField searchField;

	protected String head;
	protected String[] str;
	protected String searchType;

	public JTextField[] textFields;
	public JLabel[] labels;

	/**
	 * Constructor
	 * 
	 * 
	 * @param h
	 *            a string contains the header of each screen that inherits from
	 *            this parent
	 * @param s
	 *            array of strings contains the Text that will be put in the
	 *            labels and combo box
	 * @param x
	 *            integer contains the number of the text fields and labels
	 */
	public Screen(String h, String[] s, int x) {
		head = h;
		str = new String[s.length];
		str = s;

		textFields = new JTextField[x];
		labels = new JLabel[x];

		for (int i = 0; i < x; i++) {
			textFields[i] = new JTextField();
			labels[i] = new JLabel();
		}
		textFields[0].setEditable(false);
		setVisible(true);
		// setBounds(100, 100, 900, 900);

		setBounds(100, 100, 878, 559);

		setResizable(false);

		Init();

		Add();

		Action();

	}

	/**
	 * A getter method to return the values of a private array of strings
	 * 
	 * 
	 * @param i
	 *            : the index of the string to return
	 * @return a string of index i
	 */
	public String getStr(int i) {

		return str[i];
	}

	public String[] getStrArr() {

		return str;
	}

	/**
	 * Collects all the Action listeners in the class
	 * 
	 * 
	 * 
	 */
	private void Action() {
		bookItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				if (head != "Book") {

					dispose();
					Class.books();

				}
			}
		});

		visitorItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				if (head != "Visitors") {
					dispose();

					Class.visitors();
				}
			}
		});

		borrowerItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				if (head != "Borrowers") {
					dispose();

					Class.borrowers();
				}
			}
		});

		warningsItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				if (head != "Warnings") {
					dispose();

					Class.warnings();
				}
			}
		});

		aboutItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				JOptionPane
						.showMessageDialog(
								null,
								" This Project Was Created By\nMohamed Habib\nMahmoud Omara\nMahmoud Numan\nMostafa Zaghlol ");
			}
		});

		exitItem.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				dispose();
				Class.Exit();
			}
		});

		// //////////////**********************************////////////////////////

		btnAdd.addActionListener(new ActionListener() {
			String[] additems = new String[6];

			public void actionPerformed(ActionEvent arg0) {
				if (head == "Books") {
					for (int i = 0; i < str.length; i++) {
						additems[i] = textFields[i].getText();
					}
					conn.AddBook(additems[1], additems[2], additems[3],
							additems[4], additems[5]);

					table(conn.BooksView());
					for (int j = 0; j < str.length; j++) {
						textFields[j].setText("");

					}
				} else if (head == "Borrowers") {

					conn.AddBorrower(textFields[1].getText(),
							textFields[2].getText(), textFields[3].getText(),
							textFields[4].getText(), textFields[5].getText(),
							textFields[6].getText(), textFields[8].getText(),
							textFields[9].getText());
					table(conn.Borrow());
					for (int j = 0; j < str.length; j++) {
						textFields[j].setText("");

					}

				} else if (head == "Visitors") {

					conn.Addvisitor(textFields[1].getText(),
							textFields[2].getText(), textFields[3].getText(),
							textFields[4].getText());
					table(conn.VisitorsView());
					for (int j = 0; j < str.length; j++) {
						textFields[j].setText("");

					}
				}

			}
		});

		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

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

		});

		btnSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (head.equalsIgnoreCase("books")) {
					table(conn.BooksView());
				} else if (head.equalsIgnoreCase("Borrowers")) {
					table(conn.Borrow());
				} else if (head.equalsIgnoreCase("Visitors")) {
					table(conn.VisitorsView());
				}

			}
		});

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Delete frame = new Delete(head);
							frame.setVisible(true);
							// Class.getBook().table(conn.BooksView());

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				Class.getBook().table(conn.BooksView());
			}

		});

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String key = comboBox.getSelectedItem().toString();
				String value = searchField.getText();

				// Books b=new Books(conn.Search(key, value, "books"));
				SearchResults search = new SearchResults(key, value, head, str,
						str.length);
				searchField.setText(null);

			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Class.Back();
			}
		});

		getComboBox().addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent event) {

				if (event.getStateChange() == ItemEvent.SELECTED) {
					searchType = str[getComboBox().getSelectedIndex()];

				}
			}
		});

	}

	/*
	 * public void actionPerformed(ActionEvent event) {
	 * 
	 * 
	 * if (event.getSource() == bookItem) { if (head != "Borrowers") {
	 * dispose(); Class.borrowers(); } }
	 * 
	 * if (event.getSource() == visitorItem) { if (head != "Visitors") {
	 * 
	 * dispose(); Class.visitors(); } }
	 * 
	 * if (event.getSource() == warningsItem) { if (head != "Visitors") {
	 * 
	 * dispose(); Class.warnings(); } }
	 * 
	 * if (event.getSource() == aboutItem) { JOptionPane.showMessageDialog(null,
	 * " This Project Was Created By\nMohamed Habib\nMahmoud Omara\nMahmoud Numan\nMostafa Zaghlol "
	 * ); }
	 * 
	 * 
	 * if (event.getSource() == exitItem) { dispose(); Class.Exit(); }
	 * 
	 * if (event.getSource() == btnAdd){
	 * 
	 * 
	 * }
	 * 
	 * if (event.getSource() == btnModify){
	 * 
	 * 
	 * }
	 * 
	 * if (event.getSource() == btnDelete){
	 * 
	 * 
	 * }
	 * 
	 * if (event.getSource() == btnSave){
	 * 
	 * 
	 * }
	 * 
	 * if (event.getSource() == btnSearch){
	 * 
	 * 
	 * }
	 * 
	 * if (event.getSource() == btnBack){
	 * 
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	/**
	 * Collects all initialization in the class
	 * 
	 * 
	 * 
	 */

	public void Init() {

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		screenMenu = new JMenu("Choose Screen");
		screenMenu.setMnemonic('C');

		bookItem = new JMenuItem("Book");
		bookItem.setMnemonic('B');
		visitorItem = new JMenuItem("Visitor");
		visitorItem.setMnemonic('V');
		borrowerItem = new JMenuItem("Borrower");
		borrowerItem.setMnemonic('E');
		warningsItem = new JMenuItem("Warnings");
		warningsItem.setMnemonic('W');

		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		aboutItem = new JMenuItem("About....");
		aboutItem.setMnemonic('A');
		exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('E');

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);// maybe init or add

		btnBack = new JButton("Back");
		btnBack.setBounds(0, 476, 89, 23);

		panel = new JPanel();
		panel.setBounds(0, 0, 862, 31);
		panel.setLayout(null);

		lblhead = new JLabel(head);
		lblhead.setBounds(412, 2, 90, 40);
		lblhead.setFont(UIManager.getFont("MenuBar.font"));

		panel1 = new JPanel();
		panel1.setBounds(0, 76, 862, 31);
		panel1.setLayout(null);

		btnModify = new JButton("Edit");
		btnModify.setBounds(229, 5, 107, 23);
		btnAdd = new JButton("Add");
		btnAdd.setBounds(0, 5, 107, 23);
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(117, 5, 102, 23);
		btnSave = new JButton("Refresh");
		btnSave.setBounds(346, 5, 107, 23);
		lblSearch = new JLabel("Search:");
		lblSearch.setFont(UIManager.getFont("Label.font"));
		lblSearch.setBounds(471, 9, 55, 14);
		String s[] = { "ID", "Name" };
		setComboBox(new JComboBox(s));
		// comboBox.setModel(new DefaultComboBoxModel( str));
		getComboBox().setBounds(536, 6, 80, 20);

		searchField = new JTextField();
		searchField.setBounds(622, 6, 131, 20);
		searchField.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(763, 5, 89, 23);

		panel2 = new JPanel();
		panel2.setBounds(0, 111, 862, 100);
		panel2.setLayout(null);

		String[] k = str;
		String[][] l = conn.BooksView();
		// table( l);
	}

	void table(String[][] d) {

		setTable(new JTable());
		Object rowData[][] = d;
		Object columnNames[] = str;

		setTable(new JTable(rowData, columnNames));

		scrollPane = new JScrollPane(getTable());

		scrollPane.setBounds(0, 279, 862, 190);

		contentPane.add(scrollPane);

	}

	/**
	 * Collects all adding methods in the class
	 * 
	 * 
	 * 
	 * 
	 */
	public void Add() {
		menuBar.add(screenMenu);
		screenMenu.add(bookItem);
		screenMenu.add(visitorItem);
		screenMenu.add(borrowerItem);
		screenMenu.add(warningsItem);

		menuBar.add(fileMenu);
		fileMenu.add(aboutItem);
		fileMenu.add(exitItem);

		contentPane.add(btnBack);
		contentPane.add(panel);
		panel.add(lblhead);
		contentPane.add(panel1);

		panel1.add(btnModify);
		panel1.add(btnAdd);
		panel1.add(btnDelete);
		panel1.add(btnSave);
		panel1.add(lblSearch);
		panel1.add(getComboBox());
		panel1.add(searchField);
		panel1.add(btnSearch);

		contentPane.add(panel2);

		for (int i = 0; i < textFields.length; i++) {

			panel2.add(textFields[i]);
			panel2.add(labels[i]);
		}

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}

}
