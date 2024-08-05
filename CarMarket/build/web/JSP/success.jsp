<%-- 
    Document   : success
    Created on : Jun 18, 2024, 2:17:54 PM
    Author     : admin
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #87CEEB; /* Màu xanh nước biển */
                margin: 0;
                padding: 0;
            }
            .container {
                width: 50%;
                margin: 100px auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 10px;
                text-align: center;
            }
            h1 {
                color: #4CAF50;
            }
            p {
                font-size: 18px;
                color: #555;
            }
            .btn-home {
                display: inline-block;
                padding: 10px 20px;
                font-size: 16px;
                color: #fff;
                background-color: #4CAF50;
                border: none;
                border-radius: 5px;
                text-decoration: none;
                transition: background-color 0.3s;
                cursor: pointer;
            }
            .btn-home:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <form action="/carmarket/login" method="get">
                <h1>Your Action Done Successfully!</h1>
                <p>Your action have finish successfully. Please wait a moment while we process it.</p>
                <input type="submit" class="btn-home" value="Back to Homepage">
                <p>Thank you for your patience.</p>
            </form>
        </div>
    </body>
</html>
