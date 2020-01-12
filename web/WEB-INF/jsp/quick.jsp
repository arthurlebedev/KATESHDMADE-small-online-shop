<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <jsp:include page="commons/head.jsp"/>
</head>

<body>
    

                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            </div>
                            <div class="modal-body">
                                <div class="modal-product">
                                    <!-- Start product images -->
                                    <div class="product-images">
                                        <div class="main-image images">
                                            <img style="width: 520px" alt="big images" src="https://blobkateshdmade.blob.core.windows.net/images2/${artic.foto1}">
                                        </div>
                                    </div>
                                    <!-- end product images -->
                                    <div class="product-info">
                                        <form action="cart.htm" method="post">
                                        <h1>${artic.nombre}</h1>
                                        <div class="rating__and__review">
                                            <ul class="rating">
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
                                                
                                            </ul>
                                            <div class="review">
                                                <a href="#"/>${stars.clientes} customer reviews</a>
                                            </div>
                                        </div>
                                        <div class="price-box-3">
                                            <div class="s-price-box">
                                                <span class="new-price">€${artic.precio}.00</span>
                                            </div>
                                        </div>
                                        <div class="quick-desc">
                                            ${artic.text}
                                        </div>
                                        <c:if test="${params!=null}">
                                            <c:forEach varStatus="count" items="${params}" var="pa">
                                                <c:if test="${pa.paramType=='COMBO'}">
                                                    <div class="form-group">
                                                        <label for="sel1">${pa.id.paramName}:</label>
                                                        <select required style="width: 350px" class="form-control" name="combo${count.index}">
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
                                                                <option value="${pa.id.paramName}: ${pa.param7}">${pa.param7}</option>
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
                                        <div class="social-sharing">
                                            <div class="widget widget_socialsharing_widget">
                                                <h3 class="widget-title-modal">Share this product</h3>
                                                <ul class="social-icons">
                                                    <li><a target="_blank" title="rss" href="#" class="rss social-icon"><i class="zmdi zmdi-rss"></i></a></li>
                                                    <li><a target="_blank" title="Linkedin" href="#" class="linkedin social-icon"><i class="zmdi zmdi-linkedin"></i></a></li>
                                                    <li><a target="_blank" title="Pinterest" href="#" class="pinterest social-icon"><i class="zmdi zmdi-pinterest"></i></a></li>
                                                    <li><a target="_blank" title="Tumblr" href="#" class="tumblr social-icon"><i class="zmdi zmdi-tumblr"></i></a></li>
                                                </ul>
                                            </div>
                                        </div>
                                        <input type="hidden" name="id" value="${artic.idarticulo}">
                                        <div class="addtocart-btn">
                                            <a onclick="document.getElementById('subut').click()">Add to cart</a>
                                            <button id="subut" style="display: none" type="submit"></button>
                                        </div>
                                    </form>    
                                    </div><!-- .product-info -->
                                </div><!-- .modal-product -->
                            </div><!-- .modal-body -->



       <!-- jquery latest version -->
    <script src="js/vendor/jquery-1.12.0.min.js"></script>
    <!-- Bootstrap framework js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- All js plugins included in this file. -->
    <script src="js/plugins.js"></script>
    <script src="js/slick.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <!-- Waypoints.min.js. -->
    <script src="js/waypoints.min.js"></script>
    <!-- Main js file that contents all jQuery plugins activation. -->
    <script src="js/main.js"></script>
</body>

</html>