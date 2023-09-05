
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class GetAll_TestSave2 { 
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/crud_operations";
		String username= "root";
		String password= "root";  
		String sql="SELECT * FROM student";
		Connection connection = null;
		
		//STEP 1: Load/Register the driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		//STEP 2:Establish Connection
		 connection= DriverManager.getConnection(url, username, password);
	    //Establish statement
			Statement statement = connection.createStatement();
	   //Execute the statement
			ResultSet resultSet=statement.executeQuery(sql);  
			while(resultSet.next()) { 
				System.out.println(resultSet.getInt(1));  
				System.out.println(resultSet.getString(2));   
				System.out.println(resultSet.getString(3));  
				System.out.println(resultSet.getString(4)); 
				System.out.println("----------------------");
			} 
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("All good");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}		
}
