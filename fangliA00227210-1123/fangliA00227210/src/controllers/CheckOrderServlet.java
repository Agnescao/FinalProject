package controllers;

import java.awt.List;
import java.io.IOException;



import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;
import model.Book;
import model.Order;
import model.User;

/**
 * Servlet implementation class CheckOrderServlet
 */
@WebServlet("/CheckOrderServlet")
public class CheckOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user=(User)request.getSession().getAttribute("user");
		int userid=user.getId();
		System.out.println(userid);
		ArrayList orders= (ArrayList)OrderDAO.instance.checkorder(userid);
		//for(int i=0;i<orders.size();i++){
		//	Order or=(Order)orders.get(i);
		//	System.out.println(or.getId());
		//}
		request.setAttribute("orders",orders);
		 request.getRequestDispatcher("checkmyorder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
