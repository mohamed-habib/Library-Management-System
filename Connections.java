/**
 * Connections.java  
 * Connections Package
 * @author  Mahmoud Emara
 * this class have all functions that get and set and access data base in MYSQL
 * and make all operation on it
 * we make our operation on the data base library
 * 
 */

package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import javax.xml.crypto.Data;

public class Connectins {

	// JDBC driver name and database URL
	public String pass;

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost/library";
	String dbUrl = "jdbc:mysql://localhost/library?allowMultiQuery=true";
	Connection conn = null;
	Statement stmt = null;
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	/**
	 * void connection function that connect to the data base with the user name
	 * and password and database url it takes no paramiter
	 * 
	 */
	public void connectToDB() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * void closeConnection function that close all open connections and other
	 * resources it uses to clean the environment
	 * 
	 * 
	 * 
	 */
	public void closeConnection()

	{
		try {
			if (stmt != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}// do nothing
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException se) {
			se.printStackTrace();

		}
	}

	/**
	 * String [][] BooksView function that get all informations about any book
	 * and store it in two d array to show them in the table of the books
	 * 
	 * 
	 * @return
	 */
	public String[][] BooksView() {
		String[][] Result = new String[30][6];
		try {

			connectToDB();
			stmt = conn.createStatement();
			// to view the book quary

			String sql = "SELECT Id,Name,Author,Eddition,ReleaseDate,publisher FROM books ";
			ResultSet rs = stmt.executeQuery(sql);
			// Extract data from result set
			int j = 0;

			while (rs.next()) {
				int i = 0;
				// Retrieve by column name
				int Id = rs.getInt("Id");
				String id = String.valueOf(Id);
				String Author = rs.getString("Author");
				String Eddition = rs.getNString("Eddition");
				// String Edition =String.valueOf(Eddition);
				String Name = rs.getString("Name");
				String ReleaseDate = rs.getString("ReleaseDate");
				String publisher = rs.getString("publisher");
				Result[j][i] = id;
				Result[j][++i] = Name;
				Result[j][++i] = Author;
				Result[j][++i] = Eddition;
				Result[j][++i] = ReleaseDate;
				Result[j][++i] = publisher;

				j++;

			} // while

			rs.close();
			// to search by book id

		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("DataBase Error Please Try Again !");
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("DataBase Error Please Try Again !");
		}

		finally {
			closeConnection();
		}// end finally

		return Result;
	}

	/**
	 * void AddBook function is used to add new book information in the data
	 * base it takes the following parameters
	 * 
	 * @param Name
	 * @param Author
	 * @param Eddition
	 * @param ReleaseDate
	 * @param Publisher
	 */
	public void AddBook(String Name, String Author, String Eddition,
			String ReleaseDate, String Publisher) {

		connectToDB();
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO books(name,author,eddition,releasedate,Publisher) "
					+ "VALUES ( '"
					+ Name
					+ "', '"
					+ Author
					+ "','"
					+ Eddition
					+ "','" + ReleaseDate + "','" + Publisher + "')";
			// by clicking save it will be updated from here
			stmt.executeUpdate(sql);
		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	/**
	 * String [][] Search function is used to search for a specific informations
	 * in any table just give it the key you want to search with and its value
	 * and the screen name you want to search with and it returns all
	 * information about that key and value in o d array to display them in
	 * atable
	 * 
	 * @param key
	 * @param value
	 * @param Screen
	 * @return
	 */
	public String[][] Search(String key, String value, String Screen) {
		System.out.println(Screen);
		String[][] SearchResult = new String[30][13];
		try {

			connectToDB();
			stmt = conn.createStatement();
			// to search by book name
			if (key == "Id" || key == "id" || key == "ID") {
				int ID = Integer.parseInt(value);

				// Extract data from result set
				if (Screen.equalsIgnoreCase("books")) {
					String sql = "SELECT * FROM " + Screen + " WHERE id='" + ID
							+ "' ";
					ResultSet rs = stmt.executeQuery(sql);

					int j = 0;

					while (rs.next()) {
						int i = 0;
						// Retrieve by column name
						int Id = rs.getInt("Id");
						String id = String.valueOf(Id);
						String Author = rs.getString("Author");
						String Eddition = rs.getNString("Eddition");
						// String Edition =String.valueOf(Eddition);
						String Name = rs.getString("Name");
						String ReleaseDate = rs.getString("ReleaseDate");
						String publisher = rs.getString("publisher");
						SearchResult[j][i] = id;
						SearchResult[j][++i] = Name;
						SearchResult[j][++i] = Author;
						SearchResult[j][++i] = Eddition;
						SearchResult[j][++i] = ReleaseDate;
						SearchResult[j][++i] = publisher;

						j++;

					} // while
					rs.close();
				}

				else if (Screen.equalsIgnoreCase("Borrowers")) {
					String sql = "SELECT * FROM borrow WHERE id='" + ID + "' ";
					ResultSet rs = stmt.executeQuery(sql);
					int j = 0;

					while (rs.next()) {
						int i = 0;
						// Retrieve by column name
						int Id = rs.getInt("Id");
						String id = String.valueOf(Id);
						int Book_Id = rs.getInt("bookId");
						String B_ook_id = String.valueOf(Book_Id);
						String SNN = rs.getString("SNN");
						String Faculty = rs.getString("Faculty");
						String Name = rs.getString("Name");
						String Class = rs.getString("Class");
						String Date_of_Borrow = rs.getString("Date_of_Borrow");
						String Date_of_Return = rs.getString("Date_of_Return");
						String Phone = rs.getString("Phone");
						String Adress = rs.getString("Adress");
						String E_mail = rs.getString("Email");
						SearchResult[j][i] = id;
						SearchResult[j][++i] = B_ook_id;
						SearchResult[j][++i] = Name;
						SearchResult[j][++i] = SNN;
						SearchResult[j][++i] = Date_of_Borrow;
						SearchResult[j][++i] = Date_of_Return;
						SearchResult[j][++i] = Phone;
						SearchResult[j][++i] = Adress;
						SearchResult[j][++i] = E_mail;
						SearchResult[j][++i] = Faculty;
						SearchResult[j][++i] = Class;

						j++;

					} // while
					rs.close();
				} else if (Screen.equalsIgnoreCase("Visitors")) {
					String sql = "SELECT * FROM guest WHERE id='" + ID + "' ";
					ResultSet rs = stmt.executeQuery(sql);
					int j = 0;

					while (rs.next()) {
						int i = 0;
						// Retrieve by column name
						int Id = rs.getInt("Id");
						String id = String.valueOf(Id);
						String SNN = rs.getString("SNN");
						String Faculty = rs.getString("Faculty");

						String Name = rs.getString("Name");
						String Class = rs.getString("Class");

						SearchResult[j][i] = id;
						SearchResult[j][++i] = Name;
						SearchResult[j][++i] = SNN;
						SearchResult[j][++i] = Faculty;
						SearchResult[j][++i] = Class;

						j++;

					} // while
					rs.close();
				}

			}// (if(1)
				// to search by book id
			else if (key == "Name" || key == "name") {
				if (Screen.equalsIgnoreCase("books")) {
					String sql = "SELECT * FROM " + Screen
							+ " WHERE name LIKE'%" + value + "%' ";
					ResultSet rs = stmt.executeQuery(sql);
					// Extract data from result set
					int j = 0;

					while (rs.next()) {
						int i = 0;
						// Retrieve by column name
						int Id = rs.getInt("Id");
						String id = String.valueOf(Id);
						String Author = rs.getString("Author");
						String Eddition = rs.getNString("Eddition");
						// String Edition =String.valueOf(Eddition);
						String Name = rs.getString("Name");
						String ReleaseDate = rs.getString("ReleaseDate");
						String publisher = rs.getString("publisher");
						SearchResult[j][i] = id;
						SearchResult[j][++i] = Name;
						SearchResult[j][++i] = Author;
						SearchResult[j][++i] = Eddition;
						SearchResult[j][++i] = ReleaseDate;
						SearchResult[j][++i] = publisher;

						j++;

					}
					rs.close();// while
				} else if (Screen.equalsIgnoreCase("Borrowers")) {
					String sql = "SELECT * FROM borrow WHERE Name LIKE'%"
							+ value + "%' ";
					ResultSet rs = stmt.executeQuery(sql);
					int j = 0;

					while (rs.next()) {
						int i = 0;
						// Retrieve by column name
						int Id = rs.getInt("Id");
						String id = String.valueOf(Id);
						int Book_Id = rs.getInt("bookId");
						String B_ook_id = String.valueOf(Book_Id);
						String SNN = rs.getString("SNN");
						String Faculty = rs.getString("Faculty");
						String Name = rs.getString("Name");
						String Class = rs.getString("Class");
						String Date_of_Borrow = rs.getString("Date_of_Borrow");
						String Date_of_Return = rs.getString("Date_of_Return");
						String Phone = rs.getString("Phone");
						String Adress = rs.getString("Adress");
						String E_mail = rs.getString("Email");
						SearchResult[j][i] = id;
						SearchResult[j][++i] = B_ook_id;
						SearchResult[j][++i] = Name;
						SearchResult[j][++i] = SNN;
						SearchResult[j][++i] = Date_of_Borrow;
						SearchResult[j][++i] = Date_of_Return;
						SearchResult[j][++i] = Phone;
						SearchResult[j][++i] = Adress;
						SearchResult[j][++i] = E_mail;
						SearchResult[j][++i] = Faculty;
						SearchResult[j][++i] = Class;

						j++;

					} // while
					rs.close();

				} else if (Screen.equalsIgnoreCase("Visitors")) {
					String sql = "SELECT * FROM guest WHERE Name LIKE'%"
							+ value + "%' ";
					ResultSet rs = stmt.executeQuery(sql);
					int j = 0;

					while (rs.next()) {
						int i = 0;
						// Retrieve by column name
						int Id = rs.getInt("Id");
						String id = String.valueOf(Id);
						String SNN = rs.getString("SNN");
						String Faculty = rs.getString("Faculty");

						String Name = rs.getString("Name");
						String Class = rs.getString("Class");

						SearchResult[j][i] = id;
						SearchResult[j][++i] = Name;
						SearchResult[j][++i] = SNN;
						SearchResult[j][++i] = Faculty;
						SearchResult[j][++i] = Class;

						j++;

					} // while
					rs.close();
				}
			}// if(2)

		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("DataBase Error Please Try Again !");
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("DataBase Error Please Try Again !");
		} finally {
			closeConnection();
		}

		return SearchResult;

	}

	/**
	 * void Delete function that delete any record from the data base just give
	 * it the key you want to delete with and its value and the table name you
	 * want to delete from it takes the following parameters
	 * 
	 * @param key
	 * @param value
	 * @param Screen
	 */
	public void Delete(String key, String value, String Screen) {

		try {
			connectToDB();
			stmt = conn.createStatement();

			if (key == "Id" || key == "id" || key == "ID") {
				int ID = Integer.parseInt(value);
				String sql = "DELETE FROM " + Screen + " " + "WHERE id = '"
						+ ID + "'";
				stmt.executeUpdate(sql);

			}// (if(1)
				// to search by book id
			else if (key == "Name" || key == "name") {
				String sql = "DELETE FROM " + Screen + " " + "WHERE name = '"
						+ value + "'";

				stmt.executeUpdate(sql);

			}// if(2)

		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("DataBase Error Please Try Again !");
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("DataBase Error Please Try Again !");
		} finally {
			closeConnection();
		}

	}

	/**
	 * * String [][] VisitorsView function that get all informations about any
	 * visitor and store it in two d array to show them in the table of the
	 * visitors
	 * 
	 * @return
	 */
	public String[][] VisitorsView() {
		String[][] result = new String[30][5];
		try {

			connectToDB();
			stmt = conn.createStatement();
			// to view the book quary

			String sql = "SELECT * FROM guest ";
			ResultSet rs = stmt.executeQuery(sql);
			// Extract data from result set
			int j = 0;

			while (rs.next()) {
				int i = 0;
				// Retrieve by column name
				int Id = rs.getInt("Id");
				String id = String.valueOf(Id);
				String SNN = rs.getString("SNN");
				String Faculty = rs.getString("Faculty");

				String Name = rs.getString("Name");
				String Class = rs.getString("Class");

				result[j][i] = id;
				result[j][++i] = Name;
				result[j][++i] = SNN;
				result[j][++i] = Faculty;
				result[j][++i] = Class;

				j++;

			} // while

			rs.close();
			// to search by book id

		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("DataBase Error Please Try Again !");
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("DataBase Error Please Try Again !");
		}

		finally {
			closeConnection();
		}// end finally

		return result;

	}

	/**
	 * * String [][] Warnings function that get all informations about any
	 * borrower that don't return the book he borrowed and store it in two d
	 * array to show them in the table of the borrower it filters the borrower
	 * table
	 * 
	 * @return
	 */
	public String[][] Warnings() {
		String[][] Result = new String[30][12];
		try {

			connectToDB();
			stmt = conn.createStatement();
			// to view the book quary

			String sql = "SELECT* FROM borrow WHERE Date_of_Return<current_date() ";
			ResultSet rs = stmt.executeQuery(sql);
			// Extract data from result set
			int j = 0;

			while (rs.next()) {
				int i = 0;
				// Retrieve by column name
				int Id = rs.getInt("Id");
				String id = String.valueOf(Id);
				int Book_Id = rs.getInt("bookId");
				String B_ook_id = String.valueOf(Book_Id);
				String SNN = rs.getString("SNN");
				String Faculty = rs.getString("Faculty");
				String Name = rs.getString("Name");
				String Class = rs.getString("Class");
				String Date_of_Borrow = rs.getString("Date_of_Borrow");
				String Date_of_Return = rs.getString("Date_of_Return");
				String Phone = rs.getString("Phone");
				String Adress = rs.getString("Adress");
				String E_mail = rs.getString("Email");
				Date date = new Date();
				int Date = date.getDate();
				int month = date.getMonth() + 1;
				// System.out.println(Date);
				String[] str = Date_of_Return.split("-");

				int retdate = Integer.parseInt(str[2]);
				int retmonth = Integer.parseInt(str[1]);

				int fine = (((month - retmonth) * 30) + (Date - retdate)) * 2;
				System.out.println(fine);
				String Fine = String.valueOf(fine);
				Result[j][i] = id;
				Result[j][++i] = B_ook_id;
				Result[j][++i] = Name;
				Result[j][++i] = SNN;
				Result[j][++i] = Date_of_Borrow;
				Result[j][++i] = Date_of_Return;
				Result[j][++i] = Phone;
				Result[j][++i] = Adress;
				Result[j][++i] = E_mail;
				Result[j][++i] = Faculty;
				Result[j][++i] = Class;
				Result[j][++i] = Fine + "LE";

				j++;

			} // while

			rs.close();
			// to search by book id

		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("DataBase Error Please Try Again !");
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("DataBase Error Please Try Again !");
		}

		finally {
			closeConnection();
		}// end finally

		return Result;
	}

	/**
	 * * String [][] Borrow function that get all informations about any
	 * borrower and store it in two d array to show them in the table of the
	 * borrowers
	 * 
	 * @return
	 */
	public String[][] Borrow() {
		String[][] Result = new String[30][11];
		try {

			connectToDB();
			stmt = conn.createStatement();
			// to view the book quary

			String sql = "SELECT* FROM borrow ";
			ResultSet rs = stmt.executeQuery(sql);
			// Extract data from result set
			int j = 0;

			while (rs.next()) {
				int i = 0;
				// Retrieve by column name
				int Id = rs.getInt("Id");
				String id = String.valueOf(Id);
				int Book_Id = rs.getInt("bookId");
				String B_ook_id = String.valueOf(Book_Id);
				String SNN = rs.getString("SNN");
				String Faculty = rs.getString("Faculty");
				String Name = rs.getString("Name");
				String Class = rs.getString("Class");
				String Date_of_Borrow = rs.getString("Date_of_Borrow");
				String Date_of_Return = rs.getString("Date_of_Return");
				String Phone = rs.getString("Phone");
				String Adress = rs.getString("Adress");
				String E_mail = rs.getString("Email");
				Result[j][i] = id;
				Result[j][++i] = B_ook_id;
				Result[j][++i] = Name;
				Result[j][++i] = SNN;
				Result[j][++i] = Date_of_Borrow;
				Result[j][++i] = Date_of_Return;
				Result[j][++i] = Phone;
				Result[j][++i] = Adress;
				Result[j][++i] = E_mail;
				Result[j][++i] = Faculty;
				Result[j][++i] = Class;

				j++;

			} // while

			rs.close();
			// to search by book id

		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			System.out.println("DataBase Error Please Try Again !");
		} catch (Exception e) {
			// Handle errors for Class.forName
			System.out.println("DataBase Error Please Try Again !");
		}

		finally {
			closeConnection();
		}// end finally

		return Result;
	}

	/**
	 * void Update it update the information of any book and it takes this
	 * parameters
	 * 
	 * @param Id
	 * @param Name
	 * @param Author
	 * @param Eddition
	 * @param ReleaseDate
	 * @param Publisher
	 */
	public void Update(String Id, String Name, String Author, String Eddition,
			String ReleaseDate, String Publisher) {

		connectToDB();
		try {
			stmt = conn.createStatement();
			String sql = "update books set name = '" + Name + "', author = '"
					+ Author + "', eddition = '" + Eddition
					+ "', ReleaseDate = '" + ReleaseDate + "', Publisher = '"
					+ Publisher + "' where id = '" + Id + "'";
			// by clicking save it will be updated from here
			stmt.executeUpdate(sql);
		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	/**
	 * Add new borrower and store its data in the data base it takes the
	 * following parameters
	 * 
	 * @param BookId
	 * @param Name
	 * @param SNN
	 * @param BorrowDate
	 * @param Date_of_Return
	 * @param Phone
	 * @param Adress
	 * @param E_mail
	 */
	public void AddBorrower(String BookId, String Name, String SNN,
			String BorrowDate, String Date_of_Return, String Phone,
			String Adress, String E_mail) {

		connectToDB();
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO borrow(bookId,Name,SNN,Date_of_Borrow,Date_of_Return,Phone,Adress,Email) "
					+ "VALUES ( '"
					+ BookId
					+ "', '"
					+ Name
					+ "','"
					+ SNN
					+ "','"
					+ BorrowDate
					+ "','"
					+ Date_of_Return
					+ "','"
					+ Phone + "','" + Adress + "','" + E_mail + "')";
			// by clicking save it will be updated from here
			stmt.executeUpdate(sql);
		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}

	/**
	 * 
	 * Add new visitors the library and store its data in the data base it takes
	 * the following parameters
	 * 
	 * @param Name
	 * @param SNN
	 * @param Faculty
	 * @param Class
	 */
	public void Addvisitor(String Name, String SNN, String Faculty, String Class) {

		connectToDB();
		try {
			stmt = conn.createStatement();
			String sql = "INSERT INTO guest(Name,SNN,Faculty,Class) "
					+ "VALUES (  '" + Name + "','" + SNN + "','" + Faculty
					+ "','" + Class + "' )";
			// by clicking save it will be updated from here
			stmt.executeUpdate(sql);
		}// try

		catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {

			closeConnection();

		}

	}

	/**
	 * 
	 it takes the name of the user and its pass word and check the
	 * authentication
	 * 
	 * @param name
	 * @return
	 */
	public String Login(String name) {
		try {

			connectToDB();
			stmt = conn.createStatement();
			String sql = "SELECT PassWord FROM user WHERE UserName ='" + name
					+ "'";
			ResultSet rs = stmt.executeQuery(sql);
			// STEP 5: Extract data from result set
			rs.next();
			pass = rs.getString("PassWord");
			rs.close();

		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {

			closeConnection();

		}
		return pass;

	}

}
