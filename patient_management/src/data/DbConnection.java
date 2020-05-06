package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbConnection {
	private Connection con;
	private Statement stmt;
	
	public DbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patientmanagementsystem","root","maheshR1996");
		}catch(SQLException | ClassNotFoundException exception) {
			exception.printStackTrace();
		}
	}
	
	public boolean queryProcess(String query) throws SQLException{
		stmt = con.createStatement();
		try {
			stmt.execute(query);
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	public ResultSet getQueryResult(String query){
		try{
			stmt=con.createStatement();
			return stmt.executeQuery(query);
		} catch(SQLException e){
			System.out.println(e.getMessage());
			return null;
		}
	}

}
