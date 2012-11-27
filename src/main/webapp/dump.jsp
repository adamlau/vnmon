<%--
  Created by IntelliJ IDEA.
  User: adamlau
  Date: 15/10/12
  Time: 2:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<html>
<head>
    <title>Virtual Number monitoring</title>
    <p>Current checks:</p>
    <c:forEach var="state" items="${states}">
        ${state.toString()}<br/>
    </c:forEach>
    <br/>
    <p>Removed checks:</p>
    <c:forEach var="state" items="${removedStates}">
        ${state}<br/>
    </c:forEach>
</head>
<body>

</body>
</html>