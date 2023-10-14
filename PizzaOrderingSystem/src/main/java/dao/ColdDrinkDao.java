package dao;
import java.sql.*;

import beans.ColdDrinkBean;
import databaseConnection.ConnectionProvider;

public class ColdDrinkDao {
      public String save(ColdDrinkBean cd) {
    	  try {
    		Connection con=ConnectionProvider.getConnection();
    		PreparedStatement p=con.prepareStatement("select * from itemPrices where itemName=(?)");
    		p.setString(1, cd.getColdrink());
    		ResultSet rs=p.executeQuery();
    		String t=cd.getSize();
    		int price=0;
    		if(rs.next()) {
    			price=rs.getInt(t)*cd.getQty();
    			
    		}
    		p=con.prepareStatement("insert into items values (?,?,?,?)");
    		p.setString(1, cd.getColdrink());
    		p.setString(2, cd.getSize());
    		p.setInt(3, cd.getQty());
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
    	  return "hello";
      }
}
