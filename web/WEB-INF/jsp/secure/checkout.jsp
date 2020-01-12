<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>Checkout || KATES´S HANDMADE</title>
    <jsp:include page="../commons/head.jsp"/>
    <script type="text/javascript">
        function hideitem(e){
            if(e.value=="Credit/Debit Card"){
                document.getElementById("hid1").style.display = "block";
                document.getElementById("hid2").style.display = "none";
            }else if(e.value=="PayPal"){    
                document.getElementById("hid2").style.display = "block";
                document.getElementById("hid1").style.display = "none";
            }else{
                document.getElementById("hid1").style.display = "none";
                document.getElementById("hid2").style.display = "none";
            }
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
                                <h2 class="bradcaump-title">Checkout</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">Checkout</span>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End Bradcaump area -->
        <!-- Start Checkout Area -->
        <section class="our-checkout-area ptb--120 bg__white">
            <div class="container">
                <div class="row">
                    <c:choose>
                        <c:when test="${checkorder!=null}">
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
                                            <li><a href="wishlist.htm">WISHLIST<span></span></a></li>
                                            <li><a href="orders.htm">ORDERS<span></span></a></li>
                                            <li><a href="account.htm?logout=1">LOGOUT<span></span></a></li>
                                        </ul>
                                    </div>
                                    <!-- End Product Cat -->
                                </div>
                            </div>
                            <h1 align="center" style="color: red; font-weight: bold">Thank you for your order</h1>
                            <h2 align="center" style="color: red; font-weight: bold">You can check it´s progress in <a href="orders.htm">YOUR ORDERS</a></h2>
                            <h2 align="center" style="color: red; font-weight: bold">Have a nice day and come again!</h2>
                        </c:when>
                        <c:otherwise>
                            <div class="col-md-8 col-lg-8">
                                <div class="ckeckout-left-sidebar">
                                    <!-- Start Checkbox Area -->
                                    <form action="checkout.htm" method="post">
                                    <div class="checkout-form">
                                        <h2 class="section-title-3">Billing details</h2>
                                        <div class="checkout-form-inner">
                                            <div class="single-checkout-box">
                                                <input style="font-weight: bold" readonly type="text" value="${cliente.nombre}" placeholder="Full Name*">
                                                <input style="font-weight: bold" readonly type="text" value="${cliente.direccion}" placeholder="Full Address*">
                                            </div>
                                            <div class="single-checkout-box">
                                                <input style="font-weight: bold" readonly type="email" value="${cliente.correo}" placeholder="Email*">
                                                <input style="font-weight: bold" readonly type="text" value="${cliente.telefono}" placeholder="Phone number*">
                                            </div>
                                            <div class="single-checkout-box">
                                                <textarea maxlength="500" name="message" placeholder="Message*"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End Checkbox Area -->
                                    <!-- Start Payment Box -->
                                    <div style="margin-bottom: 20px" class="payment-form">
                                        <h2 class="section-title-3">payment details</h2>
                                        <p>Please, choose payment method</p>
                                        <div style="margin-top: 5px" class="payment-form-inner">
                                            <div class="single-checkout-box">
                                                <select required onchange="hideitem(this)" style="font-weight: bold" name="pays">
                                                    <option style="font-weight: bold" value="" disabled selected>Select your method</option>
                                                    <option style="font-weight: bold" value="PayPal">PayPal</option>
                                                    <option style="font-weight: bold" value="Credit/Debit Card">Credit/Debit Card</option>
                                                </select> 
                                            </div>

                                        </div>
                                    </div>
                                    <!-- End Payment Box -->
                                    <!-- Start Payment Way -->
                                    <div id="hid1" style="display: none" class="our-payment-sestem">
                                        <h2  class="section-title-3">We  Accept :</h2>
                                        <ul style="margin-top: 5px"  class="payment-menu">
                                            <li><a target="_blank" href="https://www.visa.com/"><img style="width: 50px" src="images2others/pay/VISA.jpg" alt="payment-img"></a></li>
                                            <li><a target="_blank" href="https://www.mastercard.com/"><img style="width: 50px" src="images2others/pay/MASTER.png" alt="payment-img"></a></li>
                                            <li><a target="_blank" href="https://www.americanexpress.com/"><img style="width: 50px" src="images2others/pay/AMERICAN.jpg" alt="payment-img"></a></li>
                                            <li><a target="_blank" href="https://www.global.jcb/en/index.html"><img style="width: 50px" src="images2others/pay/JBC.png" alt="payment-img"></a></li>
                                            <li><a target="_blank" href="http://www.unionpayintl.com/en/"><img style="width: 50px" src="images2others/pay/UNION.png" alt="payment-img"></a></li>
                                        </ul>
                                    </div>
                                    <div id="hid2" style="display: none" class="our-payment-sestem">
                                        <ul style="margin-top: 5px"  class="payment-menu">
                                            <li><a target="_blank" href="https://www.paypal.com/"><img style="width: 100px" src="images2others/pay/paypal.png" alt="payment-img"></a></li>
                                        </ul>
                                    </div>
                                    <div class="addtocart-btn">
                                            <a onclick="document.getElementById('subut').click()">CONFIRM & BUY NOW</a>
                                            <button id="subut" style="display: none" type="submit"></button>
                                    </div>
                                    </form>
                                    <!-- End Payment Way -->
                                </div>
                            </div>
                            <div class="col-md-4 col-lg-4">
                                <div class="checkout-right-sidebar">
                                    <div class="our-important-note">
                                        <h2 class="section-title-3">Note :</h2>
                                        <p class="note-desc">Please note that your package may be delayed due to holidays, as well as the poor performance of postal services in your country. Thank you</p>
                                        <ul class="important-note">
                                            <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Free Gift Box</a></li>
                                            <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Free Delivery</a></li>
                                            <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Money Back Guarantee</a></li>
                                            <li><a href="#"><i class="zmdi zmdi-caret-right-circle"></i>Support 24/7</a></li>
                                        </ul>
                                    </div>
                                    <div class="puick-contact-area mt--60">
                                        <h6 class="section-title-3">For any trouble</h6>
                                        <a style="font-weight: bold; font-size: 1.3em" href="mailto:arth.lebedev@gmail.com">contact us</a>
                                    </div>
                                </div>
                            </div>
                        </c:otherwise>                    
                    </c:choose>                        
                </div>
            </div>
        </section>
        <!-- End Checkout Area -->
        <jsp:include page="../commons/footer.jsp"/>

</body>

</html>
