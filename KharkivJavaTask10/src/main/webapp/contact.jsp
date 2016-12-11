<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>

<!DOCTYPE html>
<html>

<head>

    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Contact :: w3layouts</title>
    
    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    
    <script type="application/x-javascript" src="js/addHandlerLoad.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <script src="js/jquery.min.js"></script>    
    <script src="js/simpleCart.min.js"></script>
    
</head>

<body>
    
    <jsp:include page="header.jsp"></jsp:include>

    <!-- contact-page -->
    <div class="contact">
        <div class="container">
            <div class="dreamcrub">
                <ul class="breadcrumbs">
                    <li class="home">
                        <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                        <span>&gt;</span>
                    </li>
                    <li class="women">
                        Contact
                    </li>
                </ul>
                <ul class="previous">
                    <li><a href="index.html">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <div class="contact-info">
                <h2>FIND US HERE</h2>
            </div>
            <div class="contact-map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6632.248000703498!2d151.265683!3d-33.7832959!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b12abc7edcbeb07%3A0x5017d681632bfc0!2sManly+Vale+NSW+2093%2C+Australia!5e0!3m2!1sen!2sin!4v1433329298259"
                style="border:0"></iframe>
            </div>
            <div class="contact-form">
                <div class="contact-info">
                    <h3>CONTACT FORM</h3>
                </div>
                <form>
                    <div class="contact-left">
                        <input type="text" placeholder="Name" required>
                        <input type="text" placeholder="E-mail" required>
                        <input type="text" placeholder="Subject" required>
                    </div>
                    <div class="contact-right">
                        <textarea placeholder="Message" required></textarea>
                    </div>
                    <div class="clearfix"></div>
                    <input type="submit" value="SUBMIT">
                </form>
            </div>
        </div>
    </div>
    <!-- //contact-page -->

    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
