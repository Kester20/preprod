<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>


<!DOCTYPE html>
<html>

<head>

    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Account :: w3layouts</title>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

    <script src="js/jquery.min.js"></script>
    <script type="application/x-javascript" src="js/addHandlerLoad.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <script src="js/simpleCart.min.js"></script>
    <script type="text/javascript" src="js/validation.js"></script>

</head>

<body>

   <jsp:include page="header.jsp"></jsp:include>

   <!-- content-section-starts -->
   <div class="content">
    <div class="container">
        <div class="login-page">
            <div class="dreamcrub">
                <ul class="breadcrumbs">
                    <li class="home">
                        <a href="index.jsp" title="Go to Home Page">Home</a>&nbsp;
                        <span>&gt;</span>
                    </li>
                    <li class="women">
                        Login
                    </li>
                </ul>
                <ul class="previous">
                    <li><a href="index.jsp">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="account_grid">
                <div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
                    <h2>NEW CUSTOMERS</h2>
                    <p>By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.
                    </p>
                    <a class="acount-btn" href="register.jsp">Create an Account</a>
                </div>
                <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
                    <h3>REGISTERED CUSTOMERS</h3>
                    <p>If you have an account with us, please log in.</p>
                    <form name="logInForm" method="post" action="<c:url value='login_servlet' />" onsubmit="">
                    <div>
                        <span>Email Address<label>*</label></span>
                        <input  type="text" name="email">
                    </div>
                    <div>
                        <span>Password<label>*</label></span>
                        <input  type="password" name="password">

                    </div>
                    <label class="errorInput">${wrongEmailOrPassword}</label><br><br>
                    <a class="forgot" href="#">Forgot Your Password?</a>
                    <input type="submit" value="Login">
                </form>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
