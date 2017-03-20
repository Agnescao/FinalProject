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
    	
       
            PreparedStatement ps = con.prepareStatement("SELECT  * FROM Customer WHERE " +
                    "Name = ?");
            ps.setString(1,request.getParameter("username"));
            ResultSet res = ps.executeQuery();
            if(res.first()){
                out.print("User already exists");
            }else{
                out.print("User name is valid");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
%>