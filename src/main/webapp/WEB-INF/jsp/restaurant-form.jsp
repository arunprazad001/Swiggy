<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Restaurant</title>
</head>
<body>
    <h1>Add Restaurant</h1>
    <form action="/restaurants/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>
        <input type="text" id="address" name="address" required><br>
        <!-- Add more fields as needed -->
        <input type="submit" value="Add Restaurant">
    </form>
</body>
</html>
