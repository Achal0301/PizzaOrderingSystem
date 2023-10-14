package dao;
import java.sql.*;

import beans.BurgerBean;
import databaseConnection.ConnectionProvider;

public class BurgerDao {
	public String save(BurgerBean b) {
		try {
		Connection con=ConnectionProvider.getConnection();
		PreparedStatement p=con.prepareStatement("select * from itemPrices where itemName=(?)" );
		p.setString(1, b.getBurger());
		ResultSet rs=p.executeQuery();
		String t=b.getSize();
		int price=0;
		if(rs.next()) {
			price=rs.getInt(t)*b.getQty();		
		}
		
		p=con.prepareStatement("insert into items values(?,?,?,?)");
		p.setString(1, b.getBurger());
		p.setString(2, b.getSize());
		p.setInt(3, b.getQty());
		p.setInt(4, price);
		int i=p.executeUpdate();
		if(i>0) {
			return "done";
		}
		else {
			return "fail";
		}
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return "error";
	}

}
