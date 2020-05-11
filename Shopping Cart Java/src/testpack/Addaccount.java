package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Addaccount")
public class Addaccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/aa.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Access db = new DB_Access();
		String cname = request.getParameter("cname");
		String cpass = request.getParameter("cpass");
		String cpass2 = request.getParameter("cpass2");
		String Name = request.getParameter("Name");
		
		
		db.CreateAccount(cname, Name, cpass);
		response.sendRedirect("Addaccount?msg=Account Created");
	}

}
