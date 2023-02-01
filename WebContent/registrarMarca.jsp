<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Registro de Marca</title>
</head>
<body>
<jsp:include page="NavMan.jsp"/>

	<div class="container">
		<form class="mt-3" action="ServletMarca?tipo=registrar"
			id="frmregistro" method="post">

			<div class="row mb-3">
				<label class="col-2 col-form-label">Nombre de Marca : </label>
				<div class="col-10">
					<input class="form-control" type="text" name="txt_nom"
						class="required">
				</div>
			</div>

			<div class="row mb-3">
				<input class="btn btn-primary" type="submit" value="Registrar">
			</div>

		</form>
	</div>

</body>
</html>