<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>


<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.getQueryString()}"/>

<c:if test="${requestScope.countOfLaptops > requestScope.showCount}">

    <ul class="women_pagenation">
        <li>Page:</li>

        <c:if test="${currentPage != 1}">
            <tg:createHrefPage url="${url}" nameHref="Prev" page="${currentPage - 1}"/>
        </c:if>

        <c:set var="start" value="${currentPage - 1 eq 0 ? 1 : currentPage - 1}"/>
        <c:set var="end" value="${currentPage + 1 > countOfPages ? currentPage : currentPage + 1 }"/>

        <c:forEach var="i" begin="${start}" end="${end}">
            <tg:createHrefPage url="${url}" nameHref="${i}" page="${i}"/>
        </c:forEach>

        <c:if test="${currentPage < countOfPages}">
            <tg:createHrefPage url="${url}" nameHref="Next" page="${currentPage + 1}"/>
        </c:if>

    </ul>

</c:if>
