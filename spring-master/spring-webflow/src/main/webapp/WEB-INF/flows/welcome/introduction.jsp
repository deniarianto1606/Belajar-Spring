<%-- 
    Document   : introduction
    Created on : Aug 21, 2016, 12:34:16 AM
    Author     : DeNiSa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Introduction</title>
    </head>
    <body>
        <h1>Library Holidays</h1>
        <c:forEach items="${holidays}" var="holiday">
        <fmt:formatDate value="${holiday}" pattern="yyyy-MM-dd" /><br />
    </c:forEach>
    <a href="${flowExecutionUrl}&_eventId=next">Next</a>
</body>
</html>
