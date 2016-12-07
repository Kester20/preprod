<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test="${sessionScope.user == null}">


       <a href="account.jsp"><span class="glyphicon glyphicon-user"> </span>Login</a>

    </c:when>



    <c:otherwise>

       <a href=""><span class="glyphicon glyphicon-user"> </span>Log out</a>

    </c:otherwise>
</c:choose>