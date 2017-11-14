<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
</head>
<body>
    <h2 align="center">Greeting : ${loginUser}. This is a welcome page.</h2>

    <ul align="center">
        <li><h3><a href="/user/list">用户列表</a></h3></li>
        <li><h3><a href="/role/list">权限列表</a></h3></li>
        <li><h3><a href="/permission/list">权限列表</a></h3></li>
    </ul>
</body>
</html>