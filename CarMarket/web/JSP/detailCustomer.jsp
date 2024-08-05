<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User Profile</title>
    <!-- Link Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <style>
        body {
            background-color: #f9f9fa;
        }
        .padding {
            padding: 3rem !important;
        }
        .user-card-full {
            overflow: hidden;
        }
        .card {
            border-radius: 5px;
            box-shadow: 0 1px 20px 0 rgba(69,90,100,0.08);
            border: none;
            margin-bottom: 30px;
        }
        .user-card-full .user-profile {
            border-radius: 5px 0 0 5px;
        }
        .bg-c-lite-green {
            background: linear-gradient(to right, #ee5a6f, #f29263);
        }
        .user-profile {
            padding: 20px 0;
        }
        .card-block {
            padding: 1.25rem;
        }
        .m-b-25 {
            margin-bottom: 25px;
        }
        .img-radius {
            border-radius: 5px;
        }
        h6 {
            font-size: 16px;
            font-weight: 600;
        }
        .text-muted {
            color: #919aa3 !important;
        }
        .social-link a {
            font-size: 20px;
            margin: 0 10px;
            transition: all 0.3s ease-in-out;
        }
        .social-link a:hover {
            color: #007bff;
        }
    </style>
</head>
<body>
    
    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-xl-6 col-md-12">
                <div class="card user-card-full">
                    <div class="row no-gutters">
                        <div class="col-sm-4 bg-c-lite-green user-profile text-white text-center">
                            <div class="card-block">
                                <div class="m-b-25">
                                    <img src="${client.image}" class="img-radius" alt="User-Profile-Image">
                                </div>
                                <h6>${client.firstName} ${client.lastName}</h6>
                                <p>Full Name</p>
                                <i class="fa fa-pencil m-t-10"></i>
                            </div>
                        </div>
                        <div class="col-sm-8">
                            <div class="card-block">
                                <h6 class="m-b-20 p-b-5 b-b-default">Information</h6>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <p class="m-b-10">Email</p>
                                        <h6 class="text-muted">${client.email}</h6>
                                    </div>
                                    
                                    <div class="col-sm-6">
                                        <p class="m-b-10">Phone</p>
                                        <h6 class="text-muted">${client.phoneNumber}</h6>
                                    </div>
                                </div>
                                <h6 class="m-b-20 m-t-40 p-b-5 b-b-default">Created Date</h6>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h6 class="text-muted">${client.createdDate}</h6>
                                    </div>
                                    <div class="col-sm-6">
                                        <p class="m-b-10">Status</p>
                                        <h6 class="text-muted">${client.status}</h6>
                                    </div>
                                </div>
                                <h6 class="m-b-20 m-t-40 p-b-5 b-b-default">Address</h6>
                                <div class="row">
                                    <div class="col-sm-6">
                                        <h6 class="text-muted">${client.address}</h6>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Link Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
