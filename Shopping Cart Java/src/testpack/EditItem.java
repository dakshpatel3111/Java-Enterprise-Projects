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
 * Servlet implementation class EditItem
 */
@WebServlet("/EditItem")
public class EditItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/mi.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DB_Access db = new DB_Access();
		String name = request.getParameter("iname");
		int qty = Integer.parseInt(request.getParameter("iqty"));
		HttpSession sess = request.getSession();
		String msg ="";
		request.setAttribute("msg", msg);
		
		db.deleteItem(name);
		int uid = (Integer)sess.getAttribute("uid");
		db.addNewItem(name, qty, uid);
		response.sendRedirect("Home");
	}

}
