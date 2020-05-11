package DataAccessCode;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class Db_access {
	private String url = "jdbc:mysql://localhost:3306/phpmyadmin";
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String uname = "root";
	private String upass = "";
	
	private Connection c;
	private Statement st;
	private PreparedStatement pst;
	
	   // Run FrontDoor.java To run the project 

	
	public Db_access() {
		try {
			Class.forName(driver);
			c = DriverManager.getConnection(url, uname, upass);
			
			st=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public boolean addPizza(String name, String phone, String email,String address,String size,String[] toppings,int delivery,double price,java.sql.Timestamp sqldate,String sqltime) {
		boolean res = true;
		
		
		String sql = "insert into orderinfo (name,phone,email,Street,size, toppings,delivery,price,date,time) values (?, ?, ?,?,?,?,?,?,?,?)";
		try {
			pst = c.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, phone);
			pst.setString(3, email);
			pst.setString(4, address);
			pst.setString(5, size);
			pst.setString(6, Arrays.toString(toppings));
			pst.setInt(7, delivery);
			pst.setDouble(8, price);
			pst.setTimestamp(9, sqldate);
			pst.setString(10, sqltime);
			
			
			pst.executeUpdate();
		} catch (SQLException e) {
			//e.printStackTrace();
			res= false;
		    
		}
		
		return res;
	}
	
	public double countprice(String size,String[] toppings) {
		double sprice,fprice = 0,toprice=1;
		double tax ;
		
		int num = toppings.length;
		if(size.equals("small")) {
			sprice = 9.99;
			if(num == 4 ) {
				toprice = toprice * (num - 1 );
				
			}
			else if(num == 8) {
				toprice = toprice * (num - 2 );
			}
			else {
				toprice = num * toprice;
				
		}
			
			tax = (toprice + sprice)/100 * 13 ;
			
			 
			fprice = tax + toprice + sprice ;
			
			
		   
		}
		else if(size.equals("medium"))
		{
			sprice = 12.99;
			
			if(num == 4 ) {
				toprice = toprice * (num - 1 );
				
			}
			else if(num == 8) {
				toprice = toprice * (num - 2 );
			}
			else {
				toprice = num * toprice;
			}
			
			tax = (toprice + sprice)/100 * 13 ;
			 
			fprice = tax + toprice + sprice ;
		}
		
		else if(size.equals("large")) {
			sprice = 14.99;
			
			if(num == 4 ) {
				toprice = toprice * (num - 1 );
				
			}
			else if(num == 8) {
				toprice = toprice * (num - 2 );
			}
			else {
				toprice = num * toprice;
			}
			
			tax = (toprice + sprice)/100 * 13 ;
			 
			fprice = tax + toprice + sprice ;
		}
		
		else if (size.equals("extralarge")) {
			sprice = 19.99;
			
			if(num == 4 ) {
				toprice = toprice * (num - 1 );
				
			}
			else if(num == 8) {
				toprice = toprice * (num - 2 );
			}
			else {
				toprice = num * toprice;
			}
			
			tax = (toprice + sprice)/100 * 13 ;
			 
			fprice = tax + toprice + sprice ;
		}
		
		
		return fprice;
	}
	
	public String changesize(String size) {
		String s = null;
		
		if(size.contentEquals("small")) {
			
		s = "S";
		
		}
		else if(size.contentEquals("medium")) {
			
			s = "M";
			
			}
		else if(size.contentEquals("large")) {
			
			s = "L";
			
			}
		else if(size.contentEquals("extralarge")) {
			
			s = "EL";
			
			}
			
			
		return s;
	}
	
	public String arraytostring(String[] toppings) {
		
		StringBuffer sb = new StringBuffer();
	      for(int i = 0; i < toppings.length; i++) {
	         sb.append(toppings[i]);
	      }
	      String toppinglist = Arrays.toString(toppings);
	      return toppinglist;
	}
}

//		public void currentdate(){
//			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//			Date date = new Date(0);
//			System.out.println(formatter.format(date));
	
//}
	
	       
		

