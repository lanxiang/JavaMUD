<%-- 
    Document   : lokatie
    Created on : Sep 30, 2013, 3:29:15 PM
    Author     : Tim.VandenLangenberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="nl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JavaMUD</title>
<link rel="stylesheet" href="${contextPath}/styles/default.css" />
</head>
<body>
	<c:import url="/WEB-INF/JSP/menu.jsp" />
	<h1>Lokatie ${lokatie.id}</h1>
	<div id="lokatieBescrijving">${lokatie.beschrijving}</div>
</body>
</html>
