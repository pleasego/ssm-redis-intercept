<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    %>
    <base href="<%=basePath%>">
</head>
<body>
    <form action="checkLogin" method="post">
        <input type="text" name="loginId">
        <input type="password" name="loginPwd">
        <input type="submit">
        <font color="red">${msg}</font>
    </form>
</body>
</html>