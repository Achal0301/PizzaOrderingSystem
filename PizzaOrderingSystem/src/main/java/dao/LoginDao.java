package dao;
import java.sql.*;

import beans.LoginBean;
import databaseConnection.ConnectionProvider;

public class LoginDao {
	public String login(LoginBean l) {
	Connection con=null;
	
	try {
		con=ConnectionProvider.getConnection();
		PreparedStatement p=con.prepareStatement("select * from reg where name=(?)");
		//p.setString(1, l.getUpass());
		p.setString(1, l.getUname());
		ResultSet rs=p.executeQuery();
		if(rs.next()) {
			
			String pass=rs.getString("password");
			if(pass.equals(l.getUpass())) {
				return "success";
			}
			else {
				return "fail";
			}
			
		}
		
	}catch(Exception e) {
		System.out.print(e);
	}
	return "error";
   
  }
}
