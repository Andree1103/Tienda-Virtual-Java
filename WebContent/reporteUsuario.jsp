<%@page import="beans.Usuario"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
ArrayList<Usuario> lista = (ArrayList<Usuario>) request.getAttribute("data");
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
							<th scope="col">Email</th>
							<th scope="col">Contraseña</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="usuariotemporal" items="${datos}">
							<tr>
								<td>${usuariotemporal.idUsuario}</td>
								<td>${usuariotemporal.email}</td>
								<td>${usuariotemporal.contrasenia}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>