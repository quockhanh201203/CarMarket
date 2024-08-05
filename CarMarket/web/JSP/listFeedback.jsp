<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>View Feedback</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                background: #f6f5f7;
                padding: 20px;
                color: #333;
            }
            .container {
                max-width: 800px;
                margin: auto;
                background: #fff;
                padding: 20px;
                box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
                border-radius: 10px;
            }
            .feedback-item {
                border-bottom: 1px solid #ddd;
                padding: 15px 0;
                display: flex;
                align-items: center;
            }
            .feedback-item:last-child {
                border-bottom: none;
            }
            .feedback-item .profile-pic {
                width: 50px;
                height: 50px;
                border-radius: 50%;
                margin-right: 15px;
            }
            .feedback-item .content {
                flex: 1;
            }
            .feedback-item .note {
                font-size: 18px;
                margin-bottom: 10px;
            }
            .feedback-item .rank {
                color: #fd4;
            }
            .feedback-item .date {
                font-size: 12px;
                color: #999;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Customer Feedback</h1>
            <c:forEach var="feedback" items="${list}" varStatus="status">
                <c:set var="client" value="${Clients[status.index]}" />
                <div class="feedback-item">
                    <img src="${client.image}" alt="User Image" class="profile-pic">
                    <div class="content">
                        <div class="name">${client.firstName} ${client.lastName}</div>
                        <div class="note">${feedback.note}</div>
                        <div class="rank">${feedback.rank} <i class="fas fa-star"></i></div>
                        <div class="date">${feedback.createDate}</div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
