package fcis;

import javax.swing.JLabel;

public class SearchResults extends Screen {

	public SearchResults(String key, String value, String screan, String[] s,
			int x) {

		super("Search Results", s, s.length);
		super.btnAdd.setVisible(false);
		super.btnDelete.setVisible(false);
		super.btnModify.setVisible(false);
		super.btnSave.setVisible(false);
		// super.table.setBounds(MAXIMIZED_BOTH, ABORT, 60, 90);
		super.btnSearch.setVisible(false);
		super.comboBox.setVisible(false);
		super.searchField.setVisible(false);
		super.lblSearch.setVisible(false);
		JLabel labl1 = new JLabel("Search results");
		labl1.setBounds(131, 8, 156, 20);
		super.add(labl1);

		super.table(conn.Search(key, value, screan));

	}

}
