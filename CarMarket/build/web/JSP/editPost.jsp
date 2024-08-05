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
            }

            .save-button:hover {
                background-color: #45a049; /* Darker green on hover */
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Post Details</h1>
            <form id="postForm" action="updatePost" method="POST">
                <div class="post-detail">
                    <h2>Post Information</h2>
                    <table>
                        <tr>
                            <th>Post ID</th>
                            <td><input type="text" name="postId" value="${post.postId}" readonly /></td>
                        </tr>
                        <tr>
                            <th>Car Name</th>
                            <td><input type="text" name="carName" value="${post.carName}" /></td>
                        </tr>
                        <tr>
                            <th>Price</th>
                            <td><input type="text" name="priceCar" value="${post.priceCar}" /></td>
                        </tr>
                        <tr>
                            <th>Date</th>
                            <td><input type="text" name="postDate" value="${post.postDate}" /></td>
                        </tr>
                        <tr>
                            <th>Status</th>
                            <td>
                                <label class="switch">
                                    <input type="checkbox" id="statusCheckbox" ${post.status ? 'checked' : ''}>
                                    <span class="slider round"></span>
                                </label>
                                <input type="hidden" name="status" id="statusHidden" value="${post.status}" />
                            </td>
                        </tr>
                        <tr>
                            <th>Description</th>
                            <td><textarea name="descriptions">${post.descriptions}</textarea></td>
                        </tr>
                        <tr>
                            <th>Year</th>
                            <td><input type="text" name="year" value="${post.year}" /></td>
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
                
                <div class="post-images">
                    <h2>Post Images</h2>
                    <c:forEach var="img" items="${image}">
                        <img src="${img.postImg}" alt="Car Image">
                    </c:forEach>
                </div>
                <div class="status-buttons">
                    <button type="button" class="save-button" id="saveButton">Save Changes</button>
                </div>
            </form>
        </div>

        <script>
            document.addEventListener('DOMContentLoaded', function () {
                const statusCheckbox = document.getElementById('statusCheckbox');
                const saveButton = document.getElementById('saveButton');
                const statusHidden = document.getElementById('statusHidden');
                const statusForm = document.getElementById('postForm');

                // Initially set the hidden input value based on checkbox state
                updateHiddenInput();

                // Add change event listener to checkbox
                statusCheckbox.addEventListener('change', function () {
                    updateHiddenInput();
                });

                // Function to update hidden input value based on checkbox state
                function updateHiddenInput() {
                    statusHidden.value = statusCheckbox.checked ? 'true' : 'false';
                }

                // Add click event listener to save button
                saveButton.addEventListener('click', function () {
                    statusForm.submit();
                });
            });
        </script>
    </body>
</html>
