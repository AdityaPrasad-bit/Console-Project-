package FeedbackProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Mobile                            //Mobile
{
	static Scanner scan=new Scanner(System.in);
	//static Scanner scan1=new Scanner(System.in);
	
	
public static void Mobile_Insertion(Connection con)
{	int Sno;
	String M_name;
	double Price;
	String Features;
	String M_Stocks;
	
	try 
	{

        System.out.println("Enter the Serial Number");
        Sno=scan.nextInt();
        System.out.println("Enter the Mobile Name");
        M_name=scan.next();
        scan.nextLine();
        System.out.println("Enter the Price");  
        Price=scan.nextDouble();
        scan.nextLine();
        System.out.println("Enter the Features");
        Features=scan.nextLine();
        System.out.println("Enter the Mobile Stock whether it is in In Stock or Out fo Stock");  
        M_Stocks=scan.nextLine();
        
		
		String Im;
		Im="insert into mobile values(?,?,?,?,?)";
		PreparedStatement p=con.prepareStatement(Im);//Prepared statement for performing insertion
		p.setInt(1,Sno);
		p.setString(2,M_name);
		p.setDouble(3,Price);
		p.setString(4,Features);
		p.setString(5,M_Stocks);
		p.executeUpdate();
		//con.close();	
	}
	
	catch(Exception e) {System.out.println(e);}
}


	
public static void Mobile_Update(Connection con) throws SQLException
{	//Scanner s=new Scanner(System.in);
	String Um;
	String U_m;
	int Sno;
	try{System.out.println("Enter The Stock");//This is used to set the value of the stock
	U_m=scan.nextLine();
	System.out.println("Enter The Stock to change from In Stock to Out of Stock or vice versa");//This will compare the stock value
	Um=scan.nextLine();//with the table and then changes it to out of stock to in stock or vice versa
	System.out.println("\nEnter the Serial number");
	Sno=scan.nextInt();
String U="UPDATE mobile SET Mobile_Stocks=? WHERE (Mobile_Stocks=? AND Sno=?)";
PreparedStatement p=con.prepareStatement(U);//Update the Stock
p.setString(1,U_m);
p.setString(2,Um);
p.setInt(3,Sno);
p.executeUpdate();
//con.close();
	}
	
	
	  catch(Exception e) {System.out.println(e);}
}

public static void Mobile_Deletion(Connection con)
{	int Sno;
	System.out.println("Enter the Serial Number");
	Sno=scan.nextInt();
	try 
	{String D="DELETE FROM mobile WHERE Sno=?";
	PreparedStatement p=con.prepareStatement(D);//Deletion of Record
	p.setInt(1,Sno);
	p.executeUpdate();
//	con.close();
	}
    catch(Exception e) {System.out.println(e);}

}




public static void Display_MobileList(Connection con)
{	try 
{
	Statement statement = con.createStatement();
	String sql1 = "select * from mobile order by Sno";
    ResultSet resultSet = statement.executeQuery(sql1);
    while(resultSet.next())
    {	int Sno=resultSet.getInt("Sno");
    	String Name=resultSet.getString("Name_of_the_Item");
    	double Price=resultSet.getDouble("Price_of_the_Device");
    	String Features=resultSet.getString("Features");
    	String Stock=resultSet.getString("Mobile_Stocks");
    	System.out.print("Serial number:-"+Sno+"\nName Of the Items:-"+Name+"\nPrice:-"+Price+"\nFeatures:-"+Features+"\nMobile Stocks:-"+Stock+"\n");
    	System.out.print("\n");
    }
}
catch(Exception e) {System.out.println(e);}
}

public static void Mobile_ItemSelect(Connection con)
{	int Sno=0;
	String Name="";
	double Price;
	String Features;
	String StockIn,StockOut;
	int id;
	System.out.println("Which Mobile do you want To buy");
	id=scan.nextInt();
	StockIn="In Stock";
	StockOut="Out of Stock";
	try
	{
	Statement st = con.createStatement();
	String sql1 = "select * from mobile order by Sno";
    ResultSet resultSet = st.executeQuery(sql1);

    while(resultSet.next()) {
    if((id==resultSet.getInt("Sno"))&&(StockIn.equals(resultSet.getString("Mobile_Stocks"))))
    	{System.out.println("The Item you buy is.\n");
    	Name=resultSet.getString("Name_Of_the_Item");
    	System.out.print("Name Of the Mobile"+Name);
    	System.out.println("\n");
    	System.out.println("\nThanks for buying the Item \n");
    	
    	System.out.println("Can you have few minutes.We Want the feedback from you regarding our services.");
    	Feedback.Feedback_Insertion(con);
    	}
    else if((id==resultSet.getInt("Sno"))&&(StockOut.equals(resultSet.getString("Mobile_Stocks"))))
	{System.out.println("The Item you buy is\n");
	Name=resultSet.getString("Name_of_the_Item");
	System.out.print("Name Of the Mobile"+Name);
	System.out.println("The Mobile Which you want to buy is out of Stock");
	System.out.println("Sorry For the Inconvenience");
	}
    }	
	}
    catch(Exception e) {System.out.println(e);}
}


}