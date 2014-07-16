/**
 * Borrowers.java 
 * @author Mohamed Habib
 * 
 * A child of @Screen that handles the borrowers of the system. Can add, edit, view, delete borrowers of the system,
 * 
 * 
 */
package fcis;

public class Borrowers extends Screen {

	public Borrowers() {
		/**
		 * sends the header of the screen, an array of strings that contains the
		 * labels and an integer contains, the number of labels and text fields
		 * and combo box
		 */
		super("Borrowers", new String[] { "ID: ", "BookId:", "Name:", "SNN:",
				"Borrow Date:", "Return Date:", "Phone:", "Adress:", "E-mail:",
				"Faculty:", "Class:" }, 11);
		/**
		 * 
		 * sets the text to the labels and the tooltip text to the fields
		 * 
		 */

		for (int i = 0; i < textFields.length; i++) {
			labels[i].setText(getStr(i));
			textFields[i].setToolTipText("Enter " + getStr(i) + " Here!");
		}

		textFields[0].setBounds(131, 8, 156, 20);
		textFields[1].setBounds(419, 8, 156, 20);
		textFields[2].setBounds(706, 8, 156, 20);
		textFields[3].setBounds(131, 46, 156, 20);
		textFields[4].setBounds(418, 46, 156, 20);
		textFields[5].setBounds(706, 46, 156, 20);
		textFields[6].setBounds(131, 77, 156, 20);
		textFields[8].setBounds(418, 77, 156, 20);
		textFields[9].setBounds(706, 77, 156, 20);
		textFields[10].setBounds(131, 108, 156, 20);

		labels[0].setBounds(10, 11, 98, 14);
		labels[1].setBounds(297, 11, 98, 14);
		labels[2].setBounds(585, 14, 98, 14);
		labels[3].setBounds(10, 49, 98, 14);
		labels[4].setBounds(297, 49, 98, 14);
		labels[5].setBounds(585, 49, 98, 14);
		labels[6].setBounds(10, 80, 98, 14);
		labels[7].setBounds(297, 80, 98, 14);
		labels[8].setBounds(585, 80, 98, 14);
		labels[9].setBounds(10, 111, 98, 14);
		labels[10].setBounds(298, 111, 98, 14);
		super.table(conn.Borrow());
		// getTable().setBounds(0, 180, 581, 239);
		// Object rowData[][] = { { "", "", "" }, { "", "", "" } };
		// Object columnNames[] = str;
		//
		// scrollPane.setBounds(0, 192, 581, 227);
	}

	// label1.setText(getStr(0));
	// label2.setText(getStr(1));
	// label3.setText(getStr(2));
	// label4.setText(getStr(3));
	// label5.setText(getStr(4));
	//
	// textField1.setToolTipText("Enter ID Here!");
	// textField2.setToolTipText("Enter Name Here!");
	// textField3.setToolTipText("Enter Class Here!");
	// textField4.setToolTipText("Enter Time Here!");
	// textField5.setToolTipText("Enter D.L Here!");

}
