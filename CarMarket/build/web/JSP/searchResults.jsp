<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Search Results</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            margin-top: 50px;
            border-radius: 8px;
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:hover {
            background-color: #f9f9f9;
        }
        .no-results {
            text-align: center;
            color: #666;
            margin-top: 20px;
        }
        .image {
            max-width: 100px;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Search Results</h1>
        <c:if test="${not empty posts}">
            <table>
                <tr>
                    <th>Image</th>
                    <th>Car Name</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
                <c:forEach var="post" items="${posts}">
                    <c:if test="${post.status}">
                        <tr>
                            <td>
                                <c:choose>
                                    <c:when test="${not empty post.images}">
                                        <img src="${post.images[0].postImg}" alt="Car Image" class="image">
                                    </c:when>
                                    <c:otherwise>
                                        No image available
                                    </c:otherwise>
                                </c:choose>
                            </td>
                             <td><a href="detailPostForClient?postId=${post.postId}">${post.carName}</a></td>
                            <td>${post.year}</td>
                            <td><span><fmt:formatNumber value="${post.priceCar}" pattern="#,##0"/> VND</span></td>
                            <td>${post.descriptions}</td>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </c:if>
        <c:if test="${empty posts}">
            <p class="no-results">No results found</p>
        </c:if>
    </div>
</body>
</html>
