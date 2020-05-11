package testpack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ViewItem")
public class ViewItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int iid = Integer.parseInt(request.getParameter("id"));
		DB_Access db = new DB_Access();
		ArrayList<Item> allItems = db.getsingleItems(iid);
		request.setAttribute("allItems", allItems);
		for(Item i : allItems)
		{
			
			String name = i.getName();
			int qty = i.getQty();
			if(i.getId()==iid) {
			request.setAttribute("itemname", name);
			request.setAttribute("itemqty", qty);
			}
		
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/pages/vi.jsp");
		rd.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
