<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>My Orders || KATES´S HANDMADE</title>
    <jsp:include page="../commons/head.jsp"/>
</head>

<body>
    <jsp:include page="../commons/header.jsp"/>  
        <!-- Start Bradcaump area -->
        <div class="ht__bradcaump__area" style="background: rgba(0, 0, 0, 0) url(images/bg/2.jpg) no-repeat scroll center center / cover ;">
            <div class="ht__bradcaump__wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">My Orders</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Orders</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area -->
        <!-- cart-main-area start -->
        <div class="cart-main-area ptb--120 bg__white">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
                            <div class="htc__shop__left__sidebar">
                            <!-- Start Product Cat -->
                            <c:if test="${userid==1}">
                            <div class="htc__shop__cat">
                                <h4 class="section-title-4">Admin Panel</h4>
                                <ul class="sidebar__list">
                                    <li><a href="insert.htm">ADD NEW ITEM<span></span></a></li>
                                    <li><a href="artlist.htm">ITEM LIST<span></span></a></li>
                                    <li><a href="users.htm">USER LIST<span></span></a></li>
                                    <li><a href="adminorders.htm">ORDER LIST<span></span></a></li>
                                    <li><a href="adminreview.htm">REVIEW LIST<span></span></a></li>
                                    <li><a href="usersearch.htm">USER SEARCH<span></span></a></li>
                                </ul>
                            </div>
                            </c:if>
                            <div class="htc__shop__cat">
                                <h4 class="section-title-4">USER MENU</h4>
                                <ul class="sidebar__list">
                                    <li><a href="account.htm">PERSONAL INFORMATION<span></span></a></li>
                                    <li><a href="cart.htm">CART<span></span></a></li>
                                    <li><a href="wishlist.htm">WISHLIST<span></span></a></li>
                                    <li><a style="color:red" href="orders.htm">ORDERS<span></span></a></li>
                                    <li><a href="account.htm?logout=1">LOGOUT<span></span></a></li>
                                </ul>
                            </div>
                            <!-- End Product Cat -->
                        </div>
                    </div>
                    <div class="col-md-9 col-lg-9 col-sm-12 col-xs-12 smt-30">
                        <c:choose>
                            <c:when test="${orderlist!=null}">  
                                <c:forEach items="${orderlist}" var="ord">             
                                    <div class="table-content table-responsive">
                                        <table>
                                            <thead>
                                                <tr style="background-color: lightgray">
                                                    <th class="product-thumbnail">Order ID: <br/>${ord.idcompra}</th>
                                                    <th class="product-name">Order Date: <br/>${ord.fechacompra}</th>
                                                    <th class="product-name">Shipping Date: <br/>${ord.fechaenvio}</th>
                                                    <th class="product-price">Shipping Status: <br/>${ord.status}</th>
                                                    <th class="product-quantity">Payment Method: <br/>${ord.modopago}</th>
                                                    <th class="product-subtotal">Total Price: <br/>€${ord.preciototal}.00</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                    <tr>
                                                        <td style="font-weight: bold" class="product-thumbnail">Image</td>
                                                        <td style="font-weight: bold" class="product-name">Product</td>
                                                        <td style="font-weight: bold" class="product-name">Parameters</td>
                                                        <td style="font-weight: bold" class="product-price">Price</td>
                                                        <td style="font-weight: bold" class="product-quantity">Quantity</td>
                                                        <td style="font-weight: bold" class="product-subtotal">Total</td>
                                                    </tr>
                                                <c:forEach items="${ord.pedlist}" var="ped">       
                                                    <tr>
                                                        <td class="product-thumbnail"><a href="product.htm?id=${ped.idart}"><img src="https://blobkateshdmade.blob.core.windows.net/images2/${ped.foto}" alt="product img" /></a></td>
                                                        <td class="product-name"><a href="product.htm?id=${ped.idart}">${ped.nombre}</a></td>
                                                        <td class="product-name" style="font-weight: bold">
                                                            <c:choose>
                                                                <c:when test="${!ped.add1.equals('NONE')||!ped.add2.equals('NONE')||!ped.add3.equals('NONE')||!ped.add4.equals('NONE')}">
                                                                    <c:if test="${!ped.add1.equals('NONE')}">
                                                                        ${ped.add1}
                                                                    </c:if>
                                                                    <c:if test="${!ped.add2.equals('NONE')}">
                                                                        <br/>
                                                                        ${ped.add2}
                                                                    </c:if>
                                                                    <c:if test="${!ped.add3.equals('NONE')}">
                                                                        <br/>
                                                                        ${ped.add3}
                                                                    </c:if>
                                                                    <c:if test="${!ped.add4.equals('NONE')}">
                                                                        <br/>
                                                                        ${ped.add4}
                                                                    </c:if>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <span style="font-weight: bold">This item don´t have params</span>
                                                                </c:otherwise>        
                                                            </c:choose>            
                                                        </td>
                                                        <td class="product-price"><span class="amount">€${ped.precio}.00</span></td>
                                                        <td class="product-quantity"><input readonly min="1" max="99" required style="font-weight: bold; text-align: center" type="number" value="${ped.cant}" /></td>
                                                        <td class="product-subtotal">€${ped.precio*ped.cant}.00</td>
                                                    </tr>
                                                </c:forEach> 
                                                    <tr>
                                                        <td colspan="6" class="product-thumbnail">Client Message: ${ord.text}</td>
                                                    </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                </c:forEach>     
                            </c:when>
                            <c:otherwise>
                                <h1 align="center" style="color: red; font-weight: bold">You don´t have any order yet</h1>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
        <!-- cart-main-area end -->
        <jsp:include page="../commons/footer.jsp"/>

</body>

</html>

