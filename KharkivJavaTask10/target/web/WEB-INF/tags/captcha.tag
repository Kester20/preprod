<%@ attribute name="captchaCode" required="true" %>
<%@ attribute name="servlet" required="true" %>
<h1>${captchaCode}</h1>
<img src="${servlet}" />