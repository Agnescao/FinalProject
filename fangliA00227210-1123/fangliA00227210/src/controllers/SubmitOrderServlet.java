package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import dao.OrderDAO;
import dao.myCart;

/**
 * Servlet implementation class SubmitOrderServlet
 */
@WebServlet("/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//try{
		myCart mycart=(myCart)request.getSession().getAttribute("mycart");
		User user=(User)request.getSession().getAttribute("user");
		OrderDAO.instance.submitorder(mycart,user);
		request.getRequestDispatcher("OrderOk.jsp").forward(request, response);
	//}
		//catch(Exception e){
		//System.out.println(e.getMessage());
		//request.getRequestDispatcher("login.jsp").forward(request, response);}
		
	
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
