<jsp:useBean id="bean" class="beans.BeanGeneral"/>
<jsp:useBean id="beans" class="beans.BeanSession"/>


<!--[if lt IE 8]>
        <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->  

<!-- Body main wrapper start -->
<div class="wrapper fixed__footer">
<%beans.getCarSession(request, response);%>
<!-- Start Header Style -->
        <header id="header" class="htc-header header--3 bg__white">
            <!-- Start Mainmenu Area -->
            <div id="sticky-header-with-topbar" class="mainmenu__area sticky__header">
                <div class="container">
                    <div class="row">
                        <div class="col-md-2 col-lg-2 col-sm-3 col-xs-3">
                            <div class="logo">
                                <a href="index.htm">
                                    <img src="images/logo/uniqlo.png" alt="logo">
                                </a>
                            </div>
                        </div>
                        <!-- Start MAinmenu Ares -->
                        <div class="col-md-8 col-lg-8 col-sm-6 col-xs-6">
                            <nav class="mainmenu__nav hidden-xs hidden-sm">
                                <ul class="main__menu">
                                    <li class="drop"><a href="index.htm">Home</a></li>
                                    <li><a href="about.htm">About</a></li>
                                    <li class="drop"><a href="shop.htm">Shop</a>
                                        <ul class="dropdown mega_dropdown">
                                            <!-- Start Single Mega MEnu -->
                                            <li><a class="mega__title" href="shop.htm">Shop</a>
                                                <ul class="mega__item">
                                                    <li><a href="shop.htm">All Products</a></li>
                                                </ul>
                                            </li>
                                            <!-- End Single Mega MEnu -->
                                            <!-- Start Single Mega MEnu -->
                                            <li><a class="mega__title" href="shop.htm">Categories</a>
                                                <ul class="mega__item">
                                                    <li><a href="shop.htm?cat=ANIMAL KIDS FRAME">ANIMAL KID´S FRAME</a></li>
                                                    <li><a href="shop.htm?cat=FRAMES WITH METRICS">FRAMES WITH METRICS</a></li>
                                                    <li><a href="shop.htm?cat=EARRING HOLDERS">EARRING HOLDERS</a></li>
                                                    <li><a href="shop.htm?cat=CLOCKS">CLOCKS</a></li>
                                                </ul>
                                            </li>
                                            <!-- End Single Mega MEnu -->
                                            <!-- Start Single Mega MEnu -->
                                            <li><a class="mega__title" href="shop.htm">Categories</a>
                                                <ul class="mega__item">
                                                    <li><a href="shop.htm?cat=CHRISTMAS GIFTS">CHRISTMAS GIFTS</a></li>
                                                    <li><a href="shop.htm?cat=SIGN AND PLAQUE">SIGN AND PLAQUE</a></li>
                                                    <li><a href="shop.htm?cat=OTHER INTERESTING FRAMES">OTHER INTERESTING FRAMES</a></li>
                                                    <li><a href="shop.htm?cat=COOL THINGS">COOL THINGS</a></li>
                                                </ul>
                                            </li>
                                            <!-- End Single Mega MEnu -->
                                        </ul>
                                    </li>
                                    <%=beans.getMenuOrder(request, response)%>
                                    <li><a href="contact.htm">contact</a></li>
                                </ul>
                            </nav>
                            <div class="mobile-menu clearfix visible-xs visible-sm">
                                <nav id="mobile_dropdown">
                                    <ul>
                                        <li><a href="index.htm">Home</a></li>
                                        <li><a href="about.htm">About</a></li>
                                        <li><a href="shop.htm">Shop</a>
                                            <ul>
                                                <li><a href="shop.htm">All Products</a></li>
                                                <li><a href="shop.htm?cat=ANIMAL KIDS FRAME">ANIMAL KID´S FRAME</a></li>
                                                <li><a href="shop.htm?cat=FRAMES WITH METRICS">FRAMES WITH METRICS</a></li>
                                                <li><a href="shop.htm?cat=EARRING HOLDERS">EARRING HOLDERS</a></li>
                                                <li><a href="shop.htm?cat=CLOCKS">CLOCKS</a></li>
                                                <li><a href="shop.htm?cat=CHRISTMAS GIFTS">CHRISTMAS GIFTS</a></li>
                                                <li><a href="shop.htm?cat=SIGN AND PLAQUE">SIGN AND PLAQUE</a></li>
                                                <li><a href="shop.htm?cat=OTHER INTERESTING FRAMES">OTHER INTERESTING FRAMES</a></li>
                                                <li><a href="shop.htm?cat=COOL THINGS">COOL THINGS</a></li>
                                            </ul>
                                        </li>
                                        <li><a href="contact.htm">contact</a></li>
                                    </ul>
                                </nav>
                            </div>                          
                        </div>
                        <!-- End MAinmenu Ares -->
                        <div class="col-md-2 col-sm-4 col-xs-3">
                            <ul class="menu-extra">
                                <li class="search search__open hidden-xs"><span class="ti-search"></span></li>
                                <li><a href="account.htm"><span class="ti-user"><%=beans.getNombreCliente(request, response)%></span></a></li>    
                                <li><a href="wishlist.htm"><span class="ti-heart"></span></a></li>
                                <li class="cart__menu"><span class="ti-shopping-cart"></span><span style="font-weight: bold; color: red"><%=beans.getCartNumber(request, response)%></span></li>
                                <%=beans.getLogout(request, response)%>
                            </ul>
                        </div>
                    </div>
                    <div class="mobile-menu-area"></div>
                </div>
            </div>
            <!-- End Mainmenu Area -->
        </header>
        <!-- End Header Style -->
        
        <div class="body__overlay"></div>
        <!-- Start Offset Wrapper -->
        <div class="offset__wrapper">
            <!-- Start Search Popap -->
            <div class="search__area">
                <div class="container" >
                    <div class="row" >
                        <div class="col-md-12" >
                            <div class="search__inner">
                                <datalist id="articulos">
                                      <%=bean.getArticulosDatalist()%>
                                  </datalist>
                                <form action="shop.htm" >
                                    <input list="articulos" placeholder="Search here... " type="text" name="searchengine">
                                    <button type="submit"></button>
                                </form>
                                <div class="search__close__btn">
                                    <span class="search__close__btn_icon"><i class="zmdi zmdi-close"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Search Popap -->
            <!-- Start Cart Panel -->
            <div class="shopping__cart">
                <div class="shopping__cart__inner">
                    <div class="offsetmenu__close__btn">
                        <a href="#"><i class="zmdi zmdi-close"></i></a>
                    </div>
                    <%=beans.getAllCart(request, response)%>
                </div>
            </div>
            <!-- End Cart Panel -->
        </div>
        <!-- End Offset Wrapper -->
