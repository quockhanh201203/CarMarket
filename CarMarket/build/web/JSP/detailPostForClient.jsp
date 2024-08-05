<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>eCommerce Product Detail</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
        <style>
            body {
                font-family: 'open sans';
                overflow-x: hidden;
            }
            img {
                max-width: 100%;
            }
            .preview {
                display: flex;
                flex-direction: column;
            }
            @media screen and (max-width: 996px) {
                .preview {
                    margin-bottom: 20px;
                }
            }
            .preview-pic {
                flex-grow: 1;
            }
            .preview-thumbnail.nav-tabs {
                border: none;
                margin-top: 15px;
            }
            .preview-thumbnail.nav-tabs li {
                width: 18%;
                margin-right: 2.5%;
            }
            .preview-thumbnail.nav-tabs li img {
                max-width: 100%;
                display: block;
            }
            .preview-thumbnail.nav-tabs li a {
                padding: 0;
                margin: 0;
            }
            .preview-thumbnail.nav-tabs li:last-of-type {
                margin-right: 0;
            }
            .tab-content {
                overflow: hidden;
            }
            .tab-content img {
                width: 100%;
                animation-name: opacity;
                animation-duration: .3s;
            }
            .card {
                margin-top: 50px;
                background: #eee;
                padding: 3em;
                line-height: 1.5em;
            }
            @media screen and (min-width: 997px) {
                .wrapper {
                    display: flex;
                }
            }
            .details {
                display: flex;
                flex-direction: column;
            }
            .colors {
                flex-grow: 1;
            }
            .product-title, .price, .sizes, .colors {
                text-transform: UPPERCASE;
                font-weight: bold;
            }
            .checked, .price span {
                color: #ff9f1a;
            }
            .product-title, .rating, .product-description, .price, .vote, .sizes {
                margin-bottom: 15px;
            }
            .product-title {
                margin-top: 0;
            }
            .size {
                margin-right: 10px;
            }
            .size:first-of-type {
                margin-left: 40px;
            }
            .color {
                display: inline-block;
                vertical-align: middle;
                margin-right: 10px;
                height: 2em;
                width: 2em;
                border-radius: 2px;
            }
            .color:first-of-type {
                margin-left: 20px;
            }
            .add-to-cart, .like {
                background: #ff9f1a;
                padding: 1.2em 1.5em;
                border: none;
                text-transform: UPPERCASE;
                font-weight: bold;
                color: #fff;
                transition: background .3s ease;
            }
            .add-to-cart:hover, .like:hover {
                background: #b36800;
                color: #fff;
            }
            .not-available {
                text-align: center;
                line-height: 2em;
            }
            .not-available:before {
                font-family: fontawesome;
                content: "\f00d";
                color: #fff;
            }
            .orange {
                background: #ff9f1a;
            }
            .green {
                background: #85ad00;
            }
            .blue {
                background: #0076ad;
            }
            .tooltip-inner {
                padding: 1.3em;
            }
            @keyframes opacity {
                0% {
                    opacity: 0;
                    transform: scale(3);
                }
                100% {
                    opacity: 1;
                    transform: scale(1);
                }
            }
            .navbar-nav .dropdown-menu {
                min-width: 200px;
            }
            .dropdown-item {
                font-size: 14px;
                padding: 5px 10px;
            }
            .notification {
                background-color: red;
                color: white;
                border-radius: 50%;
                padding: 2px 6px;
                font-size: 12px;
                position: relative;
                top: -10px;
                right: 10px;
            }
        </style>
    </head>
    <body>
        <div class="collapse navbar-collapse menu-ui-design" id="navbar-menu">
            <ul class="nav navbar-nav navbar-right" data-in="fadeInDown" data-out="fadeOutUp">
                <c:choose>
                    <c:when test="${sessionScope.userType == 'client'}">
                        <li class="scroll active"><a href="/carmarket/login">Home</a></li>
                        </c:when>
                        <c:when test="${sessionScope.currentAcc != null}">
                        <li class="scroll active"><a href="/carmarket/home">Home</a></li>
                    </c:when>
                </c:choose>
                
                    <c:choose>
                        <c:when test="${sessionScope.currentAcc == null}">
                        <li><a href="JSP/Login.jsp">Login</a></li>
                        </c:when>
                        <c:when test="${sessionScope.userType == 'client'}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Service <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="profile">Manage Account</a></li>
                                <li><a class="dropdown-item" href="managePostClient">Manage Post</a></li>
                                <li><a class="dropdown-item" href="manageCar">Manage Car</a></li>
                                <li><a class="dropdown-item" href="createPost">Create Post</a></li>
                            </ul>
                        </li>
                        <li><a href="logout">Logout</a></li>
                        </c:when>
                        <c:when test="${sessionScope.currentAcc != null}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Service <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="managecustomerprofile">Manage Customer Account</a></li>
                                <li>
                                    <a class="dropdown-item" href="managePost">Manage Post
                                        <c:if test="${applicationScope.newPostCount > 0}">
                                            <span class="notification">${applicationScope.newPostCount}</span>
                                        </c:if>
                                    </a>
                                </li>
                                <li><a class="dropdown-item" href="manageCar">Manage Car</a></li>
                            </ul>
                        </li>
                        <li><a href="logout">Logout</a></li>
                        </c:when>
                    </c:choose>
            </ul>
        </div>

        <div class="container">
            <div class="card">
                <div class="container-fliud">
                    <div class="wrapper row">
                        <div class="preview col-md-6">
                            <div class="preview-pic tab-content">
                                <div class="tab-pane active" id="pic-1"><img src="${image[0].postImg}" /></div>
                            </div>
                            <ul class="preview-thumbnail nav nav-tabs">
                                <c:forEach var="image" items="${image}">
                                    <li><a data-target="#pic-1" data-toggle="tab"><img src="${image.postImg}" /></a></li>
                                        </c:forEach>
                            </ul>
                        </div>
                        <div class="details col-md-6">
                            <h3 class="product-title">${post.carName}</h3>
                            <div class="rating">
                                <div class="stars">
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star checked"></span>
                                    <span class="fa fa-star"></span>
                                    <span class="fa fa-star"></span>
                                </div>
                                <span class="review-no" >This post was posted by<a href="viewProfileByClient?clientId=${client.clientId}" >${client.firstName} ${client.lastName}</a></span>
                            </div>
                            <p class="product-description">${post.descriptions}</p>
                            <h4 class="price">price: <span><fmt:formatNumber value="${post.priceCar}" pattern="#,##0"/> VND</span></h4>
                            <h5 class="colors">Brand: <span class="size" data-toggle="tooltip" title="small">${br.brandName}</span></h5>
                            <h5 class="colors">Model: <span class="size" data-toggle="tooltip" title="small">${md.modelName}</span></h5>
                            <h5 class="colors">Number Of Seats: <span class="size" data-toggle="tooltip" title="small">${seats.numberOfSeatsName}</span></h5>
                            <h5 class="colors">Number Of Doors: <span class="size" data-toggle="tooltip" title="small">${doors.numberOfDoorsName}</span></h5>
                            <h5 class="colors">Interior Color: <span class="size" data-toggle="tooltip" title="small">${inColor.interiorColorName}</span></h5>
                            <h5 class="colors">Exterior Color: <span class="size" data-toggle="tooltip" title="small">${exColor.exteriorColorName}</span></h5>
                            <h5 class="colors">Gearbox: <span class="size" data-toggle="tooltip" title="small">${gb.gearboxName}</span></h5>
                            <h5 class="colors">Engine: <span class="size" data-toggle="tooltip" title="small">${eg.engineName}</span></h5>
                            <div class="action">
                                <button class="like btn btn-default" type="button"><span class="fa fa-heart"></span></button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
