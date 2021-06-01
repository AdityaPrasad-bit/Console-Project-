package FeedbackProject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup {
	public static void Sign_Up(Connection con)
	{
	String name="";// Name
	String Em="";//For the Email
	double Mno;//For Mobile number
	int i=1,k=1,j=1;
	
	String pass="";//For the Password
	Scanner sc=new Scanner(System.in);

		try 
		{

		while(i==1)
		{	System.out.println("Enter the name");
			name=sc.nextLine();
			
			
			System.out.println("Enter the Mobile Number");	
			Mno=sc.nextDouble();
			//ArrayList<String> emails = new ArrayList<String>();  //For the Email address      
	        
			
			
			while(k==1)
	       {
	        System.out.println("Enter the Email");
	        System.out.println("\n");
	        System.out.println("These Are The Valid Syntax For The Email");
	        System.out.println("javaEmail@domain.co.in");  
	        System.out.println("12453@domain.com");  
	        System.out.println("javaEmail.name@domain.com");  
	        System.out.println("1avaEmail#@domain.co.in");
	        System.out.println("Invalid Email");
		    System.out.println("@yahoo.com"); 
	        Em=sc.next();
	        System.out.println("The E-mail ID is: " + Em);
	        System.out.println("Is the above E-mail ID valid? " + isValid(Em));    
	        System.out.println("If it is invalid press 1 if not press 0");
	        k=sc.nextInt();
	       }
	        while(j==1) {
	        System.out.println("Enter the password");
	        System.out.println("It contains at least 8 characters and at most 20 characters.\r\n"
	        		+ "It contains at least one digit.\r\n"
	        		+ "It contains at least one upper case alphabet.\r\n"
	        		+ "It contains at least one lower case alphabet.\r\n"
	        		+ "It contains at least one special character which includes !@#$%&*()-+=^.\r\n"
	        		+ "It doesn�t contain any white space.");
			pass=sc.next();
			if (isValidPassword(pass)) { 
				System.out.println("Valid Password"); 
			} 
			else 
			{ 
				System.out.println("Invalid Password!!!");
	        }

	        System.out.println("If it is invalid press 1 if not press 0");
	        j=sc.nextInt();
	        }
		String Q;//For the query
		
		Q=" insert into signup_client values(?,?,?,?)";
		//p=con.createStatement();	
		PreparedStatement p=con.prepareStatement(Q);//Prepared statement for performing insertion
		p.setString(1,name);
		p.setString(2,Em);
		p.setString(3,pass);
		p.setDouble(4,Mno);
		p.executeUpdate();
		//con.close();
		System.out.println("Do you want to add more press 1 otherwise press 0");
		i=sc.nextInt();
		}
		}
		
		catch(Exception e) {System.out.println(e);}
		
	}
	public static boolean isValidPassword(String password) 
	{ 

		// Regex to check valid password. 
		String regex = "^(?=.*[0-9])"
					+ "(?=.*[a-z])(?=.*[A-Z])"
					+ "(?=.*[@#$%^&+=])"
					+ "(?=\\S+$).{8,20}$"; 

		// Compile the ReGex 
		Pattern p = Pattern.compile(regex); 

		// If the password is empty 
		// return false 
		if (password == null) { 
			return false; 
		} 

		// Pattern class contains matcher() method 
		// to find matching between given password 
		// and regular expression. 
		Matcher m = p.matcher(password); 

		// Return if the password 
		// matched the ReGex 
		return m.matches(); 
	}
	static boolean isValid(String email) {
	       String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";  
	return email.matches(regex);
	   }
	

	
	
}


