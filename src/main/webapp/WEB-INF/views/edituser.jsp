<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%--@elvariable id="_csrf" type="org.springframework.security.web.server.csrf.DefaultCsrfToken"--%>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Hello, world!</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<div class="jumbotron">
    <h1 class="display-4">EDIT USER ACCIDENT</h1>
</div>

<form:form method="POST"
           action="/admin" modelAttribute="user">
    <div><label> Login : <input type="text" name="username"  value="${user.username}" /> </label></div>
    <c:forEach var = "role" items="${roles}">
    <div>
    <label><input type="checkbox" name="${role}" ${user.roles.contains(role)?"checked":""}>${role}</label>
    </div>
    </c:forEach>
    <input type="hidden" value="${user.id}" name="userId">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <div class="col-auto">
        <input type="submit"  class="btn btn-primary mb-2" value="Save"/>
    </div>
</form:form>
</body>
</html>