package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.OrderDAO;

/**
 * Servlet implementation class RemoveItemsServlet
 */
@WebServlet("/RemoveItemsServlet")
public class RemoveItemsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();    
		  if(session.getAttribute("user")==null){ 
	        	request.getRequestDispatcher("login.jsp").forward(request, response);
	           
	        }
	        else{
		int userId = ((User) session.getAttribute("user")).getId();
		//String orderID=request.getParameter("orderID");
		int orderID=Integer.parseInt(request.getParameter("orderID"));
		System.out.println(orderID);
		         OrderDAO.instance.RemoveItems(orderID,userId);
		         response.sendRedirect("showCart");}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		         
	}

}
