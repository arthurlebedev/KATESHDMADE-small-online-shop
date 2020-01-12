<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>Review List || KATES´S HANDMADE</title>
    <jsp:include page="../commons/head.jsp"/>
    <script type="text/javascript">
        function confirm_delete() {
            return confirm('Do you really want to delete this review?');
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
                                <h2 class="bradcaump-title">Review List</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Review List</span>
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
                                    <li><a style="color:red" href="adminreview.htm">REVIEW LIST<span></span></a></li>
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
                            <c:choose>
                                <c:when test="${reviewlist!=null}">  
                                    
                                    <div class="table-content table-responsive">
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th class="product-name">Client ID</th>
                                                    <th class="product-name">Client Name</th>
                                                    <th class="product-thumbnail">Item Name</th>
                                                    <th class="product-name">Stars</th>
                                                    <th class="product-subtotal">Date</th>
                                                    <th class="product-price">Check Order</th>
                                                    <th class="product-remove">Remove</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${reviewlist}" var="car">       
                                                    <tr>
                                                        <td rowspan="2" class="product-name" style="font-weight: bold; font-size: 1.5em">${car.idcliente}</td>
                                                        <td class="product-thumbnail" style="font-weight: bold">${car.nombre}</td>
                                                        <td class="product-name"><a href="product.htm?id=${car.idarticulo}">${car.artnombre}</a></td>
                                                        <td class="product-name" style="font-weight: bold">${car.stars}</td>
                                                        <td class="product-name" style="font-weight: bold">${car.fecha}</td>
                                                        <td class="product-name" style="font-weight: bold">
                                                            <c:choose>
                                                                <c:when test="${car.vercompra!=0}">
                                                                    VERIFIED
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <span style="color:red">DON´T VERIFIED</span>
                                                                </c:otherwise>    
                                                            </c:choose> 
                                                        </td>
                                                        <td rowspan="2" class="product-remove"><a onclick="return confirm_delete()" href="adminreview.htm?erase=${car.idarticulo}&&idcli=${car.idcliente}">X</a></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="5" class="product-name" style="font-weight: bold">Client Review: ${car.text}</td>
                                                    </tr>
                                                </c:forEach> 
                                            </tbody>
                                        </table>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                        <h1 align="center" style="color: red; font-weight: bold">There is no review in your shop</h1>
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
