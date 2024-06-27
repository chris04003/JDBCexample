import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


class DBdemo
{
	public static void main(String args[])
	{
	
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/college";
			String user="root";
			String pass="root";
			Connection conn=DriverManager.getConnection(url,user,pass);
			Scanner sc=new Scanner(System.in);
			System.out.println("WELCOME TO CSE A");
			System.out.println("LOGIN");
			System.out.println("Roll Number : ");
			String rollnum=sc.nextLine();
			System.out.println("Name : ");
			String namee=sc.nextLine();
			String sql2="Select name from student where rollno=?";
			PreparedStatement pstm=conn.prepareStatement(sql2);
			pstm.setString(1,rollnum);
		    ResultSet rs2=pstm.executeQuery();
		    if(rs2.next())
		    {
		    	String dbname=rs2.getString("name");
		    	if(dbname.equals(namee))
		    	{
		    		System.out.println("SUCCESSFULLY LOGGED IN :)");
		    	}
		    	else
		    	{
		    		System.out.println("LOGIN FAILURE - CHECK YOUR CREDENTIALS");
		    	}
	
		    	
		    }
		    
		    
		}
	
		catch(Exception e)
		{
			System.out.println("Connection not Established");
		}	
	}
}