<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:setLocale value="${language}" />
<fmt:setBundle var="b" basename="content" />
<fmt:message var="wordLang" key="wordLang" bundle="${b }"></fmt:message>

<select id="select"  onchange="changeLanguage(this.value)">
    <option style="display: none;">${wordLang}</option>
    <option value="ru_RU">Russian</option>
    <option value="en_US">English</option>
</select>
