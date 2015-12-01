<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    <a href="?lang=ru">ru</a>
</span>
<p><a href="${pageContext.request.contextPath}/tablets"><spring:message code="Show current tablets"/></a></p>

<sec:authorize access="!isAuthenticated()">
    <p><a href="<c:url value='/login' />"><spring:message code="log in"/></a></p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <p><a href="<c:url value='/j_spring_security_logout' />"><spring:message code="log out"/></a></p>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ADMIN')">
    <p><a href="<c:url value='/admin' />"><spring:message code="admin"/></a></p>
</sec:authorize>

</body>
</html>