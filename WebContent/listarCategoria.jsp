<%@page import="beans.Categoria"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="NavMan.jsp"/>
	<div class="container"> 
	<br>
	<div class="row">
		<div class="col">
				<form action="ServletCategoria?tipo=ListaxNOM" id="frmBuscar"
					method="post">
					<div class="d-flex mb-2">
						<input class="form-control me-2" type="text" name="txt_desc"
							id="txt_desc" style="width: 30%" required>
						<button type="submit" name="tipo" value="ListaxNOM"
							class="btn btn-secondary">Consultar</button>
					</div>
					<a href="ServletCategoria?tipo=listar" class="btn btn-warning">Mostrar
						Lista</a>
				</form>
			</div>
	</div>
	<br>

		<div class="row">
			<div class="col">
				<table class="table table-striped table-hover" align="center">
					<tr>
						<th>CÓDIGO</th>
						<th>DESCRIPCIÓN</th>
						<th colspan="2">ACCIONES</th>
					</tr>
					<%
						ArrayList<Categoria> lista = (ArrayList<Categoria>) request.getAttribute("data");
					if (lista != null) {
						for (Categoria xt : lista) {
							out.println("<tr>");
							out.println("<td>" + xt.getIdcategoria() + "</td>");
							out.println("<td>" + xt.getDescripción() + "</td>");
							out.println("<td align='center'><a href='ServletCategoria?tipo=buscar&cod=" + xt.getIdcategoria() + "'>"
							+ "<img width='15%' src='img/iconModificar.png' tittle='Editar'></a></td>");
							out.println("<td align='center'><a href='ServletCategoria?tipo=eliminar&cod=" + xt.getIdcategoria() + "'>"
							+ "<img width='15%' src='img/iconEliminar.png' tittle='Eliminar'></a></td>");
						}
					}
					%>
				</table>
			</div>
		</div>
	</div>



</body>
</html>