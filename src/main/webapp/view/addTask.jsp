<%@page language = "java" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <div class="container  border-secondary p-2 bg-light border mx-auto my-5" style="width: 500px;">
    <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    ${error}
                </div>
            </c:if>
        <form method="post" action="/add-task">
            <div class="mb-3">
                <label for="title" class="form-label">Task Title</label>
                <input type="text" id="title" name="title" value = "${task.title}" class="form-control" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea id="description" name="description" class="form-control" required>${task.description}</textarea>
            </div>

            <div class="mb-3">
                <label for="assignTo" class="form-label">Assign To</label>
                <input type="text" id="assignTo" name="assignTo" value = "${task.assignTo}"class="form-control">
            </div>

            <div class="mb-3">
                <label for="date" class="form-label">Date</label>
                <input type="date" id="date" name="date" value = "${task.date}"class="form-control">
            </div>



            <button type="submit" class="btn btn-success mx-auto">Add</button>
            <a href="/" class="btn btn-success">Home</a>
        </form>

    </div>
  </body>
  </html>