<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="servlet" required="true"  %>
<%@ attribute name="captcha" required="true"  %>

<c:choose>
    <c:when test="${initParam['captchaScope'] eq 'hidden'}">
       <img src="${servlet}"/>
       <input type ="hidden" name="hidden" value="${captcha}" />
    </c:when>

    <c:otherwise>
        <img src="${servlet}"/>
    </c:otherwise>
</c:choose>
