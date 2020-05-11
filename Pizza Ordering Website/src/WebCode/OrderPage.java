package WebCode;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BuissnessCode.Pizza;
import BuissnessCode.User;
import DataAccessCode.Db_access;



@WebServlet("/OrderPage")
public class OrderPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 /**
  * This Servlet uses order.jsp as output or Input
  */
    public OrderPage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    // Run FrontDoor.java To run the project 

    /**
     * These Servlets holds Order.jsp as its View Interface Im MVC and is Controlled by OrderPage.java Servlet
     * @requestJavaBean User , In User all the Details like name,Phone,email,address,ordertype are saved which are retrived from user
     * Here all the User order is created in Pizza Class and all the Toppings and Size are added to pizza class
     * Then all the Pizza ordered are added to the User class
     * @requestJavaBean pizza , Pizza is added to the USer class and then whole User class is added to the Session 
     */

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//taking the session and directing the server to the jsp page
		
	    
		HttpSession sess = request.getSession();
		
		
		//Initializing the variables by setting them with session values
		String name = (String)sess.getAttribute("name");
		
		request.setAttribute("name", name);
	     
		//Redirecting to the Order.jsp
		request.getRequestDispatcher("/WEB-INF/pages/order.jsp").forward(request, response);
		
       
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		Db_access db = new Db_access();
		
		//Getting the User object 
		User u = (User)sess.getAttribute("user");
	    String name = u.getName();
		String phone =u.getPhone();
		String email =u.getEmail();
		String address =u.getAddress();
	    String ordertype = u.getOrdertype();
		
			
		
		//For Size and Toppings
		String si = request.getParameter("size");
		String size = db.changesize(si);
		
		//for toppings 
		String[] toppings = (String[]) request.getParameterValues("toppings");
		//converting toppings array to string 
		String toppinglist = db.arraytostring(toppings);
		
	

		//for Price  , I have Used the method from Db_access 
		double price = db.countprice(si, toppings);
		
		//for price to add in session 
		DecimalFormat format = new DecimalFormat("$#0.00"); 
		format.format(price); 
		request.getSession().setAttribute("price",price);
		
		//For date , time and Ordertype
		 
	    //for the Ordertype
		
	    	int delivery=0;
	    if(ordertype.equals("delivery")) {
	    	
	    	delivery = 1;
	    }
	    else  if(ordertype.equals("pickup")) {
	    	delivery =0;
	    }
	
	    //for the Current Date and Time
	    java.util.Date date=new java.util.Date();
		
		java.sql.Timestamp sqlDate=new java.sql.Timestamp(date.getTime());

		
		
		
		//for Pickup time 
	    
		String sqlTime = null;
		
	    if(ordertype.equals("delivery")) {
	    	
	    	Calendar now = Calendar.getInstance();
		    now.add(Calendar.MINUTE, 45);
			 
		    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		     sqlTime = df.format(now.getTime());
	    }
	    else  if(ordertype.equals("pickup")) {
	    	Calendar now = Calendar.getInstance();
		    now.add(Calendar.MINUTE, 20);
			 
		    SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		     sqlTime = df.format(now.getTime());
	    }
	    
	    
		//creating pizza object 
		Pizza p = new Pizza();
		p.setSize(size);
		p.setToppings(toppinglist);
		p.setPrice(price);
		p.setSqldate(sqlDate);
		p.setSqltime(sqlTime);
		
		
		//Now adding the pizza to the User 
	    u.setPizza(p);
	    sess.setAttribute("user", u);
	    sess.setAttribute("pizza", p);
	  
		
		//Adding pizza to the list
	    ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	    pizzas.add(p);
	   
	    if(sess.getAttribute("pizzas") != null) {
		    pizzas.addAll((ArrayList<Pizza>) sess.getAttribute("pizzas"));    
		}
	    
	    
	    
	    //Adding the list to the session 
	    sess.setAttribute("pizzas", pizzas);
	    
	   
	     //adding to the database and checking 
		if(db.addPizza(name, phone, email, address, size, toppings, delivery, price, sqlDate, sqlTime)) {
			 
			response.sendRedirect("Cart");
			
		
	   }
	  else {
		   response.sendRedirect("OrderPage?msg=Please fill all the values");
	   }
		
	}

}
