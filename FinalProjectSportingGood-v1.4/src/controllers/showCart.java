package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.User;
import model.Order;
import dao.CartDAO;
import dao.OrderDAO;

/**
 * Servlet implementation class showCart
 */
@WebServlet("/showCart")
public class showCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		
        if(session.getAttribute("user")==null){  request.getRequestDispatcher("login.jsp").forward(request, response);
        
        }
        else{
        	int userId = ((User) session.getAttribute("user")).getId();
        	// get the cart name of a certain user
        	String cartName=  CartDAO.instance.getCartNameByUserId(userId);
        	request.setAttribute("cartName", cartName);
        	//get  all of orders for one user who have login.
	    
	      List<Order> items=new ArrayList<Order>();
		try {
			items = OrderDAO.instance.getOrders(userId);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	      request.setAttribute("items", items);
	      request.getRequestDispatcher("myCart.jsp").forward(request, response);
	      

        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
