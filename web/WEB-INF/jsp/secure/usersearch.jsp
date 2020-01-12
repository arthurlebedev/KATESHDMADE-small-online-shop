<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>USER SEARCH || KATES´S HANDMADE</title>
     <jsp:include page="../commons/head.jsp"/>
     <script type="text/javascript">
        function confirm_delete() {
            return confirm('Do you really want to delete this user?');
        }
        function confirm_delete2() {
            return confirm('Do you really want to delete this review?');
        }
    </script>
</head>

<body>
    <!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->  

    <!-- Body main wrapper start -->
    <div class="wrapper fixed__footer">
        <jsp:include page="../commons/header.jsp"/>
        <!-- Start Bradcaump area -->
        <div class="ht__bradcaump__area" style="background: rgba(0, 0, 0, 0) url(images/bg/2.jpg) no-repeat scroll center center / cover ;">
            <div class="ht__bradcaump__wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="bradcaump__inner text-center">
                                <h2 class="bradcaump-title">User Search</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">User Search</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area --> 
        <!-- Start Our ShopSide Area -->
        <section class="cart-main-area ptb--120 bg__white">
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
                                    <li><a style="color:red" href="usersearch.htm">USER SEARCH<span></span></a></li>
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
                        <div class="row">
                            <div class="col-md-12">
                                
                                <form action="usersearch.htm" method="post">
                                        <c:if test="${message!=null}">   
                                            <div class="alert alert-danger" role="alert">
                                                ${message} 
                                            </div>
                                        </c:if>
                                        <h2 style="font-weight: bold">USER SEARCH SYSTEM</h2>
                                        
                                        <label style="margin-top: 25px" for="usr">User ID: </label>
                                        <input placeholder="Enter user ID" value="${users.idcliente}" required style="width: 225px" type="text" class="form-control" id="usr" name="userid">
                                        <input style="margin-top: 5px" type="submit" value="Search User" class="btn btn-dark">
                                    </form>
                                    <c:if test="${users!=null}">
                                        <div style="margin-top: 10px" class="table-content table-responsive">
                                            <table>
                                                <thead>
                                                    <tr>
                                                        <th class="product-name">Full Name</th>
                                                        <th class="product-name">ID Card</th>
                                                        <th class="product-name">Phone Number</th>
                                                        <th class="product-name">Email</th>
                                                        <th class="product-remove">Remove</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                        <tr>
                                                            <td class="product-name" style="font-weight: bold">${users.nombre}</td>
                                                            <td class="product-name" style="font-weight: bold">${users.dni}</td>
                                                            <td class="product-name" style="font-weight: bold">${users.telefono}</td>
                                                            <td class="product-name" style="font-weight: bold">${users.correo}</td>
                                                            <td rowspan="2" class="product-remove">
                                                                <c:if test="${users.idcliente!=1}">
                                                                    <a onclick="return confirm_delete()" href="usersearch.htm?del=${users.idcliente}">X</a>
                                                                </c:if>
                                                            </td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="4" class="product-name" style="font-weight: bold">CLIENT FULL ADDRESS: ${users.direccion}</td>
                                                        </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </c:if>
                                    <c:if test="${!empty orderlist}">
                                            <h1 style="text-align: center">ORDERS</h1>
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
                                        </c:if>
                                        <c:if test="${reviewlist!=null}">
                                            <h1 style="text-align: center">REVIEWS</h1>
                                            <div class="table-content table-responsive">
                                                <table>
                                                    <thead>
                                                        <tr>
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
                                                                <td rowspan="2" class="product-remove"><a onclick="return confirm_delete2()" href="usersearch.htm?erase=${car.idarticulo}&&idcli=${car.idcliente}">X</a></td>
                                                            </tr>
                                                            <tr>
                                                                <td colspan="5" class="product-name" style="font-weight: bold">Client Review: ${car.text}</td>
                                                            </tr>
                                                        </c:forEach> 
                                                    </tbody>
                                                </table>
                                            </div>
                                        </c:if>
                                
                            </div>
                        </div>
                    </div>    
                </div>
            </div>
        </section>
        <!-- End Our ShopSide Area -->
        <jsp:include page="../commons/footer.jsp"/>
</body>

</html>

