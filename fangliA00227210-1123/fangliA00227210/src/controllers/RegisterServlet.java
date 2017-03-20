package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.User;
import dao.UserDao;

/**
 * Servlet implementation class HelloControllerServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public RegisterServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException {
      String name = request.getParameter("name");
      String password = request.getParameter("pwd");
      String gender = request.getParameter("sex");
      String address = request.getParameter("address");
      String telephone = request.getParameter("telephone");
      String email = request.getParameter("email");
      int grade = (Integer.parseInt(request.getParameter("grade")));
      User user = new User(name,password,gender,address,telephone,email,grade);
      UserDao.instance.save(user);
     request.getRequestDispatcher("index.jsp").forward(request, response);
   }

}
