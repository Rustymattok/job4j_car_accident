<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="_csrf" type="org.springframework.security.web.server.csrf.DefaultCsrfToken"--%>
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
<div>
    <form action="<c:url value="/logout"/>" method="post">
        <div class="col-auto">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit"  class="btn btn-primary mb-2" value="Sign Out"/>
        </div>
    </form>
    <%--Validation form vision for administrator page--%>
    <c:if test ="${user.authorities.contains(roleValidation)}">
        <a class="underlineHover" href="<c:url value="/admin"/>">Admin Panel</a>
    </c:if>
    </div>
    <table class="table">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Text</th>
        <th scope="col">Adress</th>
        <th scope="col">Username</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var = "accident_list" items="${object}">
        <tr>
            <td>${accident_list.accidentName}</td>
            <td>${accident_list.accidentInfo}</td>
            <td>${accident_list.accidentAddress}</td>
            <td>${accident_list.author.firstName} ${accident_list.author.lastName}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
