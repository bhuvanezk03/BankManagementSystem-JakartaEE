<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
</head>
<body>

    <form action="AccountServlet" method="post">
        <input type="hidden" name="action" value="create">
        <label>Account Type: </label><input type="text" name="accountType"><br>
        <label>Customer Name: </label><input type="text" name="customerName"><br>
        <label>Initial Balance: </label><input type="text" name="balance"><br>
        <input type="submit" value="Create Account">
    </form>

</body>
</html>
