<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>LogIn Register || KATES´S HANDMADE</title>
    <jsp:include page="commons/head.jsp"/>
    <script>
        function message(){
           document.getElementById("forget").style.display = "block";
        }
    </script>
</head>

<body>

        <jsp:include page="commons/header.jsp"/>
        <!-- Start Login Register Area -->
        <div class="htc__login__register bg__white ptb--130" style="background: rgba(0, 0, 0, 0) url(images/bg/5.jpg) no-repeat scroll center center / cover ;">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <ul class="login__register__menu" role="tablist">
                            <li role="presentation" class="login active"><a href="#login" role="tab" data-toggle="tab">Login</a></li>
                            <li role="presentation" class="register"><a href="#register" role="tab" data-toggle="tab">Register</a></li>
                        </ul>
                    </div>
                </div>
                <!-- Start Login Register Content -->
                <div class="row">
                    <div class="col-md-6 col-md-offset-3">
                        <div class="htc__login__register__wrap">
                            <!-- Start Single Content -->
                            <div id="login" role="tabpanel" class="single__tabs__panel tab-pane fade in active">
                                <form class="login" method="post">
                                    <input required type="text" name="mail" placeholder="Email*">
                                    <input required type="password" name="pass" placeholder="Password*">
                                    <c:if test="${checkout!=null}">
                                        <input type="hidden" name="checkout" value="1"/>
                                    </c:if>
                                <div class="tabs__checkbox">
                                    <span class="forget"><a href="#" onclick="message()">Forget Pasword?</a></span>
                                </div>
                                <div id="forget" style="display: none" class="alert alert-danger" role="alert">
                                    To recover a password please contact us via <a href="contact.htm" class="alert-link">Get In Touch Form</a> at the "Contact Us" page
                                </div>
                                <c:if test="${noexiste!=null}">   
                                    <div class="alert alert-danger" role="alert">
                                        Your email or password is incorrect 
                                    </div>
                                </c:if>     
                                <div class="htc__login__btn mt--30">
                                    <a onclick="document.getElementById('subut').click()">Login</a>
                                    <button id="subut" style="display: none" type="submit"></button>
                                </div>
                                </form>    
                            </div>
                            <!-- End Single Content -->
                            <!-- Start Single Content -->
                            <div id="register" role="tabpanel" class="single__tabs__panel tab-pane fade">
                                <form class="login" action="login.htm" method="post">
                                    <input type="text" name="namereg" placeholder="Name*">
                                    <input type="email" name="emailreg" placeholder="Email*">
                                    <input type="password" name="passreg" placeholder="Password*">
                                    <c:if test="${checkout!=null}">
                                        <input type="hidden" name="checkout" value="1"/>
                                    </c:if>
                                <div class="htc__login__btn">
                                    <a onclick="document.getElementById('subut2').click()">Register</a>
                                    <button id="subut2" style="display: none" type="submit"></button>
                                </div>
                                </form>    
                            </div>
                            <!-- End Single Content -->
                        </div>
                    </div>
                </div>
                <!-- End Login Register Content -->
            </div>
        </div>
        <!-- End Login Register Area -->
        <jsp:include page="commons/footer.jsp"/>

</body>

</html>
