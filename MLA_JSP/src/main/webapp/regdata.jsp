<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb","root","12345");
		String sql = "insert into tb1 values(?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		
		String s1 = request.getParameter("user");
		String s2 = request.getParameter("pwd");
		
		pst.setString(1, s1);
	    pst.setString(2, s2);
	    pst.execute();
	    
	    
	    response.sendRedirect("exp2.jsp");
	    
	    
	    
	    
	}
	catch(Exception e)
{
		e.printStackTrace();
}
%>

</body>
</html>