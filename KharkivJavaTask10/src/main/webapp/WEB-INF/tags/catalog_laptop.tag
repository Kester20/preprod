<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<ul>

    <c:forEach var="laptop" items="${requestScope.laptopList}">

        <li>
            <a class="cbp-vm-image" href="single.jsp">
                <div class="simpleCart_shelfItem">
                    <div class="view view-first">
                        <div class="inner_content clearfix">
                            <div class="product_image">
                                <img src="${laptop.image}" class="img-responsive" alt=""/>
                                <div class="mask">
                                    <div class="info">Quick View</div>
                                </div>
                                <div class="product_container">
                                    <div class="cart-left">
                                        <p class="title">${laptop.producer.name}</p>
                                    </div>
                                    <div class="pricey">
                                        <span class="item_price">$${laptop.cost}</span>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </a>
                <div class="cbp-vm-details">
                    Silver beet shallot wakame tomatillo salsify mung bean beetroot groundnut.
                </div>
                <div>
                    <a class="cbp-vm-icon cbp-vm-add item_add" href="#">Add to cart</a>
                </div>
            </li>

        </c:forEach>
    </ul>
