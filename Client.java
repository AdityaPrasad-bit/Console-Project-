package FeedbackProject;
import java.util.ArrayList;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.util.Scanner;
public class Client {
	

	public static void Client_(Connection con) throws SQLException {
		 
		String s;
		int i=1;
		Scanner scan=new Scanner(System.in);
		int flag=0;
		while(i==1)
			{	
				System.out.println("Do you want to Sign up or Log In \n ");
			System.out.println("For Sign Up press S Otherwise Press L for Login (CASE SENSITIVE)\n ");
			s=scan.next();
			if(s.equals("S"))
				Signup.Sign_Up(con);
			if(s.equals("L"))
				{flag=Login.Log_in(con);
				break;
				}
			}
			
		if(flag==0)
			{System.out.println("Please First Sign In\n");
			System.out.println("Jump to Sign In Page of the Client");
			Signup.Sign_Up(con);
			}
		else if(flag==1)
		{
		System.out.println("Which Item Do you want to buy");
		System.out.println("In the Grocery.Please press 1");
		System.out.println("In the Mobile. Please Press 2");
		int press;
		press=scan.nextInt();
		if(press==1)
			GR(con);
		else if(press==2) 
			MO(con);
		else System.out.println("You pressed the Incorrect button");
		}
		
}	
		
		public static void GR(Connection con) throws SQLException
		{//System.out.println("These are the available Items");
		Grocery.Display_GroceryList(con);
		Grocery.Grocery_ItemSelect(con);
		
		}
		public static void MO(Connection con) throws SQLException
		{
		//System.out.println("These are the available Items");
		Mobile.Display_MobileList(con);
		Mobile.Mobile_ItemSelect(con);	
		}
	


}
		

	
	
	
	
	