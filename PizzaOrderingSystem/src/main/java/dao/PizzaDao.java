package dao;
import java.sql.*;

import beans.PizzaBean;
import databaseConnection.ConnectionProvider;

public class PizzaDao {
    public String savePizza(PizzaBean pb) {
    	try {
    		Connection con=ConnectionProvider.getConnection();
    		PreparedStatement p=con.prepareStatement("select * from itemPrices where itemName=(?)");
    		p.setString(1,pb.getPizza());
    		ResultSet rs=p.executeQuery();
    		String t=pb.getSize();
    		int price=0;
    		if(rs.next()) {
    			price=rs.getInt(t)*pb.getQty();
    		}
    		
    		
    		
    		p=con.prepareStatement("insert into items values (?,?,?,?)");
    		p.setString(1, pb.getPizza());
    		p.setString(2, pb.getSize());
    		p.setInt(3, pb.getQty());
    		p.setInt(4, price);
    		int i=p.executeUpdate();
    		if(i>=1) {
    		return "done";
    		}
    		else {
    			return "no";
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    	return "hello";
    }
}
