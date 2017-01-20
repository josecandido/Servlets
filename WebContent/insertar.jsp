<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Producto</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
 <div class="col-md-3">
<h3>NUEVO PRODUCTO</h3>
<div class="form-group">
<form method="post" action="Insertar">
<p>Referencia: <input type="number" name="id" maxlength="30" class="form-control"></p>
<p>Nombre: <input type="text" name="nombre" maxlength="30" class="form-control"></p>
<p>Unidades: <input type="number" name="unidades" class="form-control"></p>
<p>Precio: <input type="number" name="precio" step="any" class="form-control"></p>
<p>Fecha: <input type="date" name="fecha" class="form-control"></p>
<a href="./index.jsp" class="btn btn-default">Inicio</a>
<input type="submit" value="Insertar" class="btn btn-default">
</form>
</div>
</div>
</body>
</html>