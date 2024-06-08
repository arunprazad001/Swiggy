<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order List</title>
</head>
<body>
    <h1>Order List</h1>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Customer ID</th>
            <th>Restaurant ID</th>
            <th>Delivery Partner ID</th>
            <th>Items</th>
            <th>Order Status</th>

        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.customerId}</td>
                <td>${order.restaurantId}</td>
                <td>${order.deliveryPartnerId}</td>
                <td>${order.items}</td>
                <td>${order.orderStatus}</td>

            </tr>
        </c:forEach>
    </table>
</body>
</html>
