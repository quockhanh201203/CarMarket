<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Post Management</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" />
    <style>
        body {
            margin-top: 20px;
            background: #eee;
        }
        .card {
            box-shadow: 0 20px 27px 0 rgb(0 0 0 / 5%);
        }
        .avatar.sm {
            width: 2.25rem;
            height: 2.25rem;
            font-size: .818125rem;
        }
        .table-nowrap .table td, .table-nowrap .table th {
            white-space: nowrap;
        }
        .table>:not(caption)>*>* {
            padding: 0.75rem 1.25rem;
            border-bottom-width: 1px;
        }
        table th {
            font-weight: 600;
            background-color: #eeecfd !important;
        }
        .switch {
            position: relative;
            display: inline-block;
            width: 34px;
            height: 20px;
        }
        .switch input {
            display: none;
        }
        .slider {
            position: absolute;
            cursor: pointer;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            background-color: #ccc;
            transition: .4s;
            border-radius: 34px;
        }
        .slider:before {
            position: absolute;
            content: "";
            height: 14px;
            width: 14px;
            left: 3px;
            bottom: 3px;
            background-color: white;
            transition: .4s;
            border-radius: 50%;
        }
        input:checked + .slider {
            background-color: #2196F3;
        }
        input:checked + .slider:before {
            transform: translateX(14px);
        }
        .btn-action {
            margin-right: 5px;
        }
        .navbar-nav .dropdown-menu {
            min-width: 200px; /* Adjust width as needed */
        }
        .dropdown-item {
            font-size: 14px; /* Smaller font size */
            padding: 5px 10px; /* Less padding */
        }
        .home-button {
            margin-bottom: 20px; /* Add some space below the button */
        }
    </style>
</head>
<body>
    <div class="container">
        <!-- Home Button -->
            <div class="row">
                <div class="col-12 text-right home-button">
                    <a href="/carmarket/home" class="btn btn-primary">Home</a>
                </div>
            </div>
        
        

        <div class="row">
            <div class="col-12 mb-3 mb-lg-5">
                <div class="overflow-hidden card table-nowrap table-card">
                    <div class="table-responsive">
                        <table class="table mb-0">
                            <thead class="small text-uppercase bg-body text-muted">
                                <tr>
                                    <th>PostID</th>
                                    <th>Car Name</th>
                                    <th>Status</th>
                                    <th>Price</th>
                                    <th>Created Date</th>
                                    <th class="text-end">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="post" items="${requestScope.listPost}" varStatus="loop">
                                    <tr class="align-middle">
                                        <td>${post.postId}</td>
                                        <td>
                                            <div class="d-flex align-items-center">
                                                <div>
                                                    <div class="h6 mb-0 lh-1">
                                                        <a href="detailPost?PostId=${post.postId}" class="view-details" data-id="${post.postId}">
                                                            ${post.carName}
                                                        </a>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                        <td>
                                            <label class="switch">
                                                <input type="checkbox" <c:if test="${post.status}">checked</c:if> disabled>
                                                <span class="slider"></span>
                                            </label>
                                        </td>
                                        <td><span><fmt:formatNumber value="${post.priceCar}" pattern="#,##0"/> VND</span></td>
                                        <td>${post.postDate}</td>
                                        <td class="text-end">
                                            <c:if test="${sessionScope.currentAcc.role == 1}">
                                                <button class="btn btn-danger btn-sm btn-action" data-toggle="modal" data-target="#deleteUserModal${post.postId}">Delete post</button>
                                            </c:if>
                                        </td>
                                    </tr>
                                    <!-- Modal for delete post -->
                                    <div class="modal fade" id="deleteUserModal${post.postId}" tabindex="-1" role="dialog" aria-labelledby="deleteUserModalLabel${post.postId}" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="deleteUserModalLabel${post.postId}">Delete Post</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Are you sure you want to delete this post?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                                    <a href="deletePost?id=${post.postId}" class="btn btn-danger">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End Modal for delete post -->
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
