<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
    <c:when test="${sessionScope.user == null}">


       <div class="reg">

           <form action="<c:url value='log_in_servlet' />" name="logInForm" id="logInForm" method="post" >
                <input class="logIn" type ="text" name="email" placeholder="Email" autofocus required /><br>
                <input class="logIn" type ="text" name="password" placeholder="Password" required/><br>
                <input type="submit" value="Log in">
           </form>

       </div>

    </c:when>



    <c:otherwise>

    </c:otherwise>
</c:choose>