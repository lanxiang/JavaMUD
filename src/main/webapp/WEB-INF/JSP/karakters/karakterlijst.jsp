<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="karakter" items="gebruiker.karakter">
    <c:url var="karakterURL" value="/lokatie">
        <c:param name="karakterId" value="${karakter.id}"/>
    </c:url>
    <a href="${karakterURL}">${karakter.naam}</a>
</c:forEach>