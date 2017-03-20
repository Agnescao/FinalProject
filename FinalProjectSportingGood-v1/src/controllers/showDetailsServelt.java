package controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class showDetailsServelt
 */
@WebServlet("/showDetailsServelt")
public class showDetailsServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showDetailsServelt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("pid"));
		Product p;
		try {
			 p=ProductDAO.instance.get(id);
			 //request.setAttribute("productselected",p);
			 request.getSession().removeAttribute("productselected");
			 request.getSession().setAttribute("productselected", p);
			 //response.sendRedirect("Modal.jsp");
			 String type=request.getParameter("type");
	            if(type.equals("men")){response.sendRedirect("MenModal.jsp");}
	            if(type.equals("women")){response.sendRedirect("WomenModal.jsp");}
	            if(type.equals("equipment")){response.sendRedirect("EquipmentModal.jsp");}
	            if(type.equals("gear")){response.sendRedirect("Modal.jsp");}
	            if(type.equals("search")){response.sendRedirect("SearchModal.jsp");}
	            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
