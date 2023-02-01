<%@page import="beans.Marca"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Actualizar Marca</title>
</head>
<body>

<jsp:include page="NavMan.jsp"/>

<%
Marca obj = (Marca) request.getAttribute("Marca");
%>
	<div class="container">
		<form class="mt-3" action="ServletMarca?tipo=actualizar" id="frmactualizar" method="post">
			<input class="form-control" type="hidden" name="txt_idM" value="${requestScope.Marca.idmarca}">

			<div class="row mb-3">
				<label class="col-2 col-form-label">Nommbre de la Marca</label>
				<div class="col-10">
					<input class="form-control" type="text" name="txt_nom" value="${requestScope.Marca.nombremarca}">
				</div>
			</div>

			<div class="row mb-3">
				<input class="btn btn-primary" type="submit" value="Actualizar">
			</div>

		</form>
	</div>

</body>
</html>