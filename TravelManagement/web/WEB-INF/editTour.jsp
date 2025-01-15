<%-- 
    Document   : editTour
    Created on : Jan 14, 2025, 4:28:37 PM
    Author     : anh58
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Tour</title>
</head>
<body>
    <h2>Edit Tour</h2>
    <form action="UpdateTourServlet" method="post">
        <input type="hidden" name="id" value="${tour.id}">
        
        <div>
            <label>Name:</label>
            <input type="text" name="name" value="${tour.name}" required>
        </div>
        <div>
            <label>Destination:</label>
            <input type="text" name="destination" value="${tour.destination}" required>
        </div>
        <div>
            <label>Price:</label>
            <input type="number" name="price" value="${tour.price}" step="0.01" required>
        </div>
        <div>
            <label>Duration (days):</label>
            <input type="number" name="duration" value="${tour.duration}" required>
        </div>
        <div>
            <label>Seats:</label>
            <input type="number" name="seats" value="${tour.seats}" required>
        </div>
        
        <button type="submit">Update</button>
        <a href="TourListServlet">Cancel</a>
    </form>
    
    <% if(request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
</body>
</html>
