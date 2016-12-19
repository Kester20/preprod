<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>

<!DOCTYPE html>
<html>

    <head>

        <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Chectout :: w3layouts</title>

        <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>

        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

        <script src="js/jquery.min.js"></script>
        <script type="application/x-javascript" src="js/addHandlerLoad.js"></script>
        <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
        <script src="js/simpleCart.min.js"></script>
        <script src="js/cartOperation.js"></script>

    </head>

    <jsp:include page="header.jsp"></jsp:include>

    <div class="cart-items">
        <div class="container">

            <tg:cart title="CREATE ORDER" blockUser="true" button=""/>

            <form action="<c:url value='confirm_order_servlet' />" method="post">
                <span>Type payment</span>
                <input type="text" name="typePayment"/>

                <span>Card</span>
                <input type="text" name="card"/>
                <input class="btnCreateOrder" type="submit" value="CONFIRM"/>

            </form>

        </div>

    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</html>
