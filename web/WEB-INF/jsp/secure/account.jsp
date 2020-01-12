<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>USER INFO || KATES´S HANDMADE</title>
     <jsp:include page="../commons/head.jsp"/>
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
                                <h2 class="bradcaump-title">User Account</h2>
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
                                    <li><a style="color:red" href="account.htm">PERSONAL INFORMATION<span></span></a></li>
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
                                <div style="margin-left: 100px" class="section__title section__title--2 center-block">
                                    <form action="account.htm" method="post">
                                        <c:if test="${message!=null}">   
                                            <div class="alert alert-danger" role="alert">
                                                ${message} 
                                            </div>
                                        </c:if>
                                        <h2 style="font-weight: bold">PERSONAL INFORMATION</h2>
                                        <br/>
                                        <label for="usr">Full Name: </label>
                                        <input value="${cliente.nombre}" required style="width: 350px" type="text" class="form-control" id="usr" name="username">
                                        <br/>
                                        <label for="usr2">ID Card: </label>
                                        <input value="${cliente.dni}" required style="width: 350px" type="text" class="form-control" id="usr2" name="usercard">
                                        <br/>
                                        <label for="usr3">Full Address: </label>
                                        <input value="${cliente.direccion}" required style="width: 350px" type="text" class="form-control" id="usr3" name="dir">
                                        <br/>
                                        <label for="usr4">Phone number (international format): </label>
                                        <input value="${cliente.telefono}" required style="width: 350px" type="tel" class="form-control" id="usr4" name="tel">
                                        <br/>
                                        <label for="usr5">Email: </label>
                                        <input value="${cliente.correo}" required style="width: 350px" type="email" class="form-control" id="usr5" name="mail">
                                        <br/>
                                        <label for="usr6">New Password: </label>
                                        <input style="width: 200px" type="password" class="form-control" id="usr6" name="newpass">
                                        <label for="usr7">Confirm New Password: </label>
                                        <input style="width: 200px" type="password" class="form-control" id="usr7" name="newpass2">
                                        <br/>
                                        <label style="color: red" for="usr8">Current Password to validate the form: </label>
                                        <input required style="width: 350px" type="password" class="form-control" id="usr8" name="passconfirm">
                                        <br/>
                                        <div class="addtocart-btn">
                                            <a onclick="document.getElementById('subut').click()">Change Personal Data</a>
                                            <button id="subut" style="display: none" type="submit"></button>
                                        </div>
                                    </form>    
                                </div>
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


