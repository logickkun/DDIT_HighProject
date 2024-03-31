<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/login" method="post">
		아이디 : <input type="text" name="username">
		비밀번호 : <input type="password" name="password">
		<input type="submit" value="로그인"><br/>
		<input type="checkbox" id="remember" name="remember-me"> <label for="remember"> Remember Me </label>
		<sec:csrfInput/>
	</form>

</body>
</html>