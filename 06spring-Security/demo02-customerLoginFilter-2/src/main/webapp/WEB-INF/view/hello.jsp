<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangxiyue
  Date: 2017/11/7
  Time: 13:03
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

      <a href="${pageContext.request.contextPath}/j_spring_security_logout" />"> Logout</a></h2>

</body>
</html>
