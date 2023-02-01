<%@page import="beans.Cliente"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
ArrayList<Cliente> lista = (ArrayList<Cliente>) request.getAttribute("data");
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
							<th scope="col">Nombre</th>
							<th scope="col">Apellido</th>
							<th scope="col">Telefono</th>
							<th scope="col">Correo</th>
							<th scope="col">Direccion</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="clientetemporal" items="${datos}">
							<tr>
								<td>${clientetemporal.codigo}</td>
								<td>${clientetemporal.nombre}</td>
								<td>${clientetemporal.apellido}</td>
								<td>${clientetemporal.telefono}</td>
								<td>${clientetemporal.correo}</td>
								<td>${clientetemporal.direccion}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>