<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Brand Car</title>
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
                height: 100%;
                width: 100%;
                justify-content: center;
                align-items: center;
                background: linear-gradient(to right, #003366, #004080, #0059b3, #0073e6);
            }
            ::selection {
                background: #1a75ff;
                color: #fff;
            }

            .wrapper {
                max-width: 600px;
                background: #fff;
                padding: 40px;
                border-radius: 15px;
                box-shadow: 0 15px 20px rgba(0, 0, 0, 0.1);
            }
            .title-text {
                display: flex;
                justify-content: center;
                margin-bottom: 30px;
            }
            .title {
                font-size: 35px;
                font-weight: 600;
                color: #003366;
            }

            .form-container {
                width: 100%;
            }
            .form-inner {
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 100%;
            }
            .form-inner form {
                width: 100%;
            }

            .field {
                width: 100%;
                margin-top: 20px;
            }
            .field label {
                display: block;
                margin-bottom: 8px;
                font-weight: 500;
                color: #333;
            }
            .field input {
                height: 50px;
                width: 100%;
                outline: none;
                padding-left: 15px;
                border-radius: 15px;
                border: 1px solid lightgrey;
                font-size: 17px;
                transition: all 0.3s ease;
            }
            .field input:focus {
                border-color: #1a75ff;
            }
            .field input::placeholder {
                color: #999;
                transition: all 0.3s ease;
            }
            .field input:focus::placeholder {
                color: #1a75ff;
            }

            .pass-link, .signup-link {
                margin-top: 20px;
                text-align: center;
            }
            .pass-link a, .signup-link a {
                color: #1a75ff;
                text-decoration: none;
            }
            .pass-link a:hover, .signup-link a:hover {
                text-decoration: underline;
            }

            .btn {
                height: 50px;
                width: 100%;
                border-radius: 15px;
                position: relative;
                overflow: hidden;
                margin-top: 30px;
            }
            .btn .btn-layer {
                height: 100%;
                width: 300%;
                position: absolute;
                left: -100%;
                background: linear-gradient(to right, #003366, #004080, #0059b3, #0073e6);
                border-radius: 15px;
                transition: all 0.4s ease;
            }
            .btn:hover .btn-layer {
                left: 0;
            }
            .btn input[type="submit"] {
                height: 100%;
                width: 100%;
                z-index: 1;
                position: relative;
                background: none;
                border: none;
                color: #fff;
                font-size: 20px;
                font-weight: 500;
                cursor: pointer;
            }

            .profile-image {
                width: 150px;
                height: 150px;
                border-radius: 50%;
                object-fit: cover;
                margin-bottom: 20px;
            }
        </style>
    </head>
    <body>

        <div class="wrapper">
            <div class="title-text">
                <div class="title">Insert Model Car</div>
            </div>
            <div class="form-container">
                <form action="/carmarket/showModel" method="post" enctype="multipart/form-data">
                    <p style="color: red;">${mess}</p>
                    <div class="field">
                        <label for="BrandName">Model</label>
                        <input name="ModelName" type="text" placeholder="Model" required>
                    </div>
                    <div class="field">
                        <label for="profileImage">Model Image<span class="requite">*</span></label>
                        <input type="file" id="profileImage" name="modelImage" accept="image/*">
                    </div>
                    <div class="field btn">
                        <div class="btn-layer"></div>
                        <input type="submit" value="Create">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
