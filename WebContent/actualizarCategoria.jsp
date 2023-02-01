<%@page import="beans.Categoria"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="NavMan.jsp"/>

<%
Categoria obj = (Categoria) request.getAttribute("Categoria");
%>

	<div class="container">
		<form class="mt-3" action="ServletCategoria?tipo=actualizar"
			id="frmactualizar" method="post">
			<input class="form-control" type="hidden" name="txt_id"
				value="${requestScope.Categoria.idcategoria}">

			<div class="row mb-3">
				<label class="col-2 col-form-label">Descripci�n</label>
				<div class="col-10">
					<input class="form-control" type="text" name="txt_des"
						value="${requestScope.Categoria.descripci�n}">
				</div>
			</div>

			<div class="row mb-3">
				<input class="btn btn-primary" type="submit" value="Actualizar">
			</div>

		</form>
	</div>

</body>
</html>