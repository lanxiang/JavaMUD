<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<c:set var="contextPath"
	value="${pageContext.servletContext.contextPath}" />
<!DOCTYPE html>
<html lang="nl">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<link rel="stylesheet" href="${contextPath}/styles/default.css" />
</head>
<body>
	<h1>Aanmelden</h1>
	<form method="post" action='<c:url value="/j_spring_security_check"/>'>
		<label>email: <input type="text" name="j_username" /></label> <label>Paswoord:
			<input type="password" name="j_password" />
		</label> <input type="submit" value="Inloggen" />
	</form>
	<form method="get" action='<c:url value="/hoofdmenu"/>'>
		<input type="submit" value="Nieuwe gebruiker aanmaken"
			<security:authorize access="isAuthenticated()">disabled="disabled"</security:authorize> />
	</form>
	<c:if test="${param.fout }">
		<p class="fout">Foutieve inloggegevens!</p>
	</c:if>

</body>
</html>