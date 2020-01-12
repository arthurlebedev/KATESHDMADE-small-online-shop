<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>User List || KATES´S HANDMADE</title>
    <jsp:include page="../commons/head.jsp"/>
    <script type="text/javascript">
        function confirm_delete() {
            return confirm('Do you really want to delete this user?');
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
                                <h2 class="bradcaump-title">Cart</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Cart</span>
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
                                    <li><a style="color:red" href="users.htm">USER LIST<span></span></a></li>
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
                        
                                     <div class="table-content table-responsive">
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th class="product-name">Client ID</th>
                                                    <th class="product-name">Full Name</th>
                                                    <th class="product-name">ID Card</th>
                                                    <th class="product-name">Phone Number</th>
                                                    <th class="product-name">Email</th>
                                                    <th class="product-remove">Remove</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${users}" var="us">       
                                                    <tr>
                                                        <td rowspan="2" class="product-name">${us.idcliente}</td>
                                                        <td class="product-name" style="font-weight: bold">${us.nombre}</td>
                                                        <td class="product-name" style="font-weight: bold">${us.dni}</td>
                                                        <td class="product-name" style="font-weight: bold">${us.telefono}</td>
                                                        <td class="product-name" style="font-weight: bold">${us.correo}</td>
                                                        <td rowspan="2" class="product-remove">
                                                            <c:if test="${us.idcliente!=1}">
                                                                <a onclick="return confirm_delete()" href="users.htm?erase=${us.idcliente}">X</a>
                                                            </c:if>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="4" class="product-name" style="font-weight: bold">CLIENT FULL ADDRESS: ${us.direccion}</td>
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

