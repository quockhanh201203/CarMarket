<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
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
            background: -webkit-linear-gradient(left, #003366, #004080, #0059b3, #0073e6);
        }
        .wrapper {
            overflow: hidden;
            max-width: 400px;
            background: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0px 15px 20px rgba(0,0,0,0.1);
        }
        .wrapper .title {
            text-align: center;
            font-size: 35px;
            font-weight: 600;
            margin-bottom: 20px;
        }
        .field {
            margin-bottom: 20px;
        }
        .field label {
            display: block;
            font-weight: 500;
            margin-bottom: 5px;
        }
        .field select, .field input, .field textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid lightgrey;
            border-radius: 5px;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }
        .field select:focus, .field input:focus, .field textarea:focus {
            border-color: #1a75ff;
        }
        .btn {
            height: 50px;
            width: 100%;
            border-radius: 5px;
            position: relative;
            overflow: hidden;
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
    </style>
</head>
<body>
    <div class="wrapper">
        <div class="title">Posting Information</div>
        <form action="/carmarket/editImage" method="post">
            <p style="color: red;">${mess}</p>
            <div class="field">
               
                <input name="PostID" type="hidden" value="${post.postId}" readonly>
            </div>
            <div class="field">
              
                <input name="CarID" type="hidden" value="${carId}" readonly>
            </div>
            <div class="field">
                <label for="brand">Car Name<span class="require">*</span></label>
                <input name="CarName" type="text" placeholder="Car Name" value="${post.carName}" required>
            </div>
            <div class="field">
                <label for="year">Year<span class="require">*</span></label>
                <select name="year" id="year" required>
                    <option value="${post.year}" disabled selected>${post.year}</option>
                    <% 
                        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
                        for (int year = currentYear; year >= 1900; year--) {
                            out.print("<option value=\"" + year + "\">" + year + "</option>");
                        }
                    %>
                </select>
            </div>
            <div class="field">
                <label for="origin">Origin<span class="require">*</span></label>
                <select id="origin" name="origin" required>
                    <option value="" disabled selected>${origin.originName}</option>
                    <c:if test="${not empty listOrigin}">
                        <c:forEach var="c" items="${listOrigin}">
                            <option value="${c.originID}">${c.originName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
            <div class="field">
                <label for="gearbox">Gearbox<span class="require">*</span></label>
                <select id="gearbox" name="gearbox" required>
                    <option value="" disabled selected>${gb.gearboxName}</option>
                    <c:if test="${not empty listGearBox}">
                        <c:forEach var="c" items="${listGearBox}">
                            <option value="${c.gearboxID}">${c.gearboxName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
            <div class="field">
                <label for="engine">Engine<span class="require">*</span></label>
                <select id="engine" name="engine" required>
                    <option value="" disabled selected>${eg.engineName}</option>
                    <c:if test="${not empty listEngine}">
                        <c:forEach var="c" items="${listEngine}">
                            <option value="${c.engineID}">${c.engineName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
            <div class="field">
                <label for="interiorColor">Interior Color<span class="require">*</span></label>
                <select id="interiorColor" name="interiorColor" required>
                    <option value="" disabled selected>${inColor.interiorColorName}</option>
                    <c:if test="${not empty listInteriorColor}">
                        <c:forEach var="c" items="${listInteriorColor}">
                            <option value="${c.interiorColorID}">${c.interiorColorName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
            <div class="field">
                <label for="exteriorColor">Exterior Color<span class="require">*</span></label>
                <select id="exteriorColor" name="exteriorColor" required>
                    <option value="" disabled selected>${exColor.exteriorColorName}</option>
                    <c:if test="${not empty listExteriorColor}">
                        <c:forEach var="c" items="${listExteriorColor}">
                            <option value="${c.exteriorColorID}">${c.exteriorColorName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>   
            <div class="field">
                <label for="numberOfSeats">Number Of Seats<span class="require">*</span></label>
                <select id="numberOfSeats" name="numberOfSeats" required>
                    <option value="" disabled selected>${seats.numberOfSeatsName}</option>
                    <c:if test="${not empty listSeats}">
                        <c:forEach var="c" items="${listSeats}">
                            <option value="${c.numberOfSeatsID}">${c.numberOfSeatsName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div> 
            <div class="field">
                <label for="numberOfDoors">Number Of Doors<span class="require">*</span></label>
                <select id="numberOfDoors" name="numberOfDoors" required>
                    <option value="" disabled selected>${doors.numberOfDoorsName}</option>
                    <c:if test="${not empty listDoors}">
                        <c:forEach var="c" items="${listDoors}">
                            <option value="${c.numberOfDoorsID}">${c.numberOfDoorsName}</option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
            <div class="field">
                <label for="price">Price<span class="require">*</span></label>
                <input id="formattedPrice" type="text" placeholder="Car Price" required>
                <input id="price" name="price" type="hidden" required>
            </div>
            <div class="field">
                <label for="description">Description<span class="require">*</span></label>
                <textarea name="description" id="description" placeholder="Please enter some description here" required rows="4" style="width: 100%; padding: 10px; border: 1px solid lightgrey; border-radius: 5px; font-size: 16px; transition: border-color 0.3s ease;"></textarea>
            </div>

            <div class="field btn">
                <div class="btn-layer"></div>
                <input type="submit" value="Next">
            </div>
        </form>
    </div>
    
    <script>
        // Function to format number as VND
        function formatVND(value) {
            if (value) {
                return new Intl.NumberFormat('vi-VN', { style: 'currency', currency: 'VND' }).format(value);
            }
            return '';
        }

        // Format initial price
        let initialPrice = "${post.priceCar}";
        document.getElementById('formattedPrice').value = formatVND(initialPrice);
        document.getElementById('price').value = initialPrice;

        document.getElementById('formattedPrice').addEventListener('input', function(e) {
            let value = e.target.value.replace(/\D/g, ''); // Remove all non-digit characters
            if (value) {
                value = formatVND(value); // Format as VND
            }
            e.target.value = value;

            // Update the hidden input with the numeric value
            document.getElementById('price').value = value.replace(/\D/g, '');
        });
    </script>
</body>
</html>
