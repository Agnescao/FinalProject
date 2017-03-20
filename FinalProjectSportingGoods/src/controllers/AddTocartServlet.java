package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.OrderDAO;
import model.Order;
import model.User;

/**
 * Servlet implementation class cartServlet
 */
@WebServlet("/AddTocartServlet")
public class AddTocartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTocartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		
        if(session.getAttribute("user")==null){ 
        	request.getRequestDispatcher("login.jsp").forward(request, response);
           
        }
        else{
        	int userId = ((User) session.getAttribute("user")).getId();
        	// If the user enters a negative or invalid number in the
        	// Update text box, the quantity is automatically reset to 1.
        	int quantity = 1;
        	try
        	{
        	 quantity=Integer.parseInt(request.getParameter("quantity"));
        	 System.out.println(quantity);
        	if (quantity < 0)
        	quantity = 1;
        	}
        	catch(NumberFormatException nfe)
        	{
        	quantity = 1;
        	}
        	
        	int productID=Integer.parseInt(request.getParameter("productid"));
            OrderDAO.instance.addtocart(productID,quantity,userId);
            
           String type=request.getParameter("typeOfProduct");
            if(type.equals("men")){response.sendRedirect("MenModal.jsp");}
            if(type.equals("women")){response.sendRedirect("WomenModal.jsp");}
            if(type.equals("Equipment")){response.sendRedirect("EquipmentModal.jsp");}
            if(type.equals("gear")){response.sendRedirect("Modal.jsp");}
            if(type.equals("search")){response.sendRedirect("SearchModal.jsp");}
        	}
		
		
	}

}
