<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tg" %>


<!DOCTYPE html>
<html>

<head>

    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Products :: w3layouts</title>

    <link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
    <link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="css/component.css" rel='stylesheet' type='text/css'/>
    <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css"/>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <script src="js/jquery.min.js"></script>
    <script type="application/x-javascript" src="js/addHandlerLoad.js"></script>
    <script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>
    <script src="js/simpleCart.min.js"></script>
    <script src="js/cbpViewModeSwitch.js" type="text/javascript"></script>
    <script src="js/classie.js" type="text/javascript"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
    <script src="js/slider.js"></script>

</head>
<body>


    <form id="catalogform" action="<c:url value='catalog_servlet' />" method="get">
    </form>
    <jsp:include page="header.jsp"></jsp:include>

    <!-- content-section-starts -->
    <div class="container">
        <div class="products-page">
            <div class="products">
                <div class="product-listy">
                    <h2>our Products</h2>
                    <ul class="product-list">



                      <h4 class="labelCriteria">Price</h4>
                      <div id="amountVal">

                        <input type="text" name="amount" id="amount" class="priceAmount">
                        -<input type="text" name="amount1" id="amount_1"  class="priceAmount">

                      </div>
                      <div id="slider-range" class="priceSlider"></div>

                      <h4 class="labelCriteria">Producers</h4>
                        <c:forEach var="producer" items="${requestScope.producerList}">

                          <li><a><label><input  type="checkbox" name="checkbox" value="${producer.name}" form="catalogform">${producer.name}</label></a></li>

                        </c:forEach>

                      <h4 class="labelCriteria">Category</h4>

                      <c:forEach var="category" items="${requestScope.categoryList}">

                        <li><a><label><input  type="checkbox" name="checkbox" value="${category.name}" form="catalogform">${category.name}</label></a></li>

                      </c:forEach>


                    </ul>

                    <input type="submit" value="Select" class="subm" form="catalogform">
                </div>
                <!-- <div class="latest-bis">
                    <img src="images/l4.jpg" class="img-responsive" alt=""/>
                    <div class="offer">
                        <p>40%</p>
                        <small>Top Offer</small>
                    </div>
                </div> -->
                <div class="tags">
                    <h4 class="tag_head">Tags Widget</h4>
                    <ul class="tags_links">
                        <li><a href="#">Kitesurf</a></li>
                        <li><a href="#">Super</a></li>
                        <li><a href="#">Duper</a></li>
                        <li><a href="#">Theme</a></li>
                        <li><a href="#">Men</a></li>
                        <li><a href="#">Women</a></li>
                        <li><a href="#">Equipment</a></li>
                        <li><a href="#">Best</a></li>
                        <li><a href="#">Accessories</a></li>
                        <li><a href="#">Men</a></li>
                        <li><a href="#">Apparel</a></li>
                        <li><a href="#">Super</a></li>
                        <li><a href="#">Duper</a></li>
                        <li><a href="#">Theme</a></li>
                        <li><a href="#">Responsive</a></li>
                        <li><a href="#">Women</a></li>
                        <li><a href="#">Equipment</a></li>
                    </ul>

                </div>

            </div>
            <div class="new-product">
                <div class="new-product-top">
                    <ul class="product-top-list">
                        <li><a href="index.jsp">Home</a>&nbsp;<span>&gt;</span></li>
                        <li><span class="act">Best Sales</span>&nbsp;</li>
                    </ul>
                    <p class="back"><a href="index.jsp">Back to Previous</a></p>
                    <div class="clearfix"></div>
                </div>
                <div class="mens-toolbar">
                    <div class="sort">
                        <div class="sort-by">
                            <label>Sort By</label>
                            <select>
                                <option value="">
                                    Position
                                </option>
                                <option value="">
                                    Name
                                </option>
                                <option value="">
                                    Price
                                </option>
                            </select>
                            <a href=""><img src="images/arrow2.gif" alt="" class="v-middle"></a>
                        </div>
                    </div>
                    <ul class="women_pagenation">
                        <li>Page:</li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                    </ul>
                    <div class="clearfix"></div>
                </div>
                <div id="cbp-vm" class="cbp-vm-switcher cbp-vm-view-grid">
                    <div class="cbp-vm-options">
                        <a href="#" class="cbp-vm-icon cbp-vm-grid cbp-vm-selected" data-view="cbp-vm-view-grid"
                        title="grid">Grid View</a>
                        <a href="#" class="cbp-vm-icon cbp-vm-list" data-view="cbp-vm-view-list" title="list">List View</a>
                    </div>
                    <div class="pages">
                        <div class="limiter visible-desktop">
                            <label>Show</label>
                            <select>
                                <option value="" selected="selected">
                                    9
                                </option>
                                <option value="">
                                    15
                                </option>
                                <option value="">
                                    30
                                </option>
                            </select> per page
                        </div>
                    </div>
                    <div class="clearfix"></div>


                    <tg:catalog_laptop />


                </div>

            </div>
            <div class="clearfix"></div>
        </div>
        <div class="clearfix"></div>
    </div>
    <!-- content-section-ends -->
    <div class="other-products">
        <div class="container">
            <h3 class="like text-center">Featured Collection</h3>
            <ul id="flexiselDemo3">
                <li><a href="single.jsp"><img src="images/l1.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">Perfectly simple</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$759</span></a></p>
                    </div>
                </li>
                <li><a href="single.jsp"><img src="images/l2.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">Praising pain</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$699</span></a></p>
                    </div>
                </li>
                <li><a href="single.jsp"><img src="images/l3.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">Neque porro</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$329</span></a></p>
                    </div>
                </li>
                <li><a href="single.jsp"><img src="images/l4.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">Equal blame</a>
                        <p><a class="item_add" href="#"><i></i> <span class=" item_price">$499</span></a></p>
                    </div>
                </li>
                <li><a href="single.jsp"><img src="images/l5.jpg" class="img-responsive"/></a>
                    <div class="product liked-product simpleCart_shelfItem">
                        <a class="like_name" href="single.jsp">Perfectly simple</a>
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
