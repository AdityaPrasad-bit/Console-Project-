package FeedbackProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Feedback
{	
	public static void Feedback_Insertion(Connection con) throws SQLException
	{	String E;
		int flag=0;

		Scanner scan=new Scanner(System.in);	
		System.out.println("Please Enter your email");
	
		E=scan.nextLine();	
		Statement statement = con.createStatement();
		 String q = "SELECT Email FROM feedback"; 
		 ResultSet r=statement.executeQuery(q);
		 while(r.next())
		{
			 String Ema=r.getString("Email");
		
		if(Ema.equals(E))
		{	
			flag=1;
			break;
		
		}
		}
		if(flag==1)
			System.out.println("You Feedback is already Submitted");
		 
		 
		else {
		String name;// Name
		String Em="";//For the Email
		double Mno;//For Mobile number
		int r_p,r_s;
		String Comment;
		System.out.println("Please fill this form to give us feedback.It will definitely help us to improve our service ");
		System.out.println("Please Enter your name");
		name=scan.nextLine();	
		System.out.println("Please Enter your email");
		Em=scan.nextLine();	
		System.out.println("Please Enter your Mobile Number");
		Mno=scan.nextDouble();	
		System.out.println("Please Enter your rate out of 10 for the product");
		r_p=scan.nextInt();	
		System.out.println("Please Enter your rate out of 10 for the service");
		r_s=scan.nextInt();	
		scan.nextLine();
		System.out.println("Please Enter your Comments.If you have any otherwise press Nil");
		Comment=scan.nextLine();	
		System.out.println("Thanks for the feedback.Your Feedback has recorded.Your Feedback is valuable to us.");
		
		try {
		String Q;//For the query
		Q="insert into feedback values(?,?,?,?,?,?)";
		//p=con.createStatement();	
		PreparedStatement p=con.prepareStatement(Q);//Prepared statement for performing insertion
		p.setString(1,name);
		p.setString(2,Em);
		p.setDouble(3,Mno);
		p.setInt(4,r_p);
		p.setInt(5, r_s);
		p.setString(6,Comment);
		p.executeUpdate();
		con.close();
		
		}
	
		catch(Exception e) {System.out.println(e);}
		}
	
	
	
}
}