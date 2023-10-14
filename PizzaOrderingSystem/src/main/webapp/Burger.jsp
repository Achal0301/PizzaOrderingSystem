<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bb" class="beans.BurgerBean"></jsp:useBean>
<jsp:setProperty property="*" name="bb"></jsp:setProperty>
<jsp:useBean id="bd" class="dao.BurgerDao"></jsp:useBean>
<%String msg=bd.save(bb);
%>
<jsp:forward page="Burger.html"></jsp:forward>
</body>
</html>