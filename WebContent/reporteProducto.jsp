<%@page import="beans.Producto"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
ArrayList<Producto> lista = (ArrayList<Producto>) request.getAttribute("data");
pageContext.setAttribute("datos", lista);
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./estilo/archi.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Insert title here</title>
</head>
<body>
<jsp:include page="NavMan.jsp"/>
	<div class="container">
		<div>
				  <div class="tittle">
				    <h1>REPORTES</h1>
				  </div>
				  <hr>
			<div id="no-more-tables">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Codigo</th>
							<th scope="col">Descricpión</th>
							<th scope="col">Precio</th>
							<th scope="col">Stock</th>
							<th scope="col">ID Marca</th>
							<th scope="col">ID Categoria</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="productotemporal" items="${datos}">
							<tr>
								<td>${productotemporal.codigo}</td>
								<td>${productotemporal.descripcion}</td>
								<td>${productotemporal.precio}</td>
								<td>${productotemporal.stock}</td>
								<td>${productotemporal.nombreMarca}</td>
								<td>${productotemporal.nombreCategoria}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>