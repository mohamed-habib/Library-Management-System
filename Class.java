/**
 * Class.java
 * @author Mohamed Habib
 * contains method that calls a screen  
 * 
 * 
 * 
 */

package fcis;

import javax.swing.JOptionPane;

public class Class {

	private static Books book;

	public static Books getBook() {
		return book;
	}

	public static void setBook(Books book) {
		Class.book = book;
	}

	private static Visitors visitor;
	private static Borrowers borrower;
	private static Warnings warning;

	private static WelcomeScreen welcomeScreen;
	private static LoginScreen loginScreen;

	static void books() {
		book = new Books();
	}

	static void visitors() {
		visitor = new Visitors();
	}

	static void borrowers() {
		borrower = new Borrowers();
	}

	static void warnings() {
		warning = new Warnings();
	}

	static void Exit() {
		JOptionPane.showMessageDialog(null, "Good Bye");
		System.exit(0);
	}

	static void Logout() {
		JOptionPane.showMessageDialog(null, "Good Bye");
		loginScreen = new LoginScreen();
	}

	static void Back() {
		welcomeScreen = new WelcomeScreen();
	}
}
