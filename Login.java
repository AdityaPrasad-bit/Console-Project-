package FeedbackProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	public static int Log_in(Connection con) throws SQLException
	{int flag=0;
	int i=1;
//	while(i==1){
	String Email,Em="";
	 String Pass,pa;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Email");
	Email=sc.next();
	System.out.println("Enter the Password");
	Pass=sc.next();
	Statement statement = con.createStatement();

//Query for sign up to compare the Email and Password values
	 String q = "SELECT* FROM signup_client"; 
	 ResultSet r=statement.executeQuery(q);
	 while(r.next())
	{
		  Em=r.getString("Email");
		  pa=r.getString("Password");
	
	if(Email.equals(Em))
	{if(Pass.equals(pa))
			{
		System.out.println("Access Granted");
		flag=1;
		break;
			}
	}
	else flag=0;
	
	
	}
	 
	 
	 
//	con.close();
	
//	}
	return flag;
	}

}
