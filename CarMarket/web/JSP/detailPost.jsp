<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Post Details</title>
        <style>
            body {
                font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
                background-color: #f4f4f4;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 80%;
                margin: 20px auto;
                background: #fff;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }

            h1, h2 {
                color: #333;
            }

            .post-detail, .car-detail, .client-detail, .post-images {
                margin-bottom: 30px;
            }

            .post-detail p, .car-detail p, .client-detail p {
                margin: 10px 0;
            }

            .post-detail img {
                max-width: 100%;
                height: auto;
                display: block;
                margin: 10px 0;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            th, td {
                padding: 10px;
                border: 1px solid #ddd;
                text-align: left;
            }

            th {
                background-color: #f8f8f8;
            }

            .post-images img {
                width: 200px;
                height: auto;
                margin: 10px;
                border-radius: 5px;
                transition: transform 0.3s ease;
            }

            .post-images img:hover {
                transform: scale(1.1);
            }

            .status-buttons {
                margin-top: 10px;
            }

            .switch {
                position: relative;
                display: inline-block;
                width: 60px;
                height: 34px;
            }

            .switch input {
                opacity: 0;
                width: 0;
                height: 0;
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
            }

            .slider:before {
                position: absolute;
                content: "";
                height: 26px;
                width: 26px;
                left: 4px;
                bottom: 4px;
                background-color: white;
                transition: .4s;
            }

            input:checked + .slider {
                background-color: #2196F3;
            }

            input:checked + .slider:before {
                transform: translateX(26px);
            }

            .slider.round {
                border-radius: 34px;
            }

            .slider.round:before {
                border-radius: 50%;
            }

            .save-button {
                background-color: #4CAF50; /* Green background */
                color: white; /* White text */
                padding: 15px 32px; /* Padding */
                text-align: center; /* Centered text */
                text-decoration: none; /* Remove underline */
                display: inline-block; /* Make the link block-level */
                font-size: 16px; /* Increase font size */
                margin: 10px 2px; /* Some margin */
                cursor: pointer; /* Pointer/hand icon */
                border: none; /* Remove borders */
                border-radius: 8px; /* Rounded corners */
                transition: background-color 0.3s ease; /* Transition effect */
                pointer-events: none; /* Initially disable pointer events */
                opacity: 0.6; /* Initially lower opacity */
            }

            .save-button.enabled {
                pointer-events: auto; /* Enable pointer events when enabled */
                opacity: 1; /* Increase opacity when enabled */
            }

            .save-button:hover {
                background-color: #45a049; /* Darker green on hover */
            }

            .back-button {
                background-color: #2196F3; /* Blue background */
                color: white; /* White text */
                padding: 10px 20px; /* Padding */
                text-align: center; /* Centered text */
                text-decoration: none; /* Remove underline */
                display: inline-block; /* Make the link block-level */
                font-size: 16px; /* Font size */
                margin: 10px 0; /* Margin */
                cursor: pointer; /* Pointer/hand icon */
                border: none; /* Remove borders */
                border-radius: 8px; /* Rounded corners */
                transition: background-color 0.3s ease; /* Transition effect */
            }

            .back-button:hover {
                background-color: #1976D2; /* Darker blue on hover */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <a href="managePost" class="back-button">Back to Post List</a>
            <h1>Post Details</h1>
            <div class="post-detail">
                <h2>Post Information</h2>
                <table>
                    <tr>
                        <th>Post ID</th>
                        <td>${post.postId}</td>
                    </tr>
                    <tr>
                        <th>Car Name</th>
                        <td>${post.carName}</td>
                    </tr>
                    <tr>
                        <th>Price</th>
                        <td><fmt:formatNumber value="${post.priceCar}" type="currency" currencySymbol="₫" /></td>
                    </tr>
                    <tr>
                        <th>Date</th>
                        <td>${post.postDate}</td>
                    </tr>
                    <tr>
                        <th>Status</th>
                        <td>
                            <form id="statusForm" action="updateClientPost" method="post" style="display: inline;">
                                <input type="hidden" id="statusHidden" name="newStatus" value="${post.status ? 'true' : 'false'}">
                                <input type="hidden" name="postId" value="${post.postId}">
                                <label class="switch">
                                    <input id="statusCheckbox" type="checkbox" ${post.status ? 'checked' : ''}>
                                    <span class="slider round"></span>
                                </label>
                                <button id="saveButton" type="button" class="save-button" disabled>Save</button>
                            </form>
                        </td>
                    </tr>
                    <tr>
                        <th>Description</th>
                        <td>${post.descriptions}</td>
                    </tr>
                    <tr>
                        <th>Year</th>
                        <td>${post.year}</td>
                    </tr>
                </table>
            </div>
            <div class="car-detail">
                <h2>Car Details</h2>
                <table>
                    <tr>
                        <th>Brand</th>
                        <td>${br.brandName}</td>
                    </tr>
                    <tr>
                        <th>Model</th>
                        <td>${md.modelName}</td>
                    </tr>
                    <tr>
                        <th>Gearbox</th>
                        <td>${gb.gearboxName}</td>
                    </tr>
                    <tr>
                        <th>Origin</th>
                        <td>${origin.originName}</td>
                    </tr>
                    <tr>
                        <th>Interior Color</th>
                        <td>${inColor.interiorColorName}</td>
                    </tr>
                    <tr>
                        <th>Exterior Color</th>
                        <td>${exColor.exteriorColorName}</td>
                    </tr>
                    <tr>
                        <th>Number of Doors</th>
                        <td>${doors.numberOfDoorsName}</td>
                    </tr>
                    <tr>
                        <th>Engine</th>
                        <td>${eg.engineName}</td>
                    </tr>
                    <tr>
                        <th>Number of Seats</th>
                        <td>${seats.numberOfSeatsName}</td>
                    </tr>
                </table>
            </div>
            <div class="client-detail">
                <h2>Client Details</h2>
                <table>
                    <tr>
                        <th>Client ID</th>
                        <td>${client.clientId}</td>
                    </tr>
                    <tr>
                        <th>Client Name</th>
                        <td><a href="postclient?clientId=${client.clientId}">${client.firstName} ${client.lastName}</a></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td>${client.email}</td>
                    </tr>
                </table>
            </div>
            <div class="post-images">
                <h2>Post Images</h2>
                <c:forEach var="img" items="${image}">
                    <img src="${img.postImg}" alt="Car Image">
                </c:forEach>
            </div>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const statusCheckbox = document.getElementById('statusCheckbox');
                const saveButton = document.getElementById('saveButton');
                const statusHidden = document.getElementById('statusHidden');
                const statusForm = document.getElementById('statusForm');

                // Initially set the hidden input value based on checkbox state
                updateHiddenInput();
                updateSaveButtonState();

                // Add change event listener to checkbox
                statusCheckbox.addEventListener('change', function () {
                    updateHiddenInput();
                    updateSaveButtonState();
                });

                // Function to update hidden input value based on checkbox state
                function updateHiddenInput() {
                    statusHidden.value = statusCheckbox.checked ? 'true' : 'false';
                }

                // Function to update save button state based on checkbox state
                function updateSaveButtonState() {
                    saveButton.disabled = statusHidden.value === '${post.status ? 'true' : 'false'}';
                    if (!saveButton.disabled) {
                        saveButton.classList.add('enabled');
                    } else {
                        saveButton.classList.remove('enabled');
                    }
                }

                // Add click event listener to save button
                saveButton.addEventListener('click', function () {
                    statusForm.submit();
                });
            });
        </script>
    </body>
</html>
