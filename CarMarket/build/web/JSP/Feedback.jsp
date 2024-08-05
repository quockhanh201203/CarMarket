<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Feedback and Services</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
    <style>
        @import url('https://fonts.googleapis.com/css?family=Poppins:400,500,600,700&display=swap');

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            display: flex;
            flex-direction: column;
            align-items: center;
            text-align: center;
            background: #f6f5f7;
            padding: 20px;
            color: #333;
        }

        .container {
            position: relative;
            width: 100%;
            max-width: 600px;
            background: #FFF;
            padding: 30px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            border-radius: 10px;
            margin-bottom: 40px;
        }

        .post {
            display: none;
        }

        .post .text {
            font-size: 24px;
            color: #444;
            font-weight: 600;
            margin-bottom: 20px;
        }

        .edit {
            position: absolute;
            right: 10px;
            top: 10px;
            font-size: 16px;
            color: #007bff;
            font-weight: 500;
            cursor: pointer;
        }

        .edit:hover {
            text-decoration: underline;
        }

        .star-widget input {
            display: none;
        }

        .star-widget label {
            font-size: 30px;
            color: #ccc;
            padding: 10px;
            transition: all 0.2s ease;
            cursor: pointer;
        }

        input:not(:checked) ~ label:hover,
        input:not(:checked) ~ label:hover ~ label {
            color: #fd4;
        }

        input:checked ~ label {
            color: #fd4;
        }

        input#rate-5:checked ~ label {
            color: #fe7;
            text-shadow: 0 0 20px #952;
        }

        input:checked ~ form {
            display: block;
        }

        form header {
            width: 100%;
            font-size: 20px;
            color: #333;
            font-weight: 500;
            margin: 20px 0;
            text-align: center;
            transition: all 0.2s ease;
        }

        form .textarea {
            height: 100px;
            width: 100%;
            overflow: hidden;
            margin-bottom: 20px;
        }

        form .textarea textarea {
            height: 100%;
            width: 100%;
            outline: none;
            color: #333;
            padding-top: 10px;
            border: none;
            background: #f3f3f3;
            padding: 12px 15px;
            font-size: 17px;
            resize: none;
            border-radius: 5px;
        }

        form .btn {
            height: 45px;
            width: 100%;
            margin-top: 15px;
        }

        form .btn button {
            height: 100%;
            width: 100%;
            border: none;
            background: #007bff;
            border-radius: 5px;
            color: #FFF;
            font-size: 17px;
            font-weight: 500;
            text-transform: uppercase;
            cursor: pointer;
            transition: all 0.3s ease;
        }

        form .btn button:hover {
            background-color: #0056b3;
        }

        /* Services section */
        .service {
            width: 100%;
            padding: 40px 0;
            background: #f8f9fa;
        }

        .service .container {
            max-width: 1200px;
            margin: 0 auto;
        }

        .service-content .row {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-around;
        }

        .single-service-item {
            background: #fff;
            padding: 20px;
            margin: 15px;
            border-radius: 10px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
            width: 30%;
            transition: all 0.3s ease;
        }

        .single-service-item:hover {
            transform: translateY(-10px);
        }

        .single-service-icon {
            font-size: 50px;
            color: #007bff;
            margin-bottom: 15px;
        }

        .single-service-item h2 {
            font-size: 20px;
            margin-bottom: 10px;
        }

        .single-service-item p {
            color: #666;
            font-size: 15px;
        }

        .single-service-item a {
            text-decoration: none;
            color: #007bff;
            font-weight: 600;
        }

        .single-service-item a:hover {
            color: #0056b3;
        }
    </style>
</head>
<body>
    <section id="service" class="service">
    </section><!--/.service-->
    <div class="container">
        <div class="post">
            <div class="text">Thanks for rating us!</div>
            <div class="edit">Edit</div>
        </div>
        <form action="/carmarket/addFeedback" method="post">
            <div class="star-widget">
                <input name="rate" type="radio" id="rate-5" value="5">
                <label for="rate-5" class="fas fa-star"></label>
                <input name="rate" type="radio" id="rate-4" value="4">
                <label for="rate-4" class="fas fa-star"></label>
                <input name="rate" type="radio" id="rate-3" value="3">
                <label for="rate-3" class="fas fa-star"></label>
                <input name="rate" type="radio" id="rate-2" value="2">
                <label for="rate-2" class="fas fa-star"></label>
                <input name="rate" type="radio" id="rate-1" value="1">
                <label for="rate-1" class="fas fa-star"></label>

                <header></header>
                <div class="textarea">
                    <textarea name="comment" cols="30" placeholder="Describe your experience..."></textarea>
                </div>
                <div class="btn">
                    <button type="submit">Post</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>
