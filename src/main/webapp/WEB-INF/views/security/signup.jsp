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
	<h2>회원가입</h2>
	<form action="/member/signup" method="post">
		아이디 : <input type="text" name="memId">
		비밀번호 : <input type="password" name="memPw">
		<input type="submit" value="회원가입">
		<sec:csrfInput/>
	</form>
</body>
</html>