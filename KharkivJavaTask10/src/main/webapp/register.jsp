<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>

<!DOCTYPE html>
<html>

<head>
    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Register :: w3layouts</title>
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords" content="Eshop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design"/>
    <script type="application/x-javascript">
        addEventListener("load", function() {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }

    </script>
    <!--webfont-->
    <!-- for bootstrap working -->
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <!-- //for bootstrap working -->
    <!-- cart -->
    <script src="js/simpleCart.min.js"></script>

    <script type="text/javascript" src="js/validation.js"></script>
    <!-- cart -->
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>
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

<div class="news-letter">
    <div class="container">
        <div class="join">
            <h6>JOIN OUR MAILING LIST</h6>
            <div class="sub-left-right">
                <form>
                    <input type="text" value="Enter Your Email Here" onfocus="this.value = '';"
                           onblur="if (this.value == '') {this.value = 'Enter Your Email Here';}"/>
                    <input type="submit" value="SUBSCRIBE"/>
                </form>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="container">
        <div class="footer_top">
            <div class="span_of_4">
                <div class="col-md-3 span1_of_4">
                    <h4>Shop</h4>
                    <ul class="f_nav">
                        <li><a href="#">new arrivals</a></li>
                        <li><a href="#">men</a></li>
                        <li><a href="#">women</a></li>
                        <li><a href="#">accessories</a></li>
                        <li><a href="#">kids</a></li>
                        <li><a href="#">brands</a></li>
                        <li><a href="#">trends</a></li>
                        <li><a href="#">sale</a></li>
                        <li><a href="#">style videos</a></li>
                    </ul>
                </div>
                <div class="col-md-3 span1_of_4">
                    <h4>help</h4>
                    <ul class="f_nav">
                        <li><a href="#">frequently asked questions</a></li>
                        <li><a href="#">men</a></li>
                        <li><a href="#">women</a></li>
                        <li><a href="#">accessories</a></li>
                        <li><a href="#">kids</a></li>
                        <li><a href="#">brands</a></li>
                    </ul>
                </div>
                <div class="col-md-3 span1_of_4">
                    <h4>account</h4>
                    <ul class="f_nav">
                        <li><a href="account.jsp">login</a></li>
                        <li><a href="register.jsp">create an account</a></li>
                        <li><a href="#">create wishlist</a></li>
                        <li><a href="checkout.jsp">my shopping bag</a></li>
                        <li><a href="#">brands</a></li>
                        <li><a href="#">create wishlist</a></li>
                    </ul>
                </div>
                <div class="col-md-3 span1_of_4">
                    <h4>popular</h4>
                    <ul class="f_nav">
                        <li><a href="#">new arrivals</a></li>
                        <li><a href="#">men</a></li>
                        <li><a href="#">women</a></li>
                        <li><a href="#">accessories</a></li>
                        <li><a href="#">kids</a></li>
                        <li><a href="#">brands</a></li>
                        <li><a href="#">trends</a></li>
                        <li><a href="#">sale</a></li>
                        <li><a href="#">style videos</a></li>
                        <li><a href="#">login</a></li>
                        <li><a href="#">brands</a></li>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="cards text-center">
            <img src="images/cards.jpg" alt=""/>
        </div>
        <div class="copyright text-center">
            <p>© 2015 Eshop. All Rights Reserved | Design by <a href="http://w3layouts.com"> W3layouts</a></p>
        </div>
    </div>
</div>
</body>

</html>
