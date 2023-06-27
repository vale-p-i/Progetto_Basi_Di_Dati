package progetto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryManager {

	private Connection con;
	private int columnCount;
	private int	rowCount;
	
	/**
	 * Register the driver and get a connection from the database
	 * @param url is an address that points to the database
	 * @param user is the user of the database
	 * @param pass is the password to access into the database
	 */
	public QueryManager(String url, String user, String pass) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 				//carica dinamicamente driver in memoria
			con = DriverManager.getConnection(url, user, pass);
			columnCount = 0;
			rowCount = 0;	
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			con = null;
			columnCount = -1;
			rowCount = -1;
		}
	}
	
	/**
	 * this method is used to insert data in the database
	 * @param query 
	 */
	public void insertValues(String query) {
		
		Statement stmt;
		
		try {
			
			stmt = con.createStatement();
			stmt.execute(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * this method updates the number of tuples resulting from a query
	 * @param query
	 */
	
	private void updateRowsColumns(String query) {
		
		Statement stmt;
		int totalRows = 0;
		
		try {
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				totalRows++;
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			columnCount = -1;
			rowCount = -1;
		}
		
		rowCount = totalRows;
	}
	
	
	
	
	
	/**
	 * this methods return the table resulting from a query
	 * @param query
	 * @return a matrix that has as the first row the list of attributes
	 */
	public String[][] getTable(String query) {
		
		Statement stmt;
		
		try {
			
			if (con == null)
				return null;
			
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			updateRowsColumns(query);
			
			if(columnCount == -1 && rowCount== -1)
				return null;
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String [][] toReturn = new String[rowCount+1][columnCount];
			
			inizialize(toReturn, rowCount+1, columnCount); 			//inizializzo con stringhe vuote
			
			for(int k = 0; k < columnCount; k++) 
				toReturn[0][k] = rsmd.getColumnName(k+1);
				
			
			for(int j = 1; j <= rowCount && rs.next(); j++) {

				for(int i = 0; i < columnCount; i++) {
					
					toReturn[j][i] = rs.getString(i+1);
				}
			}
			
			return toReturn;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public String[] makeQuery(String query) {
		
		String[][] result = getTable(query);
		
		if(columnCount == -1 && rowCount == -1 || con == null)
			return null;
		
		String[] toReturn = new String[rowCount];
		inizialize(toReturn);
		for(int j = 0; j < rowCount; j++) {
			for(int i = 0; i < columnCount; i++)
				toReturn[j] += result[j+1][i];
		}
		return toReturn;	
	}
	
	/**
	 * initialize a matrix with empty elements
	 * @param x is the matrix
	 * @param row is the number of rows
	 * @param col is the number of column
	 */
	public static void inizialize(String[][] x, int row, int col) {
		for( int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				x[i][j] = "";
	}
	
	
	public static void inizialize(String[] x) {
		for( int i = 0; i < x.length; i++)
			x[i]="";
	}
	
	public static String print(String[] x) {
		String toReturn = "";
		for(int i = 0; i < x.length; i++)
			toReturn += x[i].toString();
		return toReturn;
	}
	
	public static String printSpaced(String[] x) {
		String toReturn = "";
		for(int i = 0; i < x.length; i++)
			toReturn += x[i].toString() + " ";
		return toReturn;
	}
	
	
	
	public int getColumnCount() {
		return columnCount;
	}
	
	public int getRowCount() {
		return rowCount;
	}
	
	public  void closeConnection() {
		try {
			this.con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
