package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import dao.ProductDAO;
import dao.myCart;
import model.Book;


/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String type=request.getParameter("type");				
		if(type.equals("del")){
			String id=request.getParameter("id");
			myCart mycart=(myCart) request.getSession().getAttribute("mycart");
			mycart.delBook(id);
			request.setAttribute("booklist", mycart.showMyCart());
			request.setAttribute("totalPrice", mycart.getTotalPrice());
			request.getRequestDispatcher("showMyCart.jsp").forward(request, response);	
	   }else if(type.equals("add")){
		String id=request.getParameter("id");
		myCart mycart=(myCart) request.getSession().getAttribute("mycart");
		mycart.addBook2(id);
		response.sendRedirect("ShowCartServlet");
//	  }else if(type.equals("update")){
//		    String bookids[]=request.getParameterValues("id");
//			String nums[]=request.getParameterValues("booknum");
//			myCart mycart=(myCart) request.getSession().getAttribute("mycart");
//			for(int i=0;i<bookids.length;i++){
//				mycart.updateBook(bookids[i],nums[i]);
//				System.out.println(bookids[i]);
//			}	
//			request.setAttribute("booklist", mycart.showMyCart());
//			request.setAttribute("totalPrice", mycart.getTotalPrice());
//			request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
	}else if(type.equals("check")){
		myCart mycart=(myCart) request.getSession().getAttribute("mycart");		
		request.setAttribute("booklist", mycart.showMyCart());
		request.setAttribute("totalPrice", mycart.getTotalPrice());
		request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
	}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
