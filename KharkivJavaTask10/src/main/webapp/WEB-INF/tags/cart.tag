<%@ tag isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="title" required="true"  %>
<%@ attribute name="blockUser" required="true"%>
<%@ attribute name="button" required="true"  %>

<c:choose>
    <c:when test="${(empty sessionScope.cart) || (sessionScope.cart.getNumberOfProducts() == 0)}">
        <h2>${title}(EMPTY)</h2>
    </c:when>

    <c:otherwise>

        <h2>${title}</h2>

        <table border="1" class="cart_table">
            <tr>
                <th>Product</th>
                <th>Producer</th>
                <th>Number</th>
                <th>Price</th>
                <c:if test="${!blockUser eq true}">
                    <th>Delete</th>
                </c:if>
            </tr>

            <c:forEach var="cartMap" items="${sessionScope.cart.cart}">
                <tr>
                    <td>
                        <img src="${cartMap.key.image}" class="cart_image" alt=""/>
                    </td>

                    <td>
                        ${cartMap.key.producer.name}
                    </td>

                    <td>
                        <c:choose>
                            <c:when test="${blockUser eq true}">
                                ${cartMap.value}
                            </c:when>

                            <c:otherwise>
                                <input type="number" value="${cartMap.value}" name="number" min="1" max="10" onchange="updateTotal('${cartMap.key.id}',this.value)"/>
                            </c:otherwise>

                        </c:choose>
                    </td>
                    <td>
                        $${cartMap.key.cost}
                    </td>

                    <c:if test="${!blockUser eq true}">
                        <td>
                            <a class="deleteIcon" href="" onclick="deleteLaptopFromCart(${cartMap.key.id})">X</a>
                        </td>
                    </c:if>

                </tr>

            </c:forEach>

        </table>

        <span class="spanTotalCart">Total: $<span id="total">${sessionScope.cart.getAmount()}</span>
        </span>
        <br>
        <br>
        <br>

        <c:if test="${button eq 'CREATE ORDER'}">
            <a href="<c:url value='create_order' />" class="btnCreateOrder">
                <button>${button}</button>
        </c:if>

        </c:otherwise>
    </c:choose>

</a>
