package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comment;
import model.Reply;
import model.User;
import dao.CommentDAO;
import dao.CustomerDAO;
import dao.ReplyDAO;

/**
 * Servlet implementation class ShowCommentServlet
 */
@WebServlet("/ShowCommentServlet")
public class ShowCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
HttpSession session=request.getSession();
		
        if(session.getAttribute("user")==null){ 
        	request.getRequestDispatcher("login.jsp").forward(request, response);
           
        }
        else{
        	int userId = ((User) session.getAttribute("user")).getId();
        	String name=CustomerDAO.instance.getName(userId);
		    List<Comment> cs=CommentDAO.instance.getComments(userId);
		    
		   
		    /*List<Reply> rs=ReplyDAO.instance.getReply(commentID);*/
		    request.setAttribute("user",name);
		    request.setAttribute("comments",cs);
		  /*  request.setAttribute("replys",rs);*/
		
		 request.getRequestDispatcher("userChat.jsp").forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
