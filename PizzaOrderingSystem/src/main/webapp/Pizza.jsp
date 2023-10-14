<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean class="beans.PizzaBean" id="pb"></jsp:useBean>
<jsp:setProperty property="*" name="pb"></jsp:setProperty>
<jsp:useBean class="dao.PizzaDao" id="pd"></jsp:useBean>
<%
String msg=pd.savePizza(pb);
%>
<jsp:forward page="Pizza.html"></jsp:forward>
</body>
</html>