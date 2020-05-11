package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





@WebServlet("/ModifyAccount")
public class ModifyAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/ma.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             DB_Access db = new DB_Access();
		
		HttpSession sess = request.getSession();
				
		String Name = request.getParameter("Name");
		String loginName = request.getParameter("iname");
		String loginPass1 = request.getParameter("cpass");
		String loginPass2 = request.getParameter("cpass2");
	
		int uid= (Integer)sess.getAttribute("uid");
		User u = new User(-1,loginName,Name,loginPass1);
		db.modifyAccount(uid,u);
		response.sendRedirect("Home?msg=Account Modified");
	}

		
	}
	


