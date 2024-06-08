<!-- src/main/webapp/WEB-INF/jsp/customer-form.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
    <h2>Create Customer</h2>
    <form action="/customers/add" method="post">
        Name: <input type="text" name="name" required><br>
        Email: <input type="email" name="email" required><br>
        Address: <input type="text" name="address" required><br>
        <button type="submit">Create</button>
    </form>
</body>
</html>
