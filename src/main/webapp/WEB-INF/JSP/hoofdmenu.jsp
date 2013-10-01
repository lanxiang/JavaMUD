<%-- 
    Document   : hoofdmenu
    Created on : Oct 1, 2013, 10:30:36 AM
    Author     : Tim.VandenLangenberg
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.servletContext.contextPath}"/>
<!DOCTYPE html>
<html lang="nl">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JavaMUD - Hoofdmenu</title>
        <link rel="stylesheet" href="${contextPath}/styles/default.css"/>
    </head>
    <body>
        <c:choose>
            <c:when test="${not empty gebruiker}">
                <div id="nieuwKarakter">
                    <c:url var="nieuwKarakterURL"/>
                    <a href="${nieuwKarakterURL}">Nieuw karakter</a>
                </div>

                <div id="karakterLijst">
                    <jsp:include page="karakters/karakterlijst.jsp"/>
                </div>
                
                <div id="afmelden">
                    <c:url var="afmeldURL"/>
                    <a href="${afmeldURL}">Afmelden</a>
                </div>
            </c:when>
            <c:otherwise>
                <div id="aanmelden">
                    <c:url var="aanmeldURL"/>
                    <a href="${aanmeldURL}">Aanmelden</a>
                </div>
            </c:otherwise>
        </c:choose>
    </body>
</html>
