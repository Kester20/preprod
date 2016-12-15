<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:out value="${requestScope.countOfLaptops}/${requestScope.showCount}"/>

<c:set var="url" value="${requestScope['javax.servlet.forward.request_uri']}?${pageContext.request.getQueryString()}"/>

<c:if test="${requestScope.countOfLaptops > requestScope.showCount}">

    <ul class="women_pagenation">
        <li>Page:</li>

        <c:forEach var="i" begin="1" end="${requestScope.countOfPages}">

            <c:choose>
                <c:when test="${fn:contains(url, '&page')}">
                    <c:set var="rewriteUrl" value="${fn:substringBefore(url, '&page')}"/>
                    <li >
                        <a href="${rewriteUrl}&page=${i}">${i}</a>
                    </li>
                </c:when>

                <c:otherwise>
                    <li >
                        <a href="${url}&page=${i}">${i}</a>
                    </li>
                </c:otherwise>
            </c:choose>

        </c:forEach>
    </ul>
</c:if>
