<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%

    try{
    	
    	Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3307/sportinggoods";
		Connection con = DriverManager.getConnection(url, "root", "admin");
    	
       
            PreparedStatement ps = con.prepareStatement("SELECT  * FROM reply WHERE " +
                    "CommentID = ?");
         
            ps.setInt(1,Integer.parseInt(request.getParameter("commentId")));
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
          	  int id=res.getInt("id");
          	  int commentID=res.getInt("CommentID");
          	  String reply=res.getString("reply");
          	out.write("<li>");
          	out.write("Administrator:"+reply);
          	out.write("</li>");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
%>