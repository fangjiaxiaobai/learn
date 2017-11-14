<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangxiyue
  Date: 2017/11/7
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <h1 align="center">${title}</h1>
<h2>${message}</h2>
    ${userPrincipal.name}
    <h2><a href="<c:url value="/logout" />"> Logout</a></h2>
</body>
</html>
