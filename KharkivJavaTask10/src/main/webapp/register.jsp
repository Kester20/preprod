<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>

<!DOCTYPE html>
<html>

<head>

    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Register :: w3layouts</title>

    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <script src="js/jquery.min.js"></script>
    <script src="js/simpleCart.min.js"></script>
    <script type="text/javascript" src="js/validation.js"></script>
    <script type="application/x-javascript" src="js/addHandlerLoad.js"></script>
    
</head>

<body>


    <jsp:include page="header.jsp"></jsp:include>


    <!-- registration-form -->
    <div class="registration-form">
        <div class="container">
            <div class="dreamcrub">
                <ul class="breadcrumbs">
                    <li class="home">
                        <a href="index.jsp" title="Go to Home Page">Home</a>&nbsp;
                        <span>&gt;</span>
                    </li>
                    <li class="women">
                        Registration
                    </li>
                </ul>
                <ul class="previous">
                    <li><a href="index.jsp">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>




            <h2>Registration</h2>
            <div class="registration-grids">
                <div class="reg-form">
                    <div class="reg">
                        <p>Welcome, please enter the following details to continue.</p>
                        <p>If you have previously registered with us, <a href="#">click here</a></p>

                        <span class="transactionError">${errors.transactionalError}</span>
                        <form action="<c:url value='registration_servlet' />" name="registerForm" id="registerForm"
                        method="post" onsubmit="return validateRegisterForm ();" enctype="multipart/form-data">

                        <ul>
                            <li class="text-info">First Name:</li>
                            <li><input class="valid" type="text" value="${requestScope.formBean.firstName}" name="firstName" id="firstName"
                             onchange="isNotEmptyInput(this);"></li>
                             <li class="showInfo">${errors.firstName}</li>
                         </ul>
                         <ul>
                            <li class="text-info">Last Name:</li>
                            <li><input class="valid" type="text" value="${requestScope.formBean.lastName}" name="lastName" id="lastName"
                             onchange="isNotEmptyInput(this);"></li>
                             <li class="showInfo">${errors.secondName}</li>
                         </ul>
                         <ul>
                            <li class="text-info">Email:</li>
                            <li><input class="valid" type="text" value="${requestScope.formBean.email}" name="email"
                             placeholder="Example: ars.kester@epam.com" onchange="validateEmail(this);"></li>
                             <li class="showInfo">${errors.email}</li>
                         </ul>
                         <ul>
                            <li class="text-info">Password:</li>
                            <li><input class="valid" type="password" value="" name="pass"
                             onchange="checkLengthPassword(this);"></li>
                             <li class="showInfo">${errors.password}</li>
                         </ul>
                         <ul>
                            <li class="text-info">Re-enter Password:</li>
                            <li><input class="valid" type="password" value="" name="pass2"
                             onchange="checkStringEquals(document.registerForm.pass,this);"></li>
                             <li class="showInfo">${errors.password}</li>
                         </ul>
                         <ul>
                            <li class="text-info">Mobile Number:</li>
                            <li><input class="valid" type="text" value="${requestScope.formBean.mobileNumber}" name="mobileNumber"
                             placeholder="Example: +80945678977" onchange="validatePhone(this);"></li>
                             <li class="showInfo">${errors.mobileNumber}</li>
                         </ul>

                         <ul>

                            <li class="text-info">Upload your photo:</li>
                            <li><input type="file" name="photo" size="50"></li>

                        </ul>

                        <c:set var="code" value="${requestScope.codeCaptcha}"/>

                        <ul>
                            <li class="text-info">Enter the numbers in picture:</li>
                            <li><input class="valid" type="text" value="" name="captcha_input"></li>
                            <li class="captcha"><tg:captcha servlet="/miniservlet/captcha_servlet?codeCaptcha=${code}"
                                captcha="${code}"/>
                            </li>
                            <li class="showInfo">${errors.captcha_input}</li>

                        </ul>

                        <input type="submit" value="REGISTER NOW" >

                        <p class="click">By clicking this button, you are agree to my <a href="#">Policy Terms and
                            Conditions.</a></p>
                        </form>
                    </div>
                </div>

                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <!-- registration-form -->

    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
