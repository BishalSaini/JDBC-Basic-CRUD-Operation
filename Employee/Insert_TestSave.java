
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert_TestSave { 
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/crud_operations"; 
		String username="root"; 
		String password="root";  
		String sql="INSERT INTO employee VALUES(6,'Piyush','piyu01@mail.com','CEO')"; 
		Connection connection=null;
		
		//STEP1:Load/Register the Driver
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 		
		//STEP2:Create Connection 
			connection= DriverManager.getConnection(url,username,password); 
		//STEP3:Establish Statement 
			Statement statement=connection.createStatement(); 
		//STEP4:Execute The Statement 
		statement.execute(sql); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	    try {
			connection.close(); 
			System.out.println("ALL GOOD");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	    
	}
}

