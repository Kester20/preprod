<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>



<!-- header-section-starts -->
<div class="header">
    <div class="header-top-strip">
        <div class="container">
            <div class="header-top-left">
                <tg:logIn />
            </div>
            <div class="header-right">
                <div class="cart box_1">
                    <a href="checkout.jsp">
                        <h3><span class="simpleCart_total"> $0.00 </span> (<span id="simpleCart_quantity"
                                                                                 class="simpleCart_quantity"> 0 </span>)<img
                                src="images/bag.png" alt=""></h3>
                    </a>
                    <p><a href="javascript:;" class="simpleCart_empty">Empty cart</a></p>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- header-section-ends -->
<div class="inner-banner">
    <div class="container">
        <div class="banner-top inner-head">
            <nav class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="logo">
                        <h1><a href="index.jsp"><span>E</span> -Shop</a></h1>
                    </div>
                </div>
                <!--/.navbar-header-->

                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Men <b class="caret"></b></a>
                            <ul class="dropdown-menu multi-column columns-3">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <h6>NEW IN</h6>
                                            <li><a href="products.jsp">New In Clothing</a></li>
                                            <li><a href="products.jsp">New In Bags</a></li>
                                            <li><a href="products.jsp">New In Shoes</a></li>
                                            <li><a href="products.jsp">New In Watches</a></li>
                                            <li><a href="products.jsp">New In Grooming</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <h6>CLOTHING</h6>
                                            <li><a href="products.jsp">Polos & Tees</a></li>
                                            <li><a href="products.jsp">Casual Shirts</a></li>
                                            <li><a href="products.jsp">Casual Trousers</a></li>
                                            <li><a href="products.jsp">Jeans</a></li>
                                            <li><a href="products.jsp">Shorts & 3/4th</a></li>
                                            <li><a href="products.jsp">Formal Shirts</a></li>
                                            <li><a href="products.jsp">Formal Trousers</a></li>
                                            <li><a href="products.jsp">Suits & Blazers</a></li>
                                            <li><a href="products.jsp">Track Wear</a></li>
                                            <li><a href="products.jsp">Inner Wear</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <h6>WATCHES</h6>
                                            <li><a href="products.jsp">Analog</a></li>
                                            <li><a href="products.jsp">Chronograph</a></li>
                                            <li><a href="products.jsp">Digital</a></li>
                                            <li><a href="products.jsp">Watch Cases</a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">women <b class="caret"></b></a>
                            <ul class="dropdown-menu multi-column columns-3">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <h6>NEW IN</h6>
                                            <li><a href="products.jsp">New In Clothing</a></li>
                                            <li><a href="products.jsp">New In Bags</a></li>
                                            <li><a href="products.jsp">New In Shoes</a></li>
                                            <li><a href="products.jsp">New In Watches</a></li>
                                            <li><a href="products.jsp">New In Beauty</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <h6>CLOTHING</h6>
                                            <li><a href="products.jsp">Polos & Tees</a></li>
                                            <li><a href="products.jsp">Casual Shirts</a></li>
                                            <li><a href="products.jsp">Casual Trousers</a></li>
                                            <li><a href="products.jsp">Jeans</a></li>
                                            <li><a href="products.jsp">Shorts & 3/4th</a></li>
                                            <li><a href="products.jsp">Formal Shirts</a></li>
                                            <li><a href="products.jsp">Formal Trousers</a></li>
                                            <li><a href="products.jsp">Suits & Blazers</a></li>
                                            <li><a href="products.jsp">Track Wear</a></li>
                                            <li><a href="products.jsp">Inner Wear</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <h6>WATCHES</h6>
                                            <li><a href="products.jsp">Analog</a></li>
                                            <li><a href="products.jsp">Chronograph</a></li>
                                            <li><a href="products.jsp">Digital</a></li>
                                            <li><a href="products.jsp">Watch Cases</a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">kids <b class="caret"></b></a>
                            <ul class="dropdown-menu multi-column columns-2">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <ul class="multi-column-dropdown">
                                            <h6>NEW IN</h6>
                                            <li><a href="products.jsp">New In Boys Clothing</a></li>
                                            <li><a href="products.jsp">New In Girls Clothing</a></li>
                                            <li><a href="products.jsp">New In Boys Shoes</a></li>
                                            <li><a href="products.jsp">New In Girls Shoes</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-6">
                                        <ul class="multi-column-dropdown">
                                            <h6>ACCESSORIES</h6>
                                            <li><a href="products.jsp">Bags</a></li>
                                            <li><a href="products.jsp">Watches</a></li>
                                            <li><a href="products.jsp">Sun Glasses</a></li>
                                            <li><a href="products.jsp">Jewellery</a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </ul>
                        </li>
                        <li><a href="typography.jsp">TYPO</a></li>
                        <li><a href="contact.jsp">CONTACT</a></li>
                    </ul>
                </div>
                <!--/.navbar-collapse-->
            </nav>
            <!--/.navbar-->
        </div>
    </div>
</div>