<%@page language = "java" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Update Task</title>
  </head>
  <body>
    <div class="container border-secondary p-2 bg-light border mx-auto my-5" style="width: 500px;">
        <form method="post" action="/updateTask">
            <input type="hidden" name="id" value="${task.id}">

            <div class="mb-3">
                <label for="title" class="form-label">Task Title</label>
                <input type="text" id="title" name="title" class="form-control" value="${task.title}" required>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Description</label>
                <textarea id="description" name="description" class="form-control" required>${task.description}</textarea>
            </div>

            <div class="mb-3">
                <label for="assignTo" class="form-label">Assign To</label>
                <input type="text" id="assignTo" name="assignTo" value="${task.assignTo}" class="form-control">
            </div>

            <div class="mb-3">
                <label for="date" class="form-label">Date</label>
                <input type="date" id="date" name="date" value="${task.date}" class="form-control">
            </div>

            <div class="mb-3">
                <label for="status" class="form-label">Status</label>
                <select id="status" name="status" class="form-control">
                    <option value="true" ${task.status ? 'selected' : ''}>Completed</option>
                    <option value="false" ${!task.status ? 'selected' : ''}>Pending</option>
                </select>
            </div>

            <button type="submit" class="btn btn-success mx-auto">Update</button>
            <a href="/" class="btn btn-secondary">Home</a>
        </form>
    </div>
  </body>
</html>
