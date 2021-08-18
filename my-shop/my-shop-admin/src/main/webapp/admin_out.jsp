
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<%
    response.setHeader("refresh", "2;URL=admin_login.jsp");
    session.invalidate();//注销
%>
<h3>你已经成功推出本系统，两秒返回首页</h3>
<h3>如果没有返回，请按<a href="admin_login.jsp">这里</a></h3>
</body>