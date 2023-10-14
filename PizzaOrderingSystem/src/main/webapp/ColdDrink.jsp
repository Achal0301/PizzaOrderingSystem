<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="cb" class="beans.ColdDrinkBean"></jsp:useBean>
<jsp:setProperty property="*" name="cb"></jsp:setProperty>
<jsp:useBean id="cd" class="dao.ColdDrinkDao"></jsp:useBean>

<%String msg=cd.save(cb);
%>

<jsp:forward page="ColdDrinks.html"></jsp:forward>
</body>
</html>