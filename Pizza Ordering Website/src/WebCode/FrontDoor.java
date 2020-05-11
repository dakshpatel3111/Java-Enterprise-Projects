package WebCode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BuissnessCode.User;


@WebServlet("/FrontDoor")
public class FrontDoor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FrontDoor() {
        super();
        
    }
/**
 * This is the Main Page to Run the Application 
 *  These Servlets holds front.jsp as its View Interface In MVC and is Controlled by FrontDoor.java Servlet
 * This Servlets takes the User values like Name, Email, Address , Phone and OrderType
 * @requestparamter msg , the msg is the Error message that user recieves on improper input
 * @requestparameter Name,phone,email,address,ordertype these are the parameters taken from user
 * All the Parameters are saved on the session 
 */
    // Run FrontDoor.java To run the project 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//This  is the Front page where user enters his or her name and his details 
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
     // This is for validations
        String msg = request.getParameter("msg");
        
        // Form  to take values from the users 
        request.getRequestDispatcher("/WEB-INF/pages/front.jsp").forward(request, response);
        
        
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // In this Do post method we have taken the values from the user and transferred it to the next Page (Order Page )
		
		//Creating variables from the value submitted by form
		String name = request.getParameter("uname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String ordertype = request.getParameter("ordertype");
		
		
		//Validation of all the Inputs done by user
		
	if(name != "" && phone != "" && email != "" && address != "") {
		//Adding all the Elements to the Session 
		HttpSession sess = request.getSession();
		
		User u = new User();
		u.setName(name);
		u.setPhone(phone);
		u.setEmail(email);
		u.setOrdertype(ordertype);
		u.setAddress(address);
		
	 // sending user to the session 

		sess.setAttribute("user", u);
		
		
	
		//Sending the user to the next page
		response.sendRedirect("OrderPage");
		
		}
		else {
			response.sendRedirect("FrontDoor?msg=Please fill up whole form");
		}
	}

}
