<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>

<!DOCTYPE html>
<html>

<head>

    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Chectout :: w3layouts</title>

    <link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <script src="js/jquery.min.js"></script>
    <script type="application/x-javascript" src="js/addHandlerLoad.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <script src="js/simpleCart.min.js"></script>
    
</head>

<body>

    <jsp:include page="header.jsp"></jsp:include>
    
    <!-- checkout -->
    <div class="cart-items">
        <div class="container">
            <div class="dreamcrub">
                <ul class="breadcrumbs">
                    <li class="home">
                        <a href="index.html" title="Go to Home Page">Home</a>&nbsp;
                        <span>&gt;</span>
                    </li>
                    <li class="women">
                        Cart
                    </li>
                </ul>
                <ul class="previous">
                    <li><a href="index.html">Back to Previous Page</a></li>
                </ul>
                <div class="clearfix"></div>
            </div>
            <h2>MY SHOPPING BAG (3)</h2>
            <div class="cart-gd">
                <script>
                    $(document).ready(function(c) {
                        $('.close1').on('click', function(c) {
                            $('.cart-header').fadeOut('slow', function(c) {
                                $('.cart-header').remove();
                            });
                        });
                    });
                </script>
                <div class="cart-header">
                    <div class="close1"></div>
                    <div class="cart-sec simpleCart_shelfItem">
                        <div class="cart-item cyc">
                            <img src="images/l1.jpg" class="img-responsive" alt="">
                        </div>
                        <div class="cart-item-info">
                            <h3><a href="#"> Lorem Ipsum is not simply </a><span>Pickup time:</span></h3>
                            <ul class="qty">
                                <li>
                                    <p>Min. order value:</p>
                                </li>
                                <li>
                                    <p>FREE delivery</p>
                                </li>
                            </ul>
                            <div class="delivery">
                                <p>Service Charges : $10.00</p>
                                <span>Delivered in 1-1:30 hours</span>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>

                    </div>
                </div>
                <script>
                    $(document).ready(function(c) {
                        $('.close2').on('click', function(c) {
                            $('.cart-header2').fadeOut('slow', function(c) {
                                $('.cart-header2').remove();
                            });
                        });
                    });
                </script>
                <div class="cart-header2">
                    <div class="close2"></div>
                    <div class="cart-sec simpleCart_shelfItem">
                        <div class="cart-item cyc">
                            <img src="images/l2.jpg" class="img-responsive" alt="">
                        </div>
                        <div class="cart-item-info">
                            <h3><a href="#"> Lorem Ipsum is not simply </a><span>Pickup time:</span></h3>
                            <ul class="qty">
                                <li>
                                    <p>Min. order value:</p>
                                </li>
                                <li>
                                    <p>FREE delivery</p>
                                </li>
                            </ul>
                            <div class="delivery">
                                <p>Service Charges : $10.00</p>
                                <span>Delivered in 3-3:30 hours</span>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>

                    </div>
                </div>
                <script>
                    $(document).ready(function(c) {
                        $('.close3').on('click', function(c) {
                            $('.cart-header3').fadeOut('slow', function(c) {
                                $('.cart-header3').remove();
                            });
                        });
                    });
                </script>
                <div class="cart-header3">
                    <div class="close3"></div>
                    <div class="cart-sec simpleCart_shelfItem">
                        <div class="cart-item cyc">
                            <img src="images/l3.jpg" class="img-responsive" alt="">
                        </div>
                        <div class="cart-item-info">
                            <h3><a href="#"> Lorem Ipsum is not simply </a><span>Pickup time:</span></h3>
                            <ul class="qty">
                                <li>
                                    <p>Min. order value:</p>
                                </li>
                                <li>
                                    <p>FREE delivery</p>
                                </li>
                            </ul>
                            <div class="delivery">
                                <p>Service Charges : $10.00</p>
                                <span>Delivered On Tomorrow</span>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                        <div class="clearfix"></div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="footer.jsp"></jsp:include>
</body>

</html>
