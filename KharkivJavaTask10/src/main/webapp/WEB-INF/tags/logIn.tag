<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle var="bundle" basename="content" />

<c:choose>
    <c:when test="${sessionScope.user == null}">

       <ul>
            <li><a href="<c:url value='account.jsp' />"><span class="glyphicon glyphicon-user"> </span><fmt:message  key="login" bundle="${bundle}"></fmt:message></a></li>
            <li><a href="<c:url value='registration_servlet' />"><span class="glyphicon glyphicon-lock"> </span><fmt:message  key="create_an_account" bundle="${bundle}"></fmt:message></a></li>
       </ul>

    </c:when>



    <c:otherwise>

       <ul>
            <li><img class="avatar" src="${userAvatar}" /></li>
            <li><a>${user.firstName}</a></li>
            <li><a href="<c:url value='logout_servlet' />"><span class="glyphicon glyphicon-user"> </span>Log out</a></li>

       </ul>

    </c:otherwise>
</c:choose>
