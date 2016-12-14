<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul class="women_pagenation">
    <li>Page:</li>
    <li class="active">
        <a href="<c:url value='catalog_servlet?${pageContext.request.queryString}' />">1</a>
    </li>
    <li>
        <a href="<c:url value='catalog_servlet?${pageContext.request.queryString}' />">2</a>
    </li>
</ul>
