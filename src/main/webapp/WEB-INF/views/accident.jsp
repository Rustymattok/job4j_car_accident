<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%@ page session="false" isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<div class="jumbotron">
    <h1 class="display-4">CAR ACCIDENT REGISTRATION</h1>
    <p class="lead">Form for add new Accident</p>
</div>

<form:form method="POST"
           action="/accident" modelAttribute="modelAccident">
    <div class="form-group row">
        <form:label class ="col-sm-2 col-form-label col-form-label-lg" path="name">Name</form:label>
        <div class="col-sm-10">
            <form:input type="text" class="form-control form-control-lg" path="name" placeholder="Введите имя"/>
        </div>
    </div>

    <div class="form-group row">
        <form:label class ="col-sm-2 col-form-label col-form-label-lg" path="text">Info accident</form:label>
        <div class="col-sm-10">
            <form:input type="text" class="form-control form-control-lg" path="text" placeholder="Опишите проишествие"/>
        </div>
    </div>

    <div class="form-group row">
        <form:label class ="col-sm-2 col-form-label col-form-label-lg" path="address">Address</form:label>
        <div class="col-sm-10">
                <form:input type="text" class="form-control form-control-lg" path="address" placeholder="Введите адресс происшествия"/>
        </div>
    </div>
    <div class="col-auto">
    <button type="submit" class="btn btn-primary mb-2">Submit</button>
    </div>
</form:form>

</body>
</html>