<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>NoticeView</h1>

	<h3>WRITER : ${dto.writer}</h3>
	<h3> TITLE : ${dto.title}</h3>
  <h3>CONTENTS : ${dto.contents}</h3>
  <h3>REG_DATE : ${dto.reg_date}</h3>
       <h3>HIT : ${dto.hit}</h3>
	
	<a href="NoticeUpdate?num=${dto.num}">NoticeUpdate</a>
	<a href="NoticeDelete?num=${dto.num}">NoticeDelete</a>
</body>
</html>