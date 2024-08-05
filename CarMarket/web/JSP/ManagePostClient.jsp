<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            .edit-link {
                color: #007bff;
                text-decoration: none;
            }
            .edit-link:hover {
                text-decoration: underline;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Personal Post</h1>
            <c:if test="${not empty posts}">
                <table>
                    <tr>
                        <th>Car Name</th>
                        <th>Year</th>
                        <th>Status</th>
                        <th>Price</th>
                        <th>Description</th>
                        <th>Edit</th>
                    </tr>
                    <c:forEach var="post" items="${posts}">
                        <tr>
                            <td>${post.carName}</td>
                            <td>${post.year}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${post.status}">
                                        Approve
                                    </c:when>
                                    <c:otherwise>
                                        Unapprove
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <fmt:formatNumber value="${post.priceCar}" type="currency" currencySymbol="₫"/>
                            </td>
                            <td>${post.descriptions}</td>
                            <td><a href="editPost?postId=${post.postId}" class="edit-link">Update</a>
                                <a href="deletePostForClient?id=${post.postId}" class="edit-link">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
            <c:if test="${empty posts}">
                <p class="no-results">No results found</p>
            </c:if>
        </div>
    </body>
</html>
