package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import databaseConnection.ConnectionProvider;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
			Connection con=ConnectionProvider.getConnection();
			PreparedStatement p=con.prepareStatement("select * from items");
			ResultSet rs=p.executeQuery();
			response.setContentType("text/html");
			out.println("<html><body><table><tr><th style='width:150px';>Item Name</th><th style='width:100px;'>Item Size</th><th style='width:100px;'>Quantity</th><th style='width:100px;'>Item Price</th>"
					+"</tr></table></body></html>");
			int sum=0;
			
			while(rs.next()) {
				sum=sum+rs.getInt("ItemPrice");
			    
				out.print("<table style='border:2px solid black;text-align:center;'><tr><td style='width:150px;'>"
						+ rs.getString("ItemName")+"</td><td style='width:100px;'>"
								+ rs.getString("ItemSize")+"</td><td style='width:100px;'>"
								+rs.getInt("Quantity")+"</td><td style='width:100px;'>"
								+rs.getInt("ItemPrice")+"</td></tr></table></body></html>");				
				
			}
			out.println("Total Price :"+ sum);
			out.println("");
			out.println("<html><body><a href='Delete' style='border: 2px solid red;\r\n"
					+ "    height: 32px;\r\n"
					+ "    width: 91px;\r\n"
					+ "    background-color: red;\r\n"
					+ "    color: white;\r\n"
					+ "    border-radius: 5px;\r\n"
					+ "    font-size: 15px;'>Delete Items</a></body></html>");
			out.println("<html><body><a href='Order' style='border: 2px solid green;\r\n"
					+ "    height: 32px;\r\n"
					+ "    width: 91px;\r\n"
					+ "    background-color: green;\r\n"
					+ "    color: white;\r\n"
					+ "    border-radius: 5px;\r\n"
					+ "    font-size: 15px;\r\n"
					+ "    padding: 7px;'>Order Now</a></body></html>");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
