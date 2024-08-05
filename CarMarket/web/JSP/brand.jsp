<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html class="no-js" lang="en">

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
        <link rel="shortcut icon" type="image/icon" href="assets/logo/favicon.png" />

        <!-- CSS Stylesheets -->
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/linearicons.css">
        <link rel="stylesheet" href="assets/css/flaticon.css">
        <link rel="stylesheet" href="assets/css/animate.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/bootsnav.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
            <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
        <style>
            /* Custom CSS for rearranging brands */
            .featured-cars-content {
                margin-bottom: 30px;
            }

            .featured-cars-content .single-featured-cars {
                text-align: center;
            }

            .featured-cars-content .single-featured-cars .featured-img-box {
                margin-bottom: 15px;
            }

            .featured-cars-content .single-featured-cars .featured-cars-txt h2 {
                margin-top: 0;
                font-size: 18px;
            }

            #create-brand-btn {
                position: fixed;
                top: 150px;
                right: 20px;
            </style>
        </head>

        <body>
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
                                <a class="navbar-brand" href="home.jsp">carvilla<span></span></a>

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

            <!--[if lte IE 9]>
                <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
            <![endif]-->
            <c:if test="${sessionScope.currentAcc != null && sessionScope.userType != 'client' && sessionScope.currentAcc.role == 1}">
                <div id="create-brand-btn">
                    <a href="JSP/insertBrand.jsp" class="btn btn-primary">Create Brand</a>
                </div>
            </c:if>


            <!-- Featured cars section -->
            <section id="featured-cars" class="featured-cars">
                <div class="container">
                    <div class="section-header">
                        <h2>CAR BRAND</h2>
                    </div><!--/.section-header-->
                    <c:if test="${not empty requestScope.listBrand}">
                        <div class="row">
                            <c:forEach var="c" items="${requestScope.listBrand}">
                                <div class="col-lg-3 col-md-4 col-sm-6">
                                    <div class="featured-cars-content">
                                        <div class="single-featured-cars">
                                            <div class="featured-img-box">
                                                <div class="featured-cars-img">
                                                    <img src="${c.brandImg}" alt="cars">
                                                </div>
                                            </div>
                                            <div class="featured-cars-txt">
                                                <h2><a href="choosePostByBrand?brandID=${c.brandId}">${c.brandName}</a></h2>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </c:if>
                </div><!--/.container-->
            </section><!--/.featured-cars-->

            <!-- Blog section -->
            <section id="blog" class="blog"></section><!--/.blog-->

            <!-- Contact section -->
            <footer id="contact" class="contact">
                <div class="container">
                    <!-- Footer content -->
                </div><!--/.container-->
            </footer><!--/.contact-->

            <!-- Include all js compiled plugins -->
            <script src="assets/js/jquery.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
            <script src="assets/js/bootstrap.min.js"></script>
            <script src="assets/js/bootsnav.js"></script>
            <script src="assets/js/owl.carousel.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js"></script>
            <script src="assets/js/custom.js"></script>
        </body>

    </html>
