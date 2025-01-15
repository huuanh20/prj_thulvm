<%-- 
    Document   : tourList
    Created on : Jan 14, 2025, 4:28:12 PM
    Author     : anh58
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tour List</title>
</head>
<body>
    <h2>Welcome, ${sessionScope.user.fullName}!</h2>
    <form action="LogoutServlet" method="post">
        <button type="submit">Logout</button>
    </form>
    
    <h3>Search Tours</h3>
    <form action="SearchTourServlet" method="get">
        <label>Max Price:</label>
        <input type="number" name="maxPrice" step="0.01" required>
        <button type="submit">Search</button>
    </form>
    
    <table border="1">
        <tr>
            <th>No</th>
            <th>ID</th>
            <th>Name</th>
            <th>Destination</th>
            <th>Price</th>
            <th>Duration</th>
            <th>Seats</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${tours}" var="tour" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${tour.id}</td>
                <td>${tour.name}</td>
                <td>${tour.destination}</td>
                <td>${tour.price}</td>
                <td>${tour.duration}</td>
                <td>${tour.seats}</td>
                <td>
                    <a href="EditTourServlet?id=${tour.id}">Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
