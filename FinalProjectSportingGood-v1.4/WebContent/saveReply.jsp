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
    	
       
            PreparedStatement ps = con.prepareStatement("INSERT INTO  REPLY (CommentID,REPLY) VALUES (?, ?)");
            
            ps.setInt(1,Integer.parseInt(request.getParameter("commentId")));   
            ps.setString(2,request.getParameter("reply"));
            ps.executeUpdate();
            
            PreparedStatement ps2 = con.prepareStatement("SELECT  * FROM reply WHERE " +
                    "CommentID = ?");
         
            ps2.setInt(1,Integer.parseInt(request.getParameter("commentId")));
            ResultSet res2 = ps2.executeQuery();
            
            while(res2.next()){
          	  int id=res2.getInt("id");
          	  int commentID=res2.getInt("CommentID");
          	  String reply=res2.getString("reply");
          	out.write("<li>");
          	out.write("Administrator:"+reply);
        	out.write("</li>");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
%>