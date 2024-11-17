<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h1>List of Tasks</h1>
        <div class="list-group">
            <!-- Loop over tasks from the model -->
            <c:forEach var="task" items="${tasks}">
                <a href="/list/${task.id}" class="list-group-item list-group-item-action">
                    <strong>${task.title}</strong> - ${task.description}
                </a>
            </c:forEach>
        </div>
        <a href="/" class="btn btn-success mt-3">Home</a>
    </div>
</body>
</html>
