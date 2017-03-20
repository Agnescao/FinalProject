package controllers;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dao.UserDao;
import dao.myCart;
import model.Book;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		// TODO Auto-generated method stub
		 String name = request.getParameter("name");
	      String password = request.getParameter("password");
	      User user = UserDao.instance.checkLogin(name, password);
	      if (user != null) {
	         HttpSession session = request.getSession();
	         session.setAttribute("user", user);
	         myCart mycart=new myCart();
	         request.getSession().setAttribute("mycart", mycart);
	        List<Book> books = ProductDAO.instance.list();
	        request.setAttribute("books", books);
	        // RequestDispatcher rd= request.getRequestDispatcher("ListProductServlet");
	        // rd.forward(request, response);
	        request.getRequestDispatcher("shoppinghall.jsp").forward(request, response);
	      } else {
	         request.getRequestDispatcher("login.jsp").forward(request, response);
	      }
	   }
	}


