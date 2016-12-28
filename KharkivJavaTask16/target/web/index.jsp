<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>

<!DOCTYPE html>
<html>

<head>

    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Home :: w3layouts</title>

    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    
    <script type="application/x-javascript" src="js/addHandlerLoad.js"></script>
    <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <script src="js/simpleCart.min.js"></script>
    <script src="js/responsiveslides.min.js"></script>
    <script type="text/javascript" src="js/jquery.flexisel.js"></script>

</head>

<body>


    <jsp:include page="header.jsp"></jsp:include>

    
    <div class="banner">

        <div class="container">
            <div class="banner-bottom">
                <div class="banner-bottom-left">
                    <h2>B<br>U<br>Y</h2>
                </div>
                <div class="banner-bottom-right">
                    <div class="callbacks_container">
                        <ul class="rslides" id="slider4">
                            <li>
                                <div class="banner-info">
                                    <h3>Smart But Casual</h3>
                                    <p>Start your shopping here...</p>
                                </div>
                            </li>
                            <li>
                                <div class="banner-info">
                                    <h3>Shop Online</h3>
                                    <p>Start your shopping here...</p>
                                </div>
                            </li>
                            <li>
                                <div class="banner-info">
                                    <h3>Pack your Bag</h3>
                                    <p>Start your shopping here...</p>
                                </div>
                            </li>
                        </ul>
                    </div>

                    <script src="js/responsiveslides.min.js"></script>

                <script>

                // You can also use "$(window).load(function() {"

                $(function () {

                  // Slideshow 4

                  $("#slider4").responsiveSlides({

                    auto: true,

                    pager:true,

                    nav:false,

                    speed: 500,

                    namespace: "callbacks",

                    before: function () {

                      $('.events').append("<li>before event fired.</li>");

                    },

                    after: function () {

                      $('.events').append("<li>after event fired.</li>");

                    }

                  });



                });





                </script>

                </div>
                <div class="clearfix"></div>
            </div>
            <div class="shop">
                <a href="single.jsp">SHOP COLLECTION NOW</a>
            </div>
        </div>
    </div>
    <!-- content-section-starts-here -->
    <div class="container">
        <div class="main-content">
            <div class="online-strip">
                <div class="col-md-4 follow-us">
                    <h3>follow us : <a class="twitter" href="#"></a><a class="facebook" href="#"></a></h3>
                </div>
                <div class="col-md-4 shipping-grid">
                    <div class="shipping">
                        <img src="images/shipping.png" alt=""/>
                    </div>
                    <div class="shipping-text">
                        <h3>Free Shipping</h3>
                        <p>on orders over $ 199</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-4 online-order">
                    <p>Order online</p>
                    <h3>Tel:999 4567 8902</h3>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="products-grid">
                <header>
                    <h3 class="head text-center">Latest Products</h3>
                </header>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/acer2.jpg" alt=""/></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">Acer</a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1000</span></a></p>
                </div>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/acer3.jpg" alt=""/></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">Acer</a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1200</span></a></p>
                </div>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/apple.jpg" alt=""/></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">Apple</a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1900</span></a></p>
                </div>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/hp.jpg" alt=""/></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">HP </a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1300</span></a></p>
                </div>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/hp2.jpg" alt=""/></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">HP</a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1200</span></a></p>
                </div>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/hp06.jpg" alt=""/></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">HP</a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1300</span></a></p>
                </div>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/len.png" alt=""/></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">Lenovo</a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1000</span></a></p>
                </div>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/oi.jpg" alt=""/></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">Dell</a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1200</span></a></p>
                </div>
                <div class="col-md-4 product simpleCart_shelfItem text-center">
                    <a href="single.jsp"><img src="img/sams.jpg" alt="" /></a>
                    <div class="mask">
                        <a href="single.jsp">Quick View</a>
                    </div>
                    <a class="product_name" href="single.jsp">Samsung</a>
                    <p><a class="item_add" href="#"><i></i> <span class="item_price">$1500</span></a></p>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>

    </div>
    <div class="other-products">
        <div class="container">
            <h3 class="like text-center">Featured Collection</h3>
            <ul id="flexiselDemo3">
                <li><a href="single.jsp"><img src="images/l1.jpg" class="img-responsive" alt=""/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">perfectly simple</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$759</span></a></p>
                    </div>
                </li>
                <li><a href="single.jsp"><img src="images/l2.jpg" class="img-responsive" alt=""/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">praising pain</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$699</span></a></p>
                    </div>
                </li>
                <li><a href="single.jsp"><img src="images/l3.jpg" class="img-responsive" alt=""/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">Neque porro</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
                    </div>
                </li>
                <li><a href="single.jsp"><img src="images/l4.jpg" class="img-responsive" alt=""/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">equal blame</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$499</span></a></p>
                    </div>
                </li>
                <li><a href="single.jsp"><img src="images/l5.jpg" class="img-responsive" alt=""/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">perfectly simple</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$649</span></a></p>
                    </div>
                </li>
            </ul>

            <script type="text/javascript">

               $(window).load(function() {

                $("#flexiselDemo3").flexisel({

                    visibleItems: 4,

                    animationSpeed: 1000,

                    autoPlay: true,

                    autoPlaySpeed: 3000,

                    pauseOnHover: true,

                    enableResponsiveBreakpoints: true,

                    responsiveBreakpoints: {

                        portrait: {

                            changePoint:480,

                            visibleItems: 1

                        },

                        landscape: {

                            changePoint:640,

                            visibleItems: 2

                        },

                        tablet: {

                            changePoint:768,

                            visibleItems: 3

                        }

                    }

                });



            });





        </script>

        <script type="text/javascript" src="js/jquery.flexisel.js"></script>

    </div>
</div>
<!-- content-section-ends-here -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>