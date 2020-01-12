<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>Product Details || KATES´S HANDMADE</title>
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
                                <h2 class="bradcaump-title">Product Details</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Product Details</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area -->
        <!-- Start Product Details -->
        <section class="htc__product__details pt--120 pb--100 bg__white">
            <div class="container">
                <div class="row">
                    <c:if test="${che!=null}">
                        <div style="font-size: 1.3em"  class="alert alert-danger" role="alert">
                              To add this item to cart you need to choose some parameters
                        </div>
                    </c:if>
                    <c:if test="${wishal!=null}">
                        <div style="font-size: 1.3em" class="alert alert-danger" role="alert">
                              ${wishal}
                        </div>
                    </c:if>
                    <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12">
                        <div class="product__details__container">
                            <!-- Start Small images -->
                            <ul class="product__small__images" role="tablist">
                                <li role="presentation" class="pot-small-img active">
                                    <a href="#img-tab-1" role="tab" data-toggle="tab">
                                        <img style="width: 83.25px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto1}" alt="small-image">
                                    </a>
                                </li>
                                <c:if test="${oneart.foto2!='NONE'}">
                                    <li role="presentation" class="pot-small-img">
                                        <a href="#img-tab-2" role="tab" data-toggle="tab">
                                            <img style="width: 83.25px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto2}" alt="small-image">
                                        </a>
                                    </li>
                                </c:if>    
                                <c:if test="${oneart.foto3!='NONE'}">
                                    <li role="presentation" class="pot-small-img hidden-xs">
                                        <a href="#img-tab-3" role="tab" data-toggle="tab">
                                            <img style="width: 83.25px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto3}" alt="small-image">
                                        </a>
                                    </li>
                                </c:if>    
                                <c:if test="${oneart.foto4!='NONE'}">
                                    <li role="presentation" class="pot-small-img hidden-xs hidden-sm">
                                        <a href="#img-tab-4" role="tab" data-toggle="tab">
                                            <img style="width: 83.25px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto4}" alt="small-image">
                                        </a>
                                    </li>
                                </c:if>
                                <c:if test="${oneart.foto5!='NONE'}">   
                                    <li role="presentation" class="pot-small-img hidden-xs hidden-sm">
                                        <a href="#img-tab-5" role="tab" data-toggle="tab">
                                            <img style="width: 83.25px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto5}" alt="small-image">
                                        </a>
                                    </li>
                                </c:if>     
                            </ul>
                            <!-- End Small images -->
                            <div class="product__big__images">
                                <div class="portfolio-full-image tab-content">
                                    <div role="tabpanel" class="tab-pane fade in active" id="img-tab-1">
                                        <img style="width: 950px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto1}" alt="full-image">
                                    </div>
                                    <div role="tabpanel" class="tab-pane fade" id="img-tab-2">
                                        <img style="width: 950px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto2}" alt="full-image">
                                    </div>
                                    <div role="tabpanel" class="tab-pane fade" id="img-tab-3">
                                        <img style="width: 950px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto3}" alt="full-image">
                                    </div>
                                    <c:if test="${oneart.foto4!='NONE'}">
                                        <div role="tabpanel" class="tab-pane fade" id="img-tab-4">
                                            <img style="width: 950px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto4}" alt="full-image">
                                        </div>
                                    </c:if>
                                    <c:if test="${oneart.foto5!='NONE'}">
                                        <div role="tabpanel" class="tab-pane fade" id="img-tab-5">
                                            <img style="width: 950px" src="https://blobkateshdmade.blob.core.windows.net/images2/${oneart.foto5}" alt="full-image">
                                        </div>
                                    </c:if>    
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-6 col-sm-12 col-xs-12 smt-30 xmt-30">
                        <div class="htc__product__details__inner">
                            <div class="pro__detl__title">
                                <h2>${oneart.nombre}</h2>
                            </div>
                            <div class="pro__dtl__rating">
                                <ul class="pro__rating">
                                <c:choose>
                                    <c:when test="${stars.starsmedia>0}">
                                        <c:choose>
                                             <c:when test="${stars.starsmedia==5}">
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                            </c:when>
                                            <c:when test="${stars.starsmedia==4}">
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                            </c:when>
                                            <c:when test="${stars.starsmedia==3}">
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                            </c:when>
                                            <c:when test="${stars.starsmedia==2}">
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                            </c:when>
                                            <c:otherwise>
                                                <li><span class="zmdi zmdi-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                                <li><span class="ti-star"></span></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                    <c:otherwise>
                                        <li><span></span>Not valued yet</li>
                                    </c:otherwise>            
                                </c:choose>
                                </ul>
                                <c:if test="${stars.starsmedia>0}">
                                    <div class="review">
                                        <a href="#"/>Based on ${stars.clientes} Ratings</a>
                                    </div>
                                </c:if>
                            </div>
                            <div class="pro__details">
                                <p>${oneart.text}</p>
                            </div>
                            <ul class="pro__dtl__prize">
                                <li>€${oneart.precio}.00</li>
                            </ul>
                            <form action="cart.htm" method="post">
                            <c:if test="${params!=null}">
                                <c:forEach varStatus="count" items="${params}" var="pa">
                                    <c:if test="${pa.paramType=='COMBO'}">
                                        <div class="form-group">
                                            <label for="sel1">${pa.id.paramName}:</label>
                                            <select required style="width: 350px" class="form-control" id="sell" name="combo${count.index}">
                                                <option value="" disabled selected>Select your option</option>
                                                <c:if test="${pa.param1!='NONE'}">
                                                    <option value="${pa.id.paramName}: ${pa.param1}">${pa.param1}</option>
                                                </c:if>
                                                <c:if test="${pa.param2!='NONE'}">
                                                    <option value="${pa.id.paramName}: ${pa.param2}">${pa.param2}</option>
                                                </c:if>    
                                                <c:if test="${pa.param3!='NONE'}">
                                                    <option value="${pa.id.paramName}: ${pa.param3}">${pa.param3}</option>
                                                </c:if>
                                                <c:if test="${pa.param4!='NONE'}">
                                                    <option value="${pa.id.paramName}: ${pa.param4}">${pa.param4}</option>
                                                </c:if>
                                                <c:if test="${pa.param5!='NONE'}">
                                                    <option value="${pa.id.paramName}: ${pa.param5}">${pa.param5}</option>
                                                </c:if>
                                                <c:if test="${pa.param6!='NONE'}">
                                                    <option value="${pa.id.paramName}: ${pa.param6}">${pa.param6}</option>
                                                </c:if>
                                                <c:if test="${pa.param7!='NONE'}">
                                                     <option value="${pa.id.paramName}: ${ppa.param7}">${pa.param7}</option>
                                                </c:if>
                                                <c:if test="${pa.param8!='NONE'}">
                                                     <option value="${pa.id.paramName}: ${pa.param8}">${pa.param8}</option>
                                                </c:if>
                                                 <c:if test="${pa.param9!='NONE'}">
                                                    <option value="${pa.id.paramName}: ${pa.param9}">${pa.param9}</option>
                                                </c:if>    
                                            </select>
                                         </div>
                                    </c:if>
                                    <c:if test="${pa.paramType=='TEXT'}">
                                        <div class="form-group">
                                            <label for="usr">${pa.id.paramName}:</label>
                                            <input placeholder="Please fill out this form" required style="width: 350px" type="text" class="form-control" id="usr" name="text${count.index}">
                                            <input type="hidden" value="${pa.id.paramName}" name="hidden${count.index}"/>
                                        </div>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                            <div class="product-action-wrap">
                                <div class="prodict-statas"><span>Quantity :</span></div>
                                <div class="product-quantity">
                                    <form id='myform' method='POST' action='#'>
                                        <div class="product-quantity">
                                            <div class="cart-plus-minus">
                                                <input class="cart-plus-minus-box" type="text" value="1">
                                                <input type="hidden" name="cant" value="1">
                                            </div>
                                        </div>
                                </div>
                            </div>
                            <ul class="pro__dtl__btn">
                                <button id="subut" style="display: none" type="submit"></button>
                                <li class="buy__now__btn"><a onclick="document.getElementById('subut').click()" href="#">buy now</a></li>
                                <li><a href="wishlist.htm?id=${oneart.idarticulo}"><span class="ti-heart"></span></a></li>
                                <input type="hidden" name="id" value="${oneart.idarticulo}">
                            </ul>
                            </form>
                            <div class="pro__social__share">
                                <h2>Share :</h2>
                                <ul class="pro__soaial__link">
                                    <li><a href="https://twitter.com/" target="_blank"><i class="zmdi zmdi-twitter"></i></a></li>
                                    <li><a href="https://www.instagram.com/" target="_blank"><i class="zmdi zmdi-instagram"></i></a></li>
                                    <li><a href="https://www.facebook.com/" target="_blank"><i class="zmdi zmdi-facebook"></i></a></li>
                                </ul>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Product Details -->
        <!-- Start Product tab -->
        <section class="htc__product__details__tab bg__white pb--120">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
                        <ul class="product__deatils__tab mb--60" role="tablist">
                            <li role="presentation"  class="active">
                                <a href="#reviews" role="tab" data-toggle="tab">Reviews</a>
                            </li>
                            <li role="presentation">
                                <a href="#description" role="tab" data-toggle="tab">Dimensions</a>
                            </li>
                            <li role="presentation">
                                <a href="#sheet" role="tab" data-toggle="tab">Materials</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="product__details__tab__content">
                            <!-- Start Single Content -->
                            <div role="tabpanel" id="reviews" class="product__tab__content fade in active">
                                <div class="review__address__inner">
                                    <c:choose>
                                        <c:when test="${!reviews.isEmpty()}"> 
                                        <c:forEach varStatus="count" items="${reviews}" var="r">
                                        <!-- Start Single Review -->
                                        <c:choose>
                                            <c:when test="${num.index==0}">
                                                <div class="pro__review">
                                            </c:when>
                                            <c:otherwise>
                                                <div class="pro__review ans">
                                            </c:otherwise>
                                        </c:choose>
                                            <div class="review__details">
                                                <div class="review__info">
                                                    <h4><a href="#">${r.nombre}</a></h4>
                                                    <ul class="rating">
                                                        <c:choose>
                                                        <c:when test="${r.stars>0}">
                                                            <c:choose>
                                                                <c:when test="${r.stars==5}">
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                </c:when>
                                                                <c:when test="${r.stars==4}">
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                </c:when>
                                                                <c:when test="${r.stars==3}">
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                </c:when>
                                                                <c:when test="${r.stars==2}">
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <li><i class="zmdi zmdi-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                    <li><i class="ti-star"></i></li>
                                                                </c:otherwise>
                                                            </c:choose>
                                                            <c:choose>
                                                                <c:when test="${r.vercompra!=0}">
                                                                    <li>VERIFIED PURCHASE</li>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <li><span style="color:red">PURCHASE DON´T VERIFIED</span></li>
                                                                </c:otherwise>    
                                                            </c:choose>        
                                                        </c:when>
                                                    </c:choose>
                                                    <c:if test="${client.admin=='TRUE'}">
                                                        <li>
                                                            <a href="product.htm?erase=${r.idcliente}"><i class="zmdi zmdi-close"></i></a>
                                                        </li>
                                                    </c:if>
                                                    </ul>                
                                                </div>
                                                <div class="review__date">
                                                    <span>${r.fecha}</span>
                                                </div>
                                                <p>${r.text}</p>
                                            </div>
                                        </div>
                                        <!-- End Single Review -->
                                        </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="pro__review">
                                                <div class="review__details">
                                                <div class="review__info">
                                                <h2 style="font-weight: bold">NO REVIEWS YET</h2>
                                                </div>
                                                </div>    
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
                                    <!-- Start Single Review -->
                                    <div class="pro__review ans">
                                        
                                    </div>
                                    <!-- End Single Review -->
                                </div>
                                <!-- Start RAting Area -->
                                <c:if test="${client!=null}">
                                    <form id="review-form" action="product.htm">
                                        <div class="rating__wrap">
                                            <h2 class="rating-title">Write  A review</h2>
                                            <h4 class="rating-title-2">Your Rating</h4>
                                            <div class="rating__list">
                                                <select style="font-weight: bold" required class="form-control" id="rate" name="ratestars">
                                                    <option style="font-weight: bold" value="5">5 STARS</option>
                                                    <option style="font-weight: bold" value="4">4 STARS</option>
                                                    <option style="font-weight: bold" value="3">3 STARS</option>
                                                    <option style="font-weight: bold" value="2">2 STARS</option>
                                                    <option style="font-weight: bold" value="1">1 STARS</option>
                                                </select>
                                            </div>
                                        </div>
                                        <!-- End RAting Area -->
                                        <div class="review__box">
                                            <div class="single-review-form">
                                                <div class="review-box name">
                                                    <input style="font-weight: bold" value="${client.nombre}" readonly type="text" >
                                                    <input style="font-weight: bold" value="${client.correo}" readonly type="email" >
                                                </div>
                                            </div>
                                            <div class="single-review-form">
                                                <div class="review-box message">
                                                    <textarea name="texta" placeholder="Write your review"></textarea>
                                                </div>
                                            </div>
                                            <div class="review-btn">
                                                <c:choose>
                                                    <c:when test="${reviewcheck!=0}">
                                                        <div class="alert alert-danger" role="alert">
                                                            You can´t add second review to this product 
                                                        </div>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a onclick="document.getElementById('subut4').click()" class="fv-btn" href="#">submit review</a>
                                                        <button id="subut4" style="display: none" type="submit"></button>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                        </div>
                                    </form>
                                </c:if>                
                            </div>
                            <!-- End Single Content -->
                            <!-- Start Single Content -->
                            <div role="tabpanel" id="description" class="product__tab__content fade">
                                <div class="product__description__wrap">
                                    <div class="product__desc">
                                        <p>${oneart.dimensions}</p>
                                    </div>
                                </div>
                            </div>
                            <!-- End Single Content -->
                            <!-- Start Single Content -->
                            <div role="tabpanel" id="sheet" class="product__tab__content fade">
                                <div class="pro__feature">
                                        ${oneart.materials}
                                </div>
                            </div>
                            <!-- End Single Content -->
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Product tab -->
        <jsp:include page="commons/footer.jsp"/>

</body>

</html>
