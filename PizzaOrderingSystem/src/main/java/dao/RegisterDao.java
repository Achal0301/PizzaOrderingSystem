package dao;
import java.sql.*;

import beans.RegisterBean;
import databaseConnection.ConnectionProvider;

public class RegisterDao {
	public String save(RegisterBean r) {
		Connection con=null;
		try {
			con=ConnectionProvider.getConnection();
			PreparedStatement p=con.prepareStatement("insert into reg values (?,?,?,?)");
			p.setString(1, r.getMyName());
			p.setString(2, r.getMyPass());
			p.setString(3, r.getMyMobile());
			p.setString(4, r.getMyMail());
			int i=p.executeUpdate();
			if(i>=1){
				return "Success";
			}
			else {
				return "fail";
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return "false";
	}
}
