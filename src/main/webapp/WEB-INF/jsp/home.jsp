<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Swiggy Home</title>
</head>
<body>
    <h1>Welcome to Home</h1>
    <ul>
        <li><a href="/customer/getAll">View All Customers</a></li>
        <li><a href="/customer/show">Add Customer </a></li>
        <li><a href="/customer/{id}/orders">get customer order history</a></li>

        <li><a href="/restaurant/getAll">View All restaurants</a></li>
        <li><a href="/restaurant/show">Add restaurant  </a></li>

        <li><a href="/order/getAll">View All orders</a></li>
        <li><a href="/order/show">Place Orders  </a></li>

         <li><a href="/delivery/getAll">View All partners</a></li>
         <li><a href="/delivery/show">Add Partners </a></li>

        <!-- Add more links/buttons for other customer-related functionalities as needed -->
    </ul>
</body>
</html>