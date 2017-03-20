package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import dao.UserDAO;

/**
 * Servlet implementation class HelloControllerServlet
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
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TOD
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String password = request.getParameter("password");
      User user = UserDAO.instance.checkLogin(name, password);
      if (user != null) {
         HttpSession session = request.getSession();
         session.setAttribute("user", user);
         System.out.println("login1");
         request.getRequestDispatcher("MainPage.jsp").forward(request, response);
      } else {
    	  System.out.println("login");
         request.getRequestDispatcher("register.jsp").forward(request, response);
      }
   }

}
