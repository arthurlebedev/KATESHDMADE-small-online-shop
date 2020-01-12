<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>Shop || KATES´S HANDMADE</title>
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
                                <h2 class="bradcaump-title">Kate´s Handmade Shop</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Shop</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area --> 
        <!-- Start Our ShopSide Area -->
        <section class="htc__shop__sidebar bg__white ptb--120">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 col-lg-3 col-sm-12 col-xs-12">
                        <div class="htc__shop__left__sidebar">
                            <!-- Start Range -->
                            <div class="htc-grid-range">
                                <h4 class="section-title-4">FILTER BY PRICE</h4>
                                <div class="content-shopby">
                                    <div class="price_filter s-filter clear">
                                        <form action="shop.htm" method="post">
                                            <div class="slider__range--output">
                                                <div class="price__output--wrap">
                                                    <div class="price--output">
                                                        <c:choose>
                                                            <c:when test="${min!=null}">
                                                                <span>Price :</span><input required style="width: 70px; border: solid; border-width: 0.5px; margin-left: 5px; margin-right: 5px; border-color: lightgrey" value="${min}" min="0" max="99" type="number" name="amountmin"><span> - </span><input style="width: 70px; border: solid; border-width: 0.5px; margin-left: 5px; margin-right: 5px; border-color: lightgrey" value="${max}" required min="0" max="99" type="number" name="amountmax">
                                                            </c:when>
                                                            <c:otherwise>
                                                                <span>Price :</span><input required style="width: 70px; border: solid; border-width: 0.5px; margin-left: 5px; margin-right: 5px; border-color: lightgrey" min="0" max="99" type="number" name="amountmin"><span> - </span><input style="width: 70px; border: solid; border-width: 0.5px; margin-left: 5px; margin-right: 5px; border-color: lightgrey" required min="0" max="99" type="number" name="amountmax">
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                    <div class="price--filter">
                                                        <a onclick="document.getElementById('subut2').click()">Filter</a>
                                                        <button id="subut2" style="display: none" type="submit"></button>
                                                    </div>
                                                </div>
                                                <div style="float: right">
                                                        <a style="color: red" href="shop.htm?reset=1">RESET</a>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                            <!-- End Range -->
                            <!-- Start Product Cat -->
                            <div class="htc__shop__cat">
                                <h4 class="section-title-4">PRODUCT CATEGORIES</h4>
                                <ul class="sidebar__list">
                                    <c:choose>
                                        <c:when test="${categ=='all'}">
                                            <li><a style="color: red" href="shop.htm?cat=all">ALL PRODUCTS<span>${procount}</span></a></li>
                                        </c:when>
                                        <c:otherwise>
                                            <li><a href="shop.htm?cat=all">ALL PRODUCTS<span>${procount}</span></a></li>
                                        </c:otherwise>
                                    </c:choose>
                                    <c:forEach items="${catlist}" var="cat">
                                        <c:choose>
                                            <c:when test="${categ==cat.catname}">
                                                <li><a style="color: red" href="shop.htm?cat=${cat.catname}">${cat.catname}<span>${cat.count}</span></a></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><a href="shop.htm?cat=${cat.catname}">${cat.catname}<span>${cat.count}</span></a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </ul>
                            </div>
                            <!-- End Product Cat -->
                        </div>
                    </div>
                    <div class="col-md-9 col-lg-9 col-sm-12 col-xs-12 smt-30">
                        <div class="row">
                            <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                                <div class="producy__view__container">
                                    <!-- Start Short Form -->
                                    <div class="product__list__option">
                                        <div class="order-single-btn">
                                            <form action="shop.htm">
                                                <select name="combosort" onchange="this.form.submit()" class="select-color selectpicker">
                                                    <c:choose>
                                                        <c:when test="${combosort!=null}">
                                                            <c:choose>
                                                                <c:when test="${combosort=='1'}">
                                                                    <option selected value="1">Sort by title</option>
                                                                    <option value="2">Sort by price</option>
                                                                    <option value="3">Sort by category</option>
                                                                </c:when>
                                                                <c:when test="${combosort=='2'}">
                                                                    <option value="1">Sort by title</option>
                                                                    <option selected value="2">Sort by price</option>
                                                                    <option value="3">Sort by category</option>
                                                                </c:when>
                                                                <c:when test="${combosort=='3'}">
                                                                    <option value="1">Sort by title</option>
                                                                    <option value="2">Sort by price</option>
                                                                    <option selected value="3">Sort by category</option>
                                                                </c:when>
                                                            </c:choose>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="1">Sort by title</option>
                                                            <option value="2">Sort by price</option>
                                                            <option value="3">Sort by category</option>
                                                        </c:otherwise>    
                                                    </c:choose>
                                                </select>
                                            </form>    
                                        </div>
                                        <div class="shp__pro__show">
                                            <span>Showing ${todo.size()} results</span>
                                        </div>
                                    </div>
                                    <!-- End Short Form -->
                                    <!-- Start List And Grid View -->
                                    <ul class="view__mode" role="tablist">
                                        <li role="presentation" class="grid-view active"><a href="#grid-view" role="tab" data-toggle="tab"><i class="zmdi zmdi-grid"></i></a></li>
                                        <li role="presentation" class="list-view"><a href="#list-view" role="tab" data-toggle="tab"><i class="zmdi zmdi-view-list"></i></a></li>
                                    </ul>
                                    <!-- End List And Grid View -->
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="shop__grid__view__wrap">
                                <!-- Start Single View -->
                                <div role="tabpanel" id="grid-view" class="single-grid-view tab-pane fade in active clearfix">
                                    <c:forEach items="${todo}" var="t">
                                    <!-- Start Single Product -->
                                        <div class="col-md-3 col-lg-4 col-sm-4 col-xs-12">
                                            <div class="product">
                                                <div class="product__inner">
                                                    <div class="pro__thumb">
                                                        <a href="product.htm?id=${t.idarticulo}">
                                                            <img src="https://blobkateshdmade.blob.core.windows.net/images2/${t.foto1}" alt="product images">
                                                        </a>
                                                    </div>
                                                    <div class="product__hover__info">
                                                        <ul class="product__action">
                                                            <li><a data-toggle="modal" data-target="#productModal" title="Quick View" class="quick-view modal-view detail-link" href="shop.htm?quick=${t.idarticulo}"><span class="ti-plus"></span></a></li>
                                                            <li><a title="Add To Cart" href="cart.htm?id=${t.idarticulo}"><span class="ti-shopping-cart"></span></a></li>
                                                        </ul>
                                                    </div>
                                                    <div class="add__to__wishlist">
                                                        <a data-toggle="tooltip" title="Add To Wishlist" class="add-to-cart" href="wishlist.htm?id=${t.idarticulo}"><span class="ti-heart"></span></a>
                                                    </div>
                                                </div>
                                                <div style="overflow: hidden" class="product__details">
                                                    <h2><a href="product.htm?id=${t.idarticulo}">${t.nombre}</a></h2>
                                                    <ul class="product__price">
                                                        <li class="new__price">€${t.precio}.00</li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    <!-- End Single Product -->
                                    </c:forEach>
                                </div>
                                <!-- End Single View -->
                                <!-- Start Single View -->
                                <div role="tabpanel" id="list-view" class="single-grid-view tab-pane fade clearfix">
                                    <c:forEach items="${todo}" var="t"> 
                                    <!-- Start List Content-->
                                    <div class="single__list__content clearfix">
                                        <div class="col-md-3 col-lg-3 col-sm-4 col-xs-12">
                                            <div class="list__thumb">
                                                <a href="product.htm?id=${t.idarticulo}">
                                                    <img style="width: 270px" src="https://blobkateshdmade.blob.core.windows.net/images2/${t.foto1}" alt="list images">
                                                </a>
                                            </div>
                                        </div>
                                        <div class="col-md-9 col-lg-9 col-sm-8 col-xs-12">
                                            <div class="list__details__inner">
                                                <h2><a href="product.htm?id=${t.idarticulo}">${t.nombre}</a></h2>
                                                <p style="height: 80px; overflow: hidden">${t.text}</p>
                                                <span class="product__price">€${t.precio}.00</span>
                                                <div class="shop__btn">
                                                    <a class="htc__btn" href="cart.htm?id=${t.idarticulo}"><span class="ti-shopping-cart"></span>Add to Cart</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End List Content-->
                                    </c:forEach> 
                                </div>
                                <!-- End Single View -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Our ShopSide Area -->
        <!-- QUICKVIEW PRODUCT -->
            <div id="quickview-wrapper">
                <!-- Modal -->
                <div class="modal fade" id="productModal" tabindex="-1" role="dialog">
                    <div class="modal-dialog modal__container" role="document">
                        <div class="modal-content">
                            
                        </div><!-- .modal-content -->
                    </div><!-- .modal-dialog -->
                </div>
                <!-- END Modal -->
            </div>
        <!-- END QUICKVIEW PRODUCT -->
        <jsp:include page="commons/footer.jsp"/>
</body>

</html>

