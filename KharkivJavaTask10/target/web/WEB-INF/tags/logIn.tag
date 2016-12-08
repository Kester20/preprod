<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test="${sessionScope.user == null}">

       <ul>

            <li><a href="account.jsp"><span class="glyphicon glyphicon-user"> </span>Login</a></li>
            <li><a href="register.jsp"><span class="glyphicon glyphicon-lock"> </span>Create an Account</a></li>

       </ul>

    </c:when>



    <c:otherwise>

       <ul>

            <li><a>${userName}</a></li>
            <li><a href="<c:url value='logout_servlet' />"><span class="glyphicon glyphicon-user"> </span>Log out</a></li>

       </ul>

    </c:otherwise>
</c:choose>