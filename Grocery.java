package FeedbackProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class Grocery                            //Grocery List
{
public static void Grocery_ListInsertion(Connection con)
{	 Scanner scan=new Scanner(System.in);


	int Sno;
	String G_Name;
	double Price;
	String Features;
	String G_Stock;
	try {
	Statement st;
	
    System.out.println("Enter the Serial Number");
    Sno=scan.nextInt();
    scan.nextLine();
    System.out.println("Enter the Grocery Name");
    G_Name=scan.nextLine();
    System.out.println("Enter the Price");  
    Price=scan.nextDouble();
    scan.nextLine();
    System.out.println("Enter The Description Of The Item");
    Features=scan.nextLine();
    System.out.println("Enter the Grocery Stock whether it is in in Stock or Out fo Stock");  
    G_Stock=scan.nextLine();
    
	
	String Im;
	Im="insert into grocery values(?,?,?,?,?)";
	PreparedStatement p=con.prepareStatement(Im);//Prepared statement for performing insertion
	p.setInt(1,Sno);
	p.setString(2,G_Name);
	p.setDouble(3,Price);
	p.setString(4,Features);
	p.setString(5,G_Stock);
	p.executeUpdate();
//	con.close();
	}
	
	catch(Exception e) {System.out.println(e);}

}

public static void Display_GroceryList(Connection con)
{	try 
{
	Statement statement = con.createStatement();
	String sql1 = "select * from grocery order by Serial_Number";
    ResultSet resultSet = statement.executeQuery(sql1);
	System.out.println("These are the available Grocery Items");
    while(resultSet.next())
    {	int Sno=resultSet.getInt("Serial_number");
    	String Name=resultSet.getString("Name_of_the_Item");
    	double Price=resultSet.getDouble("Price");
    	String About=resultSet.getString("About_This_Item");
    	String Stock=resultSet.getString("Grocery_Stocks");
    	System.out.print("Serial number:-"+Sno+"\nName Of the Item:-"+Name+"\nPrice:-"+Price+"\nAbout_This_Item:-"+About+"\nGrocery Stock:-"+Stock+"\n");
    	System.out.println("\n");
    
    }
}

catch(Exception e) {System.out.println(e);}
}


public static void Grocery_ItemSelect(Connection con)
{	Scanner scan=new Scanner(System.in);
	int Sno=0;
	String Name="";
	double Price;
	String About;
	String StockIn,StockOut;
	int id;
	System.out.println("Which Grocery do you want To buy");
	id=scan.nextInt();
	StockIn="In Stock";
	StockOut="Out of Stock";
	try
	{
	Statement st = con.createStatement();
	String sql1 = "select * from grocery order by Serial_number";
    ResultSet resultSet = st.executeQuery(sql1);

    while(resultSet.next()) {
    if((id==resultSet.getInt("Serial_number"))&&(StockIn.equals(resultSet.getString("Grocery_Stocks"))))
    	{System.out.println("The Item you buy is\n");
    	Name=resultSet.getString("Name_Of_the_Item");
    	System.out.print("Name Of the Grocery"+Name);
    	System.out.println("\n");
    	System.out.println("\nThanks for buying the Item");
    	System.out.println("Can you have few minutes.We Want the feedback from you regarding our services.");
    	Feedback.Feedback_Insertion(con);
    	}
    else if((id==resultSet.getInt("Serial_number"))&&(StockOut.equals(resultSet.getString("Grocery_Stocks"))))
	{System.out.println("The Item you buy is\n");
	Name=resultSet.getString("Name_of_the_Item");
	System.out.print("Name Of the Grocery"+Name);
	System.out.println("The Grocery Which you want to buy is out of Stock");
	System.out.println("Sorry For the Inconvenience");
	}
    }	
	}
    catch(Exception e) {System.out.println(e);}
}

public static void Grocery_Update(Connection con) throws SQLException
{	Scanner scan=new Scanner(System.in);
	String Um;
	String U_m;
	int Sno;
	try
	{
	System.out.println("Enter The Stock");//This is used to set the value of the stock
	U_m=scan.nextLine();
	System.out.println("Enter The Stock to change from In Stock to Out of Stock or vice versa");//This will compare the stock value 
	Um=scan.nextLine();//with the table and then changes it to out of stock to in stock or vice versa
	System.out.println("\nEnter the Serial number");
	Sno=scan.nextInt();
	String U="UPDATE grocery SET Grocery_Stocks=? WHERE (Grocery_Stocks=? AND Serial_number=?)";
	PreparedStatement p=con.prepareStatement(U);//Update the Stock
	p.setString(1,U_m);
	p.setString(2,Um);
	p.setInt(3,Sno);
	p.executeUpdate();
//	con.close();
	}
	
	
	  catch(Exception e) {System.out.println(e);}
}

public static void Grocery_Deletion(Connection con)
{	Scanner scan=new Scanner(System.in);
	int S_no; //Serial Number
	System.out.println("Enter the Serial Number");
	S_no=scan.nextInt();
	try 
	{String D="DELETE FROM grocery WHERE Serial_number=?";
	PreparedStatement p=con.prepareStatement(D);//Deletion of Record
	p.setInt(1,S_no);
	p.executeUpdate();
	//con.close();
	}
    catch(Exception e) {System.out.println(e);}

}

}