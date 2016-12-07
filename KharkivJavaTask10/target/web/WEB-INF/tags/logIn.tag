<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test="${sessionScope.user == null}">
       <form action="<c:url value='log_in_servlet' />" name="logInForm" id="logInForm" method="post" >

            <input type ="text" name="email" placeholder="Email" autofocus required />
            <input type ="text" name="password" placeholder="Password" required/>
       </form>
    </c:when>

    <c:otherwise>

    </c:otherwise>
</c:choose>