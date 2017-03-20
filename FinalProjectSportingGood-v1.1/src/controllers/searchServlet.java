package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("productName");
		System.out.println(name);
		 List<Product> p=ProductDAO.instance.getProducts(name);
		/* if (p!= null) {*/
				
		        request.setAttribute("productList", p);
		        request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
		     /* } else {
		         request.getRequestDispatcher("SearchResult.jsp").forward(request, response);
		         PrintWriter p2=response.getWriter();
		         p2.print("NO ITEM FOR WHANT YOU WANT,SORRY !");
		         p2.close();		
		      }*/
	}

}
