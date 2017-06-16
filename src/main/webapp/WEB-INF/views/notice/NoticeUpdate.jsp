<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>NoticeUpdate</h1><br>
	
	<form action="NoticeUpdate" method="post">
	<p><input type="hidden" name="num" value="${dto.num}"></p>
	<p><input type="text" name="title"></p>
	<p><input type="text" name="contents"></p>
	<p><input type="submit" name="UPdate"></p>
	</form>
	
</body>
</html>