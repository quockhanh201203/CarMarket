<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Forgot Password</title>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }
        html, body {
            display: grid;
            height: 100%;
            width: 100%;
            place-items: center;
            background: linear-gradient(to left, #003366, #004080, #0059b3, #0073e6);
        }
        ::selection {
            background: #1a75ff;
            color: #fff;
        }
        .wrapper {
            overflow: hidden;
            max-width: 390px;
            background: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 15px 20px rgba(0, 0, 0, 0.1);
        }
        .wrapper .title-text {
            display: flex;
            justify-content: center;
            font-size: 35px;
            font-weight: 600;
            text-align: center;
        }
        .form-container {
            width: 100%;
            overflow: hidden;
        }
        .form-inner {
            display: flex;
            flex-direction: column;
            width: 100%;
        }
        .field {
            height: 50px;
            width: 100%;
            margin-top: 20px;
            display: flex;
            justify-content: space-between;
        }
        .field input {
            height: 100%;
            width: 45px;
            outline: none;
            text-align: center;
            border-radius: 10px;
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
        .pass-link {
            margin-top: 5px;
            text-align: right;
        }
        .pass-link a {
            color: #1a75ff;
            text-decoration: none;
        }
        .pass-link a:hover {
            text-decoration: underline;
        }
        .btn {
            height: 50px;
            width: 100%;
            border-radius: 15px;
            margin-top: 20px;
            position: relative;
            overflow: hidden;
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
        .error-message {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="wrapper">
        <div class="title-text">OTP Verification</div>
        <div class="form-container">
            <div class="form-inner">
                <form action="forgetpassword" method="post" >
                    <p>Code has been send to ${sessionScope.userMail}</p>
                    <p class="error-message">${requestScope.wrongOTP}</p>
                    <input type="hidden" name="lostPass" value="verifyOTP"/>
                    <div class="field">
                        <input type="text" name="op1" maxlength="1" autofocus/>
                        <input type="text" name="op2" maxlength="1"/>
                        <input type="text" name="op3" maxlength="1"/>
                        <input type="text" name="op4" maxlength="1"/>
                        <input type="text" name="op5" maxlength="1"/>
                        <input type="text" name="op6" maxlength="1"/>
                    </div>
                    <div class="pass-link"><a href="forgetpassword?lostPass=resendOTP">Can't get mail?</a></div>
                    <div class="btn">
                        <div class="btn-layer"></div>
                        <input type="submit" value="Get your OTP">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>
        const inputs = document.querySelectorAll('.field input');
        inputs.forEach((input, index) => {
            input.addEventListener('input', (e) => {
                if (e.target.value.length === 1 && index < inputs.length - 1) {
                    inputs[index + 1].focus();
                }
            });
        });
    </script>
</body>
</html>
