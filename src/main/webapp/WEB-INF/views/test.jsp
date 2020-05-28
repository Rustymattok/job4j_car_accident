<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<div class="jumbotron">
    <h1 class="display-4">CAR ACCIDENT REGISTRATION</h1>
    <p class="lead">You may see registered accident and add new one</p>
    <p class="lead">
        <a class="btn btn-primary btn-lg" href="/accident" role="button">ADD ACCIDNET</a>
    </p>
</div>
<table class="table">
    <thead>
    <tr>
        <th scope="col">firstName</th>
        <th scope="col">lastName</th>
        <th scope="col">emal</th>
        <th scope="col">password</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var = "accident_list" items="${testAttribute}">
        <tr>
            <td>${accident_list.firstName}</td>
            <td>${accident_list.lastName}</td>
            <td>${accident_list.email}</td>
            <td>${accident_list.password}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
