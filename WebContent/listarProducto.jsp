<%@page import="beans.Producto"%>
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
				<form action="ServletProducto?tipo=listarxPrecio"
					id="frmlistarxPrecio" method="post" class="row g-4">
					<div class="col-auto">
						Consultar Producto: <input type="text" name="txt_consulta"
							required autofocus> <select class="btn btn-light"
							name="Elegir">
							<option value="1">Codigo</option>
							<option value="2">Precio</option>
						</select> <input class="btn btn-success" type="submit" value="Buscar">
						<a href="ServletProducto?tipo=listar" class="btn btn-warning">Mostrar
							Lista</a>
				</form>
			</div>
		</div>
		
		<br><br> 
		
		<div class="row">
			<div class="col">
				<table class="table table-striped table-hover" align="center">
					<tr>
						<th>ID PRODUCTO</th>
						<th>NOMBRE</th>
						<th>PRECIO</th>
						<th>STOCK</th>
						<th>MARCA</th>
						<th>CATEGORIA</th>
						<th colspan="2">ACCIONES</th>
					</tr>
					<%
						ArrayList<Producto> lista = (ArrayList<Producto>) request.getAttribute("data");
					if (lista != null) {
						for (Producto xPro : lista) {
							out.println("<tr>");
							out.println("<td>" + xPro.getCodigo() + "</td>");
							out.println("<td>" + xPro.getDescripcion() + "</td>");
							out.println("<td>" + xPro.getPrecio() + "</td>");
							out.println("<td>" + xPro.getStock() + "</td>");
							out.println("<td>" + xPro.getNombreMarca() + "</td>");
							out.println("<td>" + xPro.getNombreCategoria() + "</td>");
							out.println("<td align='center'><a href='ServletProducto?tipo=buscar&cod=" + xPro.getCodigo() + "'>"
							+ "<img width='30%' src='img/iconModificar.png' title='Editar'></a></td>");
							out.println("<td align='center'><a href='ServletProducto?tipo=eliminar&cod=" + xPro.getCodigo() + "'>"
							+ "<img width='30%' src='img/iconEliminar.png' title='Eliminar'></a></td>");
						}
					}
					%>
				</table>
			</div>
		</div>
	</div> 
</body>
</html>
