<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Car Information</title>
</head>
<body>
    <h1>Car Information</h1>
    <p>Car ID: ${carId}</p>
    <p>Car Name: ${carName}</p>
    <p>Year: ${year}</p>
    <p>Origin: ${origin}</p>
    <p>Gearbox: ${gearbox}</p>
    <p>Engine: ${engine}</p>
    <p>Interior Color: ${interiorColor}</p>
    <p>Exterior Color: ${exteriorColor}</p>
    <p>Number of Seats: ${numberOfSeats}</p>
    <p>Number of Doors: ${numberOfDoors}</p>
    <p>Price: ${price}</p>
    <p>Description: ${description}</p>
</body>
</html>
