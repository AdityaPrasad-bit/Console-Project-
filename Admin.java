package FeedbackProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Admin
{
	public static void Admin_(Connection con)throws SQLException 
	{System.out.println("\n You are in the admin side\n");
	 System.out.println("Now Please enter the Email and password");
	int flag=0;
	int i=1;
	int j=0;
//	while(i==1){
	String Email,Em="";
	 String Pass,pa;
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the Email");
	Em=sc.next();
	System.out.println("Enter the Password");
	pa=sc.next();
	try {
	Statement statement = con.createStatement();

//Query for sign up to compare the Email and Password values
	 String q = "SELECT * FROM admin"; 
	 ResultSet r=statement.executeQuery(q);
		 while(r.next())
		 {  Email=r.getString("Email");
		  Pass=r.getString("Password");
		  
		 if(Em.equals(Email))
			{while(i==1)
			{if(pa.equals(Pass))
				{System.out.println("Access Granted");
				i=2;
				flag=1;
				break;
				}
			  else 
			  { System.out.println("Incorrect Password please enter the correct password again");
				System.out.println("Enter the Password");
				pa=sc.next();
			  
			  }
			}
			} 
			
//			else if(!Em.equals(Email))
//				System.out.println("Access Denied You Are Not Admin If You Are then Please Enter the Correct Email and Password");
//			
			
	}
	
	
	//if(flag==0) System.out.println("Access Denied You Are Not Admin If You Are then Please Enter the Correct Email and Password");
	
	
	 if(flag==1)
	{	System.out.println(" ");
		System.out.println("Hello Admin!!!\n");
		System.out.println("Where do you want to go in the Grocery or in the Mobile ?\n");
		System.out.println("Press 1 For Grocery");
		System.out.println("Press 2 For Mobile");
		j=sc.nextInt();
		if(j==1)
			G(con);
		else if(j==2)
			M(con);
		
	}
	}catch (SQLException e) {
		System.out.print(e);
	}
	}

		public static void G(Connection con) throws SQLException
		{int g=0;
		Scanner s=new Scanner(System.in);

		System.out.println("Which Oeration Do you want to perform \n");
		System.out.println("Press 1 for Insertion \n");
		System.out.println("Press 2 for Update \n");
		System.out.println("Press 3 for Deletion \n");
		g=s.nextInt();
		switch(g)
		{
		case 1:System.out.println("Available List\n");
			
			Grocery.Display_GroceryList(con);
				Grocery.Grocery_ListInsertion(con);
				System.out.println("\n After Insertion");	
			   Grocery.Display_GroceryList(con);
			   break;
		case 2:System.out.println("Available List\n");
			Grocery.Display_GroceryList(con);
			Grocery.Grocery_Update(con);
			System.out.println("\n After Updation");
			  Grocery.Display_GroceryList(con);
		       break;
		case 3:System.out.println("Available List\n");
			Grocery.Display_GroceryList(con);
			Grocery.Grocery_Deletion(con);
			System.out.println("\n After Deletion");
				Grocery.Display_GroceryList(con);
				break;
		}
	
	
	
		}
		
		public static void M(Connection con) throws SQLException
		{int m=0;
		Scanner s=new Scanner(System.in);

		System.out.println("Which Oeration Do you want to perform \n");
		System.out.println("Press 1 for Insertion \n");
		System.out.println("Press 2 for Update \n");
		System.out.println("Press 3 for Deletion \n");
		m=s.nextInt();
		switch(m)
		{
		case 1:System.out.println("Available List\n");
			Mobile.Display_MobileList(con);
			Mobile.Mobile_Insertion(con);
		System.out.println("\n After Insertion");
		  	   Mobile.Display_MobileList(con);
			   break;
		case 2:System.out.println("Available List\n");
			Mobile.Display_MobileList(con);
			Mobile.Mobile_Update(con);
		System.out.println("\n After Updation");
			  Mobile.Display_MobileList(con);
		       break;
		case 3:System.out.println("Available List\n");
			Mobile.Display_MobileList(con);
			Mobile.Mobile_Deletion(con);
		System.out.println("\n After Deletion");
				Mobile.Display_MobileList(con);
			    break;
		}
	
	
	
		}
		
		
	}
