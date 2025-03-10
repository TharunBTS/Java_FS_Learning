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

	String user = request.getParameter("user");	
	String pass = request.getParameter("pwd");	
	
	if(user.equals("admin") && pass.equals("a123"))
	{
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request,response);
	}
	else
	{
		out.println("<br><br> Invalid Credentials");
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request,response);
	}

%>

</body>
</html>