package databaseConnection;
import java.sql.*;


public final class ConnectionProvider {
	
	public static Connection getConnection() {
		Connection con=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con=DriverManager.getConnection(DatabaseDetails.DATABASE_URL ,DatabaseDetails.DATABASE_USER,DatabaseDetails.DATABASE_PASS);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}

}
