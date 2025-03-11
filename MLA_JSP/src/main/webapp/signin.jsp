<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Signin Page</h1>
	<form action="regdata.jsp" method="post">
	
		UserName : <input type="text" name = "user"><br><br>
		E-mail : <input type="email" name="email"><br><br>
		Age : <input type="text" name = "age"> <br><br>
		Gender : 
		<input type="radio" name="gender" value="Male"><label for="Male">Male</label>
		<input type="radio" name="gender" value="Female"><label for="Female">Female</label><br><br>
		Enter Password : <input type="password" name="pwd"><br><br>
		<input type="submit" value="Register"><br>
	
	</form>


</body>
</html>