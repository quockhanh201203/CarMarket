<%-- 
    Document   : Login
    Created on : Oct 29, 2023, 11:35:37 PM
    Author     : Acer
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
            *{
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                font-family: 'Poppins', sans-serif;
            }
            html, body{
                display: grid;
                height: 100%;
                width: 100%;
                place-items: center;
                background: -webkit-linear-gradient(left, #003366, #004080, #0059b3, #0073e6);
            }
            ::selection{
                background: #1a75ff;
                color: #fff;
            }
            .wrapper{
                overflow: hidden;
                max-width: 400px;
                background: #fff;
                padding: 30px;
                border-radius: 15px;
                box-shadow: 0px 15px 20px rgba(0,0,0,0.1);
            }
            .wrapper .title{
                text-align: center;
                font-size: 35px;
                font-weight: 600;
                margin-bottom: 20px;
            }
            .field{
                margin-bottom: 20px;
            }
            .field label{
                display: block;
                font-weight: 500;
                margin-bottom: 5px;
            }
            .field select, .field input{
                width: 100%;
                padding: 10px;
                border: 1px solid lightgrey;
                border-radius: 5px;
                font-size: 16px;
                transition: border-color 0.3s ease;
            }
            .field select:focus, .field input:focus{
                border-color: #1a75ff;
            }
            .field select::placeholder, .field input::placeholder{
                color: #999;
            }
            .btn{
                height: 50px;
                width: 100%;
                border-radius: 5px;
                position: relative;
                overflow: hidden;
            }
            .btn .btn-layer{
                height: 100%;
                width: 300%;
                position: absolute;
                left: -100%;
                background: -webkit-linear-gradient(right,#003366,#004080,#0059b3, #0073e6);
                transition: left 0.4s ease;
                border-radius: 5px;
            }
            .btn:hover .btn-layer{
                left: 0;
            }
            .btn input[type="submit"]{
                height: 100%;
                width: 100%;
                background: none;
                border: none;
                color: #fff;
                font-size: 20px;
                font-weight: 500;
                cursor: pointer;
                position: relative;
                z-index: 1;
            }
            .signup-link{
                text-align: center;
                margin-top: 20px;
                color: #555;
            }
        </style>
    </head>
    <body>
        <div class="wrapper">
            <div class="title">Vehicle Information</div>
            <form action="/carmarket/createPost" method="post">
                <p style="color: red;">${mess}</p>
                <div class="field">
                    <label for="brand">Brand Name<span class="require">*</span></label>
                    <select id="brand" name="brand" required>
                        <option value="" disabled selected>Select your brand</option>
                        <c:if test="${not empty listBrand}">
                            <c:forEach var="c" items="${listBrand}">
                                <option value="${c.brandId}">${c.brandName}</option>
                            </c:forEach> 
                        </c:if>
                    </select>
                </div>
                <div class="field">
                    <label for="model">Model Name<span class="require">*</span></label>
                    <select id="model" name="model" required>
                        <option value="" disabled selected>Select your model</option>
                        <c:if test="${not empty listModel}">
                            <c:forEach var="c" items="${listModel}">
                                <option value="${c.modelId}">${c.modelName}</option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
                <div class="field btn">
                    <div class="btn-layer"></div>
                    <input type="submit" value="Next">
                </div>
                <div class="signup-link">You have to finish step 1 before going to step 2</div>
            </form>
        </div>
    </body>
</html>
