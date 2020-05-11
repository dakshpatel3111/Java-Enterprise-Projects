package testpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
 * Servlet implementation class Additem
 */
@WebServlet("/Additem")
public class Additem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/ai.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DB_Access db = new DB_Access();
//		if(db.isItemNameValid(request.getParameter("iname")) && 
//				db.isItemQtyValid(request.getParameter("iqty"))) {
		String ItemName = request.getParameter("iname");
		int iQty = Integer.parseInt(request.getParameter("iqty"));
		
		
		HttpSession sess = request.getSession();
		int uid = (Integer)sess.getAttribute("uid");
		db.addNewItem(ItemName, iQty, uid);
		response.sendRedirect("Home?msg=item added succesfully");
		}
//		else {
//			response.sendRedirect("Home?msg=Values are wrong try again");
//		}
	}


