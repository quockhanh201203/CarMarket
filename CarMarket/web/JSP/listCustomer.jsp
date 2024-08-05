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
                            <div class="card-header d-flex justify-content-between align-items-center">
                                <h5 class="mb-0">List customers</h5>
                                <c:if test="${sessionScope.currentAcc.role == 1}">
                                    <button class="btn btn-light btn-sm" data-toggle="modal" data-target="#createCustomerModal">Create new customer</button>
                                </c:if>
                            </div>
                            <div class="table-responsive">
                                <table class="table mb-0">
                                    <thead class="small text-uppercase bg-body text-muted">
                                        <tr>
                                            <th>CustomerID</th>
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Status</th>
                                            <th>Phone Number</th>
                                            <th>Created Date</th>
                                            <th class="text-end">Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="c" items="${requestScope.listClient}">
                                            <tr class="align-middle">
                                                <td>${c.clientId}</td>
                                                <td>
                                                    <div class="d-flex align-items-center">
                                                        <div>
                                                            <div class="h6 mb-0 lh-1">
                                                                <a href="#" class="view-details" data-id="${c.clientId}">
                                                                    ${c.firstName} ${c.lastName}
                                                                </a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                                <td>${c.email}</td>
                                                <td>
                                                    <label class="switch">
                                                        <input type="checkbox" ${c.status ? 'checked' : ''} disabled>
                                                        <span class="slider"></span>
                                                    </label>
                                                </td>
                                                <td>${c.phoneNumber}</td>
                                                <td>${c.createDate}</td>
                                                <td class="text-end">
                                                    <c:if test="${sessionScope.currentAcc.role == 1}">
                                                        <button class="btn btn-danger btn-sm btn-action" data-toggle="modal" data-target="#deleteUserModal${c.clientId}">Delete user</button>
                                                    </c:if>
                                                </td>
                                            </tr>

                                            <!-- View Details Modal -->
                                        <div class="modal fade" id="viewDetailsModal${c.clientId}" tabindex="-1" role="dialog" aria-labelledby="viewDetailsModalLabel${c.clientId}" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="viewDetailsModalLabel${c.clientId}">User Details</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p><strong>ID:</strong> ${c.clientId}</p>
                                                        <p><strong>Name:</strong> ${c.firstName} ${c.lastName}</p>
                                                        <p><strong>Email:</strong> ${c.email}</p>
                                                        <p><strong>Status:</strong>
                                                            <label class="switch">
                                                                <input type="checkbox" class="status-toggle" data-id="${c.clientId}" ${c.status ? 'checked' : ''}>
                                                                <span class="slider"></span>
                                                            </label>
                                                        </p>
                                                        <p><strong>Phone Number:</strong> ${c.phoneNumber}</p>
                                                        <p><strong>Created Date:</strong> ${c.createDate}</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <button type="button" class="btn btn-primary save-button" data-id="${c.clientId}" disabled>Save changes</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- End View Details Modal -->

                                        <!-- Delete User Modal -->
                                        <div class="modal fade" id="deleteUserModal${c.clientId}" tabindex="-1" role="dialog" aria-labelledby="deleteUserModalLabel${c.clientId}" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="deleteUserModalLabel${c.clientId}">Delete User</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>Are you sure you want to delete this user?</p>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                                        <a href="deleteUser?id=${c.clientId}" class="btn btn-danger">Delete</a>
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
                                        <form action="managecustomerprofile" method="post">
                                            <div class="field form-group">
                                                <input class="form-control" name="FirstName" type="text" placeholder="First Name" required>
                                            </div>
                                            <div class="field form-group">
                                                <input class="form-control" name="LastName" type="text" placeholder="Last Name" required>
                                            </div>
                                            <div class="field form-group">
                                                <input class="form-control" name="email" type="email" placeholder="Email" required>
                                            </div>
                                            <div class="field form-group">
                                                <input class="form-control" name="phoneNumber" type="text" placeholder="Phone Number" required>
                                            </div>
                                            <div class="field form-group">
                                                <input class="form-control" name="Address" type="text" placeholder="Address" required>
                                            </div>
                                            <div class="field form-group">
                                                <input class="form-control" name="pass" type="password" placeholder="Password" required>
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
                        var clientId = $(this).data('id');
                        $('#viewDetailsModal' + clientId).modal('show');
                    });

                    $('.status-toggle').on('change', function () {
                        var clientId = $(this).data('id');
                        $('.save-button[data-id="' + clientId + '"]').prop('disabled', false);
                    });

                    $('.save-button').on('click', function () {
                        var clientId = $(this).data('id');
                        var newStatus = $('.status-toggle[data-id="' + clientId + '"]').is(':checked');
                        window.location.href = 'updateStatusCustomer?id=' + clientId + '&status=' + newStatus;
                    });
                });
            </script>
    </body>
</html>
