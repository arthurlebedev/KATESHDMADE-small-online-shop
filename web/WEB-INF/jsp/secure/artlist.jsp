<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>Item List || KATES´S HANDMADE</title>
    <jsp:include page="../commons/head.jsp"/>
    <script type="text/javascript">
        function confirm_delete() {
            return confirm('Do you really want to delete this item?');
        }
    </script>
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
                                <h2 class="bradcaump-title">Item List</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Item List</span>
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
                                    <li><a style="color:red" href="artlist.htm">ITEM LIST<span></span></a></li>
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
                                    <li><a href="orders.htm">ORDERS<span></span></a></li>
                                    <li><a href="account.htm?logout=1">LOGOUT<span></span></a></li>
                                </ul>
                            </div>
                            <!-- End Product Cat -->
                        </div>
                        </div>
                        <div class="col-md-9 col-lg-9 col-sm-12 col-xs-12 smt-30">
                                    <c:if test="${message!=null}">   
                                            <div class="alert alert-danger" role="alert">
                                                ${message} 
                                            </div>
                                    </c:if>
                                    <div class="table-content table-responsive">
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th class="product-name">Item ID</th>
                                                    <th class="product-thumbnail">Image</th>
                                                    <th class="product-name">Product</th>
                                                    <th class="product-name">Parameters</th>
                                                    <th class="product-subtotal">Materials</th>
                                                    <th class="product-price">Price</th>
                                                    <th class="product-remove">Remove</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${itemlist}" var="car">       
                                                    <tr>
                                                        <td class="product-name" style="font-weight: bold; font-size: 1.5em">${car.idarticulo}</td>
                                                        <td class="product-thumbnail"><a href="product.htm?id=${car.idarticulo}"><img src="https://blobkateshdmade.blob.core.windows.net/images2/${car.foto1}" alt="product img" /></a></td>
                                                        <td class="product-name"><a href="product.htm?id=${car.idarticulo}">${car.nombre}</a></td>
                                                        <td class="product-name" style="font-weight: bold">
                                                            <c:choose>
                                                                <c:when test="${!car.add1.equals('NONE')||!car.add2.equals('NONE')||!car.add3.equals('NONE')||!car.add4.equals('NONE')}">
                                                                    <c:if test="${!car.add1.equals('NONE')}">
                                                                        ${car.add1}
                                                                    </c:if>
                                                                    <c:if test="${!car.add2.equals('NONE')}">
                                                                        <br/>
                                                                        ${car.add2}
                                                                    </c:if>
                                                                    <c:if test="${!car.add3.equals('NONE')}">
                                                                        <br/>
                                                                        ${car.add3}
                                                                    </c:if>
                                                                    <c:if test="${!car.add4.equals('NONE')}">
                                                                        <br/>
                                                                        ${car.add4}
                                                                    </c:if>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <span style="font-weight: bold">This item don´t have params</span>
                                                                </c:otherwise>        
                                                            </c:choose>            
                                                        </td>
                                                        <td class="product-name" style="font-weight: bold">${car.materials}</td>
                                                        <td class="product-price"><span class="amount">€${car.precio}.00</span></td>
                                                        <td class="product-remove"><a onclick="return confirm_delete()" href="artlist.htm?erase=${car.idarticulo}">X</a></td>
                                                    </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                    
                    </div>
                </div>
            </div>
        </div>
        <!-- cart-main-area end -->
        <jsp:include page="../commons/footer.jsp"/>

</body>

</html>

