<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var m ="${message}";
	if(m != ''){
		alert(m);
	}
</script>
</head>
<body>
	<h1>NotieList</h1>
	<table>
		<tr>
			<td>num</td>
			<td>title</td>
			<td>writer</td>
			<td>contents</td>
			<td>reg_date</td>
			<td>hit</td>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
				<td>${dto.num}</td>
				<td><a href="NoticeView?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.contents}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.hit}</td>
		</tr>
		
		</c:forEach>
	</table>
	
	
	
	<a href="NoticeWrite">write</a>
</body>
</html>