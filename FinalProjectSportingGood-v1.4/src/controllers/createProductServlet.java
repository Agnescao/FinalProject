package controllers;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Product;
import dao.CategoryDAO;
import dao.ProductDAO;

/**
 * Servlet implementation class createProductServlet
 */
@WebServlet("/createProductServlet")
public class createProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  
		
		String name=request.getParameter("pName");
		Double price=99.0;
		/* price=Double.parseDouble(request.getParameter("price"));*/
		String de=request.getParameter("description");
		 String category=request.getParameter("categoryName");
		 int cid=CategoryDAO.instance.getId(category);
         String imageName=request.getParameter("images");
         String path=" d:\\soft\\apache-tomcat-8.0.26\\webapps\\ROOT\\"+imageName;
         Product product=new Product(name,price,de,cid,path);
 		ProductDAO.instance.uploadProduct(product);
 		
         
         
 		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
 		
	}

}
