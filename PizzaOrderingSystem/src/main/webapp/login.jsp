<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean class="beans.LoginBean" id="lb"></jsp:useBean>
<jsp:setProperty property="*" name="lb"/>
<jsp:useBean class="dao.LoginDao" id="ld"></jsp:useBean>


<%String result=ld.login(lb);

if(result.equals("success")){
	out.println("good to go");
%>
<jsp:forward page="Home.html"></jsp:forward>


<%	
}
else if(result.equals("fail")){
out.println("Enter correct username and password");
%>
<jsp:forward page="login.html"></jsp:forward>
<% 
}
else{
	out.println("Sorry");
}
%>

</body>
</html>