<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .navbar-nav .dropdown-menu {
                min-width: 200px; /* Điều chỉnh chiều rộng nếu cần */
            }
            .dropdown-item {
                font-size: 14px; /* Kích thước font nhỏ hơn */
                padding: 5px 10px; /* Giảm khoảng đệm */
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
                <li class="scroll active"><a href="/carmarket/login">Home</a></li>
                <li class="scroll"><a href="#featured-cars">Model</a></li>
                <li class="scroll"><a href="#new-cars">New Post</a></li>
                <li class="scroll"><a href="#brand">Brands</a></li>
                <li class="scroll"><a href="#contact">Contact</a></li>
                    <c:choose>
                        <c:when test="${sessionScope.currentAcc == null}">
                        <li><a href="JSP/Login.jsp">Login</a></li>
                        </c:when>
                        <c:when test="${sessionScope.userType == 'client'}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Service <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="profile">Manage Account</a></li>
                                <li><a class="dropdown-item" href="viewCustomerFeedback">View Customer Feedback</a></li>
                                <li>
                                    <a class="dropdown-item" href="managePostClient">
                                        Manage Post
                                    </a>
                                </li>
                                <li><a class="dropdown-item" href="createPost">Create Post</a></li>
                            </ul>
                        </li>
                        <li><a href="logout">Logout</a></li>
                        </c:when>
                        <c:when test="${sessionScope.currentAcc != null}">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Manage Service <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <c:if test="${sessionScope.currentAcc.role == 1 || sessionScope.currentAcc.role == 2}">
                                    <li><a class="dropdown-item" href="managecustomerprofile">Manage Customer Account</a></li>
                                    </c:if>
                                <li><a class="dropdown-item" href="viewCustomerFeedback">View Customer Feedback</a></li>
                                <c:if test="${sessionScope.currentAcc.role == 1 || sessionScope.currentAcc.role == 3}">
                                <li>
                                    <a class="dropdown-item" href="managePost">
                                        Manage Post
                                        <c:if test="${applicationScope.newPostCount > 0}">
                                            <span class="notification">${applicationScope.newPostCount}</span>
                                        </c:if>
                                    </a>
                                </li>
                                </c:if>
                                <c:if test="${sessionScope.currentAcc.role == 1}">
                                    <li><a class="dropdown-item" href="manageProvider">Manage Provider Account</a></li>
                                    </c:if>
                            </ul>
                        </li>
                        <li><a href="logout">Logout</a></li>
                        </c:when>
                    </c:choose>
            </ul>
        </div>
    </body>
</html>
