<%--
  Created by IntelliJ IDEA.
  User: wangxiyue
  Date: 2017/11/7
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<body>
<h1>Title : ${title}</h1>
<h1>Message : ${message}</h1>


<!-- csrt for log out-->
<%--<form action="${logoutUrl}" method="post" id="logoutForm">--%>
    <%--<input type="hidden"--%>
           <%--name="${_csrf.parameterName}"--%>
           <%--value="${_csrf.token}" />--%>
<%--</form>--%>

<script>
//    function formSubmit() {
//        document.getElementById("logoutForm").submit();
//    }
</script>

<c:if test="${pageContext.request.userPrincipal.name != null}">
    <h2>
        Welcome : ${pageContext.request.userPrincipal.name} |
        <%--<a href="javascript:formSubmit()"> Logout</a>--%>
        <a href="${pageContext.request.contextPath}/logout"> Logout</a>
    </h2>
</c:if>

</body>
</html>