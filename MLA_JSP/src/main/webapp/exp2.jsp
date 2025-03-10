<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>




<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>

*
{
margin : 0px;
box-sizing: border-box;
padding: 0px;
}


.nav-bar
{

	display : flex;
	flex-direction : row;
	justify-content : space-between;
	align-items: center;
}

ol{
display : flex;
align-items: center;
gap:25px;
text-decoration: none;
list-style-type: none;
font-size: 22px
}



.hright img
{
height : 50px;
width : 50px;
border-radius: 5px;
margin-right : 10px
}

</style>

<body>

<div class = "nav-bar">
<div class="hleft">
<h1>Mphasis</h1>
</div>



<div class="hmid">

<ol>
<li> <a href=""> Home </a> </li>
<li><a href=""> Services </a> </li>
<li><a href=""> Product </a> </li>
</ol>

</div>

<div class="hright" style="display: flex">

<div 
style="font-size : 15px;
justify-content: center;
align-content:  center;
font-size: 20px;
margin-right:10px">


<% 

%>


<a href='login.jsp'>Login</a>
<a href='signin.jsp' style="left:30px">Signin</a>



</div>

<div>
<img src="data:image/jpeg;base64,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">
</div>

</div>





</div>
</body>
</html>