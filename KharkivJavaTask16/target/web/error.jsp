<%@ page isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
     prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<title>ServerError</title>
</head>
<body>
<h3>
ServerError
</h3>
<p>
${pageContext.errorData.statusCode}
${pageContext.errorData.throwable}
</body>
</html>