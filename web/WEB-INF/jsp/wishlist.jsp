<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>Wishlist || KATES´S HANDMADE</title>
    <jsp:include page="commons/head.jsp"/>
</head>

<body>
    <jsp:include page="commons/header.jsp"/>
        <!-- Start Bradcaump area -->
        <div class="ht__bradcaump__area" style="background: rgba(0, 0, 0, 0) url(images/bg/2.jpg) no-repeat scroll center center / cover ;">
            <div class="ht__bradcaump__wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">Wishlist</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Wishlist</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area -->
        <!-- wishlist-area start -->
        <div class="wishlist-area ptb--120 bg__white">
            <div class="container">
                <div class="row">
                    <c:choose>
                        <c:when test="${us!=null}">
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
                                    <li><a style="color:red" href="wishlist.htm">WISHLIST<span></span></a></li>
                                    <li><a href="orders.htm">ORDERS<span></span></a></li>
                                    <li><a href="account.htm?logout=1">LOGOUT<span></span></a></li>
                                </ul>
                            </div>
                            <!-- End Product Cat -->
                        </div>
                        </div>
                        <div class="col-md-9 col-lg-9 col-sm-12 col-xs-12 smt-30">
                        </c:when>
                        <c:otherwise>
                            <div class="col-md-12 col-sm-12 col-xs-12">
                        </c:otherwise>
                    </c:choose>
                        <div class="wishlist-content">
                                    <c:choose>
                                        <c:when test="${wish!=null}">
                                            <form action="wishlist.htm" method="post">
                                                <div class="wishlist-table table-responsive">    
                                                    <table>
                                                        <thead>
                                                            <tr>
                                                                <th class="product-remove"><span class="nobr">Remove</span></th>
                                                                <th class="product-thumbnail">Image</th>
                                                                <th class="product-name"><span class="nobr">Product Name</span></th>
                                                                <th class="product-price"><span class="nobr"> Unit Price </span></th>
                                                                <th class="product-stock-stauts"><span class="nobr"> Quantity </span></th>
                                                                <th class="product-add-to-cart"><span class="nobr">Add To Cart</span></th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                            <c:forEach items="${wish}" var="w">
                                                                <tr>
                                                                    <td class="product-remove"><a href="wishlist.htm?erase=${w.idarticulo}">×</a></td>
                                                                    <td class="product-thumbnail"><a href="product.htm?id=${w.idarticulo}"><img style="width: 270px" src="https://blobkateshdmade.blob.core.windows.net/images2/${w.foto1}" alt="" /></a></td>
                                                                    <td class="product-name"><a href="product.htm?id=${w.idarticulo}">${w.nombre}</a></td>
                                                                    <td class="product-price"><span class="amount">€${w.precio}.00</span></td>
                                                                    <td class="product-quantity"><input min="1" max="99" style="font-weight: bold; width: 50px; text-align: center" required type="number" name="${w.idarticulo}" value="${w.quantity}" /></td>
                                                                    <td class="product-add-to-cart"><a href="cart.htm?wish=1&&id=${w.idarticulo}&&wishquant=${w.quantity}"> Add to Cart</a></td>
                                                                    <input type="hidden" name="id${w.idarticulo}" value="${w.idarticulo}"/>
                                                                </tr>
                                                            </c:forEach>    
                                                        </tbody>
                                                    </table>
                                                </div>
                                                <div style="margin-top: 20px" class="row">
                                                    <div class="col-md-8 col-sm-7 col-xs-12">
                                                        <div class="buttons-cart">
                                                            <input type="hidden" name="quant" value="1"/>
                                                            <input type="submit" value="Update Wishlist" />
                                                        </div>
                                                    </div>
                                                </div>    
                                            </form>    
                                        </c:when>
                                        <c:otherwise>
                                            <h1 align="center" style="color: red; font-weight: bold">Your wishlist is empty</h1>
                                        </c:otherwise>
                                    </c:choose>    
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- wishlist-area end -->
        <jsp:include page="commons/footer.jsp"/>

</body>

</html>
