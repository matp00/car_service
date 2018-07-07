<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Main</title>

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
<c:if test="${not empty information}">${information}</c:if>
<form action="addVehicle" method="post">
    <div class="form-row">
        <div class="form-group col-md-6">
            <label >Brand</label>
            <input type="text" class="form-control" name="brand" placeholder="Brand">
        </div>
        <div class="form-group col-md-6">
            <label >Model</label>
            <input type="text" class="form-control" name="model" placeholder="Model">
        </div>

    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label >Production year</label>
            <input type="number" class="form-control" name="production_year" placeholder="production_year">
        </div>
        <div class="form-group col-md-6">
            <label >Registration number</label>
            <input type="text" class="form-control" name="registration_number" placeholder="Registration number">
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label >Next service</label>
            <input type="date" class="form-control" name="next_service" placeholder="Next service">
        </div>
        <div class="form-group col-md-6">
            <label >Customer Id</label>
            <input type="number" class="form-control" name="customer_id" placeholder="Customer Id">
        </div>
    </div>

    <button type="submit" class="btn btn-primary">Send</button>
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
