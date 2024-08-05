<!doctype html>
<html class="no-js" lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <head>
        <!-- meta data -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!--font-family-->
        <link href="https://fonts.googleapis.com/css?family=Poppins:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <link href="https://fonts.googleapis.com/css?family=Rufina:400,700" rel="stylesheet">

        <!-- title of site -->
        <title>CarVilla</title>

        <!-- For favicon png -->
        <link rel="shortcut icon" type="image/icon" href="assets/logo/favicon.png"/>

        <!--font-awesome.min.css-->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">

        <!--linear icon css-->
        <link rel="stylesheet" href="assets/css/linearicons.css">

        <!--flaticon.css-->
        <link rel="stylesheet" href="assets/css/flaticon.css">

        <!--animate.css-->
        <link rel="stylesheet" href="assets/css/animate.css">

        <!--owl.carousel.css-->
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">

        <!--bootstrap.min.css-->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">

        <!-- bootsnav -->
        <link rel="stylesheet" href="assets/css/bootsnav.css" >	

        <!--style.css-->
        <link rel="stylesheet" href="assets/css/style.css">

        <!--responsive.css-->
        <link rel="stylesheet" href="assets/css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->

        <!--[if lt IE 9]>
                        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            .brand {
                position: relative;
            }

            .see-more-wrapper {
                position: absolute;
                top: 0;
                right: -250px;
                margin-top: 20px;

            }

            .see-more-wrapper .item a {
                background-color: #007bff;
                color: white;
                padding: 10px 20px;
                border-radius: 5px;
                text-decoration: none;
            }

            .see-more-wrapper .item a:hover {
                background-color: #0056b3;
            }

            .see-more-container {
                position: absolute;
                left: 0;
                bottom: 20px;
                margin-left: 15px;
            }

            .see-more-btn {
                background-color: #007bff;
                color: white;
                border: none;
                padding: 10px 20px;
                font-size: 16px;
                cursor: pointer;
                border-radius: 5px;
            }

            .see-more-btn:hover {
                background-color: #0056b3;
            }

        </style>
    </head>

    <body>
        <!--[if lte IE 9]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
<![endif]-->

        <!--welcome-hero start -->
        <section id="home" class="welcome-hero">

            <!-- top-area Start -->
            <div class="top-area">
                <div class="header-area">
                    <!-- Start Navigation -->
                    <nav class="navbar navbar-default bootsnav  navbar-sticky navbar-scrollspy"  data-minus-value-desktop="70" data-minus-value-mobile="55" data-speed="1000">

                        <div class="container">

                            <!-- Start Header Navigation -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-menu">
                                    <i class="fa fa-bars"></i>
                                </button>
                                <a class="navbar-brand" href="login">carmarket<span></span></a>

                            </div><!--/.navbar-header-->
                            <%@include file="./header.jsp" %>
                            <!-- End Header Navigation -->

                            <!-- Collect the nav links, forms, and other content for toggling -->

                        </div><!--/.container-->
                    </nav><!--/nav-->
                    <!-- End Navigation -->
                </div><!--/.header-area-->
                <div class="clearfix"></div>

            </div><!-- /.top-area-->
            <!-- top-area End -->

            <div class="container">
                <div class="welcome-hero-txt">
                    <h2>get your desired car in resonable price</h2>
                    <button class="welcome-btn" onclick="window.location.href = '#contact'">contact us</button>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <form action="/carmarket/search" method="post">
                            <div class="model-search-content">
                                <div class="row">
                                    <div class="col-md-offset-1 col-md-2 col-sm-12">
                                        <div class="single-model-search">
                                            <h2>select year</h2>
                                            <div class="model-select-icon">
                                                <select name="year" class="form-control">
                                                    <option value="" disabled selected>Select Year</option>
                                                    <% 
                                                        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                                                        for (int year = currentYear; year >= 1900; year--) {
                                                            out.print("<option value=\"" + year + "\">" + year + "</option>");
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="single-model-search">
                                            <h2>car type</h2>
                                            <div class="model-select-icon">
                                                <select name="type" class="form-control">
                                                    <option value="" disabled selected>Select Engine</option>
                                                    <c:if test="${not empty requestScope.listEngine}">
                                                        <c:forEach var="c" items="${requestScope.listEngine}">
                                                            <option value="${c.engineID}">${c.engineName}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-offset-1 col-md-2 col-sm-12">
                                        <div class="single-model-search">
                                            <h2>select color</h2>
                                            <div class="model-select-icon">
                                                <select name="color" class="form-control">
                                                    <option value="" disabled selected>Select Color</option>
                                                    <c:if test="${not empty requestScope.listColor}">
                                                        <c:forEach var="c" items="${requestScope.listColor}">
                                                            <option value="${c.exteriorColorID}">${c.exteriorColorName}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="single-model-search">
                                            <h2>car gearbox</h2>
                                            <div class="model-select-icon">
                                                <select name="gearbox" class="form-control">
                                                    <option value="" disabled selected>Select Gearbox</option>
                                                    <c:if test="${not empty requestScope.listGearbox}">
                                                        <c:forEach var="c" items="${requestScope.listGearbox}">
                                                            <option value="${c.gearboxID}">${c.gearboxName}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-offset-1 col-md-2 col-sm-12">
                                        <div class="single-model-search">
                                            <h2>select origin</h2>
                                            <div class="model-select-icon">
                                                <select name="origin" class="form-control">
                                                    <option value="" disabled selected>Select origin</option>
                                                    <c:if test="${not empty requestScope.listOrigin}">
                                                        <c:forEach var="c" items="${requestScope.listOrigin}">
                                                            <option value="${c.originID}">${c.originName}</option>
                                                        </c:forEach>
                                                    </c:if>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="single-model-search">
                                            <h2>select price</h2>
                                            <div class="model-select-icon">
                                                <select name="price" class="form-control">
                                                    <option value="default">price</option>
                                                    <option value="500000000-1000000000">500.000.000 - 1.000.000.000</option>
                                                    <option value="1000000000-2000000000">1.000.000.000 - 2.000.000.000</option>
                                                    <option value="2000000000-10000000000">>2.000.000.000</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2 col-sm-12">
                                        <div class="single-model-search text-center">
                                            <button type="submit" class="welcome-btn model-search-btn">search</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>



        </section><!--/.welcome-hero-->
        <!--welcome-hero end -->

        <!--service start -->
        
        <!--service end-->

        <!--new-cars start -->
        <section id="new-cars" class="new-cars">
            <div class="container">
                <div class="section-header">
                    <p>checkout <span>the</span> latest posts</p>
                    <h2>newest posts</h2>
                </div><!--/.section-header-->
                <div class="new-cars-content">
                    <div class="owl-carousel owl-theme" id="new-cars-carousel">
                        <c:forEach var="post" items="${posts}">
                            <c:if test="${post.status}">
                                <div class="new-cars-item">
                                    <div class="single-new-cars-item">
                                        <div class="row">
                                            <div class="col-md-7 col-sm-12">
                                                <div class="new-cars-img">
                                                    <img src="${post.images[0].postImg}" alt="img"/>
                                                </div><!--/.new-cars-img-->
                                            </div>
                                            <div class="col-md-5 col-sm-12">
                                                <div class="new-cars-txt">
                                                    <h2><a href="detailPostForClient?postId=${post.postId}">${post.carName}</a></h2>
                                                    <p>
                                                        ${post.descriptions}
                                                    </p>
                                                    <p class="new-cars-para2">
                                                        <span><fmt:formatNumber value="${post.priceCar}" pattern="#,##0"/> VND</span> 
                                                    </p>
                                                </div><!--/.new-cars-txt-->	
                                            </div><!--/.col-->
                                        </div><!--/.row-->
                                    </div><!--/.single-new-cars-item-->
                                </div><!--/.new-cars-item-->
                            </c:if>
                        </c:forEach>
                    </div><!--/#new-cars-carousel-->
                </div><!--/.new-cars-content-->
            </div><!--/.container-->

        </section><!--/.new-cars-->
        <!--new-cars end -->

        <!--featured-cars start -->
        <section id="featured-cars" class="featured-cars">
            <div class="container">
                <div class="section-header">
                    <p>checkout <span>the</span> model</p>
                    <h2>MODEL</h2>
                    <h3><a href="showModel">See More</a></h3>
                </div><!--/.section-header-->
                <div class="featured-cars-content">
                    <div class="row">
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-featured-cars">
                                <div class="featured-img-box">
                                    <div class="featured-cars-img">
                                        <img src="assets/images/featured-cars/Wagon.png" alt="cars">
                                    </div>
                                </div>
                                <div class="featured-cars-txt">
                                    <h2><a href="#">Wagon</a></h2>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-featured-cars">
                                <div class="featured-img-box">
                                    <div class="featured-cars-img">
                                        <img src="assets/images/featured-cars/fc2.png" alt="cars">
                                    </div>
                                </div>
                                <div class="featured-cars-txt">
                                    <h2><a href="#">Convertible</a></h2>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-featured-cars">
                                <div class="featured-img-box">
                                    <div class="featured-cars-img">
                                        <img src="assets/images/featured-cars/fc3.png" alt="cars">
                                    </div>
                                </div>
                                <div class="featured-cars-txt">
                                    <h2><a href="#">Coupe</a></h2>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-4 col-sm-6">
                            <div class="single-featured-cars">
                                <div class="featured-img-box">
                                    <div class="featured-cars-img">
                                        <img src="assets/images/featured-cars/fc4.png" alt="cars">
                                    </div>
                                </div>
                                <div class="featured-cars-txt">
                                    <h2><a href="#"> Sedan</a></h2>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--featured-cars end -->

        <!-- clients-say strat -->
        <section id="clients-say"  class="clients-say">
            <div class="container">
                <div class="section-header">
                    <h2>Post</h2>
                </div><!--/.section-header-->
                <div class="row">
                    <div class="owl-carousel testimonial-carousel">
                        <c:forEach var="AllPost" items="${AllPost}"> 
                            <c:if test="${AllPost.status}">
                                <div class="col-sm-3 col-xs-12">
                                    <div class="single-testimonial-box">
                                        <div class="testimonial-description">
                                            <div class="testimonial-info">
                                                <div class="testimonial-img">
                                                    <img src="${AllPost.images[0].postImg}" alt="image of clients person" />
                                                </div><!--/.testimonial-img-->
                                            </div><!--/.testimonial-info-->

                                            <div class="testimonial-person">
                                                <h2><a href="detailPostForClient?postId=${AllPost.postId}">${AllPost.carName}</a></h2>
                                                
                                                <h4><span><fmt:formatNumber value="${AllPost.priceCar}" pattern="#,##0"/> VND</span></h4>
                                            </div><!--/.testimonial-person-->
                                        </div><!--/.testimonial-description-->
                                    </div><!--/.single-testimonial-box-->
                                </div><!--/.col-->
                            </c:if>
                        </c:forEach>   
                    </div><!--/.testimonial-carousel-->
                </div><!--/.row-->
            </div><!--/.container-->
            <div class="text-center">
                <a href="AllCar" class="btn btn-primary">See more</a>
            </div>
        </section><!--/.clients-say-->	
        <!-- clients-say end -->

        <!--brand strat -->
        <section id="brand" class="brand">
            <div class="container">
                <div class="brand-area">
                    <div class="owl-carousel owl-theme brand-item">

                        <div class="item">
                            <a href="#">
                                <img src="assets/images/brand/br1.png" alt="brand-image" />
                            </a>
                        </div><!--/.item-->
                        <div class="item">
                            <a href="#">
                                <img src="assets/images/brand/mercedes.png" alt="brand-image" />
                            </a>
                        </div><!--/.item-->
                        <div class="item">
                            <a href="#">
                                <img src="assets/images/brand/Lambogini.png" alt="brand-image" />
                            </a>
                        </div><!--/.item-->
                        <div class="item">
                            <a href="#">
                                <img src="assets/images/brand/Kia.png" alt="brand-image" />
                            </a>
                        </div><!--/.item-->
                        <div class="item">
                            <a href="#">
                                <img src="assets/images/brand/mazda.png" alt="brand-image" />
                            </a>
                        </div><!--/.item-->
                        <div class="item">
                            <a href="#">
                                <img src="assets/images/brand/br6.png" alt="brand-image" />
                            </a>
                        </div><!--/.item-->
                        <div class="item">
                            <a href="#">
                                <img src="assets/images/brand/br7.png" alt="brand-image" />
                            </a>
                        </div><!--/.item-->
                    </div><!--/.owl-carousel-->


                    <div class="see-more-wrapper">
                        <div class="item">
                            <a href="showBrand">See More</a>
                        </div>
                    </div>
                </div><!--/.brand-area-->
            </div><!--/.container-->
        </section>
        <!--brand end -->

        <!--blog start -->
        <section id="blog" class="blog"></section><!--/.blog-->
        <!--blog end -->

        <!--contact start-->
        <footer id="contact"  class="contact">
            <div class="container">
                <div class="footer-top">
                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="single-footer-widget">
                                <div class="footer-logo">
                                    <a href="index.html">carmarket</a>
                                </div>
                                <p>
                                    CarMarket is an innovative online platform that connects car sellers and buyers, offering a comprehensive marketplace for purchasing, selling, and promoting vehicles with ease and security.
                                </p>
                                <div class="footer-contact">
                                    <p>tuanduy043203@gmail.com</p>
                                    <p>+(84)383534096</p>
                                </div>
                            </div>
                        </div>
                            <div class="col-md-2 col-sm-6">
                                <div class="single-footer-widget">
                                    <h2>about market</h2>
                                    <ul>
                                        <li><a href="addFeedback">about us</a></li>
                                    </ul>
                                </div>
                            </div>
                        
                        <div class="col-md-3 col-xs-12">
                            <div class="single-footer-widget">
                                <h2>top brands</h2>
                                <div class="row">
                                    <div class="col-md-7 col-xs-6">
                                        <ul>
                                            <li><a href="#">BMW</a></li>
                                            <li><a href="#">lamborghini</a></li>
                                            <li><a href="#">camaro</a></li>
                                            <li><a href="#">audi</a></li>
                                            <li><a href="#">infiniti</a></li>
                                            <li><a href="#">nissan</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-md-5 col-xs-6">
                                        <ul>
                                            <li><a href="#">ferrari</a></li>
                                            <li><a href="#">porsche</a></li>
                                            <li><a href="#">land rover</a></li>
                                            <li><a href="#">aston martin</a></li>
                                            <li><a href="#">mersedes</a></li>
                                            <li><a href="#">opel</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-offset-1 col-md-3 col-sm-6">
                            <div class="single-footer-widget">
                                <h2>news letter</h2>
                                <div class="footer-newsletter">
                                    <p>
                                        Subscribe to get latest news  update and informations
                                    </p>
                                </div>
                                <div class="hm-foot-email">
                                    <div class="foot-email-box">
                                        <input type="text" class="form-control" placeholder="Add Email">
                                    </div><!--/.foot-email-box-->
                                    <div class="foot-email-subscribe">
                                        <span><i class="fa fa-arrow-right"></i></span>
                                    </div><!--/.foot-email-icon-->
                                </div><!--/.hm-foot-email-->
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-copyright">
                    <div class="row">
                        <div class="col-sm-6">
                            <p>
                                &copy; copyright.designed and developed by <a href="https://www.themesine.com/">themesine</a>.
                            </p><!--/p-->
                        </div>
                        <div class="col-sm-6">
                            <div class="footer-social">
                                <a href="#"><i class="fa fa-facebook"></i></a>	
                                <a href="#"><i class="fa fa-instagram"></i></a>
                                <a href="#"><i class="fa fa-linkedin"></i></a>
                                <a href="#"><i class="fa fa-pinterest-p"></i></a>
                                <a href="#"><i class="fa fa-behance"></i></a>	
                            </div>
                        </div>
                    </div>
                </div><!--/.footer-copyright-->
            </div><!--/.container-->

            <div id="scroll-Top">
                <div class="return-to-top">
                    <i class="fa fa-angle-up " id="scroll-top" data-toggle="tooltip" data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
                </div>

            </div><!--/.scroll-Top-->

        </footer><!--/.contact-->
        <!--contact end-->



        <!-- Include all js compiled plugins (below), or include individual files as needed -->

        <script src="assets/js/jquery.js"></script>

        <!--modernizr.min.js-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>

        <!--bootstrap.min.js-->
        <script src="assets/js/bootstrap.min.js"></script>

        <!-- bootsnav js -->
        <script src="assets/js/bootsnav.js"></script>

        <!--owl.carousel.js-->
        <script src="assets/js/owl.carousel.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>

        <!--Custom JS-->
        <script src="assets/js/custom.js"></script>

    </body>

</html>