<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Delivery Partner</title>
</head>
<body>
    <h1>Add Delivery Partner</h1>
    <form action="/delivery-partners/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="phoneNumber">Phone Number:</label>
        <input type="text" id="phoneNumber" name="phoneNumber" required pattern="^\d{10}$" title="Phone number should be 10 digits"><br>

        <!-- Add more fields as needed -->

        <input type="submit" value="Add Delivery Partner">
    </form>
</body>
</html>
