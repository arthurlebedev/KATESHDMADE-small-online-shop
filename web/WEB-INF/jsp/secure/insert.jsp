<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html class="no-js" lang="en">
<head>
    <title>ADD NEW ITEM || KATES´S HANDMADE</title>
     <jsp:include page="../commons/head.jsp"/>
     <script type="text/javascript">
         function button1(){
             document.getElementById("image2").style.display = "block";
             document.getElementById("but1").style.display = "none";
         }
         function button2(){
             document.getElementById("image3").style.display = "block";
             document.getElementById("but2").style.display = "none";
             document.getElementById("del1").style.display = "none";
         }
         function button3(){
             document.getElementById("image4").style.display = "block";
             document.getElementById("but3").style.display = "none";
             document.getElementById("del2").style.display = "none";
         }
         function button4(){
             document.getElementById("image5").style.display = "block";
             document.getElementById("but4").style.display = "none";
             document.getElementById("del3").style.display = "none";
         }
         
         function delete1(){
             document.getElementById("image2").style.display = "none";
             document.getElementById("but1").style.display = "block";
         }
         function delete2(){
             document.getElementById("image3").style.display = "none";
             document.getElementById("but2").style.display = "inline";
             document.getElementById("del1").style.display = "inline";
         }
         function delete3(){
             document.getElementById("image4").style.display = "none";
             document.getElementById("but3").style.display = "inline";
             document.getElementById("del2").style.display = "inline";
         }
         function delete4(){
             document.getElementById("image5").style.display = "none";
             document.getElementById("but4").style.display = "inline";
             document.getElementById("del3").style.display = "inline";
         }
         function params(){
             document.getElementById("paramsadd").style.display = "block";
             document.getElementById("delbutparams").style.display = "block";
             document.getElementById("butparams").style.display = "none";
         }
         function delparamsall(){
             document.getElementById("delbutparams").style.display = "none";
             document.getElementById("butparams").style.display = "block";
             document.getElementById("paramsadd").style.display = "none";
             document.getElementById("combo1add").style.display = "none";
             document.getElementById("combo1add").style.display = "none";
             document.getElementById("text1add").style.display = "none";
             document.getElementById("c1nam").value = "";
             document.getElementById("c1par1").value = "";
             document.getElementById("c1par2").value = "";
             document.getElementById("c1par3").value = "";
             document.getElementById("c1par4").value = "";
             document.getElementById("c1par5").value = "";
             document.getElementById("c1par6").value = "";
             document.getElementById("c1par7").value = "";
             document.getElementById("c1par8").value = "";
             document.getElementById("c1par9").value = "";
             document.getElementById("t1nam").value = "";
             document.getElementById("combo2add").style.display = "none";
             document.getElementById("c2nam").value = "";
             document.getElementById("c2par1").value = "";
             document.getElementById("c2par2").value = "";
             document.getElementById("c2par3").value = "";
             document.getElementById("c2par4").value = "";
             document.getElementById("c2par5").value = "";
             document.getElementById("c2par6").value = "";
             document.getElementById("c2par7").value = "";
             document.getElementById("c2par8").value = "";
             document.getElementById("c2par9").value = "";
             document.getElementById("dpar2").style.display = "none";
             document.getElementById("text2add").style.display = "none";
             document.getElementById("t2nam").value = "";
             document.getElementById("combo3add").style.display = "none";
             document.getElementById("c3nam").value = "";
             document.getElementById("c3par1").value = "";
             document.getElementById("c3par2").value = "";
             document.getElementById("c3par3").value = "";
             document.getElementById("c3par4").value = "";
             document.getElementById("c3par5").value = "";
             document.getElementById("c3par6").value = "";
             document.getElementById("c3par7").value = "";
             document.getElementById("c3par8").value = "";
             document.getElementById("c3par9").value = "";
             document.getElementById("dpar3").style.display = "none";
             document.getElementById("text3add").style.display = "none";
             document.getElementById("t3nam").value = "";
             document.getElementById("combo4add").style.display = "none";
             document.getElementById("c4nam").value = "";
             document.getElementById("c4par1").value = "";
             document.getElementById("c4par2").value = "";
             document.getElementById("c4par3").value = "";
             document.getElementById("c4par4").value = "";
             document.getElementById("c4par5").value = "";
             document.getElementById("c4par6").value = "";
             document.getElementById("c4par7").value = "";
             document.getElementById("c4par8").value = "";
             document.getElementById("c4par9").value = "";
             document.getElementById("dpar4").style.display = "none";
             document.getElementById("text4add").style.display = "none";
             document.getElementById("t4nam").value = "";
             
         }
         function text1(){
             document.getElementById("text1add").style.display = "block";
             document.getElementById("combo1add").style.display = "none";
             document.getElementById("c1nam").value = "";
             document.getElementById("c1par1").value = "";
             document.getElementById("c1par2").value = "";
             document.getElementById("c1par3").value = "";
             document.getElementById("c1par4").value = "";
             document.getElementById("c1par5").value = "";
             document.getElementById("c1par6").value = "";
             document.getElementById("c1par7").value = "";
             document.getElementById("c1par8").value = "";
             document.getElementById("c1par9").value = "";
             document.getElementById("dpar1").style.display = "block";
         }
         function combo1(){
             document.getElementById("text1add").style.display = "none";
             document.getElementById("combo1add").style.display = "block";
             document.getElementById("t1nam").value = "";
             document.getElementById("dpar1").style.display = "block";
         }
         function delparams1(){
             document.getElementById("combo1add").style.display = "none";
             document.getElementById("c1nam").value = "";
             document.getElementById("c1par1").value = "";
             document.getElementById("c1par2").value = "";
             document.getElementById("c1par3").value = "";
             document.getElementById("c1par4").value = "";
             document.getElementById("c1par5").value = "";
             document.getElementById("c1par6").value = "";
             document.getElementById("c1par7").value = "";
             document.getElementById("c1par8").value = "";
             document.getElementById("c1par9").value = "";
             document.getElementById("dpar1").style.display = "none";
             document.getElementById("text1add").style.display = "none";
             document.getElementById("t1nam").value = "";
         }
                    function combo1p2(){
                        document.getElementById("combo1param3").style.display = "block";
                        document.getElementById("butcombo1p2").style.display = "none";
                    }
                    function combo1p3(){
                        document.getElementById("butcombo1p3").style.display = "none";
                        document.getElementById("combo1param4").style.display = "block";
                        document.getElementById("butcombo1d3").style.display = "none";
                    }
                    function combo1d3(){
                        document.getElementById("butcombo1p2").style.display = "inline";
                        document.getElementById("combo1param3").style.display = "none";
                        document.getElementById("c1par3").value = "";
                    }
                    function combo1p4(){
                        document.getElementById("butcombo1p4").style.display = "none";
                        document.getElementById("combo1param5").style.display = "block";
                        document.getElementById("butcombo1d4").style.display = "none";
                    }
                    function combo1d4(){
                        document.getElementById("butcombo1p3").style.display = "inline";
                        document.getElementById("combo1param4").style.display = "none";
                        document.getElementById("butcombo1d3").style.display = "inline";
                        document.getElementById("c1par4").value = "";
                    }
                    function combo1p5(){
                        document.getElementById("butcombo1p5").style.display = "none";
                        document.getElementById("combo1param6").style.display = "block";
                        document.getElementById("butcombo1d5").style.display = "none";
                    }
                    function combo1d5(){
                        document.getElementById("butcombo1p4").style.display = "inline";
                        document.getElementById("combo1param5").style.display = "none";
                        document.getElementById("butcombo1d4").style.display = "inline";
                        document.getElementById("c1par5").value = "";
                    }
                    function combo1p6(){
                        document.getElementById("butcombo1p6").style.display = "none";
                        document.getElementById("combo1param7").style.display = "block";
                        document.getElementById("butcombo1d6").style.display = "none";
                    }
                    function combo1d6(){
                        document.getElementById("butcombo1p5").style.display = "inline";
                        document.getElementById("combo1param6").style.display = "none";
                        document.getElementById("butcombo1d5").style.display = "inline";
                        document.getElementById("c1par6").value = "";
                    }
                    function combo1p7(){
                        document.getElementById("butcombo1p7").style.display = "none";
                        document.getElementById("combo1param8").style.display = "block";
                        document.getElementById("butcombo1d7").style.display = "none";
                    }
                    function combo1d7(){
                        document.getElementById("butcombo1p6").style.display = "inline";
                        document.getElementById("combo1param7").style.display = "none";
                        document.getElementById("butcombo1d6").style.display = "inline";
                        document.getElementById("c1par7").value = "";
                    }
                    function combo1p8(){
                        document.getElementById("butcombo1p8").style.display = "none";
                        document.getElementById("combo1param9").style.display = "block";
                        document.getElementById("butcombo1d8").style.display = "none";
                    }
                    function combo1d8(){
                        document.getElementById("butcombo1p7").style.display = "inline";
                        document.getElementById("combo1param8").style.display = "none";
                        document.getElementById("butcombo1d7").style.display = "inline";
                        document.getElementById("c1par8").value = "";
                    }
                    function combo1d9(){
                        document.getElementById("butcombo1p8").style.display = "inline";
                        document.getElementById("combo1param9").style.display = "none";
                        document.getElementById("butcombo1d8").style.display = "inline";
                        document.getElementById("c1par9").value = "";
                    }
        
        function text2(){
             document.getElementById("text2add").style.display = "block";
             document.getElementById("combo2add").style.display = "none";
             document.getElementById("c2nam").value = "";
             document.getElementById("c2par1").value = "";
             document.getElementById("c2par2").value = "";
             document.getElementById("c2par3").value = "";
             document.getElementById("c2par4").value = "";
             document.getElementById("c2par5").value = "";
             document.getElementById("c2par6").value = "";
             document.getElementById("c2par7").value = "";
             document.getElementById("c2par8").value = "";
             document.getElementById("c2par9").value = "";
             document.getElementById("dpar2").style.display = "block";
         }
         function combo2(){
             document.getElementById("text2add").style.display = "none";
             document.getElementById("combo2add").style.display = "block";
             document.getElementById("t2nam").value = "";
             document.getElementById("dpar2").style.display = "block";
         }
         function delparams2(){
             document.getElementById("combo2add").style.display = "none";
             document.getElementById("c2nam").value = "";
             document.getElementById("c2par1").value = "";
             document.getElementById("c2par2").value = "";
             document.getElementById("c2par3").value = "";
             document.getElementById("c2par4").value = "";
             document.getElementById("c2par5").value = "";
             document.getElementById("c2par6").value = "";
             document.getElementById("c2par7").value = "";
             document.getElementById("c2par8").value = "";
             document.getElementById("c2par9").value = "";
             document.getElementById("dpar2").style.display = "none";
             document.getElementById("text2add").style.display = "none";
             document.getElementById("t2nam").value = "";
         }
                    function combo2p2(){
                        document.getElementById("combo2param3").style.display = "block";
                        document.getElementById("butcombo2p2").style.display = "none";
                    }
                    function combo2p3(){
                        document.getElementById("butcombo2p3").style.display = "none";
                        document.getElementById("combo2param4").style.display = "block";
                        document.getElementById("butcombo2d3").style.display = "none";
                    }
                    function combo2d3(){
                        document.getElementById("butcombo2p2").style.display = "inline";
                        document.getElementById("combo2param3").style.display = "none";
                        document.getElementById("c2par3").value = "";
                    }
                    function combo2p4(){
                        document.getElementById("butcombo2p4").style.display = "none";
                        document.getElementById("combo2param5").style.display = "block";
                        document.getElementById("butcombo2d4").style.display = "none";
                    }
                    function combo2d4(){
                        document.getElementById("butcombo2p3").style.display = "inline";
                        document.getElementById("combo2param4").style.display = "none";
                        document.getElementById("butcombo2d3").style.display = "inline";
                        document.getElementById("c2par4").value = "";
                    }
                    function combo2p5(){
                        document.getElementById("butcombo2p5").style.display = "none";
                        document.getElementById("combo2param6").style.display = "block";
                        document.getElementById("butcombo2d5").style.display = "none";
                    }
                    function combo2d5(){
                        document.getElementById("butcombo2p4").style.display = "inline";
                        document.getElementById("combo2param5").style.display = "none";
                        document.getElementById("butcombo2d4").style.display = "inline";
                        document.getElementById("c2par5").value = "";
                    }
                    function combo2p6(){
                        document.getElementById("butcombo2p6").style.display = "none";
                        document.getElementById("combo2param7").style.display = "block";
                        document.getElementById("butcombo2d6").style.display = "none";
                    }
                    function combo2d6(){
                        document.getElementById("butcombo2p5").style.display = "inline";
                        document.getElementById("combo2param6").style.display = "none";
                        document.getElementById("butcombo2d5").style.display = "inline";
                        document.getElementById("c2par6").value = "";
                    }
                    function combo2p7(){
                        document.getElementById("butcombo2p7").style.display = "none";
                        document.getElementById("combo2param8").style.display = "block";
                        document.getElementById("butcombo2d7").style.display = "none";
                    }
                    function combo2d7(){
                        document.getElementById("butcombo2p6").style.display = "inline";
                        document.getElementById("combo2param7").style.display = "none";
                        document.getElementById("butcombo2d6").style.display = "inline";
                        document.getElementById("c2par7").value = "";
                    }
                    function combo2p8(){
                        document.getElementById("butcombo2p8").style.display = "none";
                        document.getElementById("combo2param9").style.display = "block";
                        document.getElementById("butcombo2d8").style.display = "none";
                    }
                    function combo2d8(){
                        document.getElementById("butcombo2p7").style.display = "inline";
                        document.getElementById("combo2param8").style.display = "none";
                        document.getElementById("butcombo2d7").style.display = "inline";
                        document.getElementById("c2par8").value = "";
                    }
                    function combo2d9(){
                        document.getElementById("butcombo2p8").style.display = "inline";
                        document.getElementById("combo2param9").style.display = "none";
                        document.getElementById("butcombo2d8").style.display = "inline";
                        document.getElementById("c2par9").value = "";
                    }
                    
        function text3(){
             document.getElementById("text3add").style.display = "block";
             document.getElementById("combo3add").style.display = "none";
             document.getElementById("c3nam").value = "";
             document.getElementById("c3par1").value = "";
             document.getElementById("c3par2").value = "";
             document.getElementById("c3par3").value = "";
             document.getElementById("c3par4").value = "";
             document.getElementById("c3par5").value = "";
             document.getElementById("c3par6").value = "";
             document.getElementById("c3par7").value = "";
             document.getElementById("c3par8").value = "";
             document.getElementById("c3par9").value = "";
             document.getElementById("dpar3").style.display = "block";
         }
         function combo3(){
             document.getElementById("text3add").style.display = "none";
             document.getElementById("combo3add").style.display = "block";
             document.getElementById("t3nam").value = "";
             document.getElementById("dpar3").style.display = "block";
         }
         function delparams3(){
             document.getElementById("combo3add").style.display = "none";
             document.getElementById("c3nam").value = "";
             document.getElementById("c3par1").value = "";
             document.getElementById("c3par2").value = "";
             document.getElementById("c3par3").value = "";
             document.getElementById("c3par4").value = "";
             document.getElementById("c3par5").value = "";
             document.getElementById("c3par6").value = "";
             document.getElementById("c3par7").value = "";
             document.getElementById("c3par8").value = "";
             document.getElementById("c3par9").value = "";
             document.getElementById("dpar3").style.display = "none";
             document.getElementById("text3add").style.display = "none";
             document.getElementById("t3nam").value = "";
         }
                    function combo3p2(){
                        document.getElementById("combo3param3").style.display = "block";
                        document.getElementById("butcombo3p2").style.display = "none";
                    }
                    function combo3p3(){
                        document.getElementById("butcombo3p3").style.display = "none";
                        document.getElementById("combo3param4").style.display = "block";
                        document.getElementById("butcombo3d3").style.display = "none";
                    }
                    function combo3d3(){
                        document.getElementById("butcombo3p2").style.display = "inline";
                        document.getElementById("combo3param3").style.display = "none";
                        document.getElementById("c3par3").value = "";
                    }
                    function combo3p4(){
                        document.getElementById("butcombo3p4").style.display = "none";
                        document.getElementById("combo3param5").style.display = "block";
                        document.getElementById("butcombo3d4").style.display = "none";
                    }
                    function combo3d4(){
                        document.getElementById("butcombo3p3").style.display = "inline";
                        document.getElementById("combo3param4").style.display = "none";
                        document.getElementById("butcombo3d3").style.display = "inline";
                        document.getElementById("c3par4").value = "";
                    }
                    function combo3p5(){
                        document.getElementById("butcombo3p5").style.display = "none";
                        document.getElementById("combo3param6").style.display = "block";
                        document.getElementById("butcombo3d5").style.display = "none";
                    }
                    function combo3d5(){
                        document.getElementById("butcombo3p4").style.display = "inline";
                        document.getElementById("combo3param5").style.display = "none";
                        document.getElementById("butcombo3d4").style.display = "inline";
                        document.getElementById("c3par5").value = "";
                    }
                    function combo3p6(){
                        document.getElementById("butcombo3p6").style.display = "none";
                        document.getElementById("combo3param7").style.display = "block";
                        document.getElementById("butcombo3d6").style.display = "none";
                    }
                    function combo3d6(){
                        document.getElementById("butcombo3p5").style.display = "inline";
                        document.getElementById("combo3param6").style.display = "none";
                        document.getElementById("butcombo3d5").style.display = "inline";
                        document.getElementById("c3par6").value = "";
                    }
                    function combo3p7(){
                        document.getElementById("butcombo3p7").style.display = "none";
                        document.getElementById("combo3param8").style.display = "block";
                        document.getElementById("butcombo3d7").style.display = "none";
                    }
                    function combo3d7(){
                        document.getElementById("butcombo3p6").style.display = "inline";
                        document.getElementById("combo3param7").style.display = "none";
                        document.getElementById("butcombo3d6").style.display = "inline";
                        document.getElementById("c3par7").value = "";
                    }
                    function combo3p8(){
                        document.getElementById("butcombo3p8").style.display = "none";
                        document.getElementById("combo3param9").style.display = "block";
                        document.getElementById("butcombo3d8").style.display = "none";
                    }
                    function combo3d8(){
                        document.getElementById("butcombo3p7").style.display = "inline";
                        document.getElementById("combo3param8").style.display = "none";
                        document.getElementById("butcombo3d7").style.display = "inline";
                        document.getElementById("c3par8").value = "";
                    }
                    function combo3d9(){
                        document.getElementById("butcombo3p8").style.display = "inline";
                        document.getElementById("combo3param9").style.display = "none";
                        document.getElementById("butcombo3d8").style.display = "inline";
                        document.getElementById("c3par9").value = "";
                    }
                    
        function text4(){
             document.getElementById("text4add").style.display = "block";
             document.getElementById("combo4add").style.display = "none";
             document.getElementById("c4nam").value = "";
             document.getElementById("c4par1").value = "";
             document.getElementById("c4par2").value = "";
             document.getElementById("c4par3").value = "";
             document.getElementById("c4par4").value = "";
             document.getElementById("c4par5").value = "";
             document.getElementById("c4par6").value = "";
             document.getElementById("c4par7").value = "";
             document.getElementById("c4par8").value = "";
             document.getElementById("c4par9").value = "";
             document.getElementById("dpar4").style.display = "block";
         }
         function combo4(){
             document.getElementById("text4add").style.display = "none";
             document.getElementById("combo4add").style.display = "block";
             document.getElementById("t4nam").value = "";
             document.getElementById("dpar4").style.display = "block";
         }
         function delparams4(){
             document.getElementById("combo4add").style.display = "none";
             document.getElementById("c4nam").value = "";
             document.getElementById("c4par1").value = "";
             document.getElementById("c4par2").value = "";
             document.getElementById("c4par3").value = "";
             document.getElementById("c4par4").value = "";
             document.getElementById("c4par5").value = "";
             document.getElementById("c4par6").value = "";
             document.getElementById("c4par7").value = "";
             document.getElementById("c4par8").value = "";
             document.getElementById("c4par9").value = "";
             document.getElementById("dpar4").style.display = "none";
             document.getElementById("text4add").style.display = "none";
             document.getElementById("t4nam").value = "";
         }
                    function combo4p2(){
                        document.getElementById("combo4param3").style.display = "block";
                        document.getElementById("butcombo4p2").style.display = "none";
                    }
                    function combo4p3(){
                        document.getElementById("butcombo4p3").style.display = "none";
                        document.getElementById("combo4param4").style.display = "block";
                        document.getElementById("butcombo4d3").style.display = "none";
                    }
                    function combo4d3(){
                        document.getElementById("butcombo4p2").style.display = "inline";
                        document.getElementById("combo4param3").style.display = "none";
                        document.getElementById("c4par3").value = "";
                    }
                    function combo4p4(){
                        document.getElementById("butcombo4p4").style.display = "none";
                        document.getElementById("combo4param5").style.display = "block";
                        document.getElementById("butcombo4d4").style.display = "none";
                    }
                    function combo4d4(){
                        document.getElementById("butcombo4p3").style.display = "inline";
                        document.getElementById("combo4param4").style.display = "none";
                        document.getElementById("butcombo4d3").style.display = "inline";
                        document.getElementById("c4par4").value = "";
                    }
                    function combo4p5(){
                        document.getElementById("butcombo4p5").style.display = "none";
                        document.getElementById("combo4param6").style.display = "block";
                        document.getElementById("butcombo4d5").style.display = "none";
                    }
                    function combo4d5(){
                        document.getElementById("butcombo4p4").style.display = "inline";
                        document.getElementById("combo4param5").style.display = "none";
                        document.getElementById("butcombo4d4").style.display = "inline";
                        document.getElementById("c4par5").value = "";
                    }
                    function combo4p6(){
                        document.getElementById("butcombo4p6").style.display = "none";
                        document.getElementById("combo4param7").style.display = "block";
                        document.getElementById("butcombo4d6").style.display = "none";
                    }
                    function combo4d6(){
                        document.getElementById("butcombo4p5").style.display = "inline";
                        document.getElementById("combo4param6").style.display = "none";
                        document.getElementById("butcombo4d5").style.display = "inline";
                        document.getElementById("c4par6").value = "";
                    }
                    function combo4p7(){
                        document.getElementById("butcombo4p7").style.display = "none";
                        document.getElementById("combo4param8").style.display = "block";
                        document.getElementById("butcombo4d7").style.display = "none";
                    }
                    function combo4d7(){
                        document.getElementById("butcombo4p6").style.display = "inline";
                        document.getElementById("combo4param7").style.display = "none";
                        document.getElementById("butcombo4d6").style.display = "inline";
                        document.getElementById("c4par7").value = "";
                    }
                    function combo4p8(){
                        document.getElementById("butcombo4p8").style.display = "none";
                        document.getElementById("combo4param9").style.display = "block";
                        document.getElementById("butcombo4d8").style.display = "none";
                    }
                    function combo4d8(){
                        document.getElementById("butcombo4p7").style.display = "inline";
                        document.getElementById("combo4param8").style.display = "none";
                        document.getElementById("butcombo4d7").style.display = "inline";
                        document.getElementById("c4par8").value = "";
                    }
                    function combo4d9(){
                        document.getElementById("butcombo4p8").style.display = "inline";
                        document.getElementById("combo4param9").style.display = "none";
                        document.getElementById("butcombo4d8").style.display = "inline";
                        document.getElementById("c4par9").value = "";
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
                                <h2 class="bradcaump-title">Kate´s Handmade Insert Item System</h2>
                                <nav class="bradcaump-inner">
                                  <a class="breadcrumb-item" href="index.htm">Home</a>
                                  <span class="brd-separetor">/</span>
                                  <span class="breadcrumb-item active">ADD NEW ITEM</span>
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
                                    <li><a style="color:red" href="insert.htm">ADD NEW ITEM<span></span></a></li>
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
                    <div class="col-md-9 col-lg-9 col-sm-12 col-xs-12 smt-30">
                        <div class="row">
                            <div class="col-md-12">
                                <div style="margin-left: 100px" class="section__title section__title--2 center-block">
                                    <form id="upload" enctype="multipart/form-data" action="insert.htm"  method="post">
                                        <c:if test="${message!=null}">   
                                            <div class="alert alert-danger" role="alert">
                                                ${message} 
                                            </div>
                                        </c:if>
                                        <h2 style="font-weight: bold">ADD ITEM SYSTEM</h2>
                                        <br/>
                                        <label for="usr">Item Photo 1: </label>
                                        <input required style="width: 400px" type="file" class="form-control" id="usr" name="imagen1">
                                        <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="button1()" type="button" class="btn btn-dark" value="+" id="but1">
                                        <br/>
                                        <div style="display: none" id="image2">
                                            <label for="usr">Item Photo 2 (optional): </label>
                                            <input style="width: 400px" type="file" class="form-control" id="usr" name="imagen2">
                                            <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="button2()" type="button" class="btn btn-dark" value="+" id="but2">
                                            <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="delete1()" type="button" class="btn btn-dark" value="-" id="del1">
                                            <br/>
                                        </div>
                                        <div style="display: none" id="image3">
                                            <label for="usr">Item Photo 3 (optional): </label>
                                            <input style="width: 400px" type="file" class="form-control" id="usr" name="imagen3">
                                            <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="button3()" type="button" class="btn btn-dark" value="+" id="but3">
                                            <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="delete2()" type="button" class="btn btn-dark" value="-" id="del2">
                                            <br/>
                                        </div>
                                        <div style="display: none" id="image4">
                                            <label for="usr">Item Photo 4 (optional): </label>
                                            <input style="width: 400px" type="file" class="form-control" id="usr" name="imagen4">
                                            <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="button4()" type="button" class="btn btn-dark" value="+" id="but4">
                                            <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="delete3()" type="button" class="btn btn-dark" value="-" id="del3">
                                            <br/>
                                        </div>
                                        <div style="display: none" id="image5">
                                            <label for="usr">Item Photo 5 (optional): </label>
                                            <input style="width: 400px" type="file" class="form-control" id="usr" name="imagen5">
                                            <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="delete4()" type="button" class="btn btn-dark" value="-" id="del4">
                                        </div>
                                        <label style="margin-top: 20px" for="usr">Category: </label>
                                        <select required style="width: 400px" class="form-control" id="usr" name="idcat">
                                            <option value="" disabled selected>Select your option</option>
                                            <option value="1">ANIMAL KIDS FRAME</option>
                                            <option value="2">FRAMES WITH METRICS</option>
                                            <option value="3">EARRING HOLDERS</option>
                                            <option value="4">CLOCKS</option>
                                            <option value="5">CHRISTMAS GIFTS</option>
                                            <option value="6">SIGN AND PLAQUE</option>
                                            <option value="7">OTHER INTERESTING FRAMES</option>
                                            <option value="8">COOL THINGS</option>
                                        </select>
                                        <label style="margin-top: 20px" for="usr">Item Name: </label>
                                        <input style="font-weight: bold; width: 400px" required type="text" class="form-control" name="nombreart" id="usr">
                                        <label style="margin-top: 20px" for="usr">Item Price: </label>
                                        <input min="1" max="200" style="font-weight: bold; width: 400px" required type="number" class="form-control" name="priceart" id="usr">
                                        <label style="margin-top: 20px" for="usr">Item Description: </label>
                                        <textarea style="width: 400px" name="textart" required rows="4" class="form-control" cols="60"></textarea>
                                        <label style="margin-top: 20px" for="usr">Item Materials: </label>
                                        <input max="50" style="font-weight: bold; width: 400px" required type="text" class="form-control" name="matart" id="usr">
                                        <label style="margin-top: 20px" for="usr">Item Dimensions: </label>
                                        <input max="200" style="font-weight: bold; width: 400px" required type="text" class="form-control" name="dimart" id="usr">
                                        <input style="font-weight: bold; width: 400px; margin-top: 10px" onclick="params()" type="button" class="btn btn-dark" value="ADD ITEM PARAMETERS (OPTIONAL)" id="butparams">
                                        <input style="font-weight: bold; width: 400px; margin-top: 10px; display: none" onclick="delparamsall()" type="button" class="btn btn-dark" value="DELETE ALL ITEM PARAMETERS" id="delbutparams">
                                        <div style="display: none" id="paramsadd">
                                            <input style="font-weight: bold; width: 200px; margin-top: 10px" onclick="text1()" type="button" class="btn btn-dark" value="ADD TEXT 1 FIELD" id="butcombo1">
                                            <input style="font-weight: bold; width: 200px; margin-top: 10px" onclick="combo1()" type="button" class="btn btn-dark" value="ADD COMBO 1 FIELD" id="buttext1">
                                            <div style="display: none" id="text1add">
                                                <label style="margin-top: 20px" for="t1nam">Param 1 Name: </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="text1name" id="t1nam">
                                            </div>
                                            <div style="display: none" id="combo1add">
                                                <label style="margin-top: 20px" for="c1nam">Combo 1 Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1name" id="c1nam">
                                                <label style="margin-top: 20px" for="c1par1">Combo 1 First Option Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt1" id="c1par1">
                                                <label style="margin-top: 20px" for="c1par2">Combo 1 Second Option Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt2" id="c1par2">
                                                <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1p2()" type="button" class="btn btn-dark" value="+" id="butcombo1p2">
                                                <div style="display: none" id="combo1param3">
                                                    <label style="margin-top: 20px" for="c1par3">Combo 1 Third Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt3" id="c1par3">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1p3()" type="button" class="btn btn-dark" value="+" id="butcombo1p3">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1d3()" type="button" class="btn btn-dark" value="-" id="butcombo1d3">
                                                </div>
                                                <div style="display: none" id="combo1param4">
                                                    <label style="margin-top: 20px" for="c1par4">Combo 1 Fouth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt4" id="c1par4">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1p4()" type="button" class="btn btn-dark" value="+" id="butcombo1p4">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1d4()" type="button" class="btn btn-dark" value="-" id="butcombo1d4">
                                                </div>
                                                <div style="display: none" id="combo1param5">
                                                    <label style="margin-top: 20px" for="c1par5">Combo 1 Fifth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt5" id="c1par5">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1p5()" type="button" class="btn btn-dark" value="+" id="butcombo1p5">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1d5()" type="button" class="btn btn-dark" value="-" id="butcombo1d5">
                                                </div>
                                                <div style="display: none" id="combo1param6">
                                                    <label style="margin-top: 20px" for="c1par6">Combo 1 Sixth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt6" id="c1par6">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1p6()" type="button" class="btn btn-dark" value="+" id="butcombo1p6">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1d6()" type="button" class="btn btn-dark" value="-" id="butcombo1d6">
                                                </div>
                                                <div style="display: none" id="combo1param7">
                                                    <label style="margin-top: 20px" for="c1par7">Combo 1 Seventh Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt7" id="c1par7">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1p7()" type="button" class="btn btn-dark" value="+" id="butcombo1p7">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1d7()" type="button" class="btn btn-dark" value="-" id="butcombo1d7">
                                                </div>
                                                <div style="display: none" id="combo1param8">
                                                    <label style="margin-top: 20px" for="c1par8">Combo 1 Eighth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt8" id="c1par8">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1p8()" type="button" class="btn btn-dark" value="+" id="butcombo1p8">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1d8()" type="button" class="btn btn-dark" value="-" id="butcombo1d8">
                                                </div>
                                                <div style="display: none" id="combo1param9">
                                                    <label style="margin-top: 20px" for="c1par9">Combo 1 Ninth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo1opt9" id="c1par9">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo1d9()" type="button" class="btn btn-dark" value="-" id="butcombo1d9">
                                                </div>
                                            </div>
                                            <input style="font-weight: bold; width: 400px; margin-top: 10px; display: none" onclick="delparams1()" id="dpar1" type="button" class="btn btn-dark" value="DELETE ALL FIRST FIELD PARAMS">
                                            
                                            <div style="margin-top: 20px">
                                                <input style="font-weight: bold; width: 200px; margin-top: 10px; " onclick="text2()" type="button" class="btn btn-dark" value="ADD TEXT 2 FIELD" id="butcombo2">
                                                <input style="font-weight: bold; width: 200px; margin-top: 10px" onclick="combo2()" type="button" class="btn btn-dark" value="ADD COMBO 2 FIELD" id="buttext2">
                                            </div>
                                            <div style="display: none" id="text2add">
                                                <label style="margin-top: 20px" for="t2nam">Param 2 Name: </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="text2name" id="t2nam">
                                            </div>
                                            <div style="display: none" id="combo2add">
                                                <label style="margin-top: 20px" for="c2nam">Combo 2 Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2name" id="c2nam">
                                                <label style="margin-top: 20px" for="c2par1">Combo 2 First Option Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt1" id="c2par1">
                                                <label style="margin-top: 20px" for="c2par2">Combo 2 Second Option Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt2" id="c2par2">
                                                <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2p2()" type="button" class="btn btn-dark" value="+" id="butcombo2p2">
                                                <div style="display: none" id="combo2param3">
                                                    <label style="margin-top: 20px" for="c2par3">Combo 2 Third Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt3" id="c2par3">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2p3()" type="button" class="btn btn-dark" value="+" id="butcombo2p3">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2d3()" type="button" class="btn btn-dark" value="-" id="butcombo2d3">
                                                </div>
                                                <div style="display: none" id="combo2param4">
                                                    <label style="margin-top: 20px" for="c2par4">Combo 2 Fouth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt4" id="c2par4">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2p4()" type="button" class="btn btn-dark" value="+" id="butcombo2p4">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2d4()" type="button" class="btn btn-dark" value="-" id="butcombo2d4">
                                                </div>
                                                <div style="display: none" id="combo2param5">
                                                    <label style="margin-top: 20px" for="c2par5">Combo 2 Fifth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt5" id="c2par5">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2p5()" type="button" class="btn btn-dark" value="+" id="butcombo2p5">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2d5()" type="button" class="btn btn-dark" value="-" id="butcombo2d5">
                                                </div>
                                                <div style="display: none" id="combo2param6">
                                                    <label style="margin-top: 20px" for="c2par6">Combo 2 Sixth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt6" id="c2par6">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2p6()" type="button" class="btn btn-dark" value="+" id="butcombo2p6">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2d6()" type="button" class="btn btn-dark" value="-" id="butcombo2d6">
                                                </div>
                                                <div style="display: none" id="combo2param7">
                                                    <label style="margin-top: 20px" for="c2par7">Combo 2 Seventh Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt7" id="c2par7">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2p7()" type="button" class="btn btn-dark" value="+" id="butcombo2p7">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2d7()" type="button" class="btn btn-dark" value="-" id="butcombo2d7">
                                                </div>
                                                <div style="display: none" id="combo2param8">
                                                    <label style="margin-top: 20px" for="c2par8">Combo 2 Eighth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt8" id="c2par8">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2p8()" type="button" class="btn btn-dark" value="+" id="butcombo2p8">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2d8()" type="button" class="btn btn-dark" value="-" id="butcombo2d8">
                                                </div>
                                                <div style="display: none" id="combo2param9">
                                                    <label style="margin-top: 20px" for="c2par9">Combo 2 Ninth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo2opt9" id="c2par9">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo2d9()" type="button" class="btn btn-dark" value="-" id="butcombo2d9">
                                                </div>
                                            </div>
                                            <input style="font-weight: bold; width: 400px; margin-top: 10px; display: none" onclick="delparams2()" id="dpar2" type="button" class="btn btn-dark" value="DELETE ALL SECOND FIELD PARAMS">
                                            
                                            <div style="margin-top: 20px">
                                                <input style="font-weight: bold; width: 200px; margin-top: 10px; " onclick="text3()" type="button" class="btn btn-dark" value="ADD TEXT 3 FIELD" id="butcombo3">
                                                <input style="font-weight: bold; width: 200px; margin-top: 10px" onclick="combo3()" type="button" class="btn btn-dark" value="ADD COMBO 3 FIELD" id="buttext3">
                                            </div>
                                            <div style="display: none" id="text3add">
                                                <label style="margin-top: 20px" for="t3nam">Param 3 Name: </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="text3name" id="t3nam">
                                            </div>
                                            <div style="display: none" id="combo3add">
                                                <label style="margin-top: 20px" for="c3nam">Combo 3 Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3name" id="c3nam">
                                                <label style="margin-top: 20px" for="c3par1">Combo 3 First Option Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt1" id="c3par1">
                                                <label style="margin-top: 20px" for="c3par2">Combo 3 Second Option Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt2" id="c3par2">
                                                <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3p2()" type="button" class="btn btn-dark" value="+" id="butcombo3p2">
                                                <div style="display: none" id="combo3param3">
                                                    <label style="margin-top: 20px" for="c3par3">Combo 3 Third Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt3" id="c3par3">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3p3()" type="button" class="btn btn-dark" value="+" id="butcombo3p3">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3d3()" type="button" class="btn btn-dark" value="-" id="butcombo3d3">
                                                </div>
                                                <div style="display: none" id="combo3param4">
                                                    <label style="margin-top: 20px" for="c3par4">Combo 3 Fouth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt4" id="c3par4">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3p4()" type="button" class="btn btn-dark" value="+" id="butcombo3p4">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3d4()" type="button" class="btn btn-dark" value="-" id="butcombo3d4">
                                                </div>
                                                <div style="display: none" id="combo3param5">
                                                    <label style="margin-top: 20px" for="c3par5">Combo 3 Fifth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt5" id="c3par5">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3p5()" type="button" class="btn btn-dark" value="+" id="butcombo3p5">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3d5()" type="button" class="btn btn-dark" value="-" id="butcombo3d5">
                                                </div>
                                                <div style="display: none" id="combo3param6">
                                                    <label style="margin-top: 20px" for="c3par6">Combo 3 Sixth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt6" id="c3par6">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3p6()" type="button" class="btn btn-dark" value="+" id="butcombo3p6">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3d6()" type="button" class="btn btn-dark" value="-" id="butcombo3d6">
                                                </div>
                                                <div style="display: none" id="combo3param7">
                                                    <label style="margin-top: 20px" for="c3par7">Combo 3 Seventh Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt7" id="c3par7">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3p7()" type="button" class="btn btn-dark" value="+" id="butcombo3p7">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3d7()" type="button" class="btn btn-dark" value="-" id="butcombo3d7">
                                                </div>
                                                <div style="display: none" id="combo3param8">
                                                    <label style="margin-top: 20px" for="c3par8">Combo 3 Eighth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt8" id="c3par8">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3p8()" type="button" class="btn btn-dark" value="+" id="butcombo3p8">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3d8()" type="button" class="btn btn-dark" value="-" id="butcombo3d8">
                                                </div>
                                                <div style="display: none" id="combo3param9">
                                                    <label style="margin-top: 20px" for="c4par9">Combo 3 Ninth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo3opt9" id="c3par9">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo3d9()" type="button" class="btn btn-dark" value="-" id="butcombo3d9">
                                                </div>
                                            </div>
                                            <input style="font-weight: bold; width: 400px; margin-top: 10px; display: none" onclick="delparams3()" id="dpar3" type="button" class="btn btn-dark" value="DELETE ALL THIRD FIELD PARAMS">
                                            
                                            <div style="margin-top: 20px">
                                                <input style="font-weight: bold; width: 200px; margin-top: 10px; " onclick="text4()" type="button" class="btn btn-dark" value="ADD TEXT 4 FIELD" id="butcombo4">
                                                <input style="font-weight: bold; width: 200px; margin-top: 10px" onclick="combo4()" type="button" class="btn btn-dark" value="ADD COMBO 4 FIELD" id="buttext4">
                                            </div>
                                            <div style="display: none" id="text4add">
                                                <label style="margin-top: 20px" for="t4nam">Param 4 Name: </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="text4name" id="t4nam">
                                            </div>
                                            <div style="display: none" id="combo4add">
                                                <label style="margin-top: 20px" for="c4nam">Combo 4 Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4name" id="c4nam">
                                                <label style="margin-top: 20px" for="c4par1">Combo 4 First Option Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt1" id="c4par1">
                                                <label style="margin-top: 20px" for="c4par2">Combo 4 Second Option Name (required): </label>
                                                <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt2" id="c4par2">
                                                <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4p2()" type="button" class="btn btn-dark" value="+" id="butcombo4p2">
                                                <div style="display: none" id="combo4param3">
                                                    <label style="margin-top: 20px" for="c4par3">Combo 4 Third Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt3" id="c4par3">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4p3()" type="button" class="btn btn-dark" value="+" id="butcombo4p3">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4d3()" type="button" class="btn btn-dark" value="-" id="butcombo4d3">
                                                </div>
                                                <div style="display: none" id="combo4param4">
                                                    <label style="margin-top: 20px" for="c4par4">Combo 4 Fouth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt4" id="c4par4">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4p4()" type="button" class="btn btn-dark" value="+" id="butcombo4p4">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4d4()" type="button" class="btn btn-dark" value="-" id="butcombo4d4">
                                                </div>
                                                <div style="display: none" id="combo4param5">
                                                    <label style="margin-top: 20px" for="c4par5">Combo 4 Fifth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt5" id="c4par5">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4p5()" type="button" class="btn btn-dark" value="+" id="butcombo4p5">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4d5()" type="button" class="btn btn-dark" value="-" id="butcombo4d5">
                                                </div>
                                                <div style="display: none" id="combo4param6">
                                                    <label style="margin-top: 20px" for="c4par6">Combo 4 Sixth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt6" id="c4par6">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4p6()" type="button" class="btn btn-dark" value="+" id="butcombo4p6">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4d6()" type="button" class="btn btn-dark" value="-" id="butcombo4d6">
                                                </div>
                                                <div style="display: none" id="combo4param7">
                                                    <label style="margin-top: 20px" for="c4par7">Combo 4 Seventh Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt7" id="c4par7">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4p7()" type="button" class="btn btn-dark" value="+" id="butcombo4p7">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4d7()" type="button" class="btn btn-dark" value="-" id="butcombo4d7">
                                                </div>
                                                <div style="display: none" id="combo4param8">
                                                    <label style="margin-top: 20px" for="c4par8">Combo 4 Eighth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt8" id="c4par8">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4p8()" type="button" class="btn btn-dark" value="+" id="butcombo4p8">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4d8()" type="button" class="btn btn-dark" value="-" id="butcombo4d8">
                                                </div>
                                                <div style="display: none" id="combo4param9">
                                                    <label style="margin-top: 20px" for="c4par9">Combo 4 Ninth Option Name (optional): </label>
                                                    <input style="font-weight: bold; width: 350px" type="text" class="form-control" name="combo4opt9" id="c4par9">
                                                    <input style="font-weight: bold; width: 50px; margin-top: 10px" onclick="combo4d9()" type="button" class="btn btn-dark" value="-" id="butcombo4d9">
                                                </div>
                                            </div>
                                            <input style="font-weight: bold; width: 400px; margin-top: 10px; display: none" onclick="delparams4()" id="dpar4" type="button" class="btn btn-dark" value="DELETE ALL FOURTH FIELD PARAMS">
                                        </div>
                                        <div class="addtocart-btn">
                                            <a style="width: 400px; text-align: center" onclick="document.getElementById('subut').click()">Add New Item</a>
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



