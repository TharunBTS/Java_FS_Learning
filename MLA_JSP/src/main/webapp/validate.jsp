<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 

String name = request.getParameter("user");
String pass = request.getParameter("pwd");

boolean isValid = false;

try
{
	
	Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "12345");
    String sql = "SELECT fname, pass FROM tb1 WHERE fname=? AND pass=?";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setString(1, name);
    pst.setString(2, pass);
    
    ResultSet rs = pst.executeQuery();
    
    while (rs.next()) {
        
    	String s1 = rs.getString("fname");
    	String s2 = rs.getString("pass");
    	
    	if(s1.equals(name) && pass.equals(s2))
    	{
    		isValid = true;
    	}
    }
    
    rs.close();
    pst.close();
   // conn.close();
	
	
	
}
catch(Exception e)
{
	e.printStackTrace();
}




 if(isValid)
{
	HttpSession hs = request.getSession();
	hs.setAttribute("username", name );
	
	response.sendRedirect("exp2.jsp");
}
else
{
	out.println("<center> <h3><font color='red'> Login failed.</font> </h3></center>");
	response.sendRedirect("login.jsp");
}

%>


</body>
</html>