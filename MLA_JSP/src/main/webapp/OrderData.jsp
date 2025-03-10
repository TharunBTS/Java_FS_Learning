<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<jsp:useBean id="obj1" class="mphasis.test.Order"></jsp:useBean>  




<!--<jsp:setProperty property="id" name="obj1"/> 
<jsp:setProperty property="name" name="obj1"/> 
<jsp:setProperty property="descp" name="obj1"/> 
<jsp:setProperty property="qty" name="obj1"/> 
-->


<jsp:setProperty property="*" name="obj1"/>

<jsp:getProperty property="id" name="obj1"/>
<jsp:getProperty property="name" name="obj1"/>
<jsp:getProperty property="descp" name="obj1"/>
<jsp:getProperty property="qty" name="obj1"/>


<jsp:include page="home.jsp"></jsp:include>


</body>
</html>