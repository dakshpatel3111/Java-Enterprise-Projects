import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class DB_Access implements DB_vars {

	private Connection con;
	private Statement st;
	
	public DB_Access() {
		try { //her try catch is auto implemented
			Class.forName(driver);
			con = DriverManager.getConnection(url,uname,upass);
			st = con.createStatement(ResultSet.CONCUR_UPDATABLE,ResultSet.TYPE_SCROLL_SENSITIVE);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//method to get all the data from the table
	public ArrayList<Myproducts1> getAllData() {
		ArrayList<Myproducts1> all = new ArrayList<Myproducts1>();
		String sql = "select id,name , description,quantity,price from myproducts";
		try {
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Myproducts1 p = new Myproducts1(rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getDouble(5));
				
				all.add(p);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}


public boolean insertProduct(Myproducts1 p) {
	boolean success = true;
	String sql = "insert into myproducts (name,description,quantity,price) "
			+ ""+"values('"+p.getName()+"', '"+p.getDescription()+"','"+p.getQuantity()+"' ,'"+p.getPrice()+"')";
    try {
		st.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		success=false;
		e.printStackTrace();
	} 
	return success;
}
public boolean deleteProduct(int id) {
	boolean success = true;
	String sql = "delete from myproducts where id = " + id;
	try {
		int res = st.executeUpdate(sql);
		if(res ==0) {
			success = false;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		success = false;
		e.printStackTrace();
	}
	return success;
	
}
public ArrayList<Myproducts1> searchProduct(String val){
	ArrayList<Myproducts1>list= new ArrayList<Myproducts1>();
	String sql = "select id ,name, description,quantity,price from myproducts "+
	"where description like '%"+val+"%' or name like '%"+val+"%'";
	
	try {
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			Myproducts1 p = new Myproducts1(rs.getInt(1),
					rs.getString(2),
					rs.getString(3),
					rs.getInt(4),
					rs.getDouble(5));
			
			list.add(p);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return list;
}







}