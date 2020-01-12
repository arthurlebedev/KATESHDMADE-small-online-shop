<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<jsp:useBean id="bean" class="beans.BeanGeneral"/>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>KATES´S HANDMADE</title>
    <jsp:include page="commons/head.jsp"/>
</head>

<body>
    

        
        <jsp:include page="commons/header.jsp"/>
        
        <!-- Start Feature Product -->
        <section class="htc__feature__product pb--100 bg__white">
            <div class="container">
                <div class="row">
                    <!-- Start Left Feature -->
                    <div class="col-md-5 col-lg-5 col-sm-6 col-xs-12">
                        <div class="feature foo">
                            <div class="feature__thumb">
                                <a href="product.htm?id=24">
                                    <img src="images2others/470x678.jpg" alt="feature product">
                                </a>
                            </div>
                            <div class="feature__details">
                                <h4 style="color: white"><a href="product.htm?id=24">Personalized Christmas Balls</a></h4>
                                <div class="feature__btn">
                                    <a class="htc__btn shop__now__indexpage" href="shop.htm">shop now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End Left Feature -->
                    <div class="col-md-7 col-lg-7 col-sm-6 col-xs-12">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12 xmt-30">
                                <div class="feature foo">
                                    <div class="feature__thumb">
                                        <a href="shop.htm?cat=CHRISTMAS GIFTS">
                                            <img src="images2others/670x324.gif" alt="feature product">
                                        </a>
                                    </div>
                                    <div class="feature__details">
                                        <h4 style="color: white"><a href="shop.htm?cat=CHRISTMAS GIFTS">Christmas Gifts</a></h4>
                                        <div class="feature__btn">
                                            <a class="htc__btn shop__now__indexpage" href="shop.htm">shop now</a>
                                        </div>
                                    </div>
                                </div>                                
                            </div>
                            <div class="col-md-5 mt--30 hidden-sm hidden-xs">
                                <div class="feature foo">
                                    <div class="feature__thumb--2">
                                        <a href="product.htm?id=32">
                                            <img src="images2others/270x324.jpg" alt="feature product">
                                        </a>
                                    </div>
                                    <div class="feature__details">
                                        <h4 style="color: white"><a href="product.htm?id=32">Wooden Sign House</a></h4>
                                        <div class="feature__btn">
                                            <a class="htc__btn shop__now__indexpage" href="shop.htm">shop now</a>
                                        </div>
                                    </div>
                                </div>                                
                            </div>
                            <div class="col-md-7 mt--30 col-sm-12 col-xs-12 xmt-30">
                                <div class="feature foo">
                                    <div class="feature__thumb">
                                        <a href="product.htm?id=12">
                                            <img src="images2others/370x324.jpg" alt="feature product">
                                        </a>
                                    </div>
                                    <div class="feature__details">
                                        <h4 style="color: white"><a href="product.htm?id=12">Magic Unicorn Frame</a></h4>
                                        <div class="feature__btn">
                                            <a class="htc__btn shop__now__indexpage" href="shop.htm">shop now</a>
                                        </div>
                                    </div>
                                </div>                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Feature Product -->
        <!-- Start Popular Courses -->
        <section class="htc__popular__product pb--130 bg__white">
            <div class="container">
                <div class="row">
                    <div class="col-xs-12">
                        <div class="section__title section__title--2 text-center">
                            <h2 class="title__line">Best Rated Products</h2>
                            <p>Here you can see our most highly regarded products</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="popular__product__wrap clearfix owl-carousel owl-theme">
                        <!-- Start Single Popular Product -->
                        <c:forEach items="${popular}" var="pop">
                        <div class="col-md-4 col-lg-4 col-sm-6 col-xs-12">
                            <div class="product">
                                <div class="product__inner">
                                    <div class="pro__thumb">
                                        <a href="product.htm?id=${pop.idarticulo}">
                                            <img src="https://blobkateshdmade.blob.core.windows.net/images2/${pop.foto1}" alt="product images">
                                        </a>
                                    </div>
                                    <div class="product__hover__info">
                                        <ul class="product__action">
                                            <li><a data-toggle="modal" data-target="#productModal" title="Quick View" class="quick-view modal-view detail-link" href="index.htm?quick=${pop.idarticulo}"><span class="ti-plus"></span></a></li>
                                            <li><a title="Add To Cart" href="cart.htm?id=${pop.idarticulo}"><span class="ti-shopping-cart"></span></a></li>
                                        </ul>
                                    </div>
                                    <div class="add__to__wishlist">
                                        <a data-toggle="tooltip" title="Add To Wishlist" class="add-to-cart" href="wishlist.htm?id=${pop.idarticulo}"><span class="ti-heart"></span></a>
                                    </div>
                                </div>
                                <div class="product__details">
                                    <h2><a href="product.htm?id=${pop.idarticulo}">${pop.nombre}</a></h2>
                                    <span class="popular__pro__prize">€${pop.precio}.00</span>
                                </div>
                            </div>                            
                        </div>
                        </c:forEach>
                        <!-- End Single Popular Product -->
                    </div>
                </div>
            </div>
        </section>
        <!-- End Popular Courses -->
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
