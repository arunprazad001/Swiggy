<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Place Order</title>
</head>
<body>
    <h1>Place Order</h1>
    <form action="/orders/add" method="post">
        <label for="customerId">Customer ID:</label>
        <input type="text" id="customerId" name="customerId" required><br>

        <label for="restaurantId">Restaurant ID:</label>
        <input type="text" id="restaurantId" name="restaurantId" required><br>

        <label for="items">Items:</label>
        <input type="text" id="items" name="items" required><br>

        <!-- Add more fields as needed -->

        <input type="submit" value="Place Order">
    </form>
</body>
</html>
