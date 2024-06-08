<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order History</title>
</head>
<body>
    <h1>Order History</h1>
    <table border="1">
        <tr>
            <th>Order ID</th>
            <th>Customer ID</th>
            <th>Order Date</th>
            <th>Total Amount</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.orderId}</td>
                <td>${order.customerId}</td>
                <td>${order.orderDate}</td>
                <td>${order.totalAmount}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
