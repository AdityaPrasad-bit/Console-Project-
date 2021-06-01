package FeedbackProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public Connection ConnectiontoDatabase() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/client","root","ubuntu7428");

	return con;	
	}
}