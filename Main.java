package FeedbackProject;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
public class Main
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{	int p;
		Database d=new Database();
		Connection con= d.ConnectiontoDatabase(); 
		Scanner scan=new Scanner(System.in);
		System.out.println("Are you Admin OR Client\n");
		System.out.println("Please Press 1 for The Admin OR Press 2 for The Client\n");
		p=scan.nextInt();
		if(p==1)
			Admin.Admin_(con); 
		else if(p==2)
			Client.Client_(con);
			

	}
}