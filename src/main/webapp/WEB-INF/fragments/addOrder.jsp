<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Add Employee</title>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<c:import url="/WEB-INF/fragments/header.jsp"/>
<br>
<div class="btn-group">
    <button class="btn btn-secondary btn-lg" type="button" onclick="location.href='http://localhost:8080/loadAllOrder';">
        Order
    </button>
    <button type="button" class="btn btn-lg btn-secondary dropdown-toggle dropdown-toggle-split" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <span class="sr-only">Toggle Dropdown</span>
    </button>
    <div class="dropdown-menu">
        <a class="dropdown-item" href="/addOrder">Add Order</a>
        <a class="dropdown-item" href="/loadByIdOrder">Load Order by ID</a>
        <a class="dropdown-item" href="/editOrder">Edit Order</a>
        <a class="dropdown-item" href="/deleteOrder">Delete Order</a>
    </div>
</div>

<c:if test="${not empty information}">${information}</c:if>

<br>
<form method="post" target="/addOrder">

    <div class="form-row">
        <div class="form-group col-md-6">
            <input type="number" class="form-control" placeholder="Status id" name="status_id">
        </div>
        <div class="form-group col-md-6">
            <input type="number" class="form-control" placeholder="Vehicle id" name="vehicle_id">
        </div>
    </div>
    <div class="form-row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Problem description" name="problem_description">
        </div>
    </div>
    <br>
    <div class="form-row">
        <div class="form-group col-md-4">
            <Label>Acceptance date</Label>
            <input type="date" class="form-control"  name="acceptance">
        </div>
        <div class="form-group col-md-4">
            <Label>Planned maintenance date</Label>
            <input type="date" class="form-control"  name="planned_maintenance">
        </div>
        <div class="form-group col-md-4">
            <Label>Maintenance start date</Label>
            <input type="date" class="form-control"  name="maintenance_start">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-2">
            <input type="number" class="form-control" placeholder="Employee id" name="employee_id">
        </div>
        <div class="form-group col-md-2">
            <input type="text" class="form-control" placeholder="Total price" name="total_price">
        </div>
        <div class="form-group col-md-2">
            <input type="text" class="form-control" placeholder="Parts cost" name="parts_cost">
        </div> <div class="form-group col-md-2">
            <input type="text" class="form-control" placeholder="Hours amount" name="hours_amount">
        </div>
    </div>
    <div class="form-row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Maintenance description" name="maintenance_description">
        </div>
    </div>
    <br>
    <input type="submit" value="Add Order">

</form>

<c:import url="/WEB-INF/fragments/footer.jsp"/>
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T" crossorigin="anonymous"></script>
</body>
</html>
