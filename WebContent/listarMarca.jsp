<%@page import="beans.Marca"%>
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
				<form action="ServletMarca?tipo=ListaxNom" id="frmBuscar"
					method="post">
					<div class="d-flex mb-2">
						<input class="form-control me-2" type="text" name="txt_buscar"
							id="txt_buscar" style="width: 30%" required>
						<button type="submit" name="tipo" value="ListaxNom"
							class="btn btn-secondary">Consultar</button>
					</div>
					<a href="ServletMarca?tipo=listar" class="btn btn-warning">Mostrar
						Lista</a>
				</form>
			</div>
	</div>
	<br>

		<div class="row">
			<div class="col">
				<table class="table table-striped table-hover" align="center">
					<tr>
						<th>ID MARCA</th>
						<th>NOMBRE DE LA MARCA</th>
						<th colspan="2">ACCIONES</th>
					</tr>
					<%
						ArrayList<Marca> lista = (ArrayList<Marca>) request.getAttribute("data");
					if (lista != null) {
						for (Marca xm : lista) {
							out.println("<tr>");
							out.println("<td>" + xm.getIdmarca() + "</td>");
							out.println("<td>" + xm.getNombremarca() + "</td>");
							out.println("<td align='center'><a href='ServletMarca?tipo=buscar&cod=" + xm.getIdmarca() + "'>"
							+ "<img width='15%' src='img/iconModificar.png' tittle='Editar'></a></td>");
							out.println("<td align='center'><a href='ServletMarca?tipo=eliminar&cod=" + xm.getIdmarca() + "'>"
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