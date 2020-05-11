package WebCode;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BuissnessCode.Pizza;
import BuissnessCode.User;
import DataAccessCode.Db_access;

@WebServlet("/Cart")


/**
 * These Servlets holds cart.jsp as its View Interface In MVC and is Controlled by Cart.java Servlet
 * @reqeusteJavabean User , This parameter is obtained and all the values are added to database and recipet are created
 * This servlets controls the user request for adding pizza and getting recipept
 */
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   // Run FrontDoor.java To run the project 

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// This is the Cart Page , where user gets the Receipt from the website with the option to add another pizza
		
		request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//This is the Order page and i have retained the value to use it further 
		
		
		HttpSession sess = request.getSession();
		Db_access db = new Db_access();
		
		User u = (User)sess.getAttribute("user");
		String name = u.getName();
		String phone =u.getPhone();
		String email =u.getEmail();
		String address =u.getAddress();
	    String ordertype = u.getOrdertype();
	    
	    Pizza p = u.getPizza();
	    double price = p.getPrice();
	    String size = p.getSize();
	    String toppinglist = p.getToppings();
	    
	    // when the user  click add another pizza button 
	    response.sendRedirect("OrderPage");
		
	    
	}

}
