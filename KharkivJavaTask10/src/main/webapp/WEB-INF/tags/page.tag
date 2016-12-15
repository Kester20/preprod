<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:out value="!${requestScope.countOfLaptops}"/>
<c:out value="!!${requestScope.showCount}"/>


<c:if test="${requestScope.countOfLaptops > requestScope.showCount}">

    <ul class="women_pagenation">
        <li>Page:</li>
        <li class="active">
            <a href="<c:url value='catalog_servlet?${pageContext.request.queryString}&page=1' />">1</a>
        </li>
        <li>
            <a href="<c:url value='catalog_servlet?${pageContext.request.queryString}&page=2' />">2</a>
        </li>
    </ul>

</c:if>
