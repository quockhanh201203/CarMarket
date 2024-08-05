<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Management</title>
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
            <div class="row">
                <div class="col-12 text-right home-button">
                    <a href="/carmarket/home" class="btn btn-primary">Home</a>
                </div>
            </div>
            <div class="row">
                <div class="col-12 mb-3 mb-lg-5">
                    <div class="overflow-hidden card table-nowrap table-card">
                        <div class="card-header d-flex justify-content-between align-items-center">
                            <h5 class="mb-0">List provider</h5>
                            <c:if test="${sessionScope.currentAcc.role == 1}">
                                <button class="btn btn-light btn-sm" data-toggle="modal" data-target="#createCustomerModal">Create new customer</button>
                            </c:if>
                        </div>
                        <div class="table-responsive">
                            <table class="table mb-0">
                                <thead class="small text-uppercase bg-body text-muted">
                                    <tr>
                                        <th>ProviderID</th>
                                        <th>Email</th>
                                        <th>Status</th>
                                        <th>Role</th>
                                        <th>Created Date</th>
                                        <th class="text-end">Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="c" items="${requestScope.listProvider}">
                                        <tr class="align-middle">
                                            <td>${c.providerId}</td>
                                            <td>
                                                <div class="d-flex align-items-center">
                                                    <div>
                                                        <div class="h6 mb-0 lh-1">
                                                            <a href="#" class="view-details" data-id="${c.providerId}">
                                                                ${c.email}
                                                            </a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>
                                                <label class="switch">
                                                    <input type="checkbox" ${c.status ? 'checked' : ''} disabled>
                                                    <span class="slider"></span>
                                                </label>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${c.role == 1}">
                                                        Admin
                                                    </c:when>
                                                    <c:when test="${c.role == 2}">
                                                        Staff
                                                    </c:when>
                                                    <c:when test="${c.role == 3}">
                                                        Manager
                                                    </c:when>
                                                    <c:otherwise>
                                                        Unknown Role
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>${c.createDate}</td>
                                            <td class="text-end">
                                                <c:if test="${sessionScope.currentAcc.role == 1}">
                                                    <button class="btn btn-danger btn-sm btn-action" data-toggle="modal" data-target="#deleteUserModal${c.providerId}">Delete user</button>
                                                </c:if>
                                            </td>
                                        </tr>

                                        <!-- View Details Modal -->
                                    <div class="modal fade" id="viewDetailsModal${c.providerId}" tabindex="-1" role="dialog" aria-labelledby="viewDetailsModalLabel${c.providerId}" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="viewDetailsModalLabel${c.providerId}">User Details</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <p><strong>ID:</strong> ${c.providerId}</p>
                                                    <p><strong>Email:</strong> ${c.email}</p>
                                                    <p><strong>Status:</strong>
                                                        <label class="switch">
                                                            <input type="checkbox" class="status-toggle" data-id="${c.providerId}" ${c.status ? 'checked' : ''}>
                                                            <span class="slider"></span>
                                                        </label>
                                                    </p>
                                                    <p><strong>Created Date:</strong> ${c.createDate}</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-primary save-button" data-id="${c.providerId}" disabled>Save changes</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End View Details Modal -->

                                    <!-- Delete User Modal -->
                                    <div class="modal fade" id="deleteUserModal${c.providerId}" tabindex="-1" role="dialog" aria-labelledby="deleteUserModalLabel${c.providerId}" aria-hidden="true">
                                        <div class="modal-dialog" role="document">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="deleteUserModalLabel${c.providerId}">Delete User</h5>
                                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                        <span aria-hidden="true">&times;</span>
                                                    </button>
                                                </div>
                                                <div class="modal-body">
                                                    <p>Are you sure you want to delete this user?</p>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                                    <a href="actionProvider?id=${c.providerId}" class="btn btn-danger">Delete</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- End Delete User Modal -->
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <!-- Create Customer Modal -->
                    <div class="modal fade" id="createCustomerModal" tabindex="-1" role="dialog" aria-labelledby="createCustomerModalLabel" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="createCustomerModalLabel">Create a Customer</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <c:if test="${not empty mess}">
                                        <div class="alert alert-danger">
                                            ${mess}
                                        </div>
                                    </c:if>
                                    <form action="actionProvider" method="post">


                                        <div class="field form-group">
                                            <input class="form-control" name="email" type="email" placeholder="Email" required>
                                        </div>
                                        <div class="field form-group">
                                            <input class="form-control" name="pass" type="password" placeholder="Password" required>
                                        </div>
                                        <div class="field form-group">
                                            <label for="role">Select Role</label>
                                            <select class="form-control" name="role" id="role" required>
                                                <option value="1">Admin</option>
                                                <option value="2">Staff</option>
                                                <option value="3">Manager</option>
                                            </select>
                                        </div>
                                        <div class="btn">
                                            <input class="btn btn-primary" type="submit" value="Create">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End Create Customer Modal -->
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.view-details').on('click', function (e) {
                    e.preventDefault();
                    var providerId = $(this).data('id');
                    $('#viewDetailsModal' + providerId).modal('show');
                });

                $('.status-toggle').on('change', function () {
                    var providerId = $(this).data('id');
                    $('.save-button[data-id="' + providerId + '"]').prop('disabled', false);
                });

                $('.save-button').on('click', function () {
                    var providerId = $(this).data('id');
                    var newStatus = $('.status-toggle[data-id="' + providerId + '"]').is(':checked');
                    window.location.href = 'updateStatusProvider?id=' + providerId + '&status=' + newStatus;
                });
            });
        </script>
    </body>
</html>
