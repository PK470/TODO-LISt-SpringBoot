<%@page language = "java" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Task Details</title>

    <!-- Custom CSS to center the content -->
    <style>
      body, html {
        height: 100%;
      }
      .centered-container {
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
      }
    </style>
  </head>
  <body>
    <!-- Center the card using flexbox -->
    <div class="container-fluid centered-container">
      <div class="card" style="width: 18rem;">
        <div class="card-header">
          Task Details
        </div>
        <div class="card-body">
          <h5 class="card-title">${task.title}</h5>
          <p class="card-text">${task.description}</p>
          <p class="card-text">${task.date}</p>
          <p class="card-text">${task.assignTo}</p>
          <p class="card-text">${task.status ? 'Completed' : 'Pending'}</p>
          <a href="/update/${task.id}" class="btn btn-success">Update</a>
          <a href="/" class="btn btn-success">Home</a>
        </div>
      </div>
    </div>
  </body>
</html>
