<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Car Images</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }
        html, body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
            width: 100%;
            background: -webkit-linear-gradient(left, #003366, #004080, #0059b3, #0073e6);
        }
        .wrapper {
            width: 100%;
            max-width: 500px;
            background: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 15px 20px rgba(0,0,0,0.1);
        }
        .title {
            text-align: center;
            font-size: 28px;
            font-weight: 600;
            margin-bottom: 25px;
            color: #333;
        }
        .field {
            margin-bottom: 20px;
        }
        .field label {
            display: block;
            font-weight: 500;
            margin-bottom: 5px;
            color: #333;
        }
        .field input[type="file"] {
            width: 100%;
            padding: 10px;
            border: 1px solid lightgrey;
            border-radius: 5px;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }
        .field input[type="file"]:focus {
            border-color: #1a75ff;
        }
        .btn {
            height: 50px;
            width: 100%;
            border-radius: 5px;
            position: relative;
            overflow: hidden;
            margin-top: 10px;
        }
        .btn .btn-layer {
            height: 100%;
            width: 300%;
            position: absolute;
            left: -100%;
            background: -webkit-linear-gradient(right,#003366,#004080,#0059b3, #0073e6);
            transition: left 0.4s ease;
            border-radius: 5px;
        }
        .btn:hover .btn-layer {
            left: 0;
        }
        .btn input[type="submit"] {
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
        .signup-link {
            text-align: center;
            margin-top: 20px;
            color: #555;
        }
        .add-button {
            display: inline-block;
            padding: 10px 20px;
            background: #0073e6;
            color: white;
            text-align: center;
            border-radius: 5px;
            cursor: pointer;
            margin: 10px 0;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }
        .add-button:hover {
            background-color: #005bb5;
        }
        .error-message {
            color: red;
            text-align: center;
            margin-bottom: 15px;
        }
    </style>
    <script>
        function addImageInput() {
            const container = document.getElementById('image-input-container');
            const newInput = document.createElement('div');
            newInput.classList.add('field');
            newInput.innerHTML = `
                <label for="profileImage">Add Image<span class="requite">*</span></label>
                <input type="file" name="profileImage" accept="image/*">
            `;
            container.appendChild(newInput);
        }
    </script>
</head>
<body>
    <div class="wrapper">
        <div class="title">Add Car Images</div>
        <form action="/carmarket/doneCreatePost" method="post" enctype="multipart/form-data">
            <c:if test="${not empty mess}">
                <p class="error-message">${mess}</p>
            </c:if>
            <div class="field">
                <label for="postID">Post ID<span class="require">*</span></label>
                <input name="PostID" type="text" value="${postId}" readonly>
            </div>
            <div id="image-input-container">
                <div class="field">
                    <label for="profileImage">Add Image<span class="requite">*</span></label>
                    <input type="file" id="profileImage" name="profileImage" accept="image/*" multiple>
                </div>
            </div>
            <div class="add-button" onclick="addImageInput()">+ Add another image</div>
            <div class="field btn">
                <div class="btn-layer"></div>
                <input type="submit" value="Next">
            </div>
            <div class="signup-link">This is the last step</div>
        </form>
    </div>
</body>
</html>
